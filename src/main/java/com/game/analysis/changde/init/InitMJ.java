package com.game.analysis.changde.init;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��ʼ���齫��
 * @author YingJH
 *
 */
public class InitMJ {

	private static List<Integer> list;
	
	/**
	 * 
	 * ��ʼ��һ���齫���е��ƵĽǱ�
	 * �Ǳ� 0-135
	 * �Ǳ�˳������Ϊ 
	 * һ���ĽǱꡢ�����ĽǱ�...
	 * һ��ĽǱꡢ����ĽǱ�...
	 * һ���ĽǱꡢ�����ĽǱ�...
	 * ���ĽǱꡢ�ϵĽǱꡢ���ĽǱꡢ���ĽǱꡢ���ĽǱꡢ�׵ĽǱꡢ�еĽǱ�
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

		//��ʼ��4���� ʣ���������
		List<Integer> chessOne = disorder.subList(0,13);
		List<Integer> chessTwo = disorder.subList(13,26);
		List<Integer> chessThree = disorder.subList(26,39);
		List<Integer> chessFour = disorder.subList(39,52);
		List<Integer> residue = disorder.subList(52,disorder.size());
		
		//��4���ƺ�����װ��map
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		map.put("chessOne", chessOne);
		map.put("chessTwo", chessTwo);
		map.put("chessThree", chessThree);
		map.put("chessFour", chessFour);
		map.put("residue", residue);
		return map;
	}
	
	
}
