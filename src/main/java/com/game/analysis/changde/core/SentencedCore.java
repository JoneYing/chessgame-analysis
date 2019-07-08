package com.game.analysis.changde.core;

import com.game.analysis.changde.bean.ChessBean;

/**
 * �к����Ĵ�����
 * 
 * @author YingJH
 * 
 */
public class SentencedCore {
	
	/**
	 * 
	 * @param bean �齫����
	 * @return
	 */
	public static boolean isHu(ChessBean bean) {
		
		//��ǰ���к�����
		int[] handCards = bean.getHandCards();
		
		//���ƽǱ�
		int kingIndex = bean.getKingIndex();
		
		//�Ƿ���Ҫ�жϷ���
		boolean hasFeng = bean.getHasFeng();
		
		//�齫���� ��+��+��+��=9+9+9+7
		int categoryCount = 34;
		
		int[] cards = new int[categoryCount];

		//��������
		System.arraycopy(bean.getHandCards(), 0, cards, 0, handCards.length);

		int kingNum = 0;
		//�ж��Ƿ��������,���������ֵ��kingNum������ǰ�Ǳ�ֵ����Ϊ0
		if (kingIndex < categoryCount) {
			kingNum = cards[kingIndex];
			cards[kingIndex] = 0;
		}

		int[] eyeTbl = new int[categoryCount];
		int eyeNum = 0;
		int empty = -1;
		for (int i = 0; i < categoryCount; ++i) {
			// �Ż��ֶΣ����������ƣ�������
			int min = (i / 9) * 9;
			int max = min + 8;
			if (max > categoryCount) max = categoryCount-1;
			if (cards[i] == 1 && (i - 2 < min || cards[i - 2] == 0)
					&& (i - 1 < min || cards[i - 1] == 0)
					&& (i + 1 > max || cards[i + 1] == 0)
					&& (i + 2 > max || cards[i + 2] == 0)) {
				if (kingNum < 0) {
					return false;
				}
				eyeNum = 1;
				eyeTbl[0] = i;
				empty = -1;
				break;
			}
			if (empty == -1 && cards[i] == 0) empty = i;
			
			if (cards[i] > 0 && cards[i] + kingNum >= 2)  eyeTbl[eyeNum++] = i;
		} //for end
		
		if (empty > 0)  eyeTbl[eyeNum++] = empty;

		boolean hu = false;
		int[] cache = { 0, 0, 0, 0 };
		for (int i = 0; i < eyeNum; i++) {
			int eye = eyeTbl[i];
			if (eye == empty) {
				hu = foreachEye(cards, kingNum - 2, kingNum, 1000, cache,hasFeng);
			} else {
				int n = cards[eye];
				if (n == 1) {
					cards[eye] = 0;
					hu = foreachEye(cards, kingNum - 1, kingNum, eye / 9,cache,hasFeng);
				} else {
					cards[eye] -= 2;
					hu = foreachEye(cards, kingNum, kingNum, eye / 9, cache,hasFeng);
				}
				cards[eye] = n;
			}
			if (hu) {
				break;
			}
		}

		if (kingNum > 0) {
			cards[kingIndex] = kingNum;
		}
		return hu;
	}

	public static boolean foreachEye(int[] cards, int kingNum, int maxKing,
			int eyeColor, int[] cache,boolean hasFeng) {
		for(int i = 0; i < 3; i++) {
			int cacheIndex = -1;
			if (eyeColor != i) cacheIndex = i;
			int needKing = SentencedHua.checkHua(cards, i * 9, i * 9 + 8, maxKing,cacheIndex, cache);
			if (cacheIndex > 0) {
				cache[i] = needKing + 1;
			}
			kingNum -= needKing;
			if (kingNum < 0) return false;
		}

		int cacheIndex = -1;
		if (eyeColor != 3) cacheIndex = 3;
		int needKing = 0;
		//�ж��з���ģʽ�齫
		if(hasFeng){
			needKing = SentencedFeng.checkFeng(cards, maxKing, cacheIndex, cache);
			if (cacheIndex > 0) {
				cache[3] = needKing + 1;
			}
		}
		return kingNum >= needKing;
	}
}