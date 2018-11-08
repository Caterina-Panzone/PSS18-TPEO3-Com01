package Controllers;

import GameObjects.FollowerEnemy;
import GameObjects.LittlePonny;
import GameObjects.Player;

public class FollowerMovementController<E extends FollowerEnemy> extends EnemyMovementController<E> {

    public FollowerMovementController(LittlePonny pos) {
        super();
        controlled = (E) new FollowerEnemy();
        b = new FollowBehaviour(controlled, pos);
    }

    public void activate(){
        setBehaviour(new FollowBehaviour(controlled, Player.getInstance()));
    }

    public void setBehaviour(Behaviour be){
        b = be;
    }
}
