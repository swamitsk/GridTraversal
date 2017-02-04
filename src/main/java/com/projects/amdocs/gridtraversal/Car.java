package com.projects.amdocs.gridtraversal;

import java.util.ArrayList;

public class Car implements Vehicle {

	 private int xAxis;
	    private int yAxis;
	    private Direction direction;
	    private ArrayList<String> instructions= new ArrayList<>();

	    
	   
	public ArrayList<String> getInstructions() {
			return instructions;
		}

		public void addInstruction(String instruction) {
			instructions.add(instruction);
		}

	public Car() {
		xAxis = -1;
		yAxis = -1;
		direction = Direction.SOUTH;
		
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;		
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;		
		
	}

	public void setDirection(Direction direction) {
		this.direction=direction;
		
	}

	public int getxAxis() {
		return xAxis;
	}

	public int getyAxis() {
		return yAxis; 
		}

	
	public Direction getDirection()
	{
		return direction;
	}
	public String getPosition()
	{
		return this.getxAxis()+" "+this.getyAxis()+" "+this.getDirection();
	}

}
