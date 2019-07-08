package com.game.analysis.utils;

import java.util.List;


public class ChessTable {

	public static int[] conversion(List<Integer> list){
		
		/**
		 * 
		 * �Ǳ� 0-33 
		 * �Ǳ�˳������Ϊ 
		 * һ��������...
		 * һ�򡢶���...
		 * һ��������...
		 * �����ϡ��������������ס���
		 */
		int[] cards = {
				0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0
			};
		
		for(int i = 0, z=list.size(); i < z; i++){
			Integer index = list.get(i);
			cards[index]=cards[index]+1;
		}
		
		return cards;
		
	}
	
}
