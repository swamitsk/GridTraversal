package com.projects.amdocs.gridtraversal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projects.amdocs.gridtraversal.Vehicle.Direction;



public class CarGridTraverserTest {
	
	private VehicleCreatorService creatorService;
	private VehicleTraversalInterface traversalService;
	private ShapeCreatorService shapeService;
	private Vehicle v1,v2,v3,v4,v5,v6,v7,v8;
	private Grid g;
	private List<String> a = new ArrayList<>();
	String s[] = new String[] {"INIT 1,1,WEST","FORWARD","FORWARD","FORWARD","TURN_LEFT","TURN_LEFT","FORWARD","GPS_REPORT",
	                        "INIT 1,1,EAST","FORWARD","FORWARD","FORWARD","TURN_LEFT","TURN_LEFT","FORWARD","GPS_REPORT",
	                        "INIT 1,1,SOUTH","FORWARD","FORWARD","FORWARD","TURN_RIGHT","FORWARD","GPS_REPORT",
	                        "INIT 1,1,EAST","FORWARD","FORWARD","FORWARD","TURN_RIGHT","FORWARD","GPS_REPORT",
	                        "INIT 1,1,NORTH","FORWARD","FORWARD","FORWARD","TURN_LEFT","TURN_LEFT","FORWARD","TURN_RIGHT","GPS_REPORT",
	                        "INIT 6,6,WEST","FORWARD","FORWARD","FORWARD","TURN_LEFT","TURN_LEFT","FORWARD","GPS_REPORT",
	                        "INIT 4,4,NORTH","FORWARD","FORWARD","FORWARD","TURN_LEFT","TURN_LEFT","FORWARD","GPS_REPORT1",
	                        "INIT 1,1,WEST1","FORWARD","FORWARD","FORWARD","TURN_LEF1T","TURN_LEFT","FORWARD","GPS_REPORT"
	                    
					};
	
	
	 @Before
	    public void setUp() {
	        final Services services = ServiceFactory.createServices();
	        creatorService = services.getVehicleCreatorService();
	        traversalService = services.getVehicleTraverserService();
	         shapeService = services.getShapeCreatorService();
	        v1 = creatorService.initialize(1,1,Direction.SOUTH);
	        v6 = creatorService.initialize(1,1,Direction.EAST);
	        v7 = creatorService.initialize(1,1,Direction.NORTH);
	        v8 = creatorService.initialize(1,1,Direction.WEST);
	        v4 = creatorService.initialize(1,0,Direction.SOUTH);
	        v2 = creatorService.initialize(1,1,Direction.NORTH);
	        v5 = creatorService.initialize(5,5,Direction.NORTH);
	        v3 = creatorService.initialize(1,1,Direction.EAST);
	        g = shapeService.initialize(5, 5);

	         
	    }

	 @Test
	public void moveForwardTest() {
		assertEquals(v4.getPosition(),traversalService.moveForward(v1,g).getPosition());
		assertEquals(v5.getPosition(),traversalService.moveForward(v5, g).getPosition());
		
	}
	 
	 @Test
	 public void turnLeftTest(){
		 assertEquals(v7.getPosition(),traversalService.turnLeft(v6).getPosition());
		 assertEquals(v8.getPosition(),traversalService.turnLeft(v7).getPosition());
	 }
	 
	 @Test
	 public void turnRightTest(){
		 assertEquals(v6.getPosition(),traversalService.turnRight(v7).getPosition());
		 assertEquals(v8.getPosition(),traversalService.turnRight(v1).getPosition());
	 }
	 
	 @Test
	 public void parserTest(){
		 Collections.addAll(a, s);
		 String s[] = {"1 1 EAST","3 1 WEST", "0 0 WEST", "4 0 SOUTH","1 3 WEST","1 3 EAST","5 1 EAST"};
		 ArrayList<String> response = new ArrayList<>();
		 Collections.addAll(response, s);
		 assertEquals(response,traversalService.parse(a, v1, g));
	 }
	

}
