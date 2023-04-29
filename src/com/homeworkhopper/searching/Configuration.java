package com.homeworkhopper.searching;

public interface Configuration<T extends Configuration<T>> {
    Iterable<T> getSuccessors();
}
