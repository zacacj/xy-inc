package br.com.xyinc.controller;

import java.util.List;

import br.com.xyinc.model.Point;
import br.com.xyinc.model.PointOfInterest;

public interface PointOfInterestDataBase {

	/**
	 * Method used to add a point of interest to the system.
	 * 
	 * @param poi
	 * @return
	 */
	boolean addPointOfInterest(PointOfInterest poi);

	/**
	 * Method used to retrieve all points of interests registered in the system.
	 * 
	 * @return
	 */
	List<PointOfInterest> listAllPointsOfInterest();

	/**
	 * Method used to retrieve all point of interest registered in the system
	 * that are closer than maxDistance from a reference point P.
	 * 
	 * @param p
	 * @param maxDistance
	 * @return
	 */
	List<PointOfInterest> listPointsCloserThenMaxDistanceFromPoint(Point p, int maxDistance);

}
