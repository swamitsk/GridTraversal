package com.projects.amdocs.gridtraversal;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GridCreatorService extends AbstractService implements ShapeCreatorService {

	private final Logger LOG = LoggerFactory.getLogger(GridCreatorService.class);
	
    private final Map<String, Grid> groups = new HashMap<>();

	
	public GridCreatorService(Services service) {
		super(service);
	}

	public Grid initialize(int maxX, int maxY) {

		// TODO Auto-generated method stub
        requireNonNull(maxX, "grid val x");
        requireNonNull(maxY, "grid val y");
        
		Grid grid = new Grid();
		grid.setMaxX(maxX);
		grid.setMaxY(maxY);
        LOG.debug("Created group: {}", grid.getName());
		return grid;

	}
}
