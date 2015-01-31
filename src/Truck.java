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

	public Truck(String model, Integer power,Integer capacity) {
		super(model, power);
		this.capacity = capacity;
	}

	public Truck() {
		super();
	}
}
