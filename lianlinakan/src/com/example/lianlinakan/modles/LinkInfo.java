package com.example.lianlinakan.modles;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;

public class LinkInfo {

	private List<Point> points = new ArrayList<Point>();

	public LinkInfo(Point p1, Point p2) {
		// TODO Auto-generated constructor stub
		this.points.add(p1);
		this.points.add(p2);

	}

	public LinkInfo(Point p1, Point p2, Point p3) {
		// TODO Auto-generated constructor stub
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);
	}

	public LinkInfo(Point p1, Point p2, Point p3, Point p4) {
		// TODO Auto-generated constructor stub
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);
		this.points.add(p4);

	}
	
	public List<Point> getLinkPoints() {
		// TODO Auto-generated method stub
		return points;
	}
}
