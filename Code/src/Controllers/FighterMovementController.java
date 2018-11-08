package Controllers;

import GameObjects.EnemyFighterOnlyShoot;
import GameObjects.LittlePonny;

public class FighterMovementController<E extends EnemyFighterOnlyShoot> extends EnemyMovementController<E> {

    public FighterMovementController(LittlePonny pos) {
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
