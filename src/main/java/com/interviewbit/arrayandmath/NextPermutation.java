package com.interviewbit.arrayandmath;

import java.util.ArrayList;

class NextPermutation {

	public static void main(String[] args) {

		int[] input = { 444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201,
				788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469,
				84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472,
				265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98,
				422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 };
		// List<Integer> a = Arrays.asList(input);
		// nextPermutation(input);
		for (int i : input)
			System.out.print(i + " ");

	}

	public static void nextPermutation(ArrayList<Integer> a) {

		int length = a.size();
		if (length == 0)
			return;
		int end = length - 1;
		int i = end - 1;
		for (; i >= 0; i--) {
			if (a.get(i) >= a.get(i + 1))
				continue;
			int j = end;
			while (j != i) {
				if (a.get(j) > a.get(i)) {
					int temp = a.get(i);
					a.set(i, a.get(j));
					a.set(j, temp);
					break;
				}
				j--;
			}
			break;
		}
		reverse(a, i + 1, end);
		return;
	}

	public static void reverse(ArrayList<Integer> num, int start, int end) {
		while (start < end) {
			int temp;
			temp = num.get(start);
			num.set(start, num.get(end));
			num.set(end, temp);
			start++;
			end--;
		}
		return;
	}

}
