package com.example.lianlinakan.service;

import java.util.List;

import com.example.lianlinakan.cfg.GameConfig;
import com.example.lianlinakan.modles.Piece;
import com.example.lianlinakan.modles.PieceImage;
import com.example.lianlinakan.util.ImageUtil;

public abstract class Board {
	/**
	 * ������Ϸ���� �� ָ���������� ��������Ϸ�еķ���
	 * @param cfg ��Ϸ����
	 * @param pieces ��������
	 * @return
	 * 	���еķǿշ���
	 */
	protected abstract List<Piece> createPieces(GameConfig cfg,
			Piece[][] pieces);
	
	public Piece[][] create(GameConfig cfg){
		//������Ϸ�����е���������������������
		Piece[][] pieces=new Piece[cfg.getXSize()][cfg.getYSize()];
		//�����������зǿյķ��鼯��
		List<Piece> notNullPieces=createPieces(cfg,pieces);
		//���ݷǿռ��ϵĴ�С��ȡͼƬ
		List<PieceImage> images=ImageUtil.getPalyImages(cfg.getContext(),notNullPieces.size());
		//��ȡͼƬ�Ŀ�͸�
		int imageWidth=images.get(0).getImage().getWidth();
		int imageHeight=images.get(0).getImage().getHeight();
		//�����ǿյķ��鼯��,����ÿ�������x��y���꣬�������Ӧ������λ��
		int size=notNullPieces.size();
		Piece tempPiece;
		for (int i = 0; i < size; i++) {
			tempPiece = notNullPieces.get(i);
			tempPiece.setBeginX(imageWidth*tempPiece.getIndexX()
					+cfg.getBeginImageX());
			tempPiece.setBeginY(imageHeight*tempPiece.getIndexY()
					+cfg.getBeginImageY());
			pieces[tempPiece.getIndexX()][tempPiece.getBeginY()]=tempPiece;
		}
		return pieces;
	}
}
