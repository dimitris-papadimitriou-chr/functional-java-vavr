package starter;

import java.util.Optional;
 import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class MockEmployeeRepository {

    private Employee[] employees;

    public MockEmployeeRepository() {
        this.employees = new Employee[]{
                new Employee(1, "jane"),
                new Employee(2, "liam")};
    }

    public Optional<Employee> getById(int id) {
        return Stream.of(employees)
                .filter(employee -> id == employee.getId())
                .findAny();
    }
}
