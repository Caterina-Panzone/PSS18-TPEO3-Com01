package Controllers;

import GameObjects.GameObject;
import GameObjects.HybridFollowerEnemy;
import GameObjects.Player;
import Map.Map;

public class HybridFollowerMovementController<E extends HybridFollowerEnemy> extends EnemyMovementController<E> {

    private int health;

    public HybridFollowerMovementController(GameObject pos) {
        super();
        controlled = (E) new HybridFollowerEnemy();
        health = controlled.getHealth();
        b = new FollowBehaviour(controlled, pos);
    }

    public void activate(){
        setBehaviour(new FollowBehaviour(controlled, Player.getInstance()));
    }

    public void setBehaviour(Behaviour be){
        b = be;
    }

    @Override
    public void update(Map map)
    {
        if(controlled.getHealth()<=health/2){
            b = new DizzyBehaviour();
        }
        super.update(map);
    }


}
