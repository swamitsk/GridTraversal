package com.projects.amdocs.gridtraversal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projects.amdocs.gridtraversal.Vehicle.Direction;

public class TraversalDemo {
	 private static final Logger LOG = LoggerFactory.getLogger(TraversalDemo.class);


	public static void main(String s[]) {

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Read from File (C) or command line input (R) or Quit (Q)");

			ArrayList<String> list = new ArrayList<String>();

			String nextLine = scanner.nextLine();

			if (nextLine.equals("R")) {
				do {
					nextLine = scanner.nextLine();
					list.add(nextLine);
				} while (!(nextLine.equals("GPS_REPORT")));
				performTraversal(list);
			} else if (nextLine.equals("C")) {
				File text = new File("text.txt");

				Scanner scnr = null;
				try {
					scnr = new Scanner(text);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					LOG.error("File not found :"+text);
					continue;
				}

				if (scanner == null) {
					LOG.error("Cannot read file"+text);
					continue;
				}
				while (scnr.hasNextLine()) {
					list.add(scnr.nextLine());
				}
				performTraversal(list);
			}
			else if (nextLine.equals("Q"))
			{
				break;
			}
			else {
				LOG.error("not valid input try again");
			}
		}

	}

	public static void performTraversal(ArrayList<String> commands) {
		final Services services = ServiceFactory.createServices();
		final VehicleCreatorService creatorService = services.getVehicleCreatorService();
		final ShapeCreatorService shapeService = services.getShapeCreatorService();
		final VehicleTraversalInterface traversalService = services.getVehicleTraverserService();

		Grid grid = shapeService.initialize(5, 5);
		Car car = creatorService.initialize(-1, -1, Direction.SOUTH);
		grid.addVehicle(car);
		ArrayList finalPositions = traversalService.parse(commands, car, grid);

		System.out.println(Arrays.toString(finalPositions.toArray()));

		return;

	}

}
