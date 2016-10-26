package cars.common;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CarDetail {
	@Id
	@GeneratedValue
	Long id;
	@Column(name="det_name")
	protected String name;
	protected String producer;
	
	@ManyToMany(mappedBy="carDetails")
	Collection<Car> cars = new ArrayList<Car>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CarDetail(String name, String producer) {
		super();
		this.name = name;
		this.producer = producer;
	}

	public CarDetail() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "CarDetail [id=" + id + ", name=" + name + ", producer="
				+ producer
				//+ ", cars=" + cars 
				+ "]";
	}
	

	
}
