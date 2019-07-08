package com.game.analysis.changde.core;

/**
 * ÅĞ¶Ï·ç×Ö
 * @author YingJH
 *
 */
public class SentencedFeng {

	public static int checkFeng(int[] cards, int maxKing, int cacheIndex,int[] cache) {
		if (cacheIndex >= 0) {
			int n = cache[cacheIndex];
			if (n > 0)
				return n - 1;
		}

		int needKing = 0;
		for (int i = 27; i < 34; i++) {
			int c = cards[i];
			if (c == 0) continue;
			if (c == 1 || c == 4) {
				needKing = needKing + 2;
			} else if (c == 2) {
				needKing = needKing + 1;
			}
			if (needKing > maxKing)
				return needKing;
		}

		return needKing;
	}
	
}
