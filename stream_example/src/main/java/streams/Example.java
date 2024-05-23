package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static Employee[] giveRaises(Employee[] employees, int raise) {
        Arrays.stream(employees).forEach(e -> e.IncreaseSalaryBy(raise));
        return employees;
    }

    public static Employee[] giveRaisesParallel(Employee[] employees, int raise) {
        Arrays.stream(employees).parallel().forEach(e -> e.IncreaseSalaryBy(raise));

        return employees;
    }

    public static List<Optional<Employee>> findEmployees(Integer[] ids) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return Stream.of(ids).map(employeeRepository::findById).collect(Collectors.toList());
    }

    public static List<Optional<Employee>> findEmployeesWithWagesGreaterThan(Integer[] ids, int salary) {
        return findEmployees(ids).stream().filter(e -> e.isPresent() && e.get().getSalary() > salary).collect(Collectors.toList());
    }

    public static Optional<Employee> findFirstEmployeeWithWageGreaterThan(Integer[] ids, int salary) {
        return findEmployeesWithWagesGreaterThan(ids, salary).stream().findFirst().orElse(null);
    }

    public static List<String> flattenAllNames(String[][] manyNames) {
        return Arrays.stream(manyNames).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    public static List<Integer> getSequence(int start, int skip, int hops) {
        return Stream.iterate(start, i -> i + skip).limit(hops).collect(Collectors.toList());

    }

    public static Employee getMinEmployee(Employee[] employees) {
        return Arrays.stream(employees).min((e1, e2) -> e1.getId() - e2.getId()).orElseThrow(NoSuchElementException::new);
    }

    public static Employee getHighestPaidEmployee(Employee[] employees) {
        return Arrays.stream(employees).max(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
    }

    public static int getLatestEmployeeId(Employee[] employees) {
        return Arrays.stream(employees).mapToInt(Employee::getId).max().orElseThrow(NoSuchElementException::new);
    }

    public static int[] removeDuplicates(int[] numbers) {
        return Arrays.stream(numbers).distinct().toArray();
    }

    public static boolean areAllEarning(Employee[] employees, int amount) {
        return Arrays.stream(employees).allMatch(e -> (e.getSalary() >= amount));
    }

    public static boolean checkForName(Employee[] employees, String name) {
        return Arrays.stream(employees).anyMatch(e -> (e.getName().split(" ")[0]).equals(name));
    }

    public static int reduceSalaries(Employee[] employees) {
        return Arrays.stream(employees).map(Employee::getSalary).reduce(0, Integer::sum);
    }

    public static String printNames(Employee[] employees) {
        return Arrays.stream(employees).map(Employee::getName).collect(Collectors.joining(", "));
    }

    public static Map<Boolean, List<Employee>> splitEmployeesBySalary(Employee[] employees, int salary) {
        return Arrays.stream(employees).collect(Collectors.partitioningBy(e -> e.getSalary() >= salary));
    }


}