public class MakeChange {
  static int comboCount = 0;

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

  static void findCombinations(int index, int[] units, int total, int[] combinations) {
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
    String[] names = {"Quarter", "Dime", "Nickel", "Penny"};
    int[] units = {25, 10, 5, 1};
    int[] combinations = new int[units.length];
    int total = 100;

    printArray(names);
    findCombinations(0, units, total, combinations);
    System.out.println("Count: " + comboCount);
  }
}