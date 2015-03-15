package cars.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum SecRole {
	GUEST,
	USER,
	MANAGER,
	ADMIN;
	
	public SimpleGrantedAuthority getAuthority() {
		return new SimpleGrantedAuthority(getRoleStr());
	}

	public String getRoleStr() {
		return "ROLE_" + name();
	}
}
