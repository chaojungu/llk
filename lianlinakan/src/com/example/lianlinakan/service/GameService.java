package com.example.lianlinakan.service;

import com.example.lianlinakan.modles.LinkInfo;
import com.example.lianlinakan.modles.Piece;
/**
 * ��Ϸ�߼� �ӿ�
 * @author Administrator
 *
 */
public interface GameService {

	/**
	 * ����һ�������������Ķ�ά����
	 * @return
	 *  �����������Ķ�ά����
	 */
	public Piece[][] getPieces();

	/**
	 * ������Ϸ��ʼ�ķ���
	 */
	public void start();
	
	/**
	 * �жϷ����������Ƿ��з���
	 * @return true ��ʾ���з��飬false ��ʾ�Ѿ�û�з�����
	 */
	boolean hasPieces();
	
	/**
	 * �������������ҳ���Ӧ�ķ��� 
	 * @param touchX ����x����
	 * @param touchY ����y����
	 * @return ���ض�Ӧ�ķ������û�з���null
	 */
	Piece findPiece(float touchX,float touchY);
	
	/**
	 * �ж����������Ƿ��������
	 * @param p1 ��һ������
	 * @param p2 �ڶ�������
	 * @return 
	 * 	����������ӣ���������֮������ӵ���Ϣ��������������ӣ�����null
	 */
	LinkInfo link(Piece p1,Piece p2);
}
