package starter;
//
//Functional Java with Vavr
//https://leanpub.com/functional-java-with-vavr
//

import io.vavr.control.Either;

import java.util.concurrent.CompletableFuture;

import static io.vavr.API.Try;
import static starter.extensions.EitherExtensions2.throwableMessage;


class Main {

  public static void main(String[] args) { 

  var controller = new ClientController();
 
        {
            CompletableFuture<Either<String, String>> clientNameFuture =
              controller.getAssignedEmployeeNameByIdAsync(2);

            var clientNameOrError = Try(clientNameFuture::get)
                    .getOrElseGet(throwableMessage())
                    .fold(
                            error -> error,
                            clientName -> clientName
                    );
            System.out.println(clientNameOrError);
        }
  }

}