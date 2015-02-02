import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Version;

import org.eclipse.persistence.jpa.config.Cascade;
import org.hibernate.annotations.Columns;

@Entity
@SecondaryTable(name="car_colors")
@Inheritance(strategy=InheritanceType.JOINED)
public class Car {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="Car_id")
	protected Long id; 
	@Version
	protected long version;
	
//	protected String model;
	@ManyToOne
	protected CarModel carModel;
	
//	protected Integer power;
//	@Embedded 
//	protected Engine engine;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ENGINE_ID")
	Engine121 engine;
	
	@Basic(fetch=FetchType.LAZY,optional=true)
	@Enumerated(EnumType.STRING)
	protected CarType carType;
	
	protected CarColor color;
	
	@Transient
	protected Date timestamp;

	@Lob
	protected String Description;

	@ElementCollection()
	protected Collection<TechRecord> techRecords = new ArrayList<TechRecord>();
	
	@ManyToMany
	protected Collection <CarDetail> carDertails = new ArrayList<CarDetail>();
	
	
	
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CarModel getModel() {
		return carModel;
	}
	public void setModel(CarModel carModel) {
		this.carModel = carModel;
	}
//	public Integer getPower() {
//		return power;
//	}
//	public void setPower(Integer power) {
//		this.power = power;
//	}
//	
	public Engine121 getEngine() {
		return engine;
	}
	public void setEngine(Engine121 engine) {
		this.engine = engine;
	}
	
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public CarColor getColor() {
		return color;
	}
	public void setColor(CarColor color) {
		this.color = color;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public Car() {
		super();
		this.timestamp = new Date();
	}
	
	public Car(CarModel model, Engine121 engine) {
		super();
		this.timestamp = new Date();		
		this.carModel = model;
		this.engine = engine;
	}
	
	public Collection<TechRecord> getTechRecords() {
		return techRecords;
	}
	
	public void setTechRecords(Collection<TechRecord> techRecords) {
		this.techRecords = techRecords;
	}
	
	public void addTechRecords(TechRecord techRecord) {
		this.techRecords.add(techRecord);
	}

	public CarModel getCarModel() {
		return carModel;
	}
	
	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
	
	public Collection<CarDetail> getCarDertails() {
		return carDertails;
	}
	
	public void setCarDertails(Collection<CarDetail> carDertails) {
		this.carDertails = carDertails;
	}	
	
	public void addCarDertail(CarDetail carDertail) {
		this.carDertails.add(carDertail);
	}	
	
	
	@Override
	public String toString() {
		String s = "Car id=" + id + "\n version=" + version 
				+ "\n model=" + carModel
//				+ "\n power=" + power  
				+ "\n engine=" + engine  
				+ "\n carType=" + carType + "\n color=" + color
				+ "\n timestamp=" + timestamp + "\n Description=" + Description;
		s += "\n techRecords:\n";
		for(TechRecord tr : techRecords)
			s+= "\t"+tr +"\n";
		return s;
	}
}
