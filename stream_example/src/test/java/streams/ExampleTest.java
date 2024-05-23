package streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;


public class ExampleTest {
    private final Employee[] employees = {
            new Employee(1, "Jeff Bezos", 100000),
            new Employee(2, "Bill Gates", 200000),
            new Employee(3, "Mark Zuckerberg", 300000)
    };

    @Test
    public void GivenEmployeesWhenRaisesReceivedThenSalariesAsExpected() {
        Employee[] richerEmployees = Example.giveRaises(employees, 100);

        assertEquals(100100, richerEmployees[0].getSalary());
        assertEquals(200100, richerEmployees[1].getSalary());
        assertEquals(300100, richerEmployees[2].getSalary());
    }

    @Test
    public void GivenEmployeesWhenRaisesReceivedInParallelThenSalariesAsExpected() {
        Employee[] richerEmployees = Example.giveRaisesParallel(employees, 100);

        assertEquals(100100, richerEmployees[0].getSalary());
        assertEquals(200100, richerEmployees[1].getSalary());
        assertEquals(300100, richerEmployees[2].getSalary());
    }

    @Test
    public void GivenIdsWhenExistsThenObtained() {
        Integer[] ids = {1, 3};
        List<Optional<Employee>> employees = Example.findEmployees(ids);

        assertEquals(2, employees.size());
        assertEquals("Jeff Bezos", employees.get(0).get().getName());
        assertEquals("Mark Zuckerberg", employees.get(1).get().getName());
    }

    @Test
    public void GivenIdsAndSalaryWhenExistsGreaterThanThenObtained() {
        Integer[] ids = {1, 2, 3};
        List<Optional<Employee>> employees = Example.findEmployeesWithWagesGreaterThan(ids, 210000);

        assertEquals(1, employees.size());
        assertEquals("Mark Zuckerberg", employees.get(0).get().getName());
    }

    @Test
    public void GivenIdsAndSalaryWhenExistsGreaterThanThenObtainsFirst() {
        Integer[] ids = {1, 2, 3};
        Optional<Employee> employee = Example.findFirstEmployeeWithWageGreaterThan(ids, 190000);

        assertEquals("Bill Gates", employee.get().getName());
    }

    @Test
    public void GivenManyNamesWhenFlattenedThenReturnsNames() {
        String[][] allNames = {
                {"Bill", "Jim"},
                {"Dee"},
                {"Niall", "Conall", "Joe"}
        };

        List<String> names = Example.flattenAllNames(allNames);

        assertEquals(6, names.size());
    }

    @Test
    public void GivenParametersWhenGeneratedThenSequenceAsExpected() {
        List<Integer> expected = Arrays.asList(new Integer[]{5, 10, 15});

        List<Integer> actual = Example.getSequence(5, 5, 3);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void GivenEmployeesWhenMinSoughtThenMinReturned() {
        Employee min = Example.getMinEmployee(employees);

        assertEquals(1, min.getId());
    }

    @Test
    public void GivenEmployeesWhenHighestPaidSoughtThenMaxReturned() {
        Employee max = Example.getHighestPaidEmployee(employees);

        assertEquals(300000, max.getSalary());
    }

    @Test
    public void GivenEmployeesWhenLatestSoughtThenMaxReturned() {
        int latest = Example.getLatestEmployeeId(employees);

        assertEquals(3, latest);
    }

    @Test
    public void GivenNumbersWhenDuplicatedRemovedThenOutputIsUnique() {
        int[] numbers = { 1, 3, 5, 1, 7, 1, 3};
        int[] expected = {1, 3, 5, 7};

        int[] actual = Example.removeDuplicates(numbers);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void GivenEmployeesWhenAllEarnSalaryThenReturnsTrue() {
        boolean allAreEarning = Example.areAllEarning(employees, 5);

        assertTrue(allAreEarning);
    }

    @Test
    public void GivenEmployeesWhenSomeNamedNExistsThenReturnsTrue() {
        boolean hasBill = Example.checkForName(employees, "Bill");

        assertTrue(hasBill);
    }

    @Test
    public void GivenEmployeesWhenSalariesReducedThenMatchesSum() {
        int sum = Example.reduceSalaries(employees);

        assertEquals(600000, sum);
    }

    @Test
    public void GivenEmployeesWhenNamesPrintedThenMatchesJoin() {
        String printed = Example.printNames(employees);

        assertEquals("Jeff Bezos, Bill Gates, Mark Zuckerberg", printed);
    }

    @Test
    public void GivenEmployeesWhenPartitionedBySalaryThenSplitCorrectly() {
        Map<Boolean, List<Employee>> partitioned = Example.splitEmployeesBySalary(employees, 200000);

        assertEquals(2, partitioned.get(true).size());
        assertEquals(1, partitioned.get(false).size());
    }
}