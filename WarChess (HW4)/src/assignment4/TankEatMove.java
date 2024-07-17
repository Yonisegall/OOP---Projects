package assignment4;

public class TankEatMove extends Move {

    public TankEatMove(Position startPos, Position endPos) {
        super(startPos, endPos);
    }

    @Override
    public void updateBoard(Board board) {
        Piece p = board.getUnderlyingMatrix()[StartPos.getRow()][StartPos.getCol()];
        if (p.getMarker() == 'T'){
            Tank t = (Tank) p;
            t.setCooldown(2);
            board.removePiece(EndPos);
        }

    }
}
