package starter;

import io.vavr.control.Option;
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

 public CompletableFuture<Option<Employee>> getByIdAsync(int id) {

        var t = Stream.of(employees)
                .filter(employee -> id == employee.getId())
                .findAny();

        CompletableFuture<Option<Employee>> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(5000);
            completableFuture.complete(Option.ofOptional(t));
            return null;
        });

        return completableFuture;
    }
}
