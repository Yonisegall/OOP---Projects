package assignment4;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'N';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        int boardSize = board.getBoardSize();

        // Define the possible offsets for knight's moves
        int[][] offsets = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2 }, {1, 2 },
                {2, -1 }, {2, 1 }
        };

        for (int[] offset : offsets) {
            int newRow = row + offset[0];
            int newCol = col + offset[1];

            if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                Piece piece = board.getPiece(new Position(newRow, newCol));
                if (piece == null || piece.getColor() != getColor()) {
                    possibleMoves.add(new Move(getPosition(), new Position(newRow, newCol)));
                }
            }
        }

        return possibleMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        Knight N = (Knight) obj;
        return getPosition().equals(N.getPosition()) && getColor().equals(N.getColor());
    }
}
