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
	private String informationTitle;
	private String informationReleaseTime;
	private String informationPhoto;
	private String informationInfo;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** minimal constructor */
	public Information(InformationType informationType, String informationTitle) {
		this.informationType = informationType;
		this.informationTitle = informationTitle;
	}

	/** full constructor */
	public Information(InformationType informationType, String informationTitle, String informationReleaseTime,
			String informationPhoto, String informationInfo) {
		this.informationType = informationType;
		this.informationTitle = informationTitle;
		this.informationReleaseTime = informationReleaseTime;
		this.informationPhoto = informationPhoto;
		this.informationInfo = informationInfo;
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

	@Column(name = "information_title", nullable = false, length = 50)

	public String getInformationTitle() {
		return this.informationTitle;
	}

	public void setInformationTitle(String informationTitle) {
		this.informationTitle = informationTitle;
	}

	@Column(name = "information_release_time", length = 50)

	public String getInformationReleaseTime() {
		return this.informationReleaseTime;
	}

	public void setInformationReleaseTime(String informationReleaseTime) {
		this.informationReleaseTime = informationReleaseTime;
	}

	@Column(name = "information_photo", length = 50)

	public String getInformationPhoto() {
		return this.informationPhoto;
	}

	public void setInformationPhoto(String informationPhoto) {
		this.informationPhoto = informationPhoto;
	}

	@Column(name = "information_info", length = 50)

	public String getInformationInfo() {
		return this.informationInfo;
	}

	public void setInformationInfo(String informationInfo) {
		this.informationInfo = informationInfo;
	}

}