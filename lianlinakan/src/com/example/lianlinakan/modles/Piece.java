package com.example.lianlinakan.modles;

import android.graphics.Point;

/**
 * one block
 * 
 * @author Administrator
 * 
 */
public class Piece {
	/** x-coordinate */
	private int beginX;
	/** y-coordinate */
	private int beginY;
	/** x-index in array */
	private int indexX;
	/** y-index in array */
	private int indexY;
	/** the image of the coordinate */
	private PieceImage image;

	public Piece(int beginX, int beginY) {
		super();
		this.beginX = beginX;
		this.beginY = beginY;
	}

	public int getBeginX() {
		return beginX;
	}

	public void setBeginX(int beginX) {
		this.beginX = beginX;
	}

	public int getBeginY() {
		return beginY;
	}

	public void setBeginY(int beginY) {
		this.beginY = beginY;
	}

	public int getIndexX() {
		return indexX;
	}

	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}

	public int getIndexY() {
		return indexY;
	}

	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}

	public PieceImage getImage() {
		return image;
	}

	public void setImage(PieceImage image) {
		this.image = image;
	}

	/**
	 * get center point of the piece
	 * 
	 * @return
	 */
	public Point getCenter() {
		return new Point(image.getImage().getWidth() / 2, image.getImage()
				.getHeight() / 2);
	}

	public boolean isSameImage(Piece otherPiece){
		if (this.image ==null || otherPiece.getImage() == null) {
			return false;
		}
		return this.image.getImageId()==otherPiece.getImage().getImageId();
	}
}
