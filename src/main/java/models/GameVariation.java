package models;

public enum GameVariation {
    SixteenPawns, Week, Light, normal;

    @Override
    public String toString() {
        switch (this) {
            case normal:
                return "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
            case SixteenPawns:
                return "rnbqkbnr/pppppppp/8/8/1PP2PP1/1PP2PP1/PPPPPPPP/RNB1KBNR w KQkq - 0 1";
            case Week:
                return "nnnnknnn/pppppppp/2p2p2/1pppppp1/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
            case Light:
                return "nnnnknnn/pppppppp/8/8/8/8/PPPPPPPP/1Q1QK1Q1 w KQkq - 0 1";
        }
        return null;
    }
}
