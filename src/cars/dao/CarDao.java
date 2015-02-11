package cars.dao;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cars.common.Car;

@Repository
public class CarDao {
	@PersistenceContext 
	EntityManager em;

	public List<Car> findByModelName(String modelName){
		if ( em != null){
			TypedQuery<Car> q = em.createQuery(
					"Select c from Car c where c.carModel.name=:modelName",
					Car.class
					);
			q.setParameter("modelName", modelName);
			return q.getResultList();
		} 
		else 
			return null;		
	}
	
	public List<Car>  findByPowerBetween(Integer start, Integer end){
		TypedQuery<Car> q = em.createQuery(
			"Select c from Car c where c.engine.power between :startPower and :endPower",
			Car.class);
			q.setParameter("startPower", start);
			q.setParameter("endPower", end);			
		return q.getResultList();
	}
	
	@Transactional
	public void saveCar(Car car){
		em.persist(car);
	}
//	public CarDao(EntityManager em) {
//		super();
//		this.em = em;
//	}

}
