package assignment4;

import java.util.ArrayList;

public class King extends Piece {

    public King(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'K';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        int boardSize = board.getBoardSize();

        // Check all eight directions
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0 , -1},          { 0, 1},
                {1 , -1}, { 1, 0}, { 1, 1}
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

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

        King K = (King) obj;
        return getPosition().equals(K.getPosition()) && getColor().equals(K.getColor());
    }
}
