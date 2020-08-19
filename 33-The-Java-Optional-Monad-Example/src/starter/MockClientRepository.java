package starter;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import java.util.concurrent.*;


public class MockClientRepository   {

    private Client[] clients;

    public MockClientRepository() {
        this.clients = new Client[]{
                new Client(1, "jim",1),
                new Client(2, "john",1)};
    }

    public Optional<Client> getById(int id) {
        return Stream.of(clients)
                .filter(client -> id == client.getId())
                .findAny();
    }
}

