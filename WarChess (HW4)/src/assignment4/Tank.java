package assignment4;

import java.util.ArrayList;

public class Tank extends Piece {

    private int Cooldown = 0;

    public Tank(Position position, Constants.PieceColor color) {
        super(position, color);
    }

    public int getCooldown() {
        return Cooldown;
    }

    public void setCooldown(int cooldown) {
        Cooldown = cooldown;
    }

    @Override
    public char getMarker() {
        return 'T';
    }

    @Override
    public ArrayList<Move> getPossibleMoves(Board board) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        int boardSize = board.getBoardSize();

        // Define the possible directions for the tank's shot
        int[][] directions = {
                {-1, 0},   // Up
                {1, 0},    // Down
                {0, -1},   // Left
                {0, 1},    // Right
                {-1, -1},  // Up-Left
                {-1, 1},   // Up-Right
                {1, -1},   // Down-Left
                {1, 1}     // Down-Right
        };

        for (int[] direction : directions) {
            for (int i = 1; i <= 2; i++) {
                int newRow = row + (direction[0] * i);
                int newCol = col + (direction[1] * i);

                if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                    Piece piece = board.getPiece(new Position(newRow, newCol));
                    if (piece == null) {
                        possibleMoves.add(new Move(getPosition(), new Position(newRow, newCol)));
                    } else if (piece.getColor() != getColor()) {
                        break;  // Stop searching in this direction if an enemy piece is encountered
                    } else {
                        break;  // Stop searching in this direction if a piece of the same color is encountered
                    }
                } else {
                    break;  // Stop searching in this direction if the boundary of the board is reached
                }
            }
        }

        return possibleMoves;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass() || getCooldown() != ((Tank) obj).getCooldown())
            return false;

        Tank T = (Tank) obj;
        return getPosition().equals(T.getPosition()) && getColor().equals(T.getColor());
    }
}