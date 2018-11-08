package Controllers;

import GameObjects.EnemyFighterHybrid;
import GameObjects.EnemyFighterOnlyShoot;
import GameObjects.MovingObject;
import Map.Map;

public class HybridMovementController<E extends EnemyFighterHybrid> extends EnemyMovementController<E>{

    public HybridMovementController() {
        super();
        controlled = (E) new EnemyFighterHybrid();
        b = new FollowBehaviour(controlled, Map.getInstance().getFormation());
    }

    @Override
    public void setBehaviour(Behaviour be) {

    }

    @Override
    public void activate() {

    }
}
