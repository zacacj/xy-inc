package br.com.xyinc.model;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {

		return this.x;
	}

	public void setX(int x) {

		this.x = x;
	}

	public int getY() {

		return this.y;
	}

	public void setY(int y) {

		this.y = y;
	}

	public double distanceTo(Point p) {

		return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2));
	}

}
