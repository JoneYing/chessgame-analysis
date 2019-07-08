package com.game.analysis.utils;

import java.util.List;


public class ChessTable {

	public static int[] conversion(List<Integer> list){
		
		/**
		 * 
		 * 角标 0-33 
		 * 角标顺序依次为 
		 * 一饼、二饼...
		 * 一万、二万...
		 * 一条、二条...
		 * 东、南、西、北、发、白、中
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
