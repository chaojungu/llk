package com.example.lianlinakan.service.impl;

import com.example.lianlinakan.cfg.GameConfig;
import com.example.lianlinakan.modles.LinkInfo;
import com.example.lianlinakan.modles.Piece;
import com.example.lianlinakan.service.Board;
import com.example.lianlinakan.service.GameService;

public class GameServiceImpl implements GameService {
	// ��ʾ������Ϸ����Ķ�ά����
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
		// ������Ϸ����������
		Board board = null;

		// ������ֱ����������
		board = new VerticalBoard();
		// ʹ����崴����Ϸ�����еķ�������
		this.pieces = board.create(gameConfig);

	}

	@Override
	public boolean hasPieces() {
		// �Զ�ά������б����������һ����Ϊ�գ�����true

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
		//����λ��
		int indexX = getIndex(relativeX, this.gameConfig.PIECE_WIDTH);
		int indexY = getIndex(relativeY, this.gameConfig.PIECE_Height);
		// �������������������С������С, ����null
		if (indexX == -1 || indexY == -1) {
			return null;
			// �������λ�ô�����������λ��
		} else if (indexX >= this.gameConfig.getXSize()
				|| indexY >= this.gameConfig.getYSize()) {
			return null;
		} else {
			return this.pieces[indexX][indexY];
		}
	}

	// ���߷���, ����relative������������Piece[][]����ĵ�һά
	// ��ڶ�ά������ֵ ��sizeΪÿ��ͼƬ�ߵĳ����߿�
	private int getIndex(int relative, int size) {
		int index = -1;
		// ��������Ա߳�, û������, ������1
		// �������x����Ϊ20, �߿�Ϊ10, 20 % 10 û������,
		// indexΪ1, ���������е�����Ϊ1(�ڶ���Ԫ��)
		if (relative % size == 0) {
			index = relative / size - 1;
		} else {
			// ������, �������x����Ϊ21, �߿�Ϊ10, 21 % 10������, indexΪ2
			// ���������е�����Ϊ2(������Ԫ��)
			index = relative / size;
		}
		return index;
	}

	@Override
	public LinkInfo link(Piece p1, Piece p2) {
		// ����Piece��ͬһ��, ��ѡ����ͬһ������, ����null
		if (p1.equals(p2))
			return null;
		// ���p1��ͼƬ��p2��ͼƬ����ͬ, �򷵻�null
		if (!p1.isSameImage(p2))
			return null;
		
		return null;
	}

}
