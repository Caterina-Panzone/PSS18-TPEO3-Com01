package Controllers;

import GameObjects.LittlePonny;
import GameObjects.HybridFollowerEnemy;
import GameObjects.Player;
import Map.Map;

public class HybridFollowerMovementController<E extends HybridFollowerEnemy> extends EnemyMovementController<E> {

    private int health;

    public HybridFollowerMovementController(LittlePonny pos) {
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
        if((controlled.getHealth()/2)<=health){
            b = new DizzyBehaviour();
        }
        super.update(map);
    }


}
