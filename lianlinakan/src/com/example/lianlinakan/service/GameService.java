package com.example.lianlinakan.service;

import com.example.lianlinakan.modles.LinkInfo;
import com.example.lianlinakan.modles.Piece;
/**
 * 游戏逻辑 接口
 * @author Administrator
 *
 */
public interface GameService {

	/**
	 * 返回一个包含方块对象的二维数组
	 * @return
	 *  包含方块对象的二维数组
	 */
	public Piece[][] getPieces();

	/**
	 * 控制游戏开始的方法
	 */
	public void start();
	
	/**
	 * 判断方块数组中是否还有方块
	 * @return true 表示还有方块，false 表示已经没有方块了
	 */
	boolean hasPieces();
	
	/**
	 * 根据鼠标的座标找出对应的方块 
	 * @param touchX 鼠标的x座标
	 * @param touchY 鼠标的y座标
	 * @return 返回对应的方块对象，没有返回null
	 */
	Piece findPiece(float touchX,float touchY);
	
	/**
	 * 判断两个方块是否可以相连
	 * @param p1 第一个方块
	 * @param p2 第二个方块
	 * @return 
	 * 	如果可以连接，两个方块之间的连接点信息，如果不可以连接，返回null
	 */
	LinkInfo link(Piece p1,Piece p2);
}
