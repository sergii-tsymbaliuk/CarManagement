package cars.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cars.common.CarModel;
import cars.dao.CarModelDao;

@Service
public class CarModelService {
	@Resource CarModelDao carModelDao;

	public List<CarModel> findAll() {
		return carModelDao.findAll();
	}

	public List<CarModel> findByName(String name) {
		return carModelDao.findByName(name);
	}

	public <S extends CarModel> S save(S entity) {
		return carModelDao.save(entity);
	}

	public List<CarModel> findAll(Sort sort) {
		return carModelDao.findAll(sort);
	}

	public Page<CarModel> findAll(Pageable pageable) {
		return carModelDao.findAll(pageable);
	}

	public CarModel findOne(Long id) {
		return carModelDao.findOne(id);
	}

	public List<CarModel> findAll(Iterable<Long> ids) {
		return carModelDao.findAll(ids);
	}

	public <S extends CarModel> List<S> save(Iterable<S> entities) {
		return carModelDao.save(entities);
	}

	public boolean exists(Long id) {
		return carModelDao.exists(id);
	}

	public void flush() {
		carModelDao.flush();
	}

	public <S extends CarModel> S saveAndFlush(S entity) {
		return carModelDao.saveAndFlush(entity);
	}

	public void deleteInBatch(Iterable<CarModel> entities) {
		carModelDao.deleteInBatch(entities);
	}

	public long count() {
		return carModelDao.count();
	}

	public void deleteAllInBatch() {
		carModelDao.deleteAllInBatch();
	}

	public void delete(Long id) {
		carModelDao.delete(id);
	}

	public CarModel getOne(Long id) {
		return carModelDao.getOne(id);
	}

	public void delete(CarModel entity) {
		carModelDao.delete(entity);
	}

	public void delete(Iterable<? extends CarModel> entities) {
		carModelDao.delete(entities);
	}

	public void deleteAll() {
		carModelDao.deleteAll();
	}
	
	

}
