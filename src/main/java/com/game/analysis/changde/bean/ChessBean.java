package com.game.analysis.changde.bean;

import java.io.Serializable;

/**
 * 
 * �齫����
 * 
 * @author YingJH
 *
 */
public class ChessBean implements Serializable{

	private static final long serialVersionUID = 5189480800038727545L;

	private int[] handCards;//��ǰ���к�����
	
	private int curCard;//��ǰ������
	
	private int kingIndex;//�������ڽǱ�
	
	private boolean hasFeng;//�Ƿ������(true:��,false:��)

	public int[] getHandCards() {
		return handCards;
	}

	public void setHandCards(int[] handCards) {
		this.handCards = handCards;
	}

	public int getCurCard() {
		return curCard;
	}

	public void setCurCard(int curCard) {
		this.curCard = curCard;
	}

	public int getKingIndex() {
		return kingIndex;
	}

	public void setKingIndex(int kingIndex) {
		this.kingIndex = kingIndex;
	}

	public boolean getHasFeng() {
		return hasFeng;
	}

	public void setHasFeng(boolean hasFeng) {
		this.hasFeng = hasFeng;
	}
	
}
