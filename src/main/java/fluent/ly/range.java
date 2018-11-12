package fluent.ly;

import java.util.*;
//import java.util.stream.*;

public class range {

  public static DidTo numbers=  range.from(Integer.MIN_VALUE).to(Integer.MAX_VALUE);
  
  boolean empty;
  int from = -1;
  int to = -1;
  boolean infinite;
  int delta = 1;

  public int from() {
    return from;
  }

  public static DidFrom from(int ¢) {
    return new range() {
      {
        from = ¢;
        empty = false;
        infinite= true;
      }
    }. new DidFrom();
  }

  public boolean isEmpty() {
    return empty;
  }

  public boolean isInfinite() {
    // TODO Auto-generated method stub
    return infinite;
  }


  abstract class RangeIter<T extends RangeIter<T>> implements Iterable<Integer> {

    @Override @SuppressWarnings("unused") public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
        int current = from;

        @Override public boolean hasNext() {
          return infinite || (current < to);
        }

        @Override public Integer next() {
          if (!hasNext())
            throw new NoSuchElementException();
          final int $ = current;
          current += delta;
          return Integer.valueOf($);
        }
      };
    }
    
    abstract T This();

  }
  
  
  
  public class DidTo extends RangeIter<DidTo>{

    @Override DidTo This() {
      // TODO Auto-generated method stub
      return this;
    }

    public boolean isInfinite() {
      // TODO Auto-generated method stub
      return infinite;
    }

    public boolean isEmpty() {
      // TODO Auto-generated method stub
      return empty;
    }

    public Integer from() {
      return to == from ? null : Integer.valueOf(from);
    }

    public DidTo from(int ¢) {
      return new DidTo() {
        {
          delta = 1;
          to += 1;
          from = ¢;
          infinite = empty = false;
        }
      };
    }

    public DidTo interset(DidFrom ¢) {
      return range.from(¢.from()).to(to);
    }

    public boolean includes(int ¢) {
      // TODO Auto-generated method stub
      return (¢ < to && ¢ >= from);
    }
  }
    
 
  
  public class DidFrom extends RangeIter<DidFrom>{
    public DidTo to(final int ¢) {
      to = ¢;
      return new DidTo() {
        {
          infinite = false;
          to = ¢;
        }
      };
    }
    
    @Override DidFrom This() {
      // TODO Auto-generated method stub
      return this;
    }

    public boolean isInfinite() {
      // TODO Auto-generated method stub
      return infinite;
    }

    public boolean isEmpty() {
      // TODO Auto-generated method stub
      return empty;
    }

    public int from() {
      // TODO Auto-generated method stub
      return from;
    }
    
  }
  


  public static DidTo to(int ¢) {
    return new range() {
      {
        from = to = ¢ - 1;
        infinite = true;
        delta = -1;
      }
    }.new DidTo();
  }


}
