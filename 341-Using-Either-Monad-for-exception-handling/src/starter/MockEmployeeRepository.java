package starter;

import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.stream.Stream;

public class MockEmployeeRepository {

    private Employee[] employees;

    public MockEmployeeRepository() {
        this.employees = new Employee[]{
                new Employee(1, "jane"),
                new Employee(2, "liam")};
    }

    public Either<String, Employee> getById(int id) {
        return Option.ofOptional(Stream.of(employees)
                .filter(client -> id == client.getId())
                .findAny()) .toEither("No Employee Found");
    }
}
