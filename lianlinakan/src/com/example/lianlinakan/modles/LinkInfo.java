package com.example.lianlinakan.modles;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;
/**
 * ���ӵ���Ϣ
 * @author Administrator
 *
 */
public class LinkInfo {

	private List<Point> points = new ArrayList<Point>();
	//ֱ�ߵ�������
	public LinkInfo(Point p1, Point p2) {
		// TODO Auto-generated constructor stub
		this.points.add(p1);
		this.points.add(p2);

	}

	//���ߵ�������
	public LinkInfo(Point p1, Point p2, Point p3) {
		// TODO Auto-generated constructor stub
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);
	}

	//˫���ߵ��ĸ���
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
