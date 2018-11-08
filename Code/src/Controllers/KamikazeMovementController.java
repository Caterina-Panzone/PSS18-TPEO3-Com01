package Controllers;

import GameObjects.LittlePonny;
import GameObjects.KamikazeEnemy;

public class KamikazeMovementController<E extends KamikazeEnemy> extends EnemyMovementController<E> {

    public KamikazeMovementController(LittlePonny pos) {
        super();
        controlled = (E) new KamikazeEnemy();
        b = new FollowBehaviour(controlled,pos);
    }

    public void activate(){
        setBehaviour(new DizzyBehaviour());
    }

    public void setBehaviour(Behaviour be){
        b = be;
    }
}
