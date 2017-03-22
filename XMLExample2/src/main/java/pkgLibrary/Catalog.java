package pkgLibrary;

import java.util.ArrayList;


import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog {

	@XmlAttribute
	int id;
	
	@XmlElement(name="book")
	private
	ArrayList<Book> books;
	//
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public Book GetBook(String id) throws BkException{
		Book n = null;
		for (Book z : books) {
			if (z.getId().equals(id)) {
				n = z;
			}
		} if (n == null) {
			n = new Book(id);
			throw new BkException(n);
		}
		return n;
	}
	public void AddBook(String id) throws BkException {
		for (Book n : books) {
			if (n.getId().equals(id)) {
				throw new BkException(n);
			}
		}
		Book b = new Book(id);
		books.add(b);
	}
	
	


	
	
	
	
}
