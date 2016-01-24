package cars.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import cars.common.Engine121;

@Repository
public interface CarEngineDao 
	extends JpaRepository<Engine121, Long>{
	
	public Engine121 findOne(Long id);
	
	public List<Engine121> findByModel( String model);
	
	public List<Engine121> findByPower( Integer power);
	public List<Engine121> findByDisplacement( Integer displacement);
	public List<Engine121> findByNumberOfCylinders( Integer	numberOfCylinders);

}
