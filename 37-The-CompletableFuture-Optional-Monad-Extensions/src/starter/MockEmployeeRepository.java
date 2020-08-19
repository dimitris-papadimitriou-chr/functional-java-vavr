package starter;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class MockEmployeeRepository {

    private Employee[] employees;

    public MockEmployeeRepository() {
        this.employees = new Employee[]{
                new Employee(1, "jane"),
                new Employee(2, "liam")};
    }

 public CompletableFuture<Optional<Employee>> getByIdAsync(int id) {

        CompletableFuture<Optional<Employee>> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(1000);
            var employeeOptional = Stream.of(employees)
                    .filter(employee -> id == employee.getId())
                    .findAny();
            completableFuture.complete(employeeOptional);
            return null;
        });

        return completableFuture;
    }
}
