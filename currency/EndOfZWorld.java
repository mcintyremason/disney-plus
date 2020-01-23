import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class EndOfZWorld {
  static int comboCount = 0;
  static ArrayList<Integer> formats = new ArrayList<Integer>();
  static DecimalFormat df = new DecimalFormat("#");


  public static void printArray(String[] output) {
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

  public static void printArray(Float[] output) {
    for(int i = 0; i < output.length; i++) {
      if(i == 0) {
        System.out.printf("%" + formats.get(i) + "s", df.format(output[i]));
      } else {
        System.out.printf("%" + formats.get(i) + "s", df.format(output[i]));
      }
    }
    System.out.print("\n");
  }

  public static void findCombinations(int index, Float[] units, float total, Float[] combinations) {
    if(total == 0) {
      printArray(combinations);
      comboCount++;
      return;
    }

    if(index == units.length) return;

    float coin = units[index];

    for(int i = 0; (coin * i) <= total; i++) {
      combinations[index] = (float)i;
      findCombinations((index + 1), units,  (float)(total - (coin * i)), combinations);
      combinations[index] = (float)0;
    }
  }

  public static void main(String[] args) {
    String[] parsedArgs = args[0].split(",");

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<Float> unitArgs = new ArrayList<Float>();

    // Parse argument
    for(int i = 0; i < parsedArgs.length; i++){
      if(i % 2 == 0) {
        names.add(parsedArgs[i]);
      } else {
        unitArgs.add(Float.parseFloat(parsedArgs[i]));
      }
    }



    float total = 0;
    ArrayList<Float> relativeValues = new ArrayList<Float>();


    // Find smallest unit of value (will have the largest value, and will be the total we want to achieve)
    for(int i = 0; i < unitArgs.size(); i++) {
      Float unit = unitArgs.get(i);

      if(unit > total) {
        total = unit;
      }
    }

    // Find relative value of each unit
    for(int i = 0; i < unitArgs.size(); i++) {
      Float unit = unitArgs.get(i);
      Float relativeValue = total / unit;

      relativeValues.add(relativeValue);
    }

    Float[] units = relativeValues.toArray(new Float[relativeValues.size()]);
    Float[] combinations = new Float[unitArgs.size()];

    System.out.println(Arrays.toString(units));

    printArray(names.toArray(new String[names.size()]));
    findCombinations(0, units, total, combinations);
    System.out.println("Count: " + comboCount);
  }
}