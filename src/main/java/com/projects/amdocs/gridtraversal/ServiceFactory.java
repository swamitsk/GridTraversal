package com.projects.amdocs.gridtraversal;

public class ServiceFactory implements Services {

	private final VehicleTraversalInterface traversalService;
	private final VehicleCreatorService creatorService;
	private final ShapeCreatorService gridCreationService;

	public static Services createServices() {
		return new ServiceFactory();
	}

	private ServiceFactory() {
		traversalService = new CarGridTraverser(this);
		creatorService = new CarCreatorService(this);
		gridCreationService = new GridCreatorService(this);
	}

	public VehicleTraversalInterface getVehicleTraverserService() {
		return traversalService;
	}
	
	public ShapeCreatorService getShapeCreatorService() {
		return gridCreationService;
	}

	public VehicleCreatorService getVehicleCreatorService() {
		return creatorService;
	}
}
