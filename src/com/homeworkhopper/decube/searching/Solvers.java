package com.homeworkhopper.decube.searching;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public final class Solvers {

    private Solvers() {}

    public static <T> SearchResult<T> breadthFirst(T start, Function<T, Iterable<T>> successors, Predicate<T> solution) {

        Queue<T> nodes = new ArrayDeque<>();
        HashMap<T, T> backpointers = new HashMap<>();

        nodes.add(start);
        backpointers.put(start, null);

        while (!nodes.isEmpty()) {

            T current = nodes.remove();

            if (solution.test(current)) {
                Deque<T> path = new ArrayDeque<>();

                while (current != null) {
                    path.addFirst(current);
                    current = backpointers.get(current);
                }

                return new SearchResult<>(start, Optional.of(path.getLast()), Optional.of(path));
            }

            for (T successor : successors.apply(current)) {
                if (!backpointers.containsKey(successor)) {
                    nodes.add(successor);
                    backpointers.put(successor, current);
                }
            }
        }
        return new SearchResult<>(start, Optional.empty(), Optional.empty());
    }
}
