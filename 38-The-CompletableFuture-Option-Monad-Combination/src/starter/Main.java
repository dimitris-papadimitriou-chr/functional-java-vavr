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

 Try<Option<String>> tryOptionalName = Try.of(() -> controller.getAssignedEmployeeNameByIdAsync(1).get());


            {
                var employeeNameOrError =  tryOptionalName 
                        .fold(
                                error -> error.getMessage(),
                                optionalName -> optionalName.fold(
                                        () -> "no client found",
                                        name -> name
                                )
                        );
                System.out.println(employeeNameOrError);

            }

            {
                var employeeNameOrError = tryOptionalName
                        .flatMap(bindT("no client found"))
                        .fold(
                                error -> error.getMessage(),
                                name -> name
                        );

                System.out.println(employeeNameOrError);

            }
  }

}
