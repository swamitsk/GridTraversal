package com.projects.amdocs.gridtraversal;

import java.util.ArrayList;
import java.util.List;

public interface VehicleTraversalInterface {
	
		
	public Vehicle moveForward(Vehicle v,Grid g);
	
	public Vehicle turnLeft(Vehicle v);
	
	public Vehicle turnRight(Vehicle v);
	
	public ArrayList<String> parse(List<String> s, Vehicle v, Grid g);

}
