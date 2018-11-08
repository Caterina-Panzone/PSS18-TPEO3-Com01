package Controllers;

import Controllers.Behaviour;
import Controllers.EnemyMovementController;
import GameObjects.GameObject;
import GameObjects.KamikazeEnemy;
import Map.Map;
import PowerUps.KamikazeShieldPU;

public class KamikazeMovementController<E extends KamikazeEnemy> extends EnemyMovementController<E> {

    public KamikazeMovementController(GameObject pos) {
        super();
        controlled = (E) new KamikazeEnemy();
        b = new FollowBehaviour(controlled, pos);
    }
}
