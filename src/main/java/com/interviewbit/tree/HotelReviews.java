package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class HotelReviews {

	public static void main(String[] args) {
		String S = "cool_ice_wifi";
		String a = "water_is_cool";
		String b = "cold_ice_drink";
		String c = "cool_wifi_speed";
		ArrayList<String> r = new ArrayList<String>();
		r.add(a);
		r.add(b);
		r.add(c);
		System.out.println(new HotelReviews().solve(S, r));

	}

	private class WordGoodNessPair {
		private int reviewGoodNess;
		private int i;

		public int getGoodness() {
			return reviewGoodNess;
		}

		public int getIndex() {
			return i;
		}

		public void setGoodness(int goodness) {
			this.reviewGoodNess = goodness;
		}

		public void setIndex(int index) {
			this.i = index;
		}
	}

	public class GoodWordComparator implements Comparator<WordGoodNessPair> {
		@Override
		public int compare(WordGoodNessPair o1, WordGoodNessPair o2) {
			if (o2.getGoodness() > o1.getGoodness())
				return 1;
			else if (o2.getGoodness() < o1.getGoodness())
				return -1;
			else {
				if (o2.getIndex() > o1.getIndex())
					return -1;
				else
					return 1;
			}
		}
	}

	public ArrayList<Integer> solve(String A, ArrayList<String> B) {
		HashSet<String> goodWordSet = new HashSet<String>();
		ArrayList<WordGoodNessPair> rank = new ArrayList<WordGoodNessPair>();
		int n = B.size();
		for (String good : A.split("_"))
			goodWordSet.add(good);
		for (int i = 0; i < n; i++) {
			String review = B.get(i);
			int count = 0;
			for (String word : review.split("_")) {
				if (goodWordSet.contains(word))
					count++;
			}
			WordGoodNessPair pair = new WordGoodNessPair();
			pair.setGoodness(count);
			pair.setIndex(i);
			rank.add(pair);
		}
		Collections.sort(rank, new GoodWordComparator());
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (WordGoodNessPair p : rank) {
			result.add(p.getIndex());
		}
		return result;

	}
}
