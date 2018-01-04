package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class TripletsWithSumBetweenGivenRange {

	private static final double TWO_THIRDS = 2.0 / 3.0;
	private static final LimitRange RANGE_ZERO_TO_TWO_THIRD = new LimitRange(0, Boolean.FALSE, TWO_THIRDS,Boolean.FALSE);
	private static final LimitRange RANGE_TWO_THIRD_TO_ONE = new LimitRange(TWO_THIRDS, Boolean.TRUE, 1, Boolean.TRUE);
	private static final LimitRange RANGE_ONE_TO_TWO = new LimitRange(1, Boolean.FALSE, 2, Boolean.FALSE);

	private static class LimitRange {
		public double lowerLimit;
		public boolean lowerLimitInclusive;
		public double upperLimit;
		public boolean upperLimitInclusive;
		public LimitRange(double lowerBound, boolean lowerInclusive, double upperBound, boolean upperInclusive) {
			this.lowerLimit = lowerBound;
			this.lowerLimitInclusive = lowerInclusive;
			this.upperLimit = upperBound;
			this.upperLimitInclusive = upperInclusive;
		}
	}

	public int solve(ArrayList<String> A) {
		if (A == null || A.size() < 3)
			return 0;
		double[] input = new double[A.size()];
		for (int i = 0; i < A.size(); i++) {
			input[i] = Double.parseDouble(A.get(i));
		}
		double[] res = findTriplet(input);
		if (res == null) {
			return 0;
		} else {
			return 1;
		}
	}

	public static double[] findTriplet(double[] list) {
		double[] case1 = caseOne(list);
		if (case1 != null) {
			return case1;
		}
		double[] case2 = caseTwo(list);
		if (case2 != null) {
			return case2;
		}
		double[] case3 = caseThree(list);
		if (case3 != null) {
			return case3;
		}
		double[] case4 = caseFour(list);
		if (case4 != null) {
			return case4;
		}
		double[] case5 = caseFive(list);
		if (case5 != null) {
			return case5;
		}
		return null;
	}

	private static double[] caseOne(double[] list) {
		double[] maxFirstRange = getMaxesInRange(list, 3, RANGE_ZERO_TO_TWO_THIRD);
		if (maxFirstRange == null) {
			return null;
		}
		double sum = maxFirstRange[0] + maxFirstRange[1] + maxFirstRange[2];
		boolean inRange = numInRange(sum, RANGE_ONE_TO_TWO);
		if (!inRange) {
			return null;
		}
		return new double[] { maxFirstRange[0], maxFirstRange[1], maxFirstRange[2] };
	}

	private static double[] caseTwo(double[] list) {
		double[] maxFirstRange = getMaxesInRange(list, 2, RANGE_ZERO_TO_TWO_THIRD);
		if (maxFirstRange == null) {
			return null;
		}
		double sum = maxFirstRange[0] + maxFirstRange[1];
		int n = list.length;
		for (int i = 0; i < n; i++) {
			boolean inRange = numInRange(list[i], RANGE_TWO_THIRD_TO_ONE);
			if (inRange && list[i] > 1 - sum && list[i] < 2 - sum) {
				return new double[] { maxFirstRange[0], maxFirstRange[1], list[i] };
			}
		}
		return null;
	}

	private static double[] caseThree(double[] list) {
		double[] minFirstRange = getMinsInRange(list, 2, RANGE_ZERO_TO_TWO_THIRD);
		if (minFirstRange == null) {
			return null;
		}
		double[] minThirdRange = getMinsInRange(list, 1, RANGE_ONE_TO_TWO);
		if (minThirdRange == null) {
			return null;
		}
		double sum = minFirstRange[0] + minFirstRange[1] + minThirdRange[0];
		boolean inRange = numInRange(sum, RANGE_ONE_TO_TWO);
		if (!inRange) {
			return null;
		}
		return new double[] { minFirstRange[0], minFirstRange[1], minThirdRange[0] };
	}

	private static double[] caseFour(double[] list) {
		double[] minSecondRange = getMinsInRange(list, 2, RANGE_TWO_THIRD_TO_ONE);
		if (minSecondRange == null) {
			return null;
		}
		double sum = minSecondRange[0] + minSecondRange[1];
		int n = list.length;
		for (int i = 0; i < n; i++) {
			boolean inRange = numInRange(list[i], RANGE_ZERO_TO_TWO_THIRD);
			if (inRange && list[i] < 2 - sum) {
				return new double[] { minSecondRange[0], minSecondRange[1], list[i] };
			}
		}
		return null;
	}

	private static double[] caseFive(double[] list) {
		double[] minFirstRange = getMinsInRange(list, 1, RANGE_ZERO_TO_TWO_THIRD);
		if (minFirstRange == null) {
			return null;
		}
		double[] minSecondRange = getMinsInRange(list, 1, RANGE_TWO_THIRD_TO_ONE);
		if (minSecondRange == null) {
			return null;
		}
		double[] minThirdRange = getMinsInRange(list, 1, RANGE_ONE_TO_TWO);
		if (minThirdRange == null) {
			return null;
		}
		double sum = minFirstRange[0] + minSecondRange[0] + minThirdRange[0];
		boolean inRange = numInRange(sum, RANGE_ONE_TO_TWO);
		if (!inRange) {
			return null;
		}
		return new double[] { minFirstRange[0], minSecondRange[0], minThirdRange[0] };
	}

	private static double[] getMinsInRange(double[] list, int numMins, LimitRange range) {
		int n = list.length;
		double[] minValues = new double[numMins];
		double[] minIndexes = new double[numMins];
		for (int i = 0; i < numMins; i++) {
			minValues[i] = -1;
			minIndexes[i] = -1;
			for (int j = 0; j < n; j++) {
				boolean inRange = numInRange(list[j], range);
				if ((list[j] <= minValues[i] || minIndexes[i] == -1) && inRange) {
					boolean good = true;
					for (int k = 0; k < i; k++) {
						if (j == minIndexes[k]) {
							good = false;
							break;
						}
					}
					if (good) {
						minValues[i] = list[j];
						minIndexes[i] = j;
					}
				}
			}
			if (minIndexes[i] == -1) {
				return null;
			}
		}
		return minValues;
	}

	private static double[] getMaxesInRange(double[] list, int numMaxes, LimitRange range) {
		int n = list.length;
		double[] maxValues = new double[numMaxes];
		double[] maxIndexes = new double[numMaxes];
		for (int i = 0; i < numMaxes; i++) {
			maxValues[i] = -1;
			maxIndexes[i] = -1;
			for (int j = 0; j < n; j++) {
				boolean inRange = numInRange(list[j], range);
				if ((list[j] >= maxValues[i] || maxIndexes[i] == -1) && inRange) {
					boolean good = true;
					for (int k = 0; k < i; k++) {
						if (j == maxIndexes[k]) {
							good = false;
							break;
						}
					}
					if (good) {
						maxValues[i] = list[j];
						maxIndexes[i] = j;
					}
				}
			}
			if (maxIndexes[i] == -1) {
				return null;
			}
		}
		return maxValues;
	}

	private static boolean numInRange(double num, LimitRange range) {
		boolean inRange = true;
		if (range.lowerLimitInclusive) {
			inRange &= (num >= range.lowerLimit);
		} else {
			inRange &= (num > range.lowerLimit);
		}
		if (range.upperLimitInclusive) {
			inRange &= (num <= range.upperLimit);
		} else {
			inRange &= (num < range.upperLimit);
		}
		return inRange;
	}

}
