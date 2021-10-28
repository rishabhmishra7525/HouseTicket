package com.neo;

import java.util.ArrayList;
import java.util.List;

public class GetData {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  static List<Integer> getvalue(int item) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		List<Integer> l5 = new ArrayList<Integer>();
		List<Integer> l6 = new ArrayList<Integer>();
		List<Integer> l7 = new ArrayList<Integer>();
		List<Integer> l8 = new ArrayList<Integer>();
		List<Integer> l9 = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			l1.add(i);
		}
		if (item == 1) {
			return l1;

		}
		
		for (int i = 11; i <= 20; i++) {
			l2.add(i);
		}

		if (item == 2) {
			return l2;

		}
		for (int i = 21; i <= 30; i++) {
			l3.add(i);
		}

		if (item == 3) {
			return l3;

		}
		for (int i = 31; i <= 40; i++) {
			l4.add(i);
		}
		if (item == 4) {
			return l4;

		}

		for (int i = 41; i <= 50; i++) {
			l5.add(i);
		}
		if (item == 5) {
			return l5;

		}

		for (int i = 51; i <= 60; i++) {
			l6.add(i);
		}

		if (item == 6) {
			return l6;

		}
		for (int i = 61; i <= 70; i++) {
			l7.add(i);
		}
		if (item == 7) {
			return l7;

		}

		for (int i = 71; i <= 80; i++) {
			l8.add(i);
		}
		if (item == 8) {
			return l8;

		}

		for (int i = 81; i <= 90; i++) {
			l9.add(i);
		}
		if (item == 9) {
			return l9;

		}
		return l9;
	}

}
