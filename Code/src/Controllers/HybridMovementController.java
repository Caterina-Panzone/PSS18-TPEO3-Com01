package Controllers;

import GameObjects.EnemyFighterHybrid;
import GameObjects.EnemyFighterOnlyShoot;
import GameObjects.MovingObject;
import GameObjects.Player;
import Map.Map;

public class HybridMovementController<E extends EnemyFighterHybrid> extends EnemyMovementController<E>{

    private int health;

    public HybridMovementController() {
        super();
        controlled = (E) new EnemyFighterHybrid();
        health = controlled.getHealth();
        b = new FollowBehaviour(controlled, Map.getInstance().getFormation());
    }

    @Override
    public void setBehaviour(Behaviour be) {
        b = be;
    }

    @Override
    public void activate() {
    }

    @Override
    public void update(Map map) {

        if(controlled.getHealth()<=health*0.2)
            b = new DizzyBehaviour();
        super.update(map);
    }
}
