package com.princeton;

import java.util.Comparator;

public class Point2D implements Comparable<Point2D>{
	
	public static final Comparator<Point2D> X_ORDER = new XOrder();
	public static final Comparator<Point2D> Y_ORDER = new YOrder();
	public static final Comparator<Point2D> POLAR_RADIUS_ORDER = new ROrder();
	private final double x;
	private final double y;
	
    private static class ROrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            double delta = (p.x*p.x + p.y*p.y) - (q.x*q.x + q.y*q.y);
            if (delta < 0) return -1;
            if (delta > 0) return +1;
            return 0;
        }
    }
    
    private static class XOrder implements Comparator<Point2D>{
    	public int compare(Point2D first,Point2D second){
    		if(first.x > second.x)
    			return 1;
    		else if(first.x < second.x)
    			return -1;
    		else 
    			return 0;
    	}
    }
    private static class YOrder implements Comparator<Point2D>{
    	public int compare(Point2D first,Point2D second){
    		if(first.y > second.y)
    			return 1;
    		else if(first.y < second.y)
    			return -1;
    		else 
    			return 0;
    	}
    }
  	public Point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) this.x = 0.0;  
        else          this.x = x;

        if (y == 0.0) this.y = 0.0; 
        else          this.y = y;
    }
  
  	public double x() {
        return x;
    }
    public double y() {
        return y;
    }
    public double r() {
        return Math.sqrt(x*x + y*y);
    }
    public double theta() {
        return Math.atan2(y, x);
    }
    private double angleTo(Point2D that) {
        double dx = that.x - this.x;
        double dy = that.y - this.y;
        return Math.atan2(dy, dx);
    }
    
    public static int isCCW(Point2D a, Point2D b, Point2D c)
    {
    	double area = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
    	if(area < 0) return -1;
    	else if(area >0) return 1;
    	else return 0;
    }
		
    @Override
    public int compareTo(Point2D that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	

}
