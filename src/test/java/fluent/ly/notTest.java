package fluent.ly;

import org.junit.*;
import il.org.spartan.*;

// This suppress is here because
// eclipse asks the method to be static
// although they shouldn't
@SuppressWarnings("static-method") public class notTest {
  @Test public void inTest() {
    Integer two = Integer.valueOf(2), three = Integer.valueOf(3);
    assert not.in(Utils.cantBeNull(two), Utils.cantBeNull(three));
    assert !not.in(Utils.cantBeNull(two), Utils.cantBeNull(two),Utils.cantBeNull(three));
  }

  @Test public void nilTest() {
    assert !not.nil(null);
    assert not.nil(Integer.toString(5));
  }
}
