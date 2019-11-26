package com.DooWahDoo.Main.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "music_library")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MusicLibrary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "music_id")
	private long musicId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "artist")
	private String artist;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "description")
	private String description;
	
//	@OneToMany(mappedBy = "musicLibrary",cascade = CascadeType.ALL)
//	private List<KaraokeSession> karaokeSessions;

	public long getMusicId() {
		return musicId;
	}

	public void setMusicId(long musicId) {
		this.musicId = musicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//
//	public List<KaraokeSession> getKaraokeSessions() {
//		return karaokeSessions;
//	}
//
//	public void setKaraokeSessions(List<KaraokeSession> karaokeSessions) {
//		this.karaokeSessions = karaokeSessions;
//	}
	
	

}
