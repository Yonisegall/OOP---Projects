package assignment4;
import java.util.ArrayList;

public class Board {

    private Piece[][] matrix;
    private ArrayList<Piece> pieces;

    public Piece[][] getUnderlyingMatrix(){
        return matrix;
    }

    public Board() {
        matrix = new Piece[7][7];
        pieces = new ArrayList<>();
    }

    public Board(int size) {
        matrix = new Piece[size][size];
        pieces = new ArrayList<>();
    }

    public Board(Piece[][] board) {

        int Size = board.length;
        matrix = new Piece[Size][Size];
        pieces = new ArrayList<>();

        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                Piece piece = board[i][j];
                if (piece != null) {
                    matrix[i][j] = piece;
                    pieces.add(piece);
                }
            }
        }
    }

    public ArrayList<Piece> getPieces(Constants.PieceColor color) {
        ArrayList<Piece> result = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.getColor() == color) {
                result.add(piece);
            }
        }
        return result;
    }

    public Piece getPiece(Position position) {
        int Size = matrix.length;

        if (position.getRow() < 0 || position.getRow() >= Size || position.getCol() < 0 || position.getCol() >= Size)
            return null;

        return matrix[position.getRow()][position.getCol()];
    }

    public void addPiece(Piece piece) {
        Position position = piece.getPosition();
        matrix[position.getRow()][position.getCol()] = piece;
        pieces.add(piece);
    }

    public void removePiece(Position position) {
        Piece piece = matrix[position.getRow()][position.getCol()];
        if (piece != null) {
            matrix[position.getRow()][position.getCol()] = null;
            pieces.remove(piece);
        }
    }

    public void updatePosition(Position oldPos, Position newPos) {
        Piece piece = matrix[oldPos.getRow()][oldPos.getCol()];
        if (piece != null) {
            Piece p = matrix[newPos.getRow()][newPos.getCol()];
            matrix[oldPos.getRow()][oldPos.getCol()] = null;
            matrix[newPos.getRow()][newPos.getCol()] = piece;
            piece.setPosition(newPos);
        }
    }

    public int getPieceCount(Constants.PieceColor pieceColor) {
        int count = 0;
        for (Piece piece : pieces) {
            if (piece.getColor() == pieceColor) {
                count++;
            }
        }
        return count;
    }

    public boolean verifyPromotion(Piece piece) {

        int Size = matrix.length;
        Position position = piece.getPosition();
        int row = position.getRow();
        Constants.PieceColor color = piece.getColor();

        if (piece instanceof Pawn) {
            if (color == Constants.PieceColor.Black && row == Size - 1)
                return true;

            if (color == Constants.PieceColor.White && row == 0)
                return true;
        }

        return false;
    }

    public void promote(Piece piece) {

        if ((!(piece instanceof Pawn)) || !(verifyPromotion(piece)))
            throw new IllegalArgumentException();

        else{
            Tank promotedPiece = new Tank(piece.getPosition(), piece.getColor());
            removePiece(piece.getPosition());
            addPiece(promotedPiece);
        }
    }

    public int getBoardSize() {
        return matrix.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass() || getBoardSize() != ((Board) obj).getBoardSize())
            return false;

        Board Other = (Board) obj;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Piece piece = matrix[i][j];
                Piece otherPiece = Other.matrix[i][j];
                if ((piece == null && otherPiece != null) || (piece != null && !piece.equals(otherPiece))) {
                    return false;
                }
            }
        }
        return true;
    }
}