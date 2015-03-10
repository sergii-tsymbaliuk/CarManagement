package cars.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cars.common.Car;
import cars.dao.CarDao;
import cars.dao.CarEngineDao;
import cars.dao.CarModelDao;

@Service
public class CarService {
	
	@Resource
	CarDao carDao;

	public List<Car> findByModelName(String modelName) {
		return carDao.findByModelName(modelName);
	}

	public List<Car> findByPowerBetween(Integer start, Integer end) {
		return carDao.findByPowerBetween(start, end);
	}

	public List<Car> findByEngineDisplacementIsLessThanAndEngineDisplacementIsLessThan(
			Integer lower, Integer higher, Pageable pageable) {
		return carDao
				.findByEngineDisplacementIsLessThanAndEngineDisplacementIsLessThan(
						lower, higher, pageable);
	}

	public <S extends Car> S save(S entity) {
		return carDao.save(entity);
	}

	public Page<Car> findAll(Pageable pageable) {
		return carDao.findAll(pageable);
	}

	public Car findOne(Integer id) {
		return carDao.findOne(id);
	}

	public boolean exists(Integer id) {
		return carDao.exists(id);
	}

	public long count() {
		return carDao.count();
	}

	public void delete(Integer id) {
		carDao.delete(id);
	}

	public void delete(Car entity) {
		carDao.delete(entity);
	}

	public void delete(Iterable<? extends Car> entities) {
		carDao.delete(entities);
	}

	public void deleteAll() {
		carDao.deleteAll();
	}

	public void deleteAllInBatch() {
		carDao.deleteAllInBatch();
	}

	public void deleteInBatch(Iterable<Car> arg0) {
		carDao.deleteInBatch(arg0);
	}

	public List<Car> findAll() {
		return carDao.findAll();
	}

	public List<Car> findAll(Iterable<Integer> arg0) {
		return carDao.findAll(arg0);
	}

	public List<Car> findAll(Sort arg0) {
		return carDao.findAll(arg0);
	}

	public void flush() {
		carDao.flush();
	}

	public Car getOne(Integer arg0) {
		return carDao.getOne(arg0);
	}

	public <S extends Car> List<S> save(Iterable<S> arg0) {
		return carDao.save(arg0);
	}

	public <S extends Car> S saveAndFlush(S arg0) {
		return carDao.saveAndFlush(arg0);
	}


	
	
}
