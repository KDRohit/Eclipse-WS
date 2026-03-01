package learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
	void style1() {
		Consumer<Integer> printImp = System.out::println;

		// Print only even numbers.
		List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6);

		System.out.println("Even Nums are :: ");
		nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList()).forEach(printImp);

		System.out.println("Nums greater than 5 :: ");
		nums.stream().filter(num -> num > 5).collect(Collectors.toList()).forEach(printImp);

		System.out.println("Square Nums are :: ");
		nums.stream().map(num -> num * num).collect(Collectors.toList()).forEach(printImp);
		;

		System.out.println("Max Num is :: ");
		nums.stream().max(Integer::compareTo).ifPresentOrElse(printImp, () -> System.out.println("No data found"));

		System.out.println("Min Num is :: ");
		nums.stream().min(Integer::compareTo).ifPresentOrElse(printImp, () -> System.out.println("No data found"));

		System.out.println("distinct Num is :: ");
		nums.stream().distinct().collect(Collectors.toList()).forEach(printImp);

		System.out.println("reverse list is :: ");
		nums.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(printImp);
	}

	void style2() {
		List<Integer> nums = Arrays.asList(50, 10, 30, 40, 20);
		Stream<Integer> s = nums.stream().sorted(Comparator.reverseOrder());
		s.skip(1).findFirst().ifPresent(System.out::println);
	}

	void style3() {
		String msg = "this is it";
		Map<Character, Integer> map = new HashMap();
		for (char c : msg.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);
	}

	void style4() {
		List<Integer> list = List.of(1, 1, 2, 3, 4, 5);
		Set<Integer> set = list.stream().collect(Collectors.toSet());
		System.out.println(set);
	}

	void style5() {
		Student stud = new Student();
		Iterator<String> it = stud.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		stud.forEach(System.out::println);
	}

	public static void main(String[] args) {
		new Demo().style5();
	}
}
