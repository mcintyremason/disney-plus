import java.text.DecimalFormat;
import java.util.ArrayList;

public class EndOfZWorld {
  static int comboCount = 0;
  static ArrayList<Integer> formats = new ArrayList<Integer>();
  static DecimalFormat df = new DecimalFormat("#");

   static void printArray(String[] output) {
    for(int i = 0; i < output.length; i++) {
      if(i == 0) {
        formats.add(output[i].length());
        System.out.printf("%" + formats.get(i) + "s", output[i]);
      } else {
        formats.add(output[i].length() + 4);
        System.out.printf("%" + formats.get(i) + "s", output[i]);
      }
    }
    System.out.print("\n");
  }

  static void printArray(Double[] output) {
    for(int i = 0; i < output.length; i++) {
      if(i == 0) {
        System.out.printf("%" + formats.get(i) + "s", df.format(output[i]));
      } else {
        System.out.printf("%" + formats.get(i) + "s", df.format(output[i]));
      }
    }
    System.out.print("\n");
  }

  static void findCombinations(int index, Double[] units, double total, Double[] combinations) {
    if(total == 0) {
      printArray(combinations);
      comboCount++;
      return;
    }

    if(index == units.length) return;

    double coin = units[index];

    for(double i = 0; (coin * i) <= total; i++) {
      combinations[index] = i;
      findCombinations((index + 1), units,  (double)(total - (coin * i)), combinations);
      combinations[index] = 0.0;
    }
  }

  static void parseArguments(String[] args, ArrayList<String> names, ArrayList<Double> unitArgs) {
    String[] parsedArgs = args[0].split(",");
    
    for(int i = 0; i < parsedArgs.length; i++){
      if(i % 2 == 0) {
        names.add(parsedArgs[i]);
      } else {
        unitArgs.add(Double.parseDouble(parsedArgs[i]));
      }
    }
  }

  // Find smallest unit (will have the largest value, as it occurs the most, and will be the total we want to yield)
  static double findSmallestUnit(ArrayList<Double> unitArgs) {
    double smallestUnit = 0;

    for(int i = 0; i < unitArgs.size(); i++) {
      Double unit = unitArgs.get(i);

      if(unit > smallestUnit) {
        smallestUnit = unit;
      }
    }

    return smallestUnit;
  }

  // Find relative value of each unit
  static void findRelativeValues(ArrayList<Double> unitArgs, ArrayList<Double> relativeValues, double total) {
    for(int i = 0; i < unitArgs.size(); i++) {
      Double unit = unitArgs.get(i);
      Double relativeValue = total / unit;

      relativeValues.add(relativeValue);
    }
  }

  public static void main(String[] args) {
    double total = 0;
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Double> unitArgs = new ArrayList<Double>();
    ArrayList<Double> relativeValues = new ArrayList<Double>();

    parseArguments(args, names, unitArgs);
    total = findSmallestUnit(unitArgs);
    findRelativeValues(unitArgs, relativeValues, total);

    Double[] units = relativeValues.toArray(new Double[relativeValues.size()]);
    Double[] combinations = new Double[unitArgs.size()];

    printArray(names.toArray(new String[names.size()]));
    findCombinations(0, units, total, combinations);
    System.out.println("Count: " + comboCount);
  }
}