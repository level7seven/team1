package il.org.spartan.etc;

import java.io.*;
import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-access", "static-method" }) public class outTest {
  @Test public void testOutString() {
    final String tested = "I am a Test String";
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested);
    azzert.assertEquals(tested, outContent + "");
  }

  @Test public void testOutBoolean() {
    final String tested = "I am a Test String";
    final boolean pred = true;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, pred);
    azzert.assertEquals(tested + " = " + pred + "\n", outContent + "");
  }

  @Test public void testOutNullCollection() {
    final String tested = "I am a Test String";
    final List<Integer> lst = null;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutEmptyCollectionOfObjects() {
    final String tested = "I am a Test String";
    final List<Object> lst = new ArrayList<>();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutCollectionOfOneObject() {
    final String tested = "I am a Test String";
    final List<Object> lst = new ArrayList<>();
    final Integer num = box.box(3);
    lst.add(num);
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("Only 1 " + tested + ": " + num + "\n", outContent + "");
  }

  @Test public void testOutCollectionOfMultipleObjects() {
    final String tested = "I am a Test String";
    final List<Object> lst = new ArrayList<>();
    final Integer num = box.box(3);
    lst.add(num);
    lst.add(num);
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertEquals("Total of " + lst.size() + " " + tested + ":\n\t 1) " + num + "\n\t 2) " + num + "\n", outContent + "");
  }
  
  @Test public void testOutCollectionOfMoreThan30Objects() {
    final String tested = "I am a Test String";
    final List<Object> lst = new ArrayList<>();
    final Integer num = box.box(3);
    for(int ¢ =0; ¢< 40; ++¢) 
      lst.add(num);
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, lst);
    azzert.assertNotEquals((outContent + "").indexOf("..."), -1);
  }

  @Test public void testOutInt() {
    final String tested = "I am a Test String";
    final int num = 0;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, num);
    azzert.assertEquals(tested + " = " + num + "\n", outContent + "");
  }

  @Test public void testOutNullObject() {
    final String tested = "I am a Test String";
    final Object str = null;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, str);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutObject() {
    final String tested = "I am a Test String";
    final Object str = "I am also a Test String";
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, str);
    azzert.assertEquals(tested + " = " + str + "\n", outContent + "");
  }

  @Test public void testOutNullObjectArray() {
    final String tested = "I am a Test String";
    final Object[] arr = null;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutEmptyObjectArrayOfObjects() {
    final String tested = "I am a Test String";
    final Object[] arr = new Object[0];
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("No " + tested + "\n", outContent + "");
  }

  @Test public void testOutObjectArrayOfOneObject() {
    final String tested = "I am a Test String";
    final Object[] arr = new Object[1];
    final Integer num = box.box(3);
    arr[0] = num;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("Only one " + tested + ": " + num + "\n", outContent + "");
  }

  @Test public void testOutObjectArrayOfMultipleObjects() {
    final String tested = "I am a Test String";
    final Object[] arr = new Object[2];
    final Integer num = box.box(3);
    arr[1] = arr[0] = num;
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    out.out(tested, arr);
    azzert.assertEquals("Total of " + arr.length + " " + tested + ":\n\t" + num + "\n\t" + num + "\n", outContent + "");
  }
  

}