package br.com.xyinc.model;

public class PointOfInterest extends Point {

	private String name;

	public PointOfInterest(String name, int x, int y) {
		super(x, y);
		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public void setName(String name) {

		this.name = name;
	}

}
