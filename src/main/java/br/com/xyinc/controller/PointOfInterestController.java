package br.com.xyinc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.xyinc.model.PointOfInterest;

/**
 * @author cleber this class is responsible for managing the REST requests
 */
public interface PointOfInterestController {

	/**
	 * Method used to add a point of interest to the system.
	 * 
	 * @param name
	 * @param x
	 * @param y
	 * @return the point of interest for check
	 */
	ResponseEntity<?> addPointOfInterest(@RequestParam(value = "name") String name, @RequestParam(value = "x") int x,
			@RequestParam(value = "y") int y);

	/**
	 * Method used to retrieve all points of interests registered in the system.
	 * 
	 * @return
	 */
	List<PointOfInterest> listPointsOfInterest();

	/**
	 * Method used to retrieve all point of interest registered in the system
	 * that are closer than maxDistance from a reference point P(x,y)
	 * 
	 * @param x
	 * @param y
	 * @param maxDistance
	 * @return
	 */
	List<PointOfInterest> listPointsOfInterestCloserToPoint(@RequestParam(value = "x") int x,
			@RequestParam(value = "y") int y, @RequestParam(value = "maxDistance") int maxDistance);
}
