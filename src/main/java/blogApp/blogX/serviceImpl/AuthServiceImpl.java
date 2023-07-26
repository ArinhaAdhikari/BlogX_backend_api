package blogApp.blogX.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import Payloads.LoginDto;
@Service
public class AuthServiceImpl implements AuthService{
 
	private AuthenticationManager authenticationManager;
	
	 
	public AuthServiceImpl(AuthenticationManager authenticationManager) {
		this.authenticationManager= authenticationManager;
	}


	@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
	Authentication authentication=	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserNameoremail(), loginDto.getPassword()));
	SecurityContextHolder.getContext().setAuthentication(authentication);
	
	return "user logged in successfully";
	}

}
