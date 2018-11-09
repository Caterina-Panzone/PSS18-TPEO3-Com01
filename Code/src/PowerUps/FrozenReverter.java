package PowerUps;

import Collisions.Visitor;
import Map.Map;

public class FrozenReverter implements Runnable {

    protected Visitor v;

    public FrozenReverter(){
        v = new UnfrozeVisitor();
    }

    @Override
    public void run() {
        Map.getInstance().getFormation().affect(v);
    }
}
