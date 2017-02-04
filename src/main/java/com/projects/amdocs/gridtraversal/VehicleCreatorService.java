package com.projects.amdocs.gridtraversal;

import com.projects.amdocs.gridtraversal.Vehicle.Direction;

public interface VehicleCreatorService {

	public Car initialize(int pointX, int pointY, Direction direction);

}
