package cars.common;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity //(name="Engine")
public class Engine121 {
	@Id
	@GeneratedValue
	Long id;
	String model;
	Integer power;
	Integer displacement;
	Integer	numberOfCylinders;

//	@OneToOne (mappedBy="engine")
//	Car ownerCar;
	
	public Engine121() {
		super();
	}

	public Engine121(String model, Integer power, Integer displacement,
			Integer numberOfCylinders) {
		super();
		this.model = model;
		this.power = power;
		this.displacement = displacement;
		this.numberOfCylinders = numberOfCylinders;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getDisplacement() {
		return displacement;
	}
	public void setDisplacement(Integer displacement) {
		this.displacement = displacement;
	}
	public Integer getNumberOfCylinders() {
		return numberOfCylinders;
	}
	public void setNumberOfCylinders(Integer numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}

//	public Car getOwnerCar() {
//		return ownerCar;
//	}
//
//	public void setOwnerCar(Car ownerCar) {
//		this.ownerCar = ownerCar;
//	}

	@Override
	public String toString() {
		return "Engine121 [id=" + id + ", model=" + model + ", power=" + power
				+ ", displacement=" + displacement + ", numberOfCylinders="
				+ numberOfCylinders + "]";
	}

	public Long getId() {
		return id;
	}

}
