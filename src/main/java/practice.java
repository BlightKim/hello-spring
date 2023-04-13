import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class practice {

  public static void main(String[] args) {
    Student[] stuArr = {
        new Student("이자바", 3, 300),
        new Student("김자바", 1, 200),
        new Student("안자바", 2, 100),
        new Student("박자바", 2, 150),
        new Student("소자바", 1, 200),
        new Student("나자바", 3, 290),
        new Student("감자바", 3, 180)
    };

    List<String> names = Stream.of(stuArr).map(s-> s.getName()).collect(Collectors.toList());

    System.out.println("names = " + names);

    Student[] student2 = Stream.of(stuArr).toArray(Student[]::new);

    Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s -> s.getName(), s -> s));

    System.out.println("stuMap = " + stuMap);

    long count = Stream.of(stuArr).collect(Collectors.counting());

    System.out.println("count = " + count);

    long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student::getTotalScore));
    System.out.println("totalScore = " + totalScore);
  }
}

class Student implements Comparable<Student> {

  String name;
  int ban;
  int totalScore;

  Student(String name, int ban, int totalScore) {
    this.name = name;
    this.ban = ban;
    this.totalScore = totalScore;
  }

  public String toString() {
    return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
  }

  String getName() {
    return name;
  }

  int getBan() {
    return ban;
  }

  int getTotalScore() {
    return totalScore;
  }

  public int compareTo(Student s) {
    return s.totalScore - this.totalScore;
  }
}