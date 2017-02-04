package com.projects.amdocs.gridtraversal;

import java.util.ArrayList;

public interface Vehicle 
{
	 public static enum Direction {
		 SOUTH("SOUTH"), EAST("EAST"), NORTH("NORTH"), WEST("WEST");
			
			private String value;  
	    	private Direction(String value){  
	    	this.value=value;  
	    	}  
	    	public Direction getNext() {
	    	      return this.ordinal() < Direction.values().length - 1
	    	          ? Direction.values()[this.ordinal() + 1]
	    	          : Direction.values()[0];
	    	    }
	    	public Direction getPrev() {
	    	      return this.ordinal() > 0
	    	          ? Direction.values()[this.ordinal() - 1]
	    	          : Direction.values()[Direction.values().length - 1];
	    	    }
		}
	public void setxAxis(int xAxis);
	
	public void setyAxis(int yAxis);
	
	public void setDirection(Direction direction);
	
	public int getxAxis();
	public int getyAxis();
	public Direction getDirection();
	public String getPosition();
	public void addInstruction(String s);
	public ArrayList<String> getInstructions();
}
