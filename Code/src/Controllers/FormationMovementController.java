package Controllers;

import Map.Formation;

public class FormationMovementController extends EnemyMovementController{
    public FormationMovementController(Formation f) {
        controlled = f;
        b = new FormationBehaviour();
    }

    @Override
    public void setBehaviour(Behaviour be) {
    } //TODO: no debería estar en esta clase

    @Override
    public void activate() {
    }//TODO: no debería estar en esta clase
}
