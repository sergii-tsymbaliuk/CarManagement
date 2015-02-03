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
		
		//Generating cars and models
		//generateCars();
		
		//Updating Car
//		q = EM.createQuery("select c from Car c");
//
//		trans = EM.getTransaction();		
//		trans.begin();
//		try {
//			for (Object o : q.getResultList()){
//				//updateCarColor(o);			 
//				
//				Car c = (Car) o;				
////				//Add Tech Records	
////				for (int i=0; i< r.nextInt(5);i++){
////					TechRecord tr = new TechRecord("Comment text "+i+" for car "+c.getModel()+" "+c.getId(), "Ivan Petrov");
////					c.addTechRecords(tr);
////				}
//				 
//				//AddDetales
////				for (int i=0; i< r.nextInt(5);i++){
////					CarDetail cd = new CarDetail("Processor","Bosh");
////					c.addCarDertail(cd);
////					EM.persist(cd);
////				}
//					
//				System.out.println(o.toString());
//				
//				EM.merge(o);			 
//			}
//			trans.commit();
//		} catch (Exception e) {
//			System.out.println(e.toString());
//			trans.rollback();
//		}

		//Adding some cars for existent models
//		generateSomeMoreCars();
		
		
		//Try getting cars with OldDao
		CarOldDao carOldDao =  new CarOldDao();
		
		System.out.println("Cars with model LAZ:");
		for (Car c : carOldDao.findByModelName("LAZ"))
			System.out.println(c);
		
		System.out.println("Cars with power between 50 and 180:");		
		for (Car c : carOldDao.findByPowerBetween(50, 180));		
		
		//Printing to console objects after update
		q = EM.createQuery("select c from Car c");
		for (Object o : q.getResultList()){
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
		
		car = new Car();
		car.setEngine(new Engine121("DOHC",150,3498,8));
		car.setModel(new CarModel("Mercedes"));
		car.setCarType(CarType.Car);
		
		bus = new Bus( 	new CarModel("LAZ"),
						new Engine121("MEMZ",80,4498,4),
						50);
		bus.setCarType(CarType.Bus);
	
		truck = new Truck(new CarModel("ZIL"),
						  new Engine121("SOHC",200,4998,16),
						  15000);
		truck.setCarType(CarType.Truck);
		
		trans = EM.getTransaction();
		
		trans.begin();
		try {
			EM.persist(car.getEngine());
			EM.persist(car.getModel());			
			EM.persist(car);
			EM.persist(bus.getEngine());
			EM.persist(bus.getModel());			
			EM.persist(bus);
			EM.persist(truck.getEngine());
			EM.persist(truck.getModel());			
			EM.persist(truck);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.toString());
			trans.rollback();
		}
	}
	
	private static void generateSomeMoreCars() {
		//generating cars for existent models
		EntityTransaction trans = EM.getTransaction();
		Query q = EM.createQuery("Select model from CarModel model");
		Car car =null;
		Bus bus  =null;
		Truck truck =null;
		Random r = new Random();
		
		for (Object o  : q.getResultList()){
			trans.begin();
			try {
				for (int i = 0; i <= 1+r.nextInt(3);i++){
					EM.persist(new Car((CarModel)o,new Engine121("dohc",50+r.nextInt(100),1200+r.nextInt(1000), 2+r.nextInt(6))));
				}
				trans.commit();				
			}
			catch (Exception e) {
				trans.rollback();
				System.out.println(e);
			}
		}
	}
}
