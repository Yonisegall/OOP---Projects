package assignment4;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    @Override
    public char getMarker() {
        return 'P';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        int boardSize = board.getBoardSize();
        int direction = getColor() == Constants.PieceColor.Black ? 1 : -1;

        // Check for forward move
        int newRow = row + direction;
        if (newRow >= 0 && newRow < boardSize) {
            Piece forwardPiece = board.getPiece(new Position(newRow, col));
            if (forwardPiece == null) {
                possibleMoves.add(new Move(getPosition(), new Position(newRow, col)));
            }
        }

        // Check for diagonal capture moves
        int[] captureCols = {col - 1, col + 1};
        for (int captureCol : captureCols) {
            if (captureCol >= 0 && captureCol < boardSize) {
                Piece capturePiece = board.getPiece(new Position(newRow, captureCol));
                if (capturePiece != null && capturePiece.getColor() != getColor()) {
                    possibleMoves.add(new Move(getPosition(), new Position(newRow, captureCol)));
                }
            }
        }

        return possibleMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        Pawn P = (Pawn) obj;
        return getPosition().equals(P.getPosition()) && getColor().equals(P.getColor());
    }
}
