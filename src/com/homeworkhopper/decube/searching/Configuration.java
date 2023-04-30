package com.homeworkhopper.decube.searching;

public interface Configuration<T extends Configuration<T>> {
    Iterable<T> getSuccessors();
}
