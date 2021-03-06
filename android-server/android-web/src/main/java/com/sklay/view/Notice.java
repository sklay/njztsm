package com.sklay.view;

import java.io.Serializable;

/**
 * 通知信息实体类
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
public class Notice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int atmeCount;
	private int msgCount;
	private int reviewCount;
	private int newFansCount;

	public int getAtmeCount() {
		return atmeCount;
	}

	public void setAtmeCount(int atmeCount) {
		this.atmeCount = atmeCount;
	}

	public int getMsgCount() {
		return msgCount;
	}

	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getNewFansCount() {
		return newFansCount;
	}

	public void setNewFansCount(int newFansCount) {
		this.newFansCount = newFansCount;
	}

	public Notice() {
		super();
	}

	public Notice(int atmeCount, int msgCount, int reviewCount, int newFansCount) {
		super();
		this.atmeCount = atmeCount;
		this.msgCount = msgCount;
		this.reviewCount = reviewCount;
		this.newFansCount = newFansCount;
	}

	@Override
	public String toString() {
		return "Notice [atmeCount=" + atmeCount + ", msgCount=" + msgCount
				+ ", reviewCount=" + reviewCount + ", newFansCount="
				+ newFansCount + "]";
	}

}
