package com.homeworkhopper.cube;

import java.util.function.Function;

public interface TurnMove extends Function<CubeConfiguration, CubeConfiguration> {

    @Override
    CubeConfiguration apply(CubeConfiguration cube);

    TurnMove prime();

    String describe();
}