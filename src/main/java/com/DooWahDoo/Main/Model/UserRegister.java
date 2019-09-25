package com.DooWahDoo.Main.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user_register")
public class UserRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "password")
	@Transient
	private String password;

//	@OneToOne(mappedBy = "userId")
//	private UserProfile userProfile;
//	
//	@OneToOne(mappedBy = "userId")
//	private KaraokeSession karaokeSession;
	
	


	
	public String getPassword() {
		return password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	
}
