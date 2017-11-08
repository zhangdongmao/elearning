package com.cms.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CurChapter entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cur_chapter", catalog = "elearning")

public class CurChapter implements java.io.Serializable {

	// Fields

	private Integer id;
	private CurCourse curCourse;
	private String chapterName;
	private Set<CurSection> curSections = new HashSet<CurSection>(0);

	// Constructors

	/** default constructor */
	public CurChapter() {
	}

	/** minimal constructor */
	public CurChapter(String chapterName) {
		this.chapterName = chapterName;
	}

	/** full constructor */
	public CurChapter(CurCourse curCourse, String chapterName, Set<CurSection> curSections) {
		this.curCourse = curCourse;
		this.chapterName = chapterName;
		this.curSections = curSections;
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
	@JoinColumn(name = "cur_id")

	public CurCourse getCurCourse() {
		return this.curCourse;
	}

	public void setCurCourse(CurCourse curCourse) {
		this.curCourse = curCourse;
	}

	@Column(name = "chapter_name", nullable = false, length = 50)

	public String getChapterName() {
		return this.chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "curChapter")

	public Set<CurSection> getCurSections() {
		return this.curSections;
	}

	public void setCurSections(Set<CurSection> curSections) {
		this.curSections = curSections;
	}

}