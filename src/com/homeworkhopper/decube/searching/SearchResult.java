package com.homeworkhopper.decube.searching;

import java.util.*;
import java.util.function.Function;

public record SearchResult<T>(T start, Optional<T> goal, Optional<Iterable<T>> path) {

    private Optional<Iterable<T>> joinPath(Iterable<T> otherPath) {
        return this.path.map(thisPath -> {
            final List<T> joined = new ArrayList<>();
            thisPath.forEach(joined::add);
            otherPath.forEach(joined::add);
            return joined;
        });
    }

    public SearchResult<T> join(Function<T, SearchResult<T>> next) {
        final Optional<SearchResult<T>> nextResult = goal.map(next);
        return new SearchResult<>(start, nextResult.flatMap(SearchResult::goal),
                nextResult.flatMap(SearchResult::path).flatMap(this::joinPath));
    }
}
