package com.projects.amdocs.gridtraversal;

import java.util.ArrayList;

public class Grid {
	
	ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
	int maxX = -1;
	int maxY = -1;
	String name = new String();
	
	public ArrayList<Vehicle> getCars() {
		return cars;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addVehicle(Car car) {
		cars.add(car);
	}
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	

}
