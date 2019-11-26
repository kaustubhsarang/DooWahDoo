package com.DooWahDoo.Main.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.UserProfile;
import com.DooWahDoo.Main.Service.UserProfileService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping("/getUserInfo/userid/{user_id}")
	public Optional<UserProfile> search(@PathVariable("user_id") long userId) {
		return userProfileService.getUserDetails(userId);
	}
}
