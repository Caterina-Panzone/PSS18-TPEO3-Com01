package Controllers;

import GameObjects.GameObject;
import GameObjects.KamikazeEnemy;

public class KamikazeMovementController<E extends KamikazeEnemy> extends EnemyMovementController<E> {

    public KamikazeMovementController(GameObject pos) {
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
