package com.DooWahDoo.Main.Controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserRegController {
	@Autowired
	private UserRegRepo userRegRepo;
	
	@Autowired
	private UserProfileRepo userProfileRepo;
	
	@PostMapping("/RegisterUser")
//   public SignUp createEmployee(@Valid @RequestBody SignUp signUp) {
	 public SignUp createEmployee(@Valid @RequestBody SignUpProfileWrapper signUpProfileWrapper) {
		UserProfile userProfile1=signUpProfileWrapper.getUserProfile();
		SignUp signUp1 = signUpProfileWrapper.getSignUp();
		userProfileRepo.save(userProfile1);
		
		signUp1.setUserProfile(userProfile1);
		return userRegRepo.save(signUp1);
		
	
    }
	@GetMapping("/test")
	public String test()
	{
		return "I'm running";
	}
	
	@PostMapping("/login")
    public String userLogin(@Valid @RequestBody SignUp signUp) {
		String status;

		Optional<SignUp> user=userRegRepo.findById(signUp.getEmailId());

		if(user.isPresent())
		{
			if(user.get().getPassword().equals(signUp.getPassword()))
			{
				System.out.println("match found");
				status="Success";
			}
			else
			{
				System.out.println("wrong combination");
				status="Fail";
			}
			
		}
		else
		{
			System.out.println("No such user");
			status = "Fail";
		}
		return status;
    }

}
