import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cars.common.Car;
import cars.common.CarModel;
import cars.common.Engine121;
import cars.dao.CarDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/appContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = false)
@FixMethodOrder(MethodSorters.JVM)
public class CarTest extends
AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired CarDao carDao;
	
	@Test public void write() {
	
//		carDao.save(new Car(
//				new CarModel("Rover") ,
//				new Engine121("zzz", 128, 2489, 6)
//				));
		
		System.out.println(carDao.findByModelName("Rover"));
		System.out.println(carDao.findByPowerBetween(127, 300));
	
	}

}
