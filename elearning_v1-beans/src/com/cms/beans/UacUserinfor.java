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
 * UacUserinfor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uac_userinfor", catalog = "elearning")

public class UacUserinfor implements java.io.Serializable {

	// Fields

	private Integer id;
	private Register register;
	private String loginTimes;
	private String lastLogin;
	private String userPhoto;
	private String identificationNumber;
	private String mobilePhoneNumber;
	private String telephoneNumber;
	private String qq;
	private String nickname;
	private Set<CurTeacher> curTeachers = new HashSet<CurTeacher>(0);
	private Set<CurUser> curUsers = new HashSet<CurUser>(0);
	private Set<CurEvaluate> curEvaluates = new HashSet<CurEvaluate>(0);
	private Set<Knowledge> knowledges = new HashSet<Knowledge>(0);

	// Constructors

	/** default constructor */
	public UacUserinfor() {
	}

	/** minimal constructor */
	public UacUserinfor(Register register, String identificationNumber, String mobilePhoneNumber, String qq,
			String nickname) {
		this.register = register;
		this.identificationNumber = identificationNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.qq = qq;
		this.nickname = nickname;
	}

	/** full constructor */
	public UacUserinfor(Register register, String loginTimes, String lastLogin, String userPhoto,
			String identificationNumber, String mobilePhoneNumber, String telephoneNumber, String qq, String nickname,
			Set<CurTeacher> curTeachers, Set<CurUser> curUsers, Set<CurEvaluate> curEvaluates,
			Set<Knowledge> knowledges) {
		this.register = register;
		this.loginTimes = loginTimes;
		this.lastLogin = lastLogin;
		this.userPhoto = userPhoto;
		this.identificationNumber = identificationNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.telephoneNumber = telephoneNumber;
		this.qq = qq;
		this.nickname = nickname;
		this.curTeachers = curTeachers;
		this.curUsers = curUsers;
		this.curEvaluates = curEvaluates;
		this.knowledges = knowledges;
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
	@JoinColumn(name = "register_id", nullable = false)

	public Register getRegister() {
		return this.register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	@Column(name = "login_times", length = 50)

	public String getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}

	@Column(name = "last_login", length = 50)

	public String getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "user_photo", length = 50)

	public String getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Column(name = "identification_number", nullable = false, length = 50)

	public String getIdentificationNumber() {
		return this.identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	@Column(name = "mobile_phone_number", nullable = false, length = 50)

	public String getMobilePhoneNumber() {
		return this.mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	@Column(name = "telephone_number", length = 50)

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Column(name = "qq", nullable = false, length = 50)

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "nickname", nullable = false, length = 50)

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacUserinfor")

	public Set<CurTeacher> getCurTeachers() {
		return this.curTeachers;
	}

	public void setCurTeachers(Set<CurTeacher> curTeachers) {
		this.curTeachers = curTeachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacUserinfor")

	public Set<CurUser> getCurUsers() {
		return this.curUsers;
	}

	public void setCurUsers(Set<CurUser> curUsers) {
		this.curUsers = curUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacUserinfor")

	public Set<CurEvaluate> getCurEvaluates() {
		return this.curEvaluates;
	}

	public void setCurEvaluates(Set<CurEvaluate> curEvaluates) {
		this.curEvaluates = curEvaluates;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uacUserinfor")

	public Set<Knowledge> getKnowledges() {
		return this.knowledges;
	}

	public void setKnowledges(Set<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}

}