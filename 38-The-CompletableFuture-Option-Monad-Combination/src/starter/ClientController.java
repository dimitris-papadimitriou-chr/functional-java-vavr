package starter;

import io.vavr.control.Either;
import io.vavr.control.Option;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import java.util.Optional;
import static starter.extensions.OptionExtensions.*;

public class ClientController {

    MockClientRepository clientRepository = 
    new MockClientRepository();

    MockEmployeeRepository employeeRepository = 
    new MockEmployeeRepository();

    public CompletableFuture<Option<String>> getAssignedEmployeeNameByIdAsync(int id) {
            return clientRepository.getByIdAsync(id)
                .thenApplyAsync(mapT(Client::getEmployeeId))
                .thenComposeAsync(bindT(employeeRepository::getByIdAsync))
                .thenApplyAsync(mapT(Employee::getName));

    }
 
}

 
