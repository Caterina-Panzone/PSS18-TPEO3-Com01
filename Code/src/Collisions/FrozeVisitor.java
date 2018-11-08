package Collisions;

import Controllers.VisitableEnemyController;

public class FrozeVisitor extends PowerUpVisitor{


    public void visitEnemyController(VisitableEnemyController e) {
        e.Freeze();
    }

}
