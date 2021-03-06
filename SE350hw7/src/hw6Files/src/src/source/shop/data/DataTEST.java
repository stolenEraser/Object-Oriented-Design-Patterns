package hw6Files.src.src.source.shop.data;
import org.junit.Assert;
import org.junit.Test;
import junit.framework.TestCase;
import hw6Files.src.src.source.shop.data.Data;

// TODO:  complete the tests
public class DataTEST extends TestCase {
  public DataTEST(String name) {
    super(name);
  }
  public void testConstructorAndAttributes() {
    String title1 = "XX";
    String director1 = "XY";
    String title2 = " XX ";
    String director2 = " XY ";
    int year = 2002;

    Video v1 = Data.newVideo(title1, year, director1);
    assertSame(title1, v1.title());
    assertEquals(year, v1.year());
    assertSame(director1, v1.director());

    Video v2 = Data.newVideo(title2, year, director2);
    assertEquals(title1, v2.title());
    assertEquals(director1, v2.director());
  }

  public void testConstructorExceptionYear() {
    try {
      Data.newVideo("X", 1800, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("X", 5000, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("X", 1801, "Y");
      Data.newVideo("X", 4999, "Y");
    } catch (IllegalArgumentException e) {
      fail();
    }
  }

  public void testConstructorExceptionTitle() {
    try {
      Data.newVideo(null, 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("", 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo(" ", 2002, "Y");
      fail();
    } catch (IllegalArgumentException e) { }
  }

  public void testConstructorExceptionDirector() {
	 String s = Data.newVideo("A",2000,"B").toString();
	 assertEquals( s, "A (2000) : B" );
	 s = Data.newVideo(" A ",2000," B ").toString();
	 assertEquals( s, "A (2000) : B" );
  }
  
  public void testHashMapConsing() {
	  String title1 = "XX";
	  String director1 = "XY";
	  String title2 = " XX ";
	  String director2 = " XY ";
	  int year = 2002;
	  
	  Video v2 = Data.newVideo(title2, year, director2);
	  assertTrue(v2.title()== v2.title());
	  assertTrue(v2.director()== v2.director());
	  assertTrue(v2.year()== v2.year());
	  Video v1 = Data.newVideo(title1, year, director1);
	  assertTrue(v1.title()== v1.title());
	  assertEquals(v2.director(),v1.director());
	  assertTrue(v1.year()== v2.year());
  }

}
