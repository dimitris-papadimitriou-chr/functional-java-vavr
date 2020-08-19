package starter.extensions;

import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;
 

public class OptionalExtensions {
    public static <T, T1> Function<Optional<T>, Optional<T1>> mapT(Function<T, T1> fn) {
        return optional -> optional.map(fn);
    }

    public static <T> Function<Optional<T>, T> orElseT(T defaultOptional) {
        return optional -> optional.orElse(defaultOptional);
    }

/*    public static <T, T1> Function<Option<T>, T1> bindT(Supplier<? extends T1> ifNone, Function<? super T, ? extends T1> f) {
        return optional -> optional.fold(ifNone, f);
    }*/

    public static <L, T, T1> Function<Optional<T>, CompletableFuture<Optional<T1>>> bindT(Function<T, CompletableFuture<Optional<T1>>> fn)
            throws InterruptedException, ExecutionException {
        return $source -> $source
                .map(x->fn.apply(x))
                .orElse(CompletableFuture.completedFuture(Optional.empty()));
    }
}
 
