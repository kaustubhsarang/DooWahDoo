package com.DooWahDoo.Main.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DooWahDoo.Main.Model.SignUp;
import com.DooWahDoo.Main.Model.SignUpProfileWrapper;
import com.DooWahDoo.Main.Service.UserLoginService;
import com.DooWahDoo.Main.Service.UserRegisterService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserRegController {
	
	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private UserRegisterService userRegisterService;

	@PostMapping("/RegisterUser")
	public Map<String, Object> createUser(@Valid @RequestBody SignUpProfileWrapper signUpProfileWrapper) {
		return userRegisterService.createUser(signUpProfileWrapper);
	}

	@GetMapping("/test")
	public String test() {
		return "I'm running";
	}

	@PostMapping("/login")
	public Map<String, Object> userLogin(@Valid @RequestBody SignUp signUp) {
		return userLoginService.getLoginDetails(signUp);

	}

}
