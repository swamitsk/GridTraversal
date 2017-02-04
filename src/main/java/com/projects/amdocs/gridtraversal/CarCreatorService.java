package com.projects.amdocs.gridtraversal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projects.amdocs.gridtraversal.Vehicle.Direction;



public class CarCreatorService extends AbstractService implements VehicleCreatorService {
	 private static final Logger LOG = LoggerFactory.getLogger(CarGridTraverser.class);


	public CarCreatorService(Services service) {
		super(service);
	}

	public Car initialize(int pointX, int pointY, Direction direction) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setxAxis(pointX);
		car.setyAxis(pointY);
		car.setDirection(direction);
        LOG.debug("Created Car: {}", car.getPosition());
		return car;
		
	}

}


