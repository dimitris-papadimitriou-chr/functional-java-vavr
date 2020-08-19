package starter;

public class ClientController {

    MockClientRepository clientRepository = 
    new MockClientRepository();

    MockEmployeeRepository employeeRepository = 
    new MockEmployeeRepository();
 
      public String getAssignedEmployeeNameById(int clientId) {
        return clientRepository
                .getById(clientId)
                .map(Client::getEmployeeId)
                .flatMap(employeeRepository::getById)
                .map(Employee::getName)
                .fold(
                        (error) -> "error : "+error,
                        (name) -> name
                );

  }
}

 
