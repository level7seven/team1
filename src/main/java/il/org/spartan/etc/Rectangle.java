package il.org.spartan.etc;

import il.org.spartan.utils.*;

public class Rectangle {
  
  private Pair<Double, Double> p1;
  private Pair<Double, Double> p2;
  
  public double length;
  public double width;

  
  public Rectangle(Pair<Double, Double> p1, Pair<Double, Double> p2) throws IllegalArgumentException {
    if(p1.first.equals(p2.first) || p1.second.equals(p2.second)) throw new IllegalArgumentException();
    
    this.p1 = p1;
    this.p2 = p2;
    
    length = Math.abs(p1.first.doubleValue() - p2.first.doubleValue());
    width = Math.abs(p1.second.doubleValue() - p2.second.doubleValue());
    
  }
  

  public double area() {
    return length*width;
  }

  public double perim() {
    return 2*(length + width);
  }


  public Rectangle transpose() {
    Pair<Double, Double> p1_new = Pair.newPair(p1.second, p1.first);
    Pair<Double, Double> p2_new = Pair.newPair(p2.second, p2.first);
    
    Rectangle newRec = null;
    
    try {
      newRec =  new Rectangle(p1_new, p2_new);
    } catch (@SuppressWarnings("unused") IllegalArgumentException ignore) {
      throw new AssertionError();
    }
  
    return newRec;
  }
  
  
}
