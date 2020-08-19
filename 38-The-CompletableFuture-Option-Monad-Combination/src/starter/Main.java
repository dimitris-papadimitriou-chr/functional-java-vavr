package starter;
//
//Functional Java with Vavr
//https://leanpub.com/functional-java-with-vavr
//

import io.vavr.control.Option;
import io.vavr.control.Try;

import static starter.extensions.TryExtensions.bindT;


class Main {

  public static void main(String[] args) { 

  var controller = new ClientController();

 Try<Option<String>> tryOptionalClientName = Try.of(() -> controller.getAssignedEmployeeNameByIdAsync(1).get());


            {
                var clientNameOrError = tryOptionalClientName
                        .fold(
                                error -> error.getMessage(),
                                optionalClientName -> optionalClientName.fold(
                                        () -> "no client found",
                                        clientName -> clientName
                                )
                        );
                System.out.println(clientNameOrError);

            }

            {
                var clientNameOrError = tryOptionalClientName
                        .flatMap(bindT("no client found"))
                        .fold(
                                error -> error.getMessage(),
                                clientName -> clientName
                        );

                System.out.println(clientNameOrError);

            }
  }

}