import javax.persistence.Entity;

@Entity
public class Bus extends Car {
	protected Integer sits;

	public Integer getSits() {
		return sits;
	}

	public void setSits(Integer sits) {
		this.sits = sits;
	}

//	public Bus(String model, Integer power,Integer sits) {
//		super( model,  power);
//		this.sits = sits;
//	}

	public Bus(CarModel model, Engine121 engine, Integer sits) {
		super( model,  engine);
		this.sits = sits;
	}	
	
	public Bus() {
		super();
	}

	@Override
	public String toString() {
		return "Bus [sits=" + sits + super.toString()+"]";
	}
	
}
