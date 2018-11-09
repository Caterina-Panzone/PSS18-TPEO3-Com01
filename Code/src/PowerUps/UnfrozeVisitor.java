package PowerUps;

import Collisions.*;
import Controllers.VisitableEnemyController;

public class UnfrozeVisitor extends PowerUpVisitor {

    public UnfrozeVisitor(){
        super();
    }

    public void visitEnemyController(VisitableEnemyController e) {
        e.Unfreeze();
    }
}
