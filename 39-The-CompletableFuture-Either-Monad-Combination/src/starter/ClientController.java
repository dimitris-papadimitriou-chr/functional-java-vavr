package starter;

import io.vavr.control.Either;

import java.util.concurrent.CompletableFuture;

import static starter.extensions.EitherExtensions2.bindT;
import static starter.extensions.EitherExtensions2.mapT;

public class ClientController {

    MockClientRepository clientRepository = 
    new MockClientRepository();

    MockEmployeeRepository employeeRepository = 
    new MockEmployeeRepository();


    public CompletableFuture<Either<String, String>> getAssignedEmployeeNameByIdAsync(int id) {
        return clientRepository.getByIdAsync(id)
                .thenApplyAsync(mapT(Client::getEmployeeId))
                .thenComposeAsync(bindT(employeeRepository::getByIdAsync))
                .thenApplyAsync(mapT(Employee::getName));

    }
 
}

 
