package com.game.analysis.changde.bean;

import java.io.Serializable;

/**
 * 
 * 麻将对象
 * 
 * @author YingJH
 *
 */
public class ChessBean implements Serializable{

	private static final long serialVersionUID = 5189480800038727545L;

	private int[] handCards;//当前需判胡的牌
	
	private int curCard;//当前牌数量
	
	private int kingIndex;//王牌所在角标
	
	private boolean hasFeng;//是否包含风(true:是,false:否)

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
