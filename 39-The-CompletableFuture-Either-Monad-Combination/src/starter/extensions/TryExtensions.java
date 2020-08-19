package starter.extensions;

import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class TryExtensions {

    public static <T, T1> Function<Option<T>, Option<T1>> mapT(Function<T, T1> fn) {
        return optional -> optional.map(fn);
    }

    public static <T> Function<Option<T>, Try<T>> bindT(String defaultLeft) {
        return $source -> $source.toEither(defaultLeft).toTry();
    }

/*    public static <L, T> Function<Option<T>, Either<L, T>> toEither(L defaultLeft) {
        return $option -> $option.fold(
                () -> Either.left(defaultLeft),
                (v) -> Either.right(v)
        );
    }*/
}
