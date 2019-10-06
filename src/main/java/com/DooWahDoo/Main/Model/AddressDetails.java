package com.DooWahDoo.Main.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address_details")
public class AddressDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private long addressId;
	
	@Column(name = "address1")
	@NotNull
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "city")
	@NotNull
	private String city;
	
	@Column(name = "state")
	@NotNull
	private String state;
	
	@Column(name = "country")
	@NotNull
	private String country;
	
	@Column(name = "zipcode")
	@NotNull
	private int zipcode;
	
	@OneToMany(mappedBy = "addressDetails",cascade = CascadeType.ALL)
	private List<UserProfile> userProfiles;
	
	@OneToMany(mappedBy = "addressDetails",cascade = CascadeType.ALL)
	private List<DjProfile> djProfiles;
	
	@OneToMany(mappedBy = "addressDetails",cascade = CascadeType.ALL)
	private List<GigInfo> gigInfos;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public List<DjProfile> getDjProfiles() {
		return djProfiles;
	}

	public void setDjProfiles(List<DjProfile> djProfiles) {
		this.djProfiles = djProfiles;
	}

	public List<GigInfo> getGigInfos() {
		return gigInfos;
	}

	public void setGigInfos(List<GigInfo> gigInfos) {
		this.gigInfos = gigInfos;
	}
	
	

}
