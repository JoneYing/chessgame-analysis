package com.game.analysis.changde.init;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化麻将类
 * @author YingJH
 *
 */
public class InitMJ {

	private static List<Integer> list;
	
	/**
	 * 
	 * 初始化一副麻将所有的牌的角标
	 * 角标 0-135
	 * 角标顺序依次为 
	 * 一饼的角标、二饼的角标...
	 * 一万的角标、二万的角标...
	 * 一条的角标、二条的角标...
	 * 东的角标、南的角标、西的角标、北的角标、发的角标、白的角标、中的角标
	 */
	static{
		list = new ArrayList<Integer>();
		//136=34*4
		for(int i=0;i<136;i++) list.add(i/4);
	}
	
	
	public static Map<String, List<Integer>> init() {
		ArrayList<Integer> disorder = new ArrayList<Integer>();
		disorder.addAll(list);
		Collections.shuffle(disorder);

		//初始化4手牌 剩余的做摸牌
		List<Integer> chessOne = disorder.subList(0,13);
		List<Integer> chessTwo = disorder.subList(13,26);
		List<Integer> chessThree = disorder.subList(26,39);
		List<Integer> chessFour = disorder.subList(39,52);
		List<Integer> residue = disorder.subList(52,disorder.size());
		
		//将4手牌和摸牌装入map
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("chessOne", chessOne);
		map.put("chessTwo", chessTwo);
		map.put("chessThree", chessThree);
		map.put("chessFour", chessFour);
		map.put("residue", residue);
		return map;
	}
	
	
}
