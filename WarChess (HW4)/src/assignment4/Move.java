package assignment4;

public class Move {

    protected Position StartPos;
    protected Position EndPos;

    public Move(Position startPos, Position endPos){
        StartPos = startPos;
        EndPos = endPos;
    }

    public Position getStartPos(){
        return StartPos;
    }

    public Position getEndPos(){
        return EndPos;
    }

    public void updateBoard(Board board) {
        Piece piece = board.getPiece(StartPos);
        if (piece != null) {
            board.removePiece(StartPos);
            board.removePiece(EndPos);
            piece.setPosition(EndPos);
            board.addPiece(piece);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        Move other = (Move) obj;
        return StartPos.equals(other.StartPos) && EndPos.equals(other.EndPos);
    }
}
