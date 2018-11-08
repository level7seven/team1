package fluent.ly;

import java.util.*;

import org.junit.*;

import fluent.ly.nil.*;

public class NilTest {
  @Test @SuppressWarnings("static-method") public void testForgetting() {
    azzert.assertNull(nil.forgetting(Integer.valueOf(1), Integer.valueOf(2)));
    azzert.assertNull(nil.forgetting(Integer.valueOf(1), "abc"));
    azzert.assertNull(
        nil.forgetting(Integer.valueOf(1), Double.valueOf(2.5), "abc", Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))));
  }

  static String helperF(Integer ¢) {
    return ¢ + "";
  }
  
  @Test @SuppressWarnings({ "static-method", "static-access" }) public void testGuardingly() {
    On<Integer, String> ff = nil.guardingly(NilTest::helperF);
    azzert.assertNull(ff.on(null));
    azzert.assertNotNull(ff.on(Integer.valueOf(1)));
    azzert.assertEquals("1", ff.on(Integer.valueOf(1)));
  }

  @Test @SuppressWarnings("static-method") public void testIgnoringBoolean() {
    azzert.assertNull(nil.ignoring(true));
    azzert.assertNull(nil.ignoring(false));
  }

  @Test @SuppressWarnings("static-method") public void testIgnoringDouble() {
    azzert.assertNull(nil.ignoring(1.5));
    azzert.assertNull(nil.ignoring(2.0));
  }

  @Test @SuppressWarnings("static-method") public void testIgnoringLong() {
    azzert.assertNull(nil.ignoring(7034567L));
    azzert.assertNull(nil.ignoring(2L));
  }
}