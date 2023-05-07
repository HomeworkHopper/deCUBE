package com.homeworkhopper.decube.cube;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public enum ThistlethwaiteStage implements Predicate<CubeConfiguration>, Function<CubeConfiguration, Iterable<CubeConfiguration>> {

    // G0=<L,R,F,B,U,D>
    G0(FaceTurn.LEFT_TURN, FaceTurn.RIGHT_TURN, FaceTurn.FRONT_TURN, FaceTurn.BACK_TURN, FaceTurn.UP_TURN, FaceTurn.DOWN_TURN) {
        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G1=<L,R,F,B,U2,D2>
    G1() {
        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G2=<L,R,F2,B2,U2,D2>
    G2 {
        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G3=<L2,R2,F2,B2,U2,D2>
    G3 {
        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    },

    // G4=I (solved)
    G4 {
        @Override
        public boolean test(CubeConfiguration configuration) {
            return false;
        }
    };

    private final Set<TurnMove> moves;

    ThistlethwaiteStage(TurnMove... moves) {
        this.moves = Set.of(moves);
    }

    @Override
    public Iterable<CubeConfiguration> apply(CubeConfiguration configuration) {
        final List<CubeConfiguration> configurations = new ArrayList<>(moves.size());

        for (TurnMove move : moves) {
            configurations.add(move.apply(configuration));
        }

        return configurations;
    }
}
