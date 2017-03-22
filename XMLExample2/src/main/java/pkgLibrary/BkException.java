package pkgLibrary;
import pkgLibrary.Book;
public class BkException extends Exception{
	private Book ErrorBook;
	public BkException(Book b){
		ErrorBook= b;
	}
	public Book getErrorBook() {
		return ErrorBook;
	}
}