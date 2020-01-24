package MakeChange;

// MakeChange
public class App {
    // Total count of all combinations.
    public static int comboCount = 0;
  
    // Output an array of String(s) in a formatted manner.
    static void printArray(String[] output) {
      for(int i = 0; i < output.length; i++) {
        if(i == 0) {
          System.out.printf("%7s", output[i]);
        } else {
          System.out.printf("%9s", output[i]);
        }
      }
      System.out.print("\n");
    }
  
    // Output an array of int(s) in a formatted manner.
    static void printArray(int[] output) {
      for(int i = 0; i < output.length; i++) {
        if(i == 0) {
          System.out.printf("%7s", output[i]);
        } else {
          System.out.printf("%9s", output[i]);
        }
      }
      System.out.print("\n");
    }
  
    // Recursive function to find a combination of units,
    //   which equals the initial total passed in on the inital call to this function.
    static void findcombination(int index, int[] units, int total, int[] combination) {
      // If total is 0, then we have a valid combination.
      // Print out the valid combination and increment the comboCount.
      if(total == 0) {
        printArray(combination);
        comboCount++;
        return;
      }
  
      // We've exhausted all possibilities for this case, and return.
      if(index == units.length) return;
  
      // Set the current coin to the unit of value at the passed in index.
      int coin = units[index];
  
      // Loop from 0 to some value such that the current coin * i is less than or equal to the total we want to yield.
      // Due to the recursive nature of this function,
      //   this will start begin yielding combinations starting with the unit in the last position.
      for(int i = 0; (coin * i) <= total; i++) {
        // Set the count for the given index to the current iteration.
        combination[index] = i;
        // Recurse and test if we produced valid combination.
        // Increment the index for the next iteration,
        //   Note we don't modify the index variable, yet pass in the incremented value to the recursive call.
        // Pass in the difference of the total from the curent coin multiplied by the current iteration.
        //   This allows us to compute other combinations of coins with the current combination in subsequent calls.
        findcombination((index + 1), units,  (total - (coin * i)), combination);
        // Reset the count for the given index.
        combination[index] = 0;
      }
    }
  
    public static void main(String[] args) {
      // The total we want to yield with any given combination of values.
      int total = 100;
      // The names of each unit of value.
      String[] names = {"Quarter", "Dime", "Nickel", "Penny"};
      // Array of units of value.
      int[] units = {25, 10, 5, 1};
      // Array to store the combination in question.
      int[] combination = new int[units.length];
  
      // Print the names of each unit of value.
      printArray(names);
      // Make initial recursive call.
      findcombination(0, units, total, combination);
      // Print the total count of all combinations.
      System.out.println("Count: " + comboCount);
    }
  }