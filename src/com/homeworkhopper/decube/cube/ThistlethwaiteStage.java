package com.homeworkhopper.decube.cube;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public enum ThistlethwaiteStage implements Predicate<CubeConfiguration>, Function<CubeConfiguration, Iterable<CubeConfiguration>> {

    // G0=<L,R,F,B,U,D>
    G0 {
        @Override
        public Iterable<CubeConfiguration> apply(CubeConfiguration configuration) {
            return Set.of(
                    FaceTurn.LEFT_TURN.apply(configuration),
                    FaceTurn.RIGHT_TURN.apply(configuration),
                    FaceTurn.FRONT_TURN.apply(configuration),
                    FaceTurn.BACK_TURN.apply(configuration),
                    FaceTurn.UP_TURN.apply(configuration),
                    FaceTurn.DOWN_TURN.apply(configuration)
            );
        }

        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G1=<L,R,F,B,U2,D2>
    G1 {
        @Override
        public Iterable<CubeConfiguration> apply(CubeConfiguration configuration) {
            return Set.of(
                    FaceTurn.LEFT_TURN.apply(configuration),
                    FaceTurn.RIGHT_TURN.apply(configuration),
                    FaceTurn.FRONT_TURN.apply(configuration),
                    FaceTurn.BACK_TURN.apply(configuration),
                    FaceTurn.UP_TURN.andThen(FaceTurn.UP_TURN).apply(configuration),
                    FaceTurn.DOWN_TURN.andThen(FaceTurn.DOWN_TURN).apply(configuration)
            );
        }

        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G2=<L,R,F2,B2,U2,D2>
    G2 {
        @Override
        public Iterable<CubeConfiguration> apply(CubeConfiguration configuration) {
            return Set.of(
                    FaceTurn.LEFT_TURN.apply(configuration),
                    FaceTurn.RIGHT_TURN.apply(configuration),
                    FaceTurn.FRONT_TURN.andThen(FaceTurn.FRONT_TURN).apply(configuration),
                    FaceTurn.BACK_TURN.andThen(FaceTurn.BACK_TURN).apply(configuration),
                    FaceTurn.UP_TURN.andThen(FaceTurn.UP_TURN).apply(configuration),
                    FaceTurn.DOWN_TURN.andThen(FaceTurn.DOWN_TURN).apply(configuration)
            );
        }

        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G3=<L2,R2,F2,B2,U2,D2>
    G3 {
        @Override
        public Iterable<CubeConfiguration> apply(CubeConfiguration configuration) {
            return Set.of(
                    FaceTurn.LEFT_TURN.andThen(FaceTurn.LEFT_TURN).apply(configuration),
                    FaceTurn.RIGHT_TURN.andThen(FaceTurn.RIGHT_TURN).apply(configuration),
                    FaceTurn.FRONT_TURN.andThen(FaceTurn.FRONT_TURN).apply(configuration),
                    FaceTurn.BACK_TURN.andThen(FaceTurn.BACK_TURN).apply(configuration),
                    FaceTurn.UP_TURN.andThen(FaceTurn.UP_TURN).apply(configuration),
                    FaceTurn.DOWN_TURN.andThen(FaceTurn.DOWN_TURN).apply(configuration)
            );
        }

        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G4=I (solved)
    G4 {
        @Override
        public Iterable<CubeConfiguration> apply(CubeConfiguration configuration) {
            return Set.of(configuration);   // a solved cube should not be succeeded
        }

        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    };
}
