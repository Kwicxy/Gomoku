package core;


import java.util.ArrayList;

public class ChessBoard {
    /* 棋盘类 */
    private ArrayList<Chess> board = new ArrayList<>();
    private int BOARD_SIZE = 15;

    public ChessBoard(int size) {
        this.BOARD_SIZE = size;
    }

    public void resetBoard() {
        /* 重置棋盘 */
        board.clear();
    }

    public void addChess(char color, int x, int y) {
        /* 添加棋子 */
        board.add(new Chess(color, x, y));
    }

    public void removeChess(char color, int x, int y) {
        /* 移除棋子 */
        board.remove(new Chess(color, x, y));
    }

    public void removeLast() {
        /* 悔棋 */
        board.remove(board.size()-1);
    }

    public String toString() {
        /* 输出棋盘状态 */
        StringBuilder sb = new StringBuilder();
        board.forEach(item -> {
            sb.append("{ Color: ").append(item.color)
                    .append(", Pos: (").append(item.x).append(", ").append(item.y).append(") }\n");
        });
        return sb.toString();
    }

    public static void main(String[] args) {
        /* 测试棋盘类 */
        ChessBoard chessBoard = new ChessBoard(15);
        chessBoard.addChess('B', 7, 7);
        chessBoard.addChess('W', 7, 8);
        System.out.println(chessBoard.toString());
        chessBoard.removeLast();
        System.out.println(chessBoard.toString());
        chessBoard.resetBoard();
    }
}
