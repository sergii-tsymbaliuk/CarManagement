package cars.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="user_name")
	String name;
	
	String login;
	String passowrd;

	
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private final Set<SecRole> roles = new HashSet<>();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassowrd() {
		return passowrd;
	}


	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}


	public Long getId() {
		return id;
	}


	public Set<SecRole> getRoles() {
		return roles;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login
				+ ", passowrd=" + passowrd + ", roles=" + roles + "]";
	}
    
}
