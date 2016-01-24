import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.QSort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cars.common.Car;
import cars.common.CarModel;
import cars.common.Engine121;
import cars.dao.CarDao;
import cars.dao.CarEngineDao;
import cars.dao.CarModelDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/appContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@FixMethodOrder(MethodSorters.JVM)
public class CarTest extends
AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired CarDao carDao;
	@Autowired CarModelDao carModelDao;
	@Autowired CarEngineDao carEngineDao;
	
	@Test public void write() {
	
//		carDao.save(new Car(
//				carModelDao.findByName("Rover").get(0) ,
//				new Engine121("xxx", 145, 2988, 4)
//				));
		
//		carDao.save(new Car(
//			new CarModel("BMW"),
//			carEngineDao.findByModel("xxx").get(0)
//			));
		
//		System.out.println(carDao.findByModelName("Rover"));
//		System.out.println(carDao.findByPowerBetween(100, 300));
		System.out.println(carDao.findAll());	
		System.out.println(carEngineDao.findAll());	
		System.out.println(carModelDao.findAll());	
//		System.out.println(carDao.findByEngineDisplacementIsLessThanAndEngineDisplacementIsLessThan(
//				10, 3000, 
//				new PageRequest(0,5,new Sort(Direction.ASC,"timestamp"))));
	}

}
