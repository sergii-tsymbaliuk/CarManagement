import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class EntryPoint {
	final static String P_UNIT = "HibernateMySQL";
	//final static String P_UNIT = "HibernatePostgreSQL";
	//final static String P_UNIT = "EclipseLinkPostgreSQL";
	//final static String P_UNIT = "EclipseLinkMySQL";

	final static EntityManagerFactory EMS = Persistence.createEntityManagerFactory(P_UNIT);
	final static EntityManager EM = EMS.createEntityManager();
	
	
	public static void main(String[] args) {
		EntityTransaction trans = EM.getTransaction();
		Query q;
		Random r = new Random();
		//generateCars();
		
		//Updating Car
		
		q = EM.createQuery("select c from Car c");
//		System.out.println(q.getResultList());
		trans = EM.getTransaction();		
		trans.begin();
		try {
			for (Object o : q.getResultList()){
				updateCarColor(o);			 
				
				//Add Tech Records
				Car c = (Car) o;				
				for (int i=0; i< r.nextInt(5);i++){
					TechRecord tr = new TechRecord("Comment text "+i+" for car "+c.getModel()+" "+c.getId(), "Ivan Petrov");
					c.addTechRecords(tr);
				}
				 
				 System.out.println(o.toString());
				
				 EM.merge(o);			 
			}
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			trans.rollback();
		}
		
		//Printing to console objects after update
		q = EM.createQuery("select c from Car c");
		for (Object o : q.getResultList()){
			//updateCarColor(o);
			System.out.println(o.toString());
		}
		

		EM.close();
		EMS.close();
	}

	private static void updateCarColor(Object o) {
		 Random r = new Random();
		 
		 if (((Car)o).getCarType() == CarType.Truck)
			((Truck)o).setColor(new CarColor("Blue",0x0000FF+r.nextInt(100)));
		 if (((Car)o).getCarType() == CarType.Bus)
			((Bus) o).setColor(new CarColor("Gray",0x0F0F0F+r.nextInt(100)*100));			 
		 if (((Car)o).getCarType() == CarType.Car)
			((Car) o).setColor(new CarColor("Green",0x00FF00+r.nextInt(100)*10000));
	}

	private static void generateCars() {
		EntityTransaction trans;
		Car car =null;
		Bus bus  =null;
		Truck truck =null;
		Random r = new Random();
		
		car = new Car("Cadillac "+r.nextInt(100),150);
		car.setEngine(new Engine("DOHC",1498));
		car.getEngine().setPower((long) 150);
		car.setCarType(CarType.Car);
		
		bus = new Bus("LAZ "+r.nextInt(10),100,50);
		bus.setEngine(new Engine("MEMZ",2498));
		bus.getEngine().setPower((long) 100);
		bus.setCarType(CarType.Bus);
	
		truck = new Truck("ZIL "+r.nextInt(10),176,15000);
		truck.setEngine(new Engine("OMZ",2498));
		truck.getEngine().setPower((long) 176);
		truck.setCarType(CarType.Truck);
		
		trans = EM.getTransaction();
		
		trans.begin();
		try {
			EM.persist(car);
			EM.persist(bus);
			EM.persist(truck);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			trans.rollback();
		}
	}

}
