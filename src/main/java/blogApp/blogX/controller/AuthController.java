package blogApp.blogX.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Payloads.LoginDto;
import Payloads.LoginDto;
import blogApp.blogX.serviceImpl.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;
	public AuthController(AuthService authService)
	{
		this.authService=authService;
	}
	@PostMapping(value= {"/login","/signin"})
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto)
	{
String response=authService.login(loginDto);
	return ResponseEntity.ok(response);
}
}
