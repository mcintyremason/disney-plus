package EndOfZWorld;

import java.text.DecimalFormat;
import java.util.ArrayList;

// EndOfZWorld
public class App {
  // Total count of all combinations.
  public static int comboCount = 0;
  static ArrayList<Integer> formats = new ArrayList<Integer>();
  static DecimalFormat df = new DecimalFormat("#");

  // Output an array of String(s) in a formatted manner.
  static void printArray(String[] output) {
    for (int i = 0; i < output.length; i++) {
      if (i == 0) {
        formats.add(output[i].length());
        System.out.printf("%" + formats.get(i) + "s", output[i]);
      } else {
        formats.add(output[i].length() + 4);
        System.out.printf("%" + formats.get(i) + "s", output[i]);
      }
    }
    System.out.print("\n");
  }

  // Output an array of int(s) in a formatted manner.
  static void printArray(Double[] output) {
    for (int i = 0; i < output.length; i++) {
      if (i == 0) {
        System.out.printf("%" + formats.get(i) + "s", df.format(output[i]));
      } else {
        System.out.printf("%" + formats.get(i) + "s", df.format(output[i]));
      }
    }
    System.out.print("\n");
  }

  // Recursive function to find a combination of units,
  // which equals the initial total passed in on the inital call to this function.
  static void findCombinations(int index, Double[] units, double total, Double[] combination) {
    // If total is 0, then we have a valid combination.
    // Print out the valid combination and increment the comboCount.
    if (total == 0) {
      printArray(combination);
      comboCount++;
      return;
    }

    // We've exhausted all possibilities for this case, and return.
    if(index == units.length) return;

    // Set the current coin to the unit of value at the passed in index.
    double coin = units[index];

    // Loop from 0 to some value such that the current coin * i is less than or equal to the total we want to yield.
    // Due to the recursive nature of this function,
    //   this will start begin yielding combination starting with the unit in the last position.
    for(double i = 0; (coin * i) <= total; i++) {
      // Set the count for the given index to the current iteration.
      combination[index] = i;
      // Recurse and test if we produced valid combination.
      // Increment the index for the next iteration,
      //   Note we don't modify the index variable, yet pass in the incremented value to the recursive call.
      // Pass in the difference of the total from the curent coin multiplied by the current iteration.
      //   This allows us to compute other combination of coins with the current combination in subsequent calls.
      findCombinations((index + 1), units,  (double)(total - (coin * i)), combination);
      // Reset the count for the given index.
      combination[index] = 0.0;
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

  // Find smallest unit (will have the largest value, as it occurs the most, and will be the total we want to yield).
  static double findSmallestUnit(ArrayList<Double> unitArgs) {
    double smallestUnit = 0;

    for(int i = 0; i < unitArgs.size(); i++) {
      Double unit = unitArgs.get(i);

      // The smallestUnit will occur the most, meaning it will have the latgest value.
      if(unit > smallestUnit) {
        smallestUnit = unit;
      }
    }

    return smallestUnit;
  }

  // Find relative value of each unit.
  // This is found by dividing the total by the number of occurances of the unit to reach the total
  static void findRelativeValues(ArrayList<Double> unitArgs, ArrayList<Double> relativeValues, double total) {
    for(int i = 0; i < unitArgs.size(); i++) {
      Double occurances = unitArgs.get(i);
      Double relativeValue = total / occurances;

      relativeValues.add(relativeValue);
    }
  }

  public static void main(String[] args) {
    // The total we want to yield with any given combination of values.
    double total = 0;
    // ArrayList of the names of each unit of value after parsing argument(s).
    ArrayList<String> names = new ArrayList<String>();
    // ArrayList of the number required of that unit to reach our target total.
    ArrayList<Double> unitArgs = new ArrayList<Double>();
    // ArrayList of the relative values of each unit.
    ArrayList<Double> relativeValues = new ArrayList<Double>();

    // Parse the argument(s).
    parseArguments(args, names, unitArgs);
    // Set the total we want to reach, by finding the unit that occurs the most.
    // Since this unit occurs most often, it will also be the smallest unit (ex. Penny).
    total = findSmallestUnit(unitArgs);
    // Find the relative value of each unit based on the total (ex. Penny = 1).
    findRelativeValues(unitArgs, relativeValues, total);

    // Array of units of value.
    Double[] units = relativeValues.toArray(new Double[relativeValues.size()]);
    // Array to store the combination in question.
    Double[] combination = new Double[unitArgs.size()];

    // Print the names of each unit of value.
    printArray(names.toArray(new String[names.size()]));
    // Make initial recursive call.
    findCombinations(0, units, total, combination);
    // Print the total count of all combinations.
    System.out.println("Count: " + comboCount);
  }
}
