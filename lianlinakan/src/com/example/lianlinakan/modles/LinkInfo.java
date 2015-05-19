package com.example.lianlinakan.modles;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;
/**
 * 连接点信息
 * @author Administrator
 *
 */
public class LinkInfo {

	private List<Point> points = new ArrayList<Point>();
	//直线的两个点
	public LinkInfo(Point p1, Point p2) {
		// TODO Auto-generated constructor stub
		this.points.add(p1);
		this.points.add(p2);

	}

	//折线的三个点
	public LinkInfo(Point p1, Point p2, Point p3) {
		// TODO Auto-generated constructor stub
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);
	}

	//双折线的四个点
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
