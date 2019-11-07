package com.DooWahDoo.Main.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.KaraokeSession;
import com.DooWahDoo.Main.Repo.KaraokeRepo;

@CrossOrigin
@RestController
@RequestMapping("/Karaoke")
public class KaraokeController {
	
	@Autowired
	private KaraokeRepo karaokeRepo;
	
	@PostMapping("/createSession")
	public KaraokeSession createSession(@Valid @RequestBody KaraokeSession karaokeSession)
	{
		return karaokeRepo.save(karaokeSession);
	}
	
	@PostMapping("/getSessions")
	public List<KaraokeSession> getSessions()
	{
		return karaokeRepo.findAll();
	}
	
	@PostMapping("/deleteSession")
	public void deleteSession(@Valid @RequestBody KaraokeSession karaokeSession)
	{
		 karaokeRepo.delete(karaokeSession);
	}

}
