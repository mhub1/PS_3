package pkgEmpty;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import pkgLibrary.BkException;
import pkgLibrary.Book;
import pkgLibrary.Catalog;
import pkgMain.XMLReader;

public class CatalogTest {

	@Test
	public void testGetBook() throws BkException{
		Catalog cat = XMLReader.ReadXMLFile();
		assertEquals(cat.GetBook("bk101"),
			cat.getBooks().get(0));
	}

	@Test (expected = BkException.class)
	public void testGetBook1() throws BkException{
		Book b = new Book("bk100");
		Catalog cat = XMLReader.ReadXMLFile();
		cat.GetBook(b.getId());
	}

	
	@Test
	public void testAddBook() throws BkException{
		Catalog cat = XMLReader.ReadXMLFile();
		Book b = new Book("bk130");
		cat.AddBook(b.getId());
		assertEquals(cat.GetBook(b.getId()),
				b);
	}

	@Test (expected = BkException.class)
	public void testAddBook1() throws BkException{
		Catalog cat = XMLReader.ReadXMLFile();
		Book b = new Book("bk101");
		cat.AddBook(b.getId());
	}

}
