package com.cms.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Information entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "information", catalog = "elearning")

public class Information implements java.io.Serializable {

	// Fields

	private Integer id;
	private InformationType informationType;
	private String title;
	private String contents;
	private String releaseTime;
	private String photo;
	private String attachment;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** minimal constructor */
	public Information(InformationType informationType, String title, String releaseTime) {
		this.informationType = informationType;
		this.title = title;
		this.releaseTime = releaseTime;
	}

	/** full constructor */
	public Information(InformationType informationType, String title, String contents, String releaseTime, String photo,
			String attachment) {
		this.informationType = informationType;
		this.title = title;
		this.contents = contents;
		this.releaseTime = releaseTime;
		this.photo = photo;
		this.attachment = attachment;
	}

	// Property accessors
	@Id
	@GeneratedValue

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "information_type_id", nullable = false)

	public InformationType getInformationType() {
		return this.informationType;
	}

	public void setInformationType(InformationType informationType) {
		this.informationType = informationType;
	}

	@Column(name = "title", nullable = false, length = 50)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "contents", length = 65535)

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Column(name = "release_time", nullable = false, length = 50)

	public String getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Column(name = "photo", length = 50)

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "attachment", length = 50)

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

}