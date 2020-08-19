package starter;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Stream;


public class MockClientRepository   {

    private Client[] clients;

    public MockClientRepository() {
        this.clients = new Client[]{
                new Client(1, "jim",1),
                new Client(2, "john",1)};
    }

     public CompletableFuture<Optional<Client>> getByIdAsync(int id) {

        CompletableFuture<Optional<Client>> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(1000);
            var clientOptional = Stream.of(clients)
                    .filter(client -> id == client.getId())
                    .findAny();
            completableFuture.complete(clientOptional);
            return null;
        });

        return completableFuture;
    }
}

