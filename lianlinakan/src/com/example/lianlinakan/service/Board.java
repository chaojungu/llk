package com.example.lianlinakan.service;

import java.util.List;

import com.example.lianlinakan.cfg.GameConfig;
import com.example.lianlinakan.modles.Piece;
import com.example.lianlinakan.modles.PieceImage;
import com.example.lianlinakan.util.ImageUtil;

public abstract class Board {
	/**
	 * 根据游戏配置 在 指定方块数组 中生成游戏中的方块
	 * @param cfg 游戏配置
	 * @param pieces 方块数组
	 * @return
	 * 	所有的非空方块
	 */
	protected abstract List<Piece> createPieces(GameConfig cfg,
			Piece[][] pieces);
	
	public Piece[][] create(GameConfig cfg){
		//根据游戏配置中的行数和列数来创建数组
		Piece[][] pieces=new Piece[cfg.getXSize()][cfg.getYSize()];
		//返回在数组中非空的方块集合
		List<Piece> notNullPieces=createPieces(cfg,pieces);
		//根据非空集合的大小来取图片
		List<PieceImage> images=ImageUtil.getPalyImages(cfg.getContext(),notNullPieces.size());
		//获取图片的宽和高
		int imageWidth=images.get(0).getImage().getWidth();
		int imageHeight=images.get(0).getImage().getHeight();
		//遍历非空的方块集合,计算每个方块的x和y座标，并放入对应的数组位置
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
