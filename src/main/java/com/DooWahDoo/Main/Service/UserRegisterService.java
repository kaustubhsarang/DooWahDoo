package com.DooWahDoo.Main.Service;

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

	public SignUp createUser(SignUpProfileWrapper signUpProfileWrapper) {
		UserProfile userProfile = signUpProfileWrapper.getUserProfile();
		SignUp signUp = signUpProfileWrapper.getSignUp();
		userProfileRepo.save(userProfile);
		signUp.setUserProfile(userProfile);
		emailService.sendEmail(signUp.getEmailId(),userProfile.getFirstName());
		return userRegRepo.save(signUp);
	}

}
