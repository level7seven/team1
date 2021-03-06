package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.LinearRegression.*;

@SuppressWarnings("static-method") public class LinearRegressionTest {
  @Test public void linearRegressionTwoDots() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(0.0, 0.0);
    list.record(5.0, 5.0);
    final LinearRegression regression = new LinearRegression(list);
    try {
      assert regression.getLine().equals(new LinearFunction(1.0, 0.0));
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void linearRegressionOneDot() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(0.0, 0.0);
    final LinearRegression regression = new LinearRegression(list);
    try {
      regression.getLine();
    } catch (final NotEnoughDots __) {
      forget.it(__);
      assert true;
    } catch (final InfiniteSlopeFunction __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void linearRegressionExactThreeDots() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(1.0, 1.0);
    list.record(2.0, 4.0);
    list.record(3.0, 7.0);
    final LinearRegression regression = new LinearRegression(list);
    try {
      assert regression.getLine().equals(new LinearFunction(3.0, -2.0));
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void linearRegressionNotExactThreeDots() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(1.0, 1.0);
    list.record(2.0, 5.0);
    list.record(3.0, 7.0);
    final LinearRegression regression = new LinearRegression(list);
    try {
      assert regression.getLine().slope >= 2.0 && regression.getLine().slope <= 4.0;
      assert regression.getLine().intercept <= 1.0 && regression.getLine().intercept >= -3.0;
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void linearRegressionTwoSameX() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(1.0, 1.0);
    list.record(1.0, 5.0);
    list.record(3.0, 7.0);
    final LinearRegression regression = new LinearRegression(list);
    try {
      assert regression.getLine().slope >= 1.0 && regression.getLine().slope <= 3.0;
      assert regression.getLine().intercept <= 4.0 && regression.getLine().intercept >= -2.0;
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void linearRegressionOnlyTwoSameX() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(1.0, 1.0);
    list.record(1.0, 5.0);
    final LinearRegression regression = new LinearRegression(list);
    try {
      regression.getLine();
    } catch (final InfiniteSlopeFunction ¢) {
      assert ¢.xVal == 1.0;
    } catch (final NotEnoughDots __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void linearRegressionOnlySameX() {
    final RealNumbersPairList list = new RealNumbersPairList();
    list.record(7.0, 1.0);
    list.record(7.0, 5.4);
    list.record(7.0, 4.0);
    list.record(7.0, 8.9);
    list.record(7.0, 22.2);
    list.record(7.0, 25.8);
    final LinearRegression regression = new LinearRegression(list);
    try {
      regression.getLine();
    } catch (final InfiniteSlopeFunction ¢) {
      assert ¢.xVal == 7.0;
    } catch (final NotEnoughDots __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void linearRegressionBuildFromArrays() {
    final double xVals[] = { 1.0, 3.0, 4.0 }, yVals[] = { 1.0, 9.0, 13.0 };
    final LinearRegression regression = new LinearRegression(xVals, yVals);
    try {
      assert regression.getLine().slope >= 3.5 && regression.getLine().slope <= 4.5;
      assert regression.getLine().intercept <= -2.5 && regression.getLine().intercept >= -3.5;
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void checkR2MeasurmentBadFit() {
    final double xVals[] = { 1.0, 1.0, 4.0 }, yVals[] = { 1.0, 5.0, 7.0 };
    final LinearRegression regression = new LinearRegression(xVals, yVals);
    try {
      regression.getLine();
      final double R2 = regression.getR2Measurement();
      assert R2 <= 0.6 && R2 >= 0.5;
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void checkR2MeasurmentGoodFit() {
    final double xVals[] = { 1.0, 2.0, 3.0 }, yVals[] = { 1.0, 5.0, 9.0 };
    final LinearRegression regression = new LinearRegression(xVals, yVals);
    try {
      regression.getLine();
      final double R2 = regression.getR2Measurement();
      assert R2 <= 1.0 && R2 >= 0.9;
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }

  @Test public void checkR2MeasurmentVeryBadFit() {
    final double xVals[] = { 1.0, 1.0, 3.0, 4.0 }, yVals[] = { 1.0, 1000.0, -500.0, 1700.9 };
    final LinearRegression regression = new LinearRegression(xVals, yVals);
    try {
      regression.getLine();
      final double R2 = regression.getR2Measurement();
      assert R2 <= 0.1 && R2 >= 0.0;
    } catch (final Exception __) {
      forget.it(__);
      assert false;
    }
  }
}
