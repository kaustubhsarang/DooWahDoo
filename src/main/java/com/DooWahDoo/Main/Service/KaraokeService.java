package com.DooWahDoo.Main.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DooWahDoo.Main.Model.GigInfo;
import com.DooWahDoo.Main.Model.KaraokeSession;
import com.DooWahDoo.Main.Model.MusicLibrary;
import com.DooWahDoo.Main.Model.UserProfile;
import com.DooWahDoo.Main.Repo.GigInfoRepo;
import com.DooWahDoo.Main.Repo.KaraokeRepo;
import com.DooWahDoo.Main.Repo.MusicLibRepo;
import com.DooWahDoo.Main.Repo.UserProfileRepo;

@Component
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
		System.out.println("I'm here 2");
		KaraokeSession karaokeSession = new KaraokeSession();
		System.out.println("I'm here 3");
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
	
	public List<String> setIdsFromPayload(Map<String,String> payload) {
		List<String> idList = new ArrayList<>();
		String userId = payload.get("userId");
		String musicId = payload.get("musicId");
		String gigId = payload.get("gigId");
		idList.add(userId);
		idList.add(musicId);
		idList.add(gigId);
		return idList;
		
	}

}
