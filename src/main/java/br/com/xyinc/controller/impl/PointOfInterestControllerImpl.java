package br.com.xyinc.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.xyinc.controller.PointOfInterestController;
import br.com.xyinc.model.Point;
import br.com.xyinc.model.PointOfInterest;

@RestController
public class PointOfInterestControllerImpl implements PointOfInterestController {

	PointOfInterestDataBaseImpl pointOfInterestDB;

	PointOfInterestControllerImpl() {

		this.pointOfInterestDB = new PointOfInterestDataBaseImpl();
	}

	@Override
	@RequestMapping(path = "/addpointofinterest", method = RequestMethod.POST)
	public ResponseEntity<?> addPointOfInterest(@RequestParam(value = "name") String name,
			@RequestParam(value = "x") int x, @RequestParam(value = "y") int y) {

		final PointOfInterest poi = new PointOfInterest(name, x, y);

		if ((x > -1) && (y > -1) && this.pointOfInterestDB.addPointOfInterest(poi)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@Override
	@RequestMapping(path = "/listpointsofinterest", method = RequestMethod.GET)
	public List<PointOfInterest> listPointsOfInterest() {

		return this.pointOfInterestDB.listAllPointsOfInterest();
	}

	@Override
	@RequestMapping(path = "/listpointsofinterestclosertopoint", method = RequestMethod.GET)
	public List<PointOfInterest> listPointsOfInterestCloserToPoint(@RequestParam(value = "x") int x,
			@RequestParam(value = "y") int y, @RequestParam(value = "maxDistance") int maxDistance) {

		return this.pointOfInterestDB.listPointsCloserThenMaxDistanceFromPoint(new Point(x, y), maxDistance);
	}

}
