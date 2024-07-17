package assignment4;
import java.util.ArrayList;

public abstract class Piece {

    private Position piecePosition;
    private Constants.PieceColor pieceColor;

    public Piece(Position position, Constants.PieceColor color){
        piecePosition = position;
        pieceColor = color;
    }

    public abstract char getMarker();

    public abstract ArrayList<Move> getPossibleMoves(Board board);

    public abstract boolean equals(Object obj);


    public void setPosition(Position position){
        piecePosition = position;
    }
    public Constants.PieceColor getColor(){
        return pieceColor;
    }

    public Position getPosition(){
        return piecePosition;
    }

    @Override
    public String toString() {
        char marker = getMarker();
        int row = piecePosition.getRow();
        int col = piecePosition.getCol();
        char color = pieceColor.toString().charAt(0);

        return ""+marker+"("+row+","+col+")"+color+"";
    }
}
