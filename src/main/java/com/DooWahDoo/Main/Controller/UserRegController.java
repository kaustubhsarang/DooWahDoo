package com.DooWahDoo.Main.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.SignUp;
import com.DooWahDoo.Main.Model.SignUpProfileWrapper;
import com.DooWahDoo.Main.Model.UserProfile;
import com.DooWahDoo.Main.Repo.UserProfileRepo;
import com.DooWahDoo.Main.Repo.UserRegRepo;
@RestController
@RequestMapping("/api/v1")
public class UserRegController {
	@Autowired
	private UserRegRepo userRegRepo;
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	@PostMapping("/employees")
//   public SignUp createEmployee(@Valid @RequestBody SignUp signUp) {
	 public SignUp createEmployee(@Valid @RequestBody SignUpProfileWrapper signUpProfileWrapper) {
		UserProfile userProfile1=signUpProfileWrapper.getUserProfile();
		SignUp signUp1 = signUpProfileWrapper.getSignUp();
		userProfileRepo.save(userProfile1);
		
		signUp1.setUserProfile(userProfile1);
		return userRegRepo.save(signUp1);
		
	
    }

}
