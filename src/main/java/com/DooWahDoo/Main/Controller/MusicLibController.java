package com.DooWahDoo.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.SearchSong.MusicSearch;

@CrossOrigin
@RestController
@RequestMapping("/music")
public class MusicLibController {
	@Autowired
	private MusicSearch musicSearch;

	@GetMapping("/test")
	public String Hello() {
		return "Hello";
	}

	@RequestMapping("/searchAll")
	public List search(String q) {
		List searchResults = null;
		try {
			searchResults = musicSearch.searchAll(q);
		} catch (Exception ex) {

		}

		return searchResults;
	}

	@RequestMapping("/searchArtist")
	public List searchArtist(String q) {
		List searchResults = null;
		try {
			searchResults = musicSearch.searchArtist(q);
		} catch (Exception ex) {

		}

		return searchResults;
	}

	@RequestMapping("/searchSong")
	public List searchSong(String q) {
		List searchResults = null;
		try {
			searchResults = musicSearch.searchSong(q);
		} catch (Exception ex) {

		}

		return searchResults;
	}

	@RequestMapping("/searchGenre")
	public List searchGenre(String q) {
		List searchResults = null;
		try {
			searchResults = musicSearch.searchGenre(q);
		} catch (Exception ex) {

		}

		return searchResults;
	}
}
