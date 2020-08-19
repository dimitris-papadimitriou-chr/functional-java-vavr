package starter.extensions;

import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;
 

public class EitherExtensions2 {
    public static <R> Function<Throwable, Either<String, R>> throwableMessage() {
        return x -> Either.left(x.getMessage());
    }

    public static <L, T, T1> Function<Either<L, T>, Either<L, T1>> mapT(Function<T, T1> fn) {
        return $source -> $source.map(fn);
    }

    public static <L, T, T1> Function<Either<L, T>, CompletableFuture<Either<L, T1>>> bindT(Function<T, CompletableFuture<Either<L, T1>>> fn) {
        return $source -> $source.fold(
                error -> CompletableFuture.completedFuture(Either.left(error)),
                value -> fn.apply(value));
    }

    public static <T, L, T1> Function<Either<L, T>, T1> foldT(Function<? super L, ? extends T1> leftMapper, Function<? super T, ? extends T1> rightMapper) {
        return optional -> optional.fold(leftMapper, rightMapper);
    }
}
