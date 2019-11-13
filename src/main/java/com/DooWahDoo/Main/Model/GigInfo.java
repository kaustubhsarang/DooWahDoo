package com.DooWahDoo.Main.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "gig_info")
public class GigInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gig_id")
	private long gidId;
	
	@Column(name = "gig_date")
	@NotNull
	private java.sql.Date gigDate;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "start_time")
	private java.sql.Time startTime;
	
	@Column(name = "end_time")
	private java.sql.Time endTime;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="dj_id")
	private DjProfile djProfile;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name="address_id")
	private AddressDetails addressDetails;
	
//	@OneToMany(mappedBy = "gigInfo",cascade = CascadeType.ALL)
//	private List<KaraokeSession> karaokeSessions;

	public long getGidId() {
		return gidId;
	}

	public void setGidId(long gidId) {
		this.gidId = gidId;
	}

	public java.sql.Date getGigDate() {
		return gigDate;
	}

	public void setGigDate(java.sql.Date gigDate) {
		this.gigDate = gigDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Time getStartTime() {
		return startTime;
	}

	public void setStartTime(java.sql.Time startTime) {
		this.startTime = startTime;
	}

	public java.sql.Time getEndTime() {
		return endTime;
	}

	public void setEndTime(java.sql.Time endTime) {
		this.endTime = endTime;
	}

	public DjProfile getDjProfile() {
		return djProfile;
	}

	public void setDjProfile(DjProfile djProfile) {
		this.djProfile = djProfile;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

//	public List<KaraokeSession> getKaraokeSessions() {
//		return karaokeSessions;
//	}
//
//	public void setKaraokeSessions(List<KaraokeSession> karaokeSessions) {
//		this.karaokeSessions = karaokeSessions;
//	}
//	
	

}
