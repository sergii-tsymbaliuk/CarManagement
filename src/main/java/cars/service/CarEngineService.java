package cars.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cars.common.Engine121;
import cars.dao.CarEngineDao;


@Service
public class CarEngineService {
		
	@Resource
	CarEngineDao carEngineDao;

	public Engine121 findOne(Long id) {
		return carEngineDao.findOne(id);
	}

	public List<Engine121> findByModel(String model) {
		return carEngineDao.findByModel(model);
	}

	public List<Engine121> findByPower(Integer power) {
		return carEngineDao.findByPower(power);
	}

	public List<Engine121> findByDisplacement(Integer displacement) {
		return carEngineDao.findByDisplacement(displacement);
	}

	public List<Engine121> findByNumberOfCylinders(Integer numberOfCylinders) {
		return carEngineDao.findByNumberOfCylinders(numberOfCylinders);
	}

	public <S extends Engine121> S save(S entity) {
		return carEngineDao.save(entity);
	}

	public List<Engine121> findAll() {
		return carEngineDao.findAll();
	}

	public List<Engine121> findAll(Sort sort) {
		return carEngineDao.findAll(sort);
	}

	public Page<Engine121> findAll(Pageable pageable) {
		return carEngineDao.findAll(pageable);
	}

	public List<Engine121> findAll(Iterable<Long> ids) {
		return carEngineDao.findAll(ids);
	}

	public <S extends Engine121> List<S> save(Iterable<S> entities) {
		return carEngineDao.save(entities);
	}

	public boolean exists(Long id) {
		return carEngineDao.exists(id);
	}

	public void flush() {
		carEngineDao.flush();
	}

	public <S extends Engine121> S saveAndFlush(S entity) {
		return carEngineDao.saveAndFlush(entity);
	}

	public void deleteInBatch(Iterable<Engine121> entities) {
		carEngineDao.deleteInBatch(entities);
	}

	public long count() {
		return carEngineDao.count();
	}

	public void deleteAllInBatch() {
		carEngineDao.deleteAllInBatch();
	}

	public void delete(Long id) {
		carEngineDao.delete(id);
	}

	public Engine121 getOne(Long id) {
		return carEngineDao.getOne(id);
	}

	public void delete(Engine121 entity) {
		carEngineDao.delete(entity);
	}

	public void delete(Iterable<? extends Engine121> entities) {
		carEngineDao.delete(entities);
	}

	public void deleteAll() {
		carEngineDao.deleteAll();
	}
	
	

}
