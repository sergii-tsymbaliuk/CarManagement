package cars.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cars.common.CarModel;
import java.lang.String;

@Repository
public interface CarModelDao extends JpaRepository<CarModel, Long> {
	
	@Override
	public List<CarModel> findAll();
	
	List<CarModel> findByName(String name);
	
}
