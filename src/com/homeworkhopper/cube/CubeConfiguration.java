package com.homeworkhopper.cube;

import com.homeworkhopper.searching.Configuration;


import java.util.*;

import static com.homeworkhopper.cube.CubeConfiguration.Piece.Color.*;

public final class CubeConfiguration implements Configuration<CubeConfiguration> {

    public static final CubeConfiguration SOLVED_CUBE = new CubeConfiguration(new Piece[][][]{
            {
                    {new CornerPiece(WHITE, GREEN, RED), new EdgePiece(WHITE, GREEN), new CornerPiece(WHITE, ORANGE, GREEN)},
                    {new EdgePiece(WHITE, RED), new MiddlePiece(WHITE), new EdgePiece(WHITE, ORANGE)},
                    {new CornerPiece(WHITE, RED, BLUE), new EdgePiece(WHITE, BLUE), new CornerPiece(WHITE, BLUE, ORANGE)}
            },
            {
                    {new EdgePiece(GREEN, RED), new MiddlePiece(GREEN), new EdgePiece(ORANGE, GREEN)},
                    {new MiddlePiece(RED), null, new MiddlePiece(ORANGE)},
                    {new EdgePiece(RED, BLUE), new MiddlePiece(BLUE), new EdgePiece(BLUE, ORANGE)}
            },
            {
                    {new CornerPiece(YELLOW, GREEN, RED), new EdgePiece(YELLOW, GREEN), new CornerPiece(YELLOW, ORANGE, GREEN)},
                    {new EdgePiece(YELLOW, RED), new MiddlePiece(YELLOW), new EdgePiece(YELLOW, ORANGE)},
                    {new CornerPiece(YELLOW, RED, BLUE), new EdgePiece(YELLOW, BLUE), new CornerPiece(YELLOW, BLUE, ORANGE)}
            }
    }, null);

    private final Piece[][][] pieces;
    private final TurnMove lastMove;

    /* package-private */ CubeConfiguration(Piece[][][] pieces, TurnMove move) {
        this.pieces = pieces;
        this.lastMove = move;
    }

    private CubeConfiguration(CubeConfiguration cube, TurnMove move) {
        this(cube.pieces, move);
    }

    public Piece[][][] viewPieces() {
        final Piece[][][] piecesCopy = new Piece[3][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    piecesCopy[i][j][k] = this.pieces[i][j][k];
                }
            }
        }
        return piecesCopy;
    }

    /* package-private */ Piece[][][] getPieces() {
        return this.pieces;
    }

    public Optional<TurnMove> getLastMove() {
        return Optional.ofNullable(this.lastMove);
    }

    @Override
    public Iterable<CubeConfiguration> getSuccessors() {

        Set<CubeConfiguration> successors = new HashSet<>();

        for (FaceTurn faceTurn : FaceTurn.values()) {
            successors.add(faceTurn.apply(this));
        }

        return successors;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(this.pieces);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other instanceof CubeConfiguration otherCube) {
            return Arrays.deepEquals(this.pieces, otherCube.pieces);
        }

        return false;
    }

    public static class CubeBuilder {

        CubeConfiguration cube;

        public CubeBuilder() {
            this(SOLVED_CUBE.pieces);
        }

        public CubeBuilder(Piece[][][] pieces) {
            cube = new CubeConfiguration(pieces, null);
        }

        public CubeBuilder performTurn(TurnMove move) {
            cube = move.apply(cube);
            return this;
        }

        public CubeConfiguration build() {
            return new CubeConfiguration(cube, null);
        }
    }

    public sealed interface Piece permits MiddlePiece, EdgePiece, CornerPiece {
        enum Color {WHITE, BLUE, ORANGE, GREEN, RED, YELLOW}
    }

    private record MiddlePiece(Color color) implements Piece {
    }

    private record EdgePiece(Color a, Color b) implements Piece {
    }

    private record CornerPiece(Color a, Color b, Color c) implements Piece {
    }
}
