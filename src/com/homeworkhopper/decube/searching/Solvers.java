package com.homeworkhopper.decube.searching;

import java.util.*;
import java.util.function.Predicate;

public final class Solvers {

    private Solvers() {}

    public static <T extends Configuration<T>> Optional<Iterable<T>> breadthFirst(T start, Predicate<T> solution) {

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

                return Optional.of(path);
            }

            for (T successor : current.getSuccessors()) {
                if (!backpointers.containsKey(successor)) {
                    nodes.add(successor);
                    backpointers.put(successor, current);
                }
            }
        }
        return Optional.empty();
    }
}
