package com.neo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HousieTicket {
	public static void main(String ar[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter row");
		int row=sc.nextInt();
		System.out.println("please enter column");
		int c=sc.nextInt();
		Ticket[] tickets = new Ticket[6];
		for (int i = 0; i < 6; i++) {
			tickets[i] = new Ticket(row,c);
		}
		List<List<Integer>> columns = new ArrayList<List<Integer>>();
		columns.add(GetData.getvalue(1));
		columns.add(GetData.getvalue(2));
		columns.add(GetData.getvalue(3));
		columns.add(GetData.getvalue(4));
		columns.add(GetData.getvalue(5));
		columns.add(GetData.getvalue(6));
		columns.add(GetData.getvalue(7));
		columns.add(GetData.getvalue(8));
		columns.add(GetData.getvalue(9));

		List<List<Integer>> set1 = new ArrayList<List<Integer>>();
		List<List<Integer>> set2 = new ArrayList<List<Integer>>();
		List<List<Integer>> set3 = new ArrayList<List<Integer>>();
		List<List<Integer>> set4 = new ArrayList<List<Integer>>();
		List<List<Integer>> set5 = new ArrayList<List<Integer>>();
		List<List<Integer>> set6 = new ArrayList<List<Integer>>();

		for (int i = 0; i < 9; i++) {
			set1.add(new ArrayList<Integer>());
			set2.add(new ArrayList<Integer>());
			set3.add(new ArrayList<Integer>());
			set4.add(new ArrayList<Integer>());
			set5.add(new ArrayList<Integer>());
			set6.add(new ArrayList<Integer>());
		}

		List<List<List<Integer>>> sets = new ArrayList<List<List<Integer>>>();

		sets.add(set1);
		sets.add(set2);
		sets.add(set3);
		sets.add(set4);
		sets.add(set5);
		sets.add(set6);

		for (int i = 0; i < 9; i++) {
			List<Integer> li = columns.get(i);
			for (int j = 0; j < 6; j++) {
				int randNumIndex = getRand(0, li.size() - 1);
				int randNum = li.get(randNumIndex);

				List<Integer> set = sets.get(j).get(i);
				set.add(randNum);

				li.remove(randNumIndex);
			}
		}

		List<Integer> lastCol = columns.get(8);
		int randNumIndex = getRand(0, lastCol.size() - 1);
		int randNum = lastCol.get(randNumIndex);

		int randSetIndex = getRand(0, sets.size() - 1);
		List<Integer> randSet = sets.get(randSetIndex).get(8);
		randSet.add(randNum);

		lastCol.remove(randNumIndex);

		for (int pass = 0; pass < 3; pass++) {
			for (int i = 0; i < 9; i++) {
				List<Integer> col = columns.get(i);
				if (col.size() == 0)
					continue;

				int randNumIndex_p = getRand(0, col.size() - 1);
				int randNum_p = col.get(randNumIndex_p);

				boolean vacantSetFound = false;
				while (!vacantSetFound) {
					int randSetIndex_p = getRand(0, sets.size() - 1);
					List<List<Integer>> randSet_p = sets.get(randSetIndex_p);

					if (getNumberOfElementsInSet(randSet_p) == 15 || randSet_p.get(i).size() == 2)
						continue;

					vacantSetFound = true;
					randSet_p.get(i).add(randNum_p);

					col.remove(randNumIndex_p);
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			List<Integer> col = columns.get(i);
			if (col.size() == 0)
				continue;

			int randNumIndex_p = getRand(0, col.size() - 1);
			int randNum_p = col.get(randNumIndex_p);

			boolean vacantSetFound = false;
			while (!vacantSetFound) {
				int randSetIndex_p = getRand(0, sets.size() - 1);
				List<List<Integer>> randSet_p = sets.get(randSetIndex_p);

				if (getNumberOfElementsInSet(randSet_p) == 15 || randSet_p.get(i).size() == 3)
					continue;

				vacantSetFound = true;
				randSet_p.get(i).add(randNum_p);

				col.remove(randNumIndex_p);
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				Collections.sort(sets.get(i).get(j));
			}
		}

		for (int setIndex = 0; setIndex < 6; setIndex++) {
			List<List<Integer>> currSet = sets.get(setIndex);
			Ticket currTicket = tickets[setIndex];

			for (int size = 3; size > 0; size--) {
				if (currTicket.getRowCount(0) == 5)
					break;
				for (int colIndex = 0; colIndex < 9; colIndex++) {
					if (currTicket.getRowCount(0) == 5)
						break;
					if (currTicket.A[0][colIndex] != 0)
						continue;

					List<Integer> currSetCol = currSet.get(colIndex);
					if (currSetCol.size() != size)
						continue;

					currTicket.A[0][colIndex] = currSetCol.remove(0);
				}
			}

			for (int size = 2; size > 0; size--) {
				if (currTicket.getRowCount(1) == 5)
					break;
				for (int colIndex = 0; colIndex < 9; colIndex++) {
					if (currTicket.getRowCount(1) == 5)
						break;
					if (currTicket.A[1][colIndex] != 0)
						continue;

					List<Integer> currSetCol = currSet.get(colIndex);
					if (currSetCol.size() != size)
						continue;

					currTicket.A[1][colIndex] = currSetCol.remove(0);
				}
			}

			for (int size = 1; size > 0; size--) {
				if (currTicket.getRowCount(2) == 5)
					break;
				for (int colIndex = 0; colIndex < 9; colIndex++) {
					if (currTicket.getRowCount(2) == 5)
						break;
					if (currTicket.A[2][colIndex] != 0)
						continue;

					List<Integer> currSetCol = currSet.get(colIndex);
					if (currSetCol.size() != size)
						continue;

					currTicket.A[2][colIndex] = currSetCol.remove(0);
				}
			}
		}

		for (int i = 0; i < 1; i++) {
			Ticket currTicket = tickets[i];

			for (int r = 0; r < 3; r++) {
				for (int col = 0; col < 9; col++) {
					int num = currTicket.A[r][col];
					if (num != 0)
						System.out.print(num);

					if (col != 8)
						System.out.print(" , ");
				}
				if (r != 2)
					System.out.println();
			}

			if (i != 5) {
				System.out.println();
				System.out.println();
				System.out.println();
			}
		}
	}
	
	
	static class Ticket {
		int A[][];
		
		int row,col;
		public Ticket(int a, int b) {
			
			row=a;
			col=b;
			this.A = new int[row][col];
		}

		public int getRowCount(int r) {
			int count = 0;
			for (int i = 0; i < 9; i++) {
				if (A[r][i] != 0)
					count++;
			}
			return count;
		}

		public int getColCount(int c) {
			int count = 0;
			for (int i = 0; i < 3; i++) {
				if (A[i][c] != 0)
					count++;
			}
			return count;
		}

		public int getEmptyCellInCol(int c) {
			for (int i = 0; i < 3; i++) {
				if (A[i][c] == 0)
					return i;
			}
			return -1;
		}

	}
	static int getRand(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	static int getNumberOfElementsInSet(List<List<Integer>> set) {
		int count = 0;
		for (List<Integer> li : set)
			count += li.size();
		return count;
	}

	
	
	
	
}
