package com.projects.amdocs.gridtraversal;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.projects.amdocs.gridtraversal.Vehicle.Direction;

public class CarGridTraverser extends AbstractService implements VehicleTraversalInterface {

	private static final Logger LOG = LoggerFactory.getLogger(CarGridTraverser.class);

	public CarGridTraverser(Services services) {
		super(services);
	}

	public Vehicle moveForward(Vehicle v, Grid g) {

		requireNonNull(g);
		requireNonNull(v);
		LOG.debug("DIR :" + v.getDirection().toString() + "  " + v.getxAxis() + "  " + v.getyAxis());
		if (v.getDirection().toString().equals(TraversalConstant.SOUTH) && v.getyAxis() > 0) {
			int temp = v.getyAxis() - 1;
			v.setyAxis(temp);
			LOG.debug("DIR :" + v.getDirection().toString() + "  " + v.getxAxis() + "  " + v.getyAxis());
		} else if (v.getDirection().toString().equals(TraversalConstant.NORTH) && v.getyAxis() < g.getMaxY()
				&& v.getyAxis() >= 0) {
			int temp = v.getyAxis() + 1;
			v.setyAxis(temp);
			LOG.debug("DIR :" + v.getDirection().toString() + "  " + v.getxAxis() + "  " + v.getyAxis());
		} else if (v.getDirection().toString().equals(TraversalConstant.WEST) && v.getxAxis() > 0) {
			int temp = v.getxAxis() - 1;
			v.setxAxis(temp);
			LOG.debug("DIR :" + v.getDirection().toString() + "  " + v.getxAxis() + "  " + v.getyAxis());
		} else if (v.getDirection().toString().equals(TraversalConstant.EAST) && v.getxAxis() >= 0
				&& v.getxAxis() < g.getMaxX()) {
			int temp = v.getxAxis() + 1;
			v.setxAxis(temp);
			LOG.debug("DIR :" + v.getDirection().toString() + "  " + v.getxAxis() + "  " + v.getyAxis());
		} else {
			LOG.debug("Out of Scope from :" + v.getPosition());
		}
		return v;
	}

	public Vehicle turnLeft(Vehicle v) {
		LOG.debug("Current Direction :" + v.getDirection());
		v.setDirection(v.getDirection().getNext());
		LOG.debug("Current Direction :"+v.getDirection());
		return v;

	}

	public Vehicle turnRight(Vehicle v) {
		LOG.debug("Current Direction :"+v.getDirection());
		v.setDirection(v.getDirection().getPrev());
		LOG.debug("Current Direction :"+v.getDirection());

		return v;

	}

	public ArrayList<String> parse(List<String> l, Vehicle v, Grid g) {
		ArrayList<String> returnVal = new ArrayList<String>();
		for (int i = 0; i < l.size(); i++) {
			LOG.debug("command :" + l.get(i));
			if (l.get(i).startsWith(TraversalConstant.INIT)) {
				List<String> list = new ArrayList<String>(Arrays.asList(l.get(i).split(",")));
				LOG.debug("list size:" + list.size());
				if (list.size() != 3) {
					LOG.debug("invalid line input ignoring " + l.get(i));
					continue;
				}
				try {
					int tempX = Integer.valueOf(list.get(0).substring(list.get(0).indexOf(" ")).trim());
					int tempY = Integer.valueOf(list.get(1).trim());
					Direction tempDir = Direction.valueOf(list.get(2).trim());

					if ((tempX <= g.getMaxX() && tempX >= 0) && (tempY <= g.getMaxY() && tempY >= 0)
							&& (tempDir != null)) {
						LOG.debug("init x:" + tempX + "init Y:" + tempY + " direction :" + tempDir);
						v.setxAxis(tempX);
						v.setyAxis(tempY);
						v.setDirection(tempDir);
					}
					else
					{
						LOG.error("invalid line input ignoring 2" + l.get(i));
						continue;

					}
				} catch (IllegalArgumentException iae) {
					LOG.error("invalid line input ignoring 2" + l.get(i));
					continue;
				}

			} else if (l.get(i).trim().equals("FORWARD")) {
				moveForward(v, g);
			} else if (l.get(i).trim().equals(TraversalConstant.TURN_LEFT)) {
				turnLeft(v);
			} else if (l.get(i).trim().equals(TraversalConstant.TURN_RIGHT)) {
				turnRight(v);
			} else if (l.get(i).equals("GPS_REPORT")) {
				returnVal.add(v.getPosition().toString());
			} else {
				LOG.error("invalid line input ignoring " + l.get(i));
				continue;
			}
		}

		return returnVal;
	}

	public String parse(ArrayList<String> s) {
		// TODO Auto-generated method stub
		return null;
	}

}
