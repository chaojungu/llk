package com.example.lianlinakan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.lianlinakan.cfg.GameConfig;
import com.example.lianlinakan.modles.Piece;
import com.example.lianlinakan.service.Board;

public class VerticalBoard extends Board {

	@Override
	protected List<Piece> createPieces(GameConfig cfg, Piece[][] pieces) {
		List<Piece> notNullPieces = new ArrayList<Piece>();
		int row = pieces.length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				if (i % 2 == 0) {
					Piece piece=new Piece(i,j);
					notNullPieces.add(piece);
				}
			}
		}
		return notNullPieces;
	}

}
