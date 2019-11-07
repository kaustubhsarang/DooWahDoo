package com.DooWahDoo.Main.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.DooWahDoo.Main.Model.GigInfo;
import com.DooWahDoo.Main.Model.KaraokeSession;
import com.DooWahDoo.Main.Model.MusicLibrary;
import com.DooWahDoo.Main.Model.UserProfile;
import com.DooWahDoo.Main.Repo.GigInfoRepo;
import com.DooWahDoo.Main.Repo.KaraokeRepo;
import com.DooWahDoo.Main.Repo.MusicLibRepo;
import com.DooWahDoo.Main.Repo.UserProfileRepo;

public class KaraokeService {
	@Autowired
	private KaraokeRepo karaokeRepo;
	@Autowired
	private UserProfileRepo userProfileRepo;
	@Autowired
	private MusicLibRepo musicLibRepo;

	@Autowired
	private GigInfoRepo gigRepo;

	public KaraokeSession createKaraokeSession(String userId, String musicId, String gigId) {
		KaraokeSession karaokeSession = new KaraokeSession();
		UserProfile user = userProfileRepo.getOne(Long.parseLong(userId));
		karaokeSession.setUserProfile(user);

		MusicLibrary musicLib = musicLibRepo.getOne(Long.parseLong(musicId));
		karaokeSession.setMusicLibrary(musicLib);

		GigInfo gig = gigRepo.getOne(Long.parseLong(gigId));
		karaokeSession.setGigInfo(gig);
		karaokeSession.setCurrent(false);
		karaokeSession.setDone(false);
		return karaokeRepo.save(karaokeSession);
	}
	
	public List<KaraokeSession> getUsers() {
		List<KaraokeSession> sessions= karaokeRepo.findAll();
		List<KaraokeSession> queueList= new ArrayList<>();
		for(KaraokeSession session : sessions) {
			if(! session.isDone()) {
				queueList.add(session);
			}
		}
		return queueList;
		
	}

}
