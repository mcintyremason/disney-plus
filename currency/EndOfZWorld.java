import java.util.ArrayList;
import java.util.Arrays;

public class EndOfZWorld {
  public static int comboCount = 0;

  public static void printArray(String[] output) {
    for(int i = 0; i < output.length; i++) {
      if(i == 0) {
        System.out.printf("%7s", output[i]);
      } else {
        System.out.printf("%9s", output[i]);
      }
    }
    System.out.print("\n");
  }

  public static void printArray(int[] output) {
    for(int i = 0; i < output.length; i++) {
      if(i == 0) {
        System.out.printf("%7s", output[i]);
      } else {
        System.out.printf("%9s", output[i]);
      }
    }
    System.out.print("\n");
  }

  public static void findCombinations(int index, Integer[] units, int total, int[] combinations) {
    if(total == 0) {
      printArray(combinations);
      comboCount++;
      return;
    }

    if(index == units.length) return;

    int coin = units[index];

    for(int i = 0; (coin * i) <= total; i++) {
      combinations[index] = i;
      findCombinations((index + 1), units,  (total - (coin * i)), combinations);
      combinations[index] = 0;
    }
  }

  public static void main(String[] args) {
    String[] parsedArgs = args[0].split(",");

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Integer> units = new ArrayList<Integer>();

    for(int i = 0; i < parsedArgs.length; i++){
      if(i % 2 == 0) {
        names.add(parsedArgs[i]);
      } else {
        units.add(Integer.parseInt(parsedArgs[i]));
      }
    }

    int[] combinations = new int[units.size()];
    int total = 25;

    printArray(names.toArray(new String[names.size()]));
    findCombinations(0, units.toArray(new Integer[units.size()]), total, combinations);
    System.out.println("Count: " + comboCount);
  }
}