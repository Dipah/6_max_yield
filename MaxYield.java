import java.util.*;

public class MaxYield {
  
  public static List<String> bestChoices(List<Integer> strips) {
    // If input has only one strip, then return it
    if (strips.size() <= 1) return Arrays.asList(Integer.toString(strips.get(0)));

    List<String> res = new ArrayList<String>(strips.size());
    for (int i=0; i<strips.size(); i++) res.add("");
    res.set(0, Integer.toString(strips.get(0)));

    // Build the solution from left to right (memoization)
    // Starting from second strip, cumulative solution is solution till now plus (
    //    If prior strip was not chosen, choose the current strip
    //    else choose the maximum of current strip or prior strip )
    for (int i=1; i < strips.size(); i++) {
      if (res.get(i - 1) == "X") {
        res.set(i, Integer.toString(strips.get(i)));
      } else {
        if (strips.get(i) > strips.get(i-1)) {
          res.set(i - 1, "X");
          res.set(i, Integer.toString(strips.get(i)));
        } else {
          res.set(i, "X");
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    // List<Integer> strips = Arrays.asList(206, 140, 300, 52, 107);
    List<Integer> strips = Arrays.asList(147, 206, 52, 240, 300);
    
    List<String> result = bestChoices(strips);

    String output = "[";
    for (int i=0; i < result.size(); i++) {
      if (i != result.size() - 1) {
        output += result.get(i) + ",";
      } else {
        output += result.get(i);
      }
    }
    System.out.println(output + "]");
  }
}
