package nme.cs102.assignment5;

import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessComponent[][] board, ChessboardPoint point, ChessColor side) {
        super(board);
        setSource(point);
        setChessColor(side);
        name = side == ChessColor.BLACK? 'R' : 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pattern = new ArrayList<>();

        //上
        ChessboardPoint pos = getSource();

        while (true) {
            pos = pos.offset(0, 1);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        //下
        pos = getSource();

        while (true) {
            pos = pos.offset(0, -1);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        //左
        pos = getSource();

        while (true) {
            pos = pos.offset(-1, 0);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        //右
        pos = getSource();

        while (true) {
            pos = pos.offset(1, 0);
            if (!canMoveToBasic(pos)) {
                break;
            }
            pattern.add(pos);
            if (!(board[pos.getX()][pos.getY()] instanceof EmptySlotComponent)) {
                break;
            }
        }

        return pattern;
    }
}
