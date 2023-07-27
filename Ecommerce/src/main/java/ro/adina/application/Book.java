package ro.adina.application;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	
	private String title;
	private String author;
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	
	
	public Book() {
		super();
	}

	public Book(String title, String author, String description) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", description=" + description + "]";
	}
	
	
	

}
