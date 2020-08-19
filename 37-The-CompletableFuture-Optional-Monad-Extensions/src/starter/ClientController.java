package starter;

import java.util.concurrent.*;
import java.util.Optional;
import static starter.extensions.OptionalExtensions.*;

public class ClientController {

    MockClientRepository clientRepository = 
    new MockClientRepository();

    MockEmployeeRepository employeeRepository = 
    new MockEmployeeRepository();

    //refactored to minimize
    public CompletableFuture<Optional<String>> getAssignedEmployeeNameByIdAsync(int id)
            throws InterruptedException, ExecutionException {

        return clientRepository.getByIdAsync(id)
                .thenApplyAsync(mapT(Client::getEmployeeId))
                .thenComposeAsync(bindT(employeeRepository::getByIdAsync))
                .thenApplyAsync(mapT(Employee::getName));

    }
 
}

 
