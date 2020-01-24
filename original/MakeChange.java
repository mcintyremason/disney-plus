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

  static void findcombination(int index, int[] units, int total, int[] combination) {
    if(total == 0) {
      printArray(combination);
      comboCount++;
      return;
    }

    if(index == units.length) return;

    int coin = units[index];

    for(int i = 0; (coin * i) <= total; i++) {
      combination[index] = i;
      findcombination((index + 1), units,  (total - (coin * i)), combination);
      combination[index] = 0;
    }
  }

  public static void main(String[] args) {
    String[] names = {"Quarter", "Dime", "Nickel", "Penny"};
    int[] units = {25, 10, 5, 1};
    int[] combination = new int[units.length];
    int total = 100;

    printArray(names);
    findcombination(0, units, total, combination);
    System.out.println("Count: " + comboCount);
  }
}