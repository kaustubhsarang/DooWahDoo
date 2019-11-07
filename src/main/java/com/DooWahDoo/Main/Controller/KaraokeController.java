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
import com.DooWahDoo.Main.Service.KaraokeService;

@CrossOrigin
@RestController
@RequestMapping("/Karaoke")
public class KaraokeController {

	@Autowired
	KaraokeService karaokeservice;

	@PostMapping("/createSession")
	public KaraokeSession createSession(@Valid @RequestBody String userId, String musicId, String gigId) {
		return karaokeservice.createKaraokeSession(userId, musicId, gigId);

	}

	@PostMapping("/getUserQueue")
	public List<KaraokeSession> getSessions() {
		return karaokeservice.getUsers();
		 
	}

//	@PostMapping("/deleteSession")
//	public void deleteSession(@Valid @RequestBody KaraokeSession karaokeSession) {
//		karaokeRepo.delete(karaokeSession);
//	}

}
