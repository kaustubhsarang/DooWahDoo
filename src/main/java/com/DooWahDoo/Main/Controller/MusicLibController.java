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
	public String Hello()
	{
		return "Hello";
	}
	
	  @RequestMapping("/search")
	  public List search(String q) {
	    List searchResults = null;
	    try {
	      searchResults = musicSearch.search(q);
	    }
	    catch (Exception ex) {

	    }

	    return searchResults;
	  }
}
