package starter.extensions;

import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.Optional;
import java.util.concurrent.*;

import java.util.function.Function;
import java.util.function.Supplier;
 

public class OptionExtensions {
public static <T, T1> Function<Option<T>, Option<T1>> mapT(Function<T, T1> fn) {
        return option -> option.map(fn);
}

public static <T, T1> Function<Option<T>, CompletableFuture<Option<T1>>> bindT(Function<T, CompletableFuture<Option<T1>>> fn) 
{
    return option -> option.fold(
            () -> CompletableFuture.completedFuture(Option.none()),
            (x) -> fn.apply(x)
    );
}

    
}



 
