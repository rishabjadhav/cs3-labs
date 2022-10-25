import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FullyFunctional {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        //0
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<String> letters = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

        //1
        //NICE!

        //2
        System.out.println("enter three names");
        String name1 = console.next().toUpperCase();
        String name2 = console.next().toUpperCase();
        String name3 = console.next().toUpperCase();
        List<String> names = new ArrayList<>(Arrays.asList(name1, name2, name3));
        Stream.of(name1, name2, name3);

        //3
        List<String> strings = new ArrayList<>(Arrays.asList("conn", "ec", "ted ", "st", "ring"));
        Collectors.joining("separator");
        System.out.println(strings.stream());

        //4
        Comparator<Integer> descending = Comparator.reverseOrder();
        Integer[] intArr = new Integer[6];
        for (int i : intArr) {
            intArr[i] = i;
        }
        Arrays.sort(intArr, descending);

        //5
        IntStream intStrm = IntStream.range(1, 10);
        intStrm.forEach(System.out::println);

        //6
        Stream<String> strm = Files.lines(Paths.get("TravelingSalesperson.iml"));
        strm.sorted().forEach(System.out::println);

        //7
        System.out.println(IntStream.range(numbers.size(), letters.size()).noneMatch(i -> numbers.size() % i == 0));

        //8
        Random rng8 = (Random) new Random().ints(1, 100).limit(letters.size()).boxed();
        System.out.println(rng8);

        //9
        Random rng9 = (Random) new Random().ints(1, 100).limit(letters.size()).distinct();
        System.out.println(rng9);

        //10
        int[] descendingArr = new int[10];
        for (int i : descendingArr) {
            descendingArr[i] = i;
        }
        int[] num = Arrays.stream(descendingArr).boxed().sorted(Comparator.comparingInt((Integer b) -> b)).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(num));

        //11
        new Thread(() -> System.out.println("running")).start();

        //12
        String str = console.nextLine();
        int num12 = console.nextInt();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < num12) {
            strBuilder.append(str);
        }
        System.out.println(strBuilder.substring(0, num12).chars().limit(num12).filter(i -> i == 100).count());

        //13
        /*
        public String doubleChar(String str) {
  String dcStr = "";
  for(int i=0; i < str.length(); i++) {
    dcStr = dcStr + str.charAt(i)+ str.charAt(i);
  }
  return dcStr;
}
        */

        //14
    }

    static int sumIf(List<Integer> nums, Predicate<Integer> conditions) {
        return nums.stream().filter(conditions).reduce(0, Integer::sum);
    }

    //15
    /*
public int sumNumbers(String str) {
  int length = str.length();
  int sum = 0;
  String temp = "";
  for (int i = 0; i < length; i++) {
    if (Character.isDigit(str.charAt(i))) {
      if (i < length - 1 && Character.isDigit(str.charAt(i + 1))) {
        temp += str.charAt(i);
      }
      else {
        temp += str.charAt(i);
        sum += Integer.parseInt(temp);
        temp = "";
      }
    }
  }
  return sum;
}

    */


}

