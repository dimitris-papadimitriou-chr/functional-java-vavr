package starter;

import java.util.concurrent.CompletableFuture;

public class ClientController {

    MockClientRepository clientRepository = new MockClientRepository();
    MockEmployeeRepository employeeRepository = new MockEmployeeRepository();
 
public String getAssignedEmployeeNameById1(int clientId) {  
  //warning : long method names is a bad code smell
      return clientRepository
            .getById(clientId)
            .flatMap(client->employeeRepository.getById(client.getEmployeeId()))
            .map(employee->employee.getName())
            .orElse("no client found");
      }


//Or if we use our various techniques to get the following more compact 

            public String getAssignedEmployeeNameById(int clientId) {  //warning : long method names is a bad code smell
        return clientRepository
                .getById(clientId)
                .map(Client::getId)//using method references
                .flatMap(employeeRepository::getById)
                .map(Employee::getName)
                .orElse("no client found");
      }

  }

 
