package com.example.lianlinakan.service.impl;

import com.example.lianlinakan.cfg.GameConfig;
import com.example.lianlinakan.modles.LinkInfo;
import com.example.lianlinakan.modles.Piece;
import com.example.lianlinakan.service.Board;
import com.example.lianlinakan.service.GameService;

public class GameServiceImpl implements GameService {
	// 表示整个游戏区域的二维数组
	private Piece[][] pieces;
	private GameConfig gameConfig;

	public GameServiceImpl(GameConfig cfg) {
		this.gameConfig = cfg;
	}

	@Override
	public Piece[][] getPieces() {
		return this.pieces;
	}

	@Override
	public void start() {
		// 定义游戏区域面板对象
		Board board = null;

		// 创建垂直区域面板对象
		board = new VerticalBoard();
		// 使用面板创建游戏区域中的方块数组
		this.pieces = board.create(gameConfig);

	}

	@Override
	public boolean hasPieces() {
		// 对二维数组进行遍历，如果有一个不为空，返回true

		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				if (pieces[i][i] != null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Piece findPiece(float touchX, float touchY) {
		int relativeX = (int) touchX - this.gameConfig.getBeginImageX();
		int relativeY = (int) touchY - this.gameConfig.getBeginImageY();
		if (relativeX < 0 || relativeY < 0) {
			return null;
		}
		//计算位置
		int indexX = getIndex(relativeX, this.gameConfig.PIECE_WIDTH);
		int indexY = getIndex(relativeY, this.gameConfig.PIECE_Height);
		// 这两个索引比数组的最小索引还小, 返回null
		if (indexX == -1 || indexY == -1) {
			return null;
			// 如果索引位置大于最大的索引位置
		} else if (indexX >= this.gameConfig.getXSize()
				|| indexY >= this.gameConfig.getYSize()) {
			return null;
		} else {
			return this.pieces[indexX][indexY];
		}
	}

	// 工具方法, 根据relative座标计算相对于Piece[][]数组的第一维
	// 或第二维的索引值 ，size为每张图片边的长或者宽
	private int getIndex(int relative, int size) {
		int index = -1;
		// 让座标除以边长, 没有余数, 索引减1
		// 例如点了x座标为20, 边宽为10, 20 % 10 没有余数,
		// index为1, 即在数组中的索引为1(第二个元素)
		if (relative % size == 0) {
			index = relative / size - 1;
		} else {
			// 有余数, 例如点了x座标为21, 边宽为10, 21 % 10有余数, index为2
			// 即在数组中的索引为2(第三个元素)
			index = relative / size;
		}
		return index;
	}

	@Override
	public LinkInfo link(Piece p1, Piece p2) {
		// 两个Piece是同一个, 即选中了同一个方块, 返回null
		if (p1.equals(p2))
			return null;
		// 如果p1的图片与p2的图片不相同, 则返回null
		if (!p1.isSameImage(p2))
			return null;
		
		return null;
	}

}
