package Controllers;

import GameObjects.EnemyFighterHybrid;
import Map.Map;

public class HybridMovementEnemyMovementController<E extends EnemyFighterHybrid> extends EnemyMovementController<E> {

    private int health;

    public HybridMovementEnemyMovementController() {
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
