package com.DooWahDoo.Main.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DooWahDoo.Main.Model.SignUp;
import com.DooWahDoo.Main.Model.SignUpProfileWrapper;
import com.DooWahDoo.Main.Model.UserProfile;
import com.DooWahDoo.Main.Repo.UserProfileRepo;
import com.DooWahDoo.Main.Repo.UserRegRepo;

@Component
public class UserRegisterService {

	@Autowired
	private UserProfileRepo userProfileRepo;

	@Autowired
	private UserRegRepo userRegRepo;

	@Autowired
	private SendEmailService emailService;

	public Map<String, Object> createUser(SignUpProfileWrapper signUpProfileWrapper) {
		UserProfile userProfile = signUpProfileWrapper.getUserProfile();
		SignUp signUp = signUpProfileWrapper.getSignUp();
		Map<String, Object> result = new HashMap<>();
		//kausi's changes
		if(userRegRepo.existsById(signUp.getEmailId()))
		{
			result.put("Status", "User already present");
			result.put("userInfo", null);
			return result;
		}
		userProfileRepo.save(userProfile);
		signUp.setUserProfile(userProfile);
		emailService.sendEmail(signUp.getEmailId(),userProfile.getFirstName());
		userRegRepo.save(signUp);
		result.put("Status", "Success");
		result.put("userInfo", signUp);
		return result;
	}

}
