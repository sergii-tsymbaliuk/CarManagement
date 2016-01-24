package cars.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cars.service.UserService;

@Service
public class AuthProvider implements AuthenticationProvider {
	@Resource UserService userService;
	
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String login = authentication.getName();
		String password = authentication.getCredentials().toString();
		User user = userService.findByLoginAndPassowrd(login, password);
		
		if (user == null ){
			throw new UsernameNotFoundException("Login failed");
		}
		
		List<GrantedAuthority> grantedAuths = new ArrayList<>();		
		for( SecRole ur:user.getRoles())
			grantedAuths.add(ur.getAuthority());

		// populating authorities
		return new UsernamePasswordAuthenticationToken(login, password,
				grantedAuths);
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}