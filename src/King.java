public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((line >= 0 && line <=7) && (column >= 0 && column <=7) && (toLine >= 0 && toLine <=7) && (toColumn >= 0 && toColumn <=7)) {
            if (toLine == line && toColumn == column) return false;
            return ((Math.abs(line - toLine) == 1 && column == toColumn) || (line == toLine && Math.abs(column - toColumn) == 1) ||
                    (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1));
        } return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}
