package com.game.analysis.changde;

import com.game.analysis.changde.bean.ChessBean;
import com.game.analysis.changde.core.SentencedCore;

public class SentencedHu {

	/**
	 * 
	 * @param cards ��ǰ��Ҫ�к����齫����
	 * �Ǳ� 0-33 
	 * �Ǳ�˳������Ϊ 
	 * һ��������...
	 * һ�򡢶���...
	 * һ��������...
	 * �����ϡ��������������ס���
	 * ֵ��ʾ��ǰ���к���ӵ�еĸ���
	 */
	public static boolean sentencedHu(ChessBean bean) {
		if(SentencedCore.isHu(bean)) return true;
		return false;
	}
	
	public static void main(String[] args) {
//		test34();
		test27();
		int d=1;
		d++;
		System.out.println(d);
		
	}
	
	public static void test34(){
		int[] cards = {
			1,1,4,0,0,0,0,0,0,
			1,0,0,1,0,0,0,0,0,
			0,0,0,0,0,0,0,0,0,
			0,0,0,0,2,0,3
		};
		ChessBean bean = new ChessBean();
		bean.setHandCards(cards);
		bean.setCurCard(34);
		bean.setKingIndex(33);
		bean.setHasFeng(false);
		boolean result = sentencedHu(bean);
		System.out.println("test34:"+result);
	}
	
	public static void test27(){
		int[] cards = {
			1,0,0,1,1,1,0,0,0,
			1,1,1,0,2,0,0,0,0,
			0,0,0,0,0,0,0,1,1,3
		};
		ChessBean bean = new ChessBean();
		bean.setHandCards(cards);
		bean.setCurCard(28);
		bean.setKingIndex(27);
		bean.setHasFeng(true);
		boolean result = sentencedHu(bean);
		System.out.println("test27:"+result);
	}
	
}
