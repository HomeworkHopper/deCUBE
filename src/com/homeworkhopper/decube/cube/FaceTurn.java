package com.homeworkhopper.decube.cube;

import static com.homeworkhopper.decube.cube.CubeConfiguration.*;

public enum FaceTurn implements TurnMove {
    /**
     * <p>
     * <img src="./doc-files/upTurn.png"></img>
     */
    UP_TURN {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][0][2] = pieces[0][0][0];
            result[0][0][1] = pieces[0][1][0];
            result[0][0][0] = pieces[0][2][0];

            result[0][1][2] = pieces[0][0][1];
            result[0][1][1] = pieces[0][1][1];  // center does not move
            result[0][1][0] = pieces[0][2][1];

            result[0][2][2] = pieces[0][0][2];
            result[0][2][1] = pieces[0][1][2];
            result[0][2][0] = pieces[0][2][2];

            for (int i = 1; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, UP_TURN);
        }

        @Override
        public TurnMove prime() {
            return UP_TURN_PRIME;
        }

        @Override
        public String describe() {
            return "U";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/upTurnPrime.png"></img>
     */
    UP_TURN_PRIME {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][2][0] = pieces[0][0][0];
            result[0][2][1] = pieces[0][1][0];
            result[0][2][2] = pieces[0][2][0];

            result[0][1][0] = pieces[0][0][1];
            result[0][1][1] = pieces[0][1][1];  // center does not move
            result[0][1][2] = pieces[0][2][1];

            result[0][0][0] = pieces[0][0][2];
            result[0][0][1] = pieces[0][1][2];
            result[0][0][2] = pieces[0][2][2];

            for (int i = 1; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, UP_TURN_PRIME);
        }

        @Override
        public TurnMove prime() {
            return UP_TURN;
        }

        @Override
        public String describe() {
            return "U'";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/downTurn.png"></img>
     */
    DOWN_TURN {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[2][2][0] = pieces[2][0][0];
            result[2][2][1] = pieces[2][1][0];
            result[2][2][2] = pieces[2][2][0];

            result[2][1][0] = pieces[2][0][1];
            result[2][1][1] = pieces[2][1][1];  // center does not move
            result[2][1][2] = pieces[2][2][1];

            result[2][0][0] = pieces[2][0][2];
            result[2][0][1] = pieces[2][1][2];
            result[2][0][2] = pieces[2][2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, DOWN_TURN);
        }

        @Override
        public TurnMove prime() {
            return DOWN_TURN_PRIME;
        }

        @Override
        public String describe() {
            return "D";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/downTurnPrime.png"></img>
     */
    DOWN_TURN_PRIME {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[2][0][2] = pieces[2][0][0];
            result[2][0][1] = pieces[2][1][0];
            result[2][0][0] = pieces[2][2][0];

            result[2][1][2] = pieces[2][0][1];
            result[2][1][1] = pieces[2][1][1];  // center does not move
            result[2][1][0] = pieces[2][2][1];

            result[2][2][2] = pieces[2][0][2];
            result[2][2][1] = pieces[2][1][2];
            result[2][2][0] = pieces[2][2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, DOWN_TURN_PRIME);
        }

        @Override
        public TurnMove prime() {
            return DOWN_TURN;
        }

        @Override
        public String describe() {
            return "D'";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/rightTurn.png"></img>
     */
    RIGHT_TURN {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][0][2] = pieces[0][2][2];
            result[0][1][2] = pieces[1][2][2];
            result[0][2][2] = pieces[2][2][2];

            result[1][0][2] = pieces[0][1][2];
            result[1][1][2] = pieces[1][1][2]; // center does not move
            result[1][2][2] = pieces[2][1][2];

            result[2][0][2] = pieces[0][0][2];
            result[2][1][2] = pieces[1][0][2];
            result[2][2][2] = pieces[2][0][2];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, RIGHT_TURN);
        }

        @Override
        public TurnMove prime() {
            return RIGHT_TURN_PRIME;
        }

        @Override
        public String describe() {
            return "R";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/rightTurnPrime.png"></img>
     */
    RIGHT_TURN_PRIME {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][0][2] = pieces[2][0][2];
            result[0][1][2] = pieces[1][0][2];
            result[0][2][2] = pieces[0][0][2];

            result[1][0][2] = pieces[2][1][2];
            result[1][1][2] = pieces[1][1][2]; // center does not move
            result[1][2][2] = pieces[0][1][2];

            result[2][0][2] = pieces[2][2][2];
            result[2][1][2] = pieces[1][2][2];
            result[2][2][2] = pieces[0][2][2];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 2; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, RIGHT_TURN_PRIME);
        }

        @Override
        public TurnMove prime() {
            return RIGHT_TURN;
        }

        @Override
        public String describe() {
            return "R'";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/leftTurn.png"></img>
     */
    LEFT_TURN {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][0][0] = pieces[2][0][0];
            result[0][1][0] = pieces[1][0][0];
            result[0][2][0] = pieces[0][0][0];

            result[1][0][0] = pieces[2][1][0];
            result[1][1][0] = pieces[1][1][0]; // center does not move
            result[1][2][0] = pieces[0][1][0];

            result[2][0][0] = pieces[2][2][0];
            result[2][1][0] = pieces[1][2][0];
            result[2][2][0] = pieces[0][2][0];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 1; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, LEFT_TURN);
        }

        @Override
        public TurnMove prime() {
            return LEFT_TURN_PRIME;
        }

        @Override
        public String describe() {
            return "L";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/leftTurnPrime.png"></img>
     */
    LEFT_TURN_PRIME {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][0][0] = pieces[0][2][0];
            result[0][1][0] = pieces[1][2][0];
            result[0][2][0] = pieces[2][2][0];

            result[1][0][0] = pieces[0][1][0];
            result[1][1][0] = pieces[1][1][0]; // center does not move
            result[1][2][0] = pieces[2][1][0];

            result[2][0][0] = pieces[0][0][0];
            result[2][1][0] = pieces[1][0][0];
            result[2][2][0] = pieces[2][0][0];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 1; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, LEFT_TURN_PRIME);
        }

        @Override
        public TurnMove prime() {
            return LEFT_TURN;
        }

        @Override
        public String describe() {
            return "L'";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/frontTurn.png"></img>
     */
    FRONT_TURN {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][2][0] = pieces[2][2][0];
            result[0][2][1] = pieces[1][2][0];
            result[0][2][2] = pieces[0][2][0];

            result[1][2][0] = pieces[2][2][1];
            result[1][2][1] = pieces[1][2][1];  // center does not move
            result[1][2][2] = pieces[0][2][1];

            result[2][2][0] = pieces[2][2][2];
            result[2][2][1] = pieces[1][2][2];
            result[2][2][2] = pieces[0][2][2];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, FRONT_TURN);
        }

        @Override
        public TurnMove prime() {
            return FRONT_TURN_PRIME;
        }

        @Override
        public String describe() {
            return "F";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/frontTurnPrime.png"></img>
     */
    FRONT_TURN_PRIME {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][2][0] = pieces[0][2][2];
            result[0][2][1] = pieces[1][2][2];
            result[0][2][2] = pieces[2][2][2];

            result[1][2][0] = pieces[0][2][1];
            result[1][2][1] = pieces[1][2][1];  // center does not move
            result[1][2][2] = pieces[2][2][1];

            result[2][2][0] = pieces[0][2][0];
            result[2][2][1] = pieces[1][2][0];
            result[2][2][2] = pieces[2][2][0];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, FRONT_TURN_PRIME);
        }

        @Override
        public TurnMove prime() {
            return FRONT_TURN;
        }

        @Override
        public String describe() {
            return "F'";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/backTurn.png"></img>
     */
    BACK_TURN {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][0][0] = pieces[0][0][2];
            result[0][0][1] = pieces[1][0][2];
            result[0][0][2] = pieces[2][0][2];

            result[1][0][0] = pieces[0][0][1];
            result[1][0][1] = pieces[1][0][1];  // center does not move
            result[1][0][2] = pieces[2][0][1];

            result[2][0][0] = pieces[0][0][0];
            result[2][0][1] = pieces[1][0][0];
            result[2][0][2] = pieces[2][0][0];

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, BACK_TURN);
        }

        @Override
        public TurnMove prime() {
            return BACK_TURN_PRIME;
        }

        @Override
        public String describe() {
            return "B";
        }
    },

    /**
     * <p>
     * <img src="./doc-files/backTurnPrime.png"></img>
     */
    BACK_TURN_PRIME {
        @Override
        public CubeConfiguration apply(CubeConfiguration cube) {
            final Piece[][][] pieces = cube.getPieces();
            final Piece[][][] result = new Piece[3][3][3];

            result[0][0][0] = pieces[2][0][0];
            result[0][0][1] = pieces[1][0][0];
            result[0][0][2] = pieces[0][0][0];

            result[1][0][0] = pieces[2][0][1];
            result[1][0][1] = pieces[1][0][1];  // center does not move
            result[1][0][2] = pieces[0][0][1];

            result[2][0][0] = pieces[2][0][2];
            result[2][0][1] = pieces[1][0][2];
            result[2][0][2] = pieces[0][0][2];

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        result[i][j][k] = pieces[i][j][k];
                    }
                }
            }

            return new CubeConfiguration(result, BACK_TURN_PRIME);
        }

        @Override
        public TurnMove prime() {
            return BACK_TURN;
        }

        @Override
        public String describe() {
            return "B'";
        }
    };
}
