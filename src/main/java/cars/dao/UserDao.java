package cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cars.security.User;
import java.lang.String;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

	
	@Override
	public User findOne(Long id);
	
	User findByLoginAndPassowrd(String login, String password);
}
