package cars.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cars.dao.UserDao;
import cars.security.User;

@Service
public class UserService {
	@Resource
	UserDao userDao;

	public Page<User> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}

	public User findOne(Long id) {
		return userDao.findOne(id);
	}

	public boolean exists(Long id) {
		return userDao.exists(id);
	}

	public long count() {
		return userDao.count();
	}

	public void delete(Long id) {
		userDao.delete(id);
	}

	public void delete(User entity) {
		userDao.delete(entity);
	}

	public void delete(Iterable<? extends User> entities) {
		userDao.delete(entities);
	}

	public void deleteAll() {
		userDao.deleteAll();
	}

	public void deleteAllInBatch() {
		userDao.deleteAllInBatch();
	}

	public void deleteInBatch(Iterable<User> arg0) {
		userDao.deleteInBatch(arg0);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public List<User> findAll(Iterable<Long> arg0) {
		return userDao.findAll(arg0);
	}

	public List<User> findAll(Sort arg0) {
		return userDao.findAll(arg0);
	}

	public void flush() {
		userDao.flush();
	}

	public User getOne(Long arg0) {
		return userDao.getOne(arg0);
	}

	public <S extends User> List<S> save(Iterable<S> arg0) {
		return userDao.save(arg0);
	}

	public <S extends User> S save(S entity) {
		return userDao.save(entity);
	}

	public <S extends User> S saveAndFlush(S arg0) {
		return userDao.saveAndFlush(arg0);
	}

	public User findByLoginAndPassowrd(String login, String password) {
		return userDao.findByLoginAndPassowrd(login, password);
	}
}
