import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Engine {
		
	@Column(name="Engine_Model")
	protected String model;
	@Column(name="Engine_Volume")	
	protected Integer volume;
	@Column(name="Engine_Power")

	protected Long Power;
	
	public Long getPower() {
		return Power;
	}
	public void setPower(Long power) {
		Power = power;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Engine(String model, Integer volume) {
		super();
		this.model = model;
		this.volume = volume;
	}
	
	public Engine() {
		super();
	}
	
	@Override
	public String toString() {
		return "Engine [model=" + model + ", volume=" + volume + "]";
	}
	
	
}
