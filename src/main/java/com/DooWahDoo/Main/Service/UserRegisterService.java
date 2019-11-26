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

	public SignUp createUser(SignUpProfileWrapper signUpProfileWrapper) {
		UserProfile userProfile1 = signUpProfileWrapper.getUserProfile();
		SignUp signUp1 = signUpProfileWrapper.getSignUp();
		userProfileRepo.save(userProfile1);

		signUp1.setUserProfile(userProfile1);
		return userRegRepo.save(signUp1);
	}

}
