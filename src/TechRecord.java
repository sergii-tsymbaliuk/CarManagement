import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class TechRecord {
	protected String text;
	protected Date date;
	protected String author;

	public TechRecord() {
		super();
	}

	public TechRecord(String text, Date date, String author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
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
		return "TechRecord [text=" + text + ", date=" + date + ", author="
				+ author + "]";
	}
	
		
}
