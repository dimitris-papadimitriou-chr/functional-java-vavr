package starter;
//
//Functional Java with Vavr
//https://leanpub.com/functional-java-with-vavr
//
import java.util.function.*;
import java.util.Optional;
import static io.vavr.API.Try;

class Main {

  public static void main(String[] args) {

  var clientName = new ClientController()
  .getAssignedEmployeeNameById(1);
  
    
    System.out.println(clientName);
  }

}