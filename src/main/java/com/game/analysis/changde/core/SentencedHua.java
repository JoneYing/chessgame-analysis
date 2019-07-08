package com.game.analysis.changde.core;

/**
 * ÅĞ¶ÏÕı³£»¨ÅÆ
 * 
 * @author YingJH
 *
 */
public class SentencedHua {

	public static int checkHua(int[] cards, int from, int to, int maxKing,
			int cacheIndex, int[] cache) {
		if (cacheIndex >= 0) {
			int n = cache[cacheIndex];
			if (n > 0) return n - 1;
		}

		int n = 0;
		for (int i = from; i <= to; i++) {
			n = n * 10 + cards[i];
		}

		if (n == 0) return 0;

		boolean n3 = false;
		for (int i = 0; i <= maxKing; i++) {
			if ((n + i) % 3 == 0) {
				n3 = true;
				break;
			}
		}

		if (!n3) {
			return maxKing + 1;
		}

		return NextSplit.nextSplit(n, 0, maxKing);
	}

	
}
