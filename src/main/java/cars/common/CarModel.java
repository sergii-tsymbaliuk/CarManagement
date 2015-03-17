package cars.common;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CarModel {
	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(name="MODEL_NAME")
	protected String name;
	protected Date originDate;
	@OneToMany(mappedBy="carModel", cascade=CascadeType.REMOVE)
	protected Collection<Car> cars = new ArrayList<Car>();
		
	public CarModel() {
		super();
	}
	
	public CarModel(String name) {
		this(name,new Date());
	}
	
	public CarModel(String name, Date originDate) {
		super();
		this.name = name;
		this.originDate = originDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOriginDate() {
		return originDate;
	}
	public void setOriginDate(Date originDate) {
		this.originDate = originDate;
	}

	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "CarModel [id=" + id + ", name=" + name + ", originDate="
				+ originDate + "]";
	}

	public Long getId() {
		return id;
	}
	
}
