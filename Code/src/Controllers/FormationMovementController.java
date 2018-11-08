package Controllers;

import Map.Formation;

public class FormationMovementController extends EnemyMovementController{
    public FormationMovementController(Formation f) {
        controlled = f;
        b = new FormationBehaviour();
    }
}
