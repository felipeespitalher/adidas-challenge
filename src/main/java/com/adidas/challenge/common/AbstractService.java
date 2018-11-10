package com.adidas.challenge.common;

import com.adidas.challenge.data.output.SuccessOutput;
import com.adidas.challenge.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractService {

    public <T, R> List<R> toList(Iterable<T> iterable, Function<? super T, ? extends R> mapper) {
        return StreamSupport.stream(iterable.spliterator(), false).map(mapper)
                .collect(Collectors.toList());
    }

    public <T> SuccessOutput getNonNull(String type, Object id, Optional<T> value) {
        return new SuccessOutput(value.orElseThrow(() -> new NotFoundException(type, id)));
    }
}
