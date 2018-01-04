package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ValidPathInRectangleWithCircle {

	private int[][] pointsInsideCircle = new int[200][200];
	private int[][] visitedPoints = new int[200][200];

	public static void main(String[] args) {
		
		ArrayList<Integer> xCoordinates = new ArrayList<Integer>(Arrays.asList(6, 53, 42, 27, 34 ,58, 29 ));
		ArrayList<Integer> yCoordinates = new ArrayList<Integer>(Arrays.asList(6 ,16 ,54, 33 ,40, 30, 23));
		System.out.println(new ValidPathInRectangleWithCircle().solve(61, 91, 6, 2 , xCoordinates, yCoordinates));
	}

	public  class Pair {
		int first;
		int second;
		Pair(int x, int y) {
			this.first = x;
			this.second = y;
		}
	}

	public  String solve(int x, int y, int totalCircles, int circleRadius, ArrayList<Integer> xCoordinates,ArrayList<Integer> yCoordinates) {
		
		ArrayList<Pair> v = new ArrayList<Pair>();
		for (int i = 0; i < totalCircles; i++) {
			v.add(new Pair(xCoordinates.get(i), yCoordinates.get(i)));
		}
		for (int i = 0; i <= x + 1; i++) {
			for (int j = 0; j <= y + 1; j++) {
				boolean flag = true;
				for (int k = 0; k < totalCircles; k++) {
					if (isAllCoordinatesInsideCircle(i, j, v.get(k).first, v.get(k).second, circleRadius)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					pointsInsideCircle[i][j] = 0;
				} else {
					pointsInsideCircle[i][j] = 1;
				}
			}
		}
		LinkedList<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0));
		int destinationX = x;
		int destinationY = y;
		while (!queue.isEmpty()) {
			Pair p1 = queue.pollFirst();
			int xx = p1.first;
			int yy = p1.second;
			if (xx == destinationX && yy == destinationY) {
				return "YES";
			}
			if (valid(xx - 1, yy,x,y)) {
				visitedPoints[xx - 1][yy] = 1;
				queue.push(new Pair(xx - 1, yy));
			}
			if (valid(xx, yy - 1,x,y)) {
				visitedPoints[xx][yy - 1] = 1;
				queue.push(new Pair(xx, yy - 1));
			}
			if (valid(xx + 1, yy,x,y)) {
				visitedPoints[xx + 1][yy] = 1;
				queue.push(new Pair(xx + 1, yy));
			}
			if (valid(xx, yy + 1,x,y)) {
				visitedPoints[xx][yy + 1] = 1;
				queue.push(new Pair(xx, yy + 1));
			}
			if (valid(xx + 1, yy + 1,x,y)) {
				visitedPoints[xx + 1][yy + 1] = 1;
				queue.push(new Pair(xx + 1, yy + 1));
			}
			if (valid(xx + 1, yy - 1,x,y)) {
				visitedPoints[xx + 1][yy - 1] = 1;
				queue.push(new Pair(xx + 1, yy - 1));
			}
			if (valid(xx - 1, yy + 1,x,y)) {
				visitedPoints[xx - 1][yy + 1] = 1;
				queue.push(new Pair(xx - 1, yy + 1));
			}
			if (valid(xx - 1, yy - 1,x,y)) {
				visitedPoints[xx - 1][yy - 1] = 1;
				queue.push(new Pair(xx - 1, yy - 1));
			}
		}
		return "NO";
	}

	public  boolean isAllCoordinatesInsideCircle(int x, int y, int x1, int y1, int r) {
		if ((x - x1) * (x - x1) + (y - y1) * (y - y1) <= r * r) {
			return true;
		}
		return false;
	}

	public  boolean valid(int xx, int yy , int x , int y) {
		if (xx >= 0 && xx <= x && yy >= 0 && yy <= y && pointsInsideCircle[xx][yy] == 0
				&& visitedPoints[xx][yy] == 0) {
			return true;
		}
		return false;
	}
}
