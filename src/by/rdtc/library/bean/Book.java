package by.rdtc.library.bean;

import java.io.Serializable;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long idBook;
	private String bookName;
	private String author;
	private int numberOfPages;
	private int year;
	
	public Book() {
		super();
	}
		
	public  Book(long idBook, String bookName, String author, int numberOfPages, int year ) {
		this.idBook = idBook;
		this.bookName = bookName;
		this.author = author;
		this.numberOfPages = numberOfPages;
		this.year = year;
	}

	public long getIdBook() {
		return idBook;
	}

	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + (int) (idBook ^ (idBook >>> 32));
		result = prime * result + numberOfPages;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (idBook != other.idBook)
			return false;
		
		if (numberOfPages != other.numberOfPages)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [idBook=" + idBook + ", bookName=" + bookName + ", author=" + author + ", numberOfPages="
				+ numberOfPages + ", year=" + year + ", listofAuthors=" + "]";
	}
	
	
	
	

}
