package com.DooWahDoo.Main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.SearchSong.MusicSearch;
import com.DooWahDoo.Main.Service.MusicSearchService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MusicSearchController {

	@Autowired
	private MusicSearchService musicSearchService;

	@RequestMapping("/getAllMusic")
	public List<MusicSearch> search() {
		return musicSearchService.getAllSongs();
	}

	@RequestMapping("/getAllMusic/byArtistName")
	public List<MusicSearch> searchBtArtistName(@RequestParam(value = "Artist") String artist) {
		return musicSearchService.getAllSongsByArtistName(artist);
	}
	
	@RequestMapping("/getAllMusic/byArtistLetter")
	public List<String> searchBtArtistLetter(@RequestParam(value = "Artist") String artist) {
		return musicSearchService.getAllSongsByArtistLetter(artist);
	}
	
	@RequestMapping("/getAllMusic/byTitle")
	public List<MusicSearch> searchByTitle(@RequestParam(value = "Title") String title) {
		return musicSearchService.getAllSongsByTitle(title);
	}
	
	@RequestMapping("/getAllMusic/byTitleLetter")
	public List<MusicSearch> searchByTitleLetter(@RequestParam(value = "Title") String title) {
		return musicSearchService.getAllSongsByTitleLetter(title);
	}
	
	@RequestMapping("/getAllMusic/byGenre")
	public List<MusicSearch> searchByGenre(@RequestParam(value = "Genre") String genre) {
		return musicSearchService.getAllSongsByGenre(genre);
	}
	
	@RequestMapping("/getAllGenre")
	public List<String> getAllGenre() {
		return musicSearchService.getAllGenre();
	}
}
