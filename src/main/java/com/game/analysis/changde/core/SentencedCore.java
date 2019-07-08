package com.game.analysis.changde.core;

import com.game.analysis.changde.bean.ChessBean;

/**
 * 判胡核心代码类
 * 
 * @author YingJH
 * 
 */
public class SentencedCore {
	
	/**
	 * 
	 * @param bean 麻将对象
	 * @return
	 */
	public static boolean isHu(ChessBean bean) {
		
		//当前需判胡的牌
		int[] handCards = bean.getHandCards();
		
		//王牌角标
		int kingIndex = bean.getKingIndex();
		
		//是否需要判断风字
		boolean hasFeng = bean.getHasFeng();
		
		//麻将总数 饼+万+条+风=9+9+9+7
		int categoryCount = 34;
		
		int[] cards = new int[categoryCount];

		//复制数组
		System.arraycopy(bean.getHandCards(), 0, cards, 0, handCards.length);

		int kingNum = 0;
		//判断是否存在王牌,如果存在则赋值给kingNum。将当前角标值设置为0
		if (kingIndex < categoryCount) {
			kingNum = cards[kingIndex];
			cards[kingIndex] = 0;
		}

		int[] eyeTbl = new int[categoryCount];
		int eyeNum = 0;
		int empty = -1;
		for (int i = 0; i < categoryCount; ++i) {
			// 优化手段，三不靠的牌，必做将
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
		//判断有风字模式麻将
		if(hasFeng){
			needKing = SentencedFeng.checkFeng(cards, maxKing, cacheIndex, cache);
			if (cacheIndex > 0) {
				cache[3] = needKing + 1;
			}
		}
		return kingNum >= needKing;
	}
}