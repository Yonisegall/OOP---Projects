package assignment4;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'B';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {

        ArrayList<Move> possibleMoves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        int boardSize = board.getBoardSize();

        // Check diagonally in all four directions
        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            while (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                Piece piece = board.getPiece(new Position(newRow, newCol));
                if (piece == null) {
                    possibleMoves.add(new Move(getPosition(), new Position(newRow, newCol)));
                } else {
                    if (piece.getColor() != getColor()) {
                        possibleMoves.add(new Move(getPosition(), new Position(newRow, newCol)));
                    }
                    break;
                }

                newRow += direction[0];
                newCol += direction[1];
            }
        }

        return possibleMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        Bishop B = (Bishop) obj;
        return getPosition().equals(B.getPosition()) && getColor().equals(B.getColor());
    }
}
