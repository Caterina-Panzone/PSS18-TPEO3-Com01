package Controllers;

import GameObjects.Enemy;
import GameObjects.EnemyFighterOnlyShoot;
import GameObjects.GameObject;
import GameObjects.MovingObject;
import Map.Map;

public class FighterMovementController<E extends EnemyFighterOnlyShoot> extends EnemyMovementController<E> {

    public FighterMovementController(GameObject pos) {
        super();
        controlled = (E) new EnemyFighterOnlyShoot();
        b = new FollowBehaviour(controlled, pos);
    }

    @Override
    public void setBehaviour(Behaviour be) {

    }

    @Override
    public void activate() {

    }
}
