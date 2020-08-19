package starter;
//
//Functional Java with Vavr
//https://leanpub.com/functional-java-with-vavr
//

import io.vavr.control.Try;

import java.util.Optional;

class Main {

  public static void main(String[] args) { 

  var controller = new ClientController();

Try<Optional<String>> tryOptionalClientName = 
Try.of(()-> controller.getAssignedEmployeeNameByIdAsync(2).get());

var clientNameOrError = tryOptionalClientName
                    .getOrElseGet(e -> Optional.of(e.getMessage()))
                    .orElse("no client found");

 
    System.out.println(clientNameOrError);
  }

}