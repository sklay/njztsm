package com.sklay.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sklay.core.enums.SMSStatus;

/**
 * 
 */
@Entity
@Table(name = "sklay_app_sms")
public class SMS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "creator", nullable = false)
	private User creator;

	@ManyToOne
	@JoinColumn(name = "app", nullable = false)
	private Application app;
	
	@Column(nullable = false)
	@Lob
	private String content;

	@Column(name = "send_time", nullable = false)
	private Date sendTime;

	private String receiver;

	@Column(columnDefinition = " int default 0")
	private SMSStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public SMSStatus getStatus() {
		return status;
	}

	public void setStatus(SMSStatus status) {
		this.status = status;
	}

	public SMS() {
		super();
	}

	public SMS(User creator, String content, Date sendTime, String receiver,
			SMSStatus status) {
		super();
		this.creator = creator;
		this.content = content;
		this.sendTime = sendTime;
		this.receiver = receiver;
		this.status = status;
	}

	@Override
	public String toString() {
		return "SMS [id=" + id + ", creator=" + creator + ", content="
				+ content + ", sendTime=" + sendTime + ", receiver=" + receiver
				+ ", status=" + status + "]";
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

}