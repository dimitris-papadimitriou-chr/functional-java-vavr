package starter.extensions;

import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TryExtensions {

    public static <T, T1> Function<Option<T>, Option<T1>> mapT(Function<T, T1> fn) {
        return option -> option.map(fn);
    }

    public static <T> Function<Option<T>, Try<T>> bindT(String defaultLeft) {
        return option -> option.toEither(defaultLeft).toTry();
    }

}
