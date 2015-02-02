import javax.persistence.Entity;

@Entity
public class Truck extends Car {
	protected Integer capacity;

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Truck(CarModel model, Engine121 engine,Integer capacity) {
		super(model, engine);
		this.capacity = capacity;
	}

	public Truck() {
		super();
	}

	@Override
	public String toString() {
		return "Truck [capacity=" + capacity + super.toString()+"]";
	}
	
	
}
