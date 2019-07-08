package com.game.analysis.changde.core;

public class NextSplit {

	public static int nextSplit(int n, int needKing, int maxKing) {
		int c = 0;
		while (true) {
			if (n == 0) return needKing;
			while (n > 0) {
				c = n % 10;
				n = n / 10;
				if (c != 0)
					break;
			}
			if (c == 1 || c == 4) {
				return one(n, needKing, maxKing);
			} else if (c == 2) {
				return two(n, needKing, maxKing);
			}
		}
	}

	public static int one(int n, int needKing, int maxKing) {
		int c1 = n % 10;
		int c2 = (n % 100) / 10;

		if (c1 == 0)
			++needKing;
		else
			n -= 1;

		if (c2 == 0)
			++needKing;
		else
			n -= 10;

		if (n == 0) return needKing;

		if (needKing > maxKing) return needKing;

		return nextSplit(n, needKing, maxKing);
	}

	public static int two(int n, int needKing, int maxKing) {
		int c1 = n % 10;
		int c2 = (n % 100) / 10;
		int c3 = (n % 1000) / 100;
		int c4 = (n % 10000) / 1000;

		boolean chooseKe = true;
		if (c1 == 0) {
			// c1 == 0 È«²ð¿Ì×Ó
		} else if (c1 == 1) {
			// ¿Ì×Ó
			if (c2 == 0 || c2 == 1) {

			} else if (c2 == 2) {
				if (c3 == 2) {
					if (c4 == 2)
						chooseKe = false;
				} else if (c3 == 3) {
					if (c4 != 2)
						chooseKe = false;
				} else {
					chooseKe = false;
				}
			} else if (c2 == 3) {
				if (c3 != 3) {
					chooseKe = false;
				}
			} else if (c2 == 4) {
				if (c3 == 2) {
					if (c4 == 2 || c4 == 3 || c4 == 4)
						chooseKe = false;
				}
				if (c3 == 3) {
					chooseKe = false;
				}
			}
		} else if (c1 == 2) {
			chooseKe = false;
		} else if (c1 == 3) {
			if (c2 == 2) {
				if (c3 == 1 || c3 == 4) {
					chooseKe = false;
				} else if (c3 == 2) {
					if (c4 != 2)
						chooseKe = false;
				}
			}
			if (c2 == 3) {
				chooseKe = false;
			} else if (c2 == 4) {
				if (c3 == 2) {
					chooseKe = false;
				}
			}
		} else if (c1 == 4) {
			if (c2 == 2 && c3 != 2) {
				chooseKe = false;
			} else if (c2 == 3) {
				if (c3 == 0 || c3 == 1 || c3 == 2) {
					chooseKe = false;
				}
			} else if (c2 == 4) {
				if (c3 == 2)
					chooseKe = false;
			}
		}

		if (chooseKe) {
			needKing += 1;
		} else {
			if (c1 < 2) {
				needKing += (2 - c1);
				n -= c1;
			} else {
				n -= 2;
			}

			if (c2 < 2) {
				needKing += (2 - c2);
				n -= c2;
			} else {
				n -= 20;
			}
		}

		if (n == 0) return needKing;

		if (needKing > maxKing) return needKing;

		return nextSplit(n, needKing, maxKing);
	}
	
}
