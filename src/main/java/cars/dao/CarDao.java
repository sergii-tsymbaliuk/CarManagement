package cars.dao;
import java.util.List;

import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cars.common.Car;

@Repository
public interface CarDao extends JpaRepository<Car, Integer>{

	@Query("select c from Car c where c.carModel.name like ?1")
	public List<Car> findByModelName(String modelName);
	
	@Query("select c from Car c where c.engine.power between :start and :end")
	public List<Car> findByPowerBetween(@Param("start") Integer start, @Param("end") Integer end);
	
	public List<Car> findByEngineDisplacementIsLessThanAndEngineDisplacementIsLessThan(
			Integer lower, Integer higher,
			Pageable pageable); //Pageble contains sort infor
	
}
