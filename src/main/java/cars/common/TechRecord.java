package cars.common;
import java.util.Date;



//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Embeddable
@Entity
public class TechRecord {
	@Id
	@GeneratedValue
	Long id;
	protected Date date;
	protected String author;
	protected String text;
	
	public TechRecord() {
		super();
	}

	public TechRecord(String text, Date date, String author) {
		super();
		this.date = date;
		this.author = author;
		this.text = text;
	}

	public TechRecord(String text, String author) {
		this(text, new Date(), author);
	}

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "TechRecord [" + date + " : " + author + " \""
				+ text + "\"]";
	}
	
		
}
