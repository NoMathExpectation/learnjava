package nme.cs102.assignment5;

import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint point) {
        super(null);
        setSource(point);
        setChessColor(ChessColor.NONE);
        name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
