package streams;

import java.util.Map;
import java.util.Optional;

public class EmployeeRepository {
    private final Map<Integer, Employee> EMPLOYEES = Map.of(
            1, new Employee(1, "Jeff Bezos", 100000),
            2, new Employee(2, "Bill Gates", 200000),
            3, new Employee(3, "Mark Zuckerberg", 300000)
    );

    public Optional<Employee> findById(Integer id) {
        return Optional.ofNullable(EMPLOYEES.get(id));
    }
}
