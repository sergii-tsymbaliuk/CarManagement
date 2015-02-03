import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class CarOldDao {
	@PersistenceContext EntityManager em;

	public List<Car> findByModelName(String modelName){
		Query q = em.createQuery(
			"Select c from Car c where c.carModel.name=:modelName");
			q.setParameter("modelName", modelName);
		return q.getResultList();
	}
	
	public List<Car>  findByPowerBetween(Integer start, Integer end){
		Query q = em.createQuery(
			"Select c from Car c where c.engine.power between :startPower and :endPower");
			q.setParameter("startPower", start);
			q.setParameter("endPower", end);			
		return q.getResultList();
	}
}
