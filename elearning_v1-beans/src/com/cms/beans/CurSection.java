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
 * CurSection entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_section", catalog = "elearning")

public class CurSection implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurChapter curChapter;
	private String sectionName;
	private String curMovieFile;

	// Constructors

	/** default constructor */
	public CurSection() {
	}

	/** minimal constructor */
	public CurSection(CurChapter curChapter, String sectionName) {
		this.curChapter = curChapter;
		this.sectionName = sectionName;
	}

	/** full constructor */
	public CurSection(CurChapter curChapter, String sectionName, String curMovieFile) {
		this.curChapter = curChapter;
		this.sectionName = sectionName;
		this.curMovieFile = curMovieFile;
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
	@JoinColumn(name = "chapter_id", nullable = false)

	public CurChapter getCurChapter() {
		return this.curChapter;
	}

	public void setCurChapter(CurChapter curChapter) {
		this.curChapter = curChapter;
	}

	@Column(name = "section_name", nullable = false, length = 50)

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Column(name = "cur_movie_file", length = 50)

	public String getCurMovieFile() {
		return this.curMovieFile;
	}

	public void setCurMovieFile(String curMovieFile) {
		this.curMovieFile = curMovieFile;
	}

}