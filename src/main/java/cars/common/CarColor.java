package cars.common;
import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Entity
@Embeddable
public class CarColor {
	@Column(name="COLOR_NAME",table="car_colors")
	protected String name;
	@Column(name="COLOR_VALUE",table="car_colors")	
	protected int value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "CarColor [name=" + name + ", value=" + value + "]";
	}

	public CarColor() {
		super();
	}
	
	public CarColor(String name, int i) {
		super();
		this.name = name;
		this.value =  i;
	} 
}
