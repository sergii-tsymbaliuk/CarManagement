package cars.common;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Version;

import org.springframework.stereotype.Component;

@Component
@Entity
@SecondaryTable(name="car_colors")
@Inheritance(strategy=InheritanceType.JOINED)
public class Car {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="Car_id")
	protected Integer id; 
	@Version
	protected long version;
	
	@ManyToOne(/*cascade={CascadeType.MERGE,CascadeType.PERSIST}*/)
	protected CarModel carModel;
	
	@OneToOne(/*cascade={CascadeType.MERGE,CascadeType.PERSIST}*/)
	@JoinColumn(name="ENGINE_ID")
	Engine121 engine;
	
	@Basic(fetch=FetchType.LAZY,optional=true)
	@Enumerated(EnumType.STRING)
	protected CarType carType;
	
	protected CarColor color;
	
	@Transient
	protected Date timestamp;

	@Lob
	protected String description;

	@OneToMany(fetch=FetchType.EAGER)
	protected List<TechRecord> techRecords = new ArrayList<TechRecord>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	protected List<CarDetail> carDetails = new ArrayList<CarDetail>();
	
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public CarModel getModel() {
		return carModel;
	}
	public void setModel(CarModel carModel) {
		this.carModel = carModel;
	}
	
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
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	public void setTechRecords(List<TechRecord> techRecords) {
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
	
	public Collection<CarDetail> getcarDetails() {
		return carDetails;
	}
	
	public void setcarDetails(List<CarDetail> carDetails) {
		this.carDetails = carDetails;
	}	
	
	public void addcarDetail(CarDetail carDetail) {
		this.carDetails.add(carDetail);
	}	
	
	
	@Override
	public String toString() {
		String s = "Car id=" + id + "\n version=" + version 
				+ "\n timestamp=" + timestamp				
				+ "\n model=" + carModel
//				+ "\n power=" + power  
				+ "\n engine=" + engine  
				+ "\n carType=" + carType + "\n color=" + color
				+ "\n Description=" + description;
		s += "\n techRecords:\n";
		for(TechRecord tr : techRecords)
			s+= "\t"+tr +"\n";

		s += "\n carDetails:\n";
		for(CarDetail cd : carDetails)
			s+= "\t"+cd +"\n";
		return s;
	}
}
