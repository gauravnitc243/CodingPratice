package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class PointsinsideRectangle {

	public static void main(String[] args) {

	}

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D) {
		int result = 0;
		double rectangleArea = calculateTriangleArea(A.get(0), B.get(0), A.get(1), B.get(1), A.get(2), B.get(2))
				+ calculateTriangleArea(A.get(2), B.get(2), A.get(3), B.get(3), A.get(0), B.get(0));
		for (int i = 0; i < C.size(); i++)
			result += isPointLiesInsideRectangle(A, B, C.get(i), D.get(i), rectangleArea);
		return result;
	}

	public double calculateTriangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
		return 0.5 * ((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)));
	}

	public int isPointLiesInsideRectangle(ArrayList<Integer> A, ArrayList<Integer> B, int X, int Y,double rectangleArea) {
		double totalArea = 0;
		for (int i = 0; i < 4; i++) {
			double area = calculateTriangleArea(A.get(i % 4), B.get(i % 4), A.get((i + 1) % 4), B.get((i + 1) % 4), X,Y);
			if (area == 0)
				return 0;
			else
				totalArea += area;
		}
		if (totalArea == rectangleArea)
			return 1;
		return 0;
	}

}
