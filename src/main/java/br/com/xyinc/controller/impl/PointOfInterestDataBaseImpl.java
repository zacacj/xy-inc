package br.com.xyinc.controller.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.xyinc.controller.PointOfInterestDataBase;
import br.com.xyinc.model.Point;
import br.com.xyinc.model.PointOfInterest;

public class PointOfInterestDataBaseImpl implements PointOfInterestDataBase {

	private final List<PointOfInterest> pointOfInterestDB;

	public PointOfInterestDataBaseImpl() {
		super();
		this.pointOfInterestDB = new ArrayList<PointOfInterest>();
	}

	@Override
	public boolean addPointOfInterest(PointOfInterest poi) {

		return this.pointOfInterestDB.add(poi);
	}

	@Override
	public List<PointOfInterest> listAllPointsOfInterest() {

		return this.pointOfInterestDB;
	}

	@Override
	public List<PointOfInterest> listPointsCloserThenMaxDistanceFromPoint(Point p, int maxDistance) {

		final List<PointOfInterest> pointsCloser = new ArrayList<PointOfInterest>();
		for (final PointOfInterest pointOfInterest : this.pointOfInterestDB) {
			if (p.distanceTo(pointOfInterest) <= maxDistance) {
				pointsCloser.add(pointOfInterest);
			}
		}
		return pointsCloser;
	}

}
