package Map;

import Controllers.EnemyMovementController;
import Controllers.FollowerMovementController;
import Controllers.KamikazeMovementController;
import GameObjects.LittlePonny;

public class FollowerControllerFactory extends AbstractControllerFactory {

    public FollowerControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(LittlePonny pos) {
        return new FollowerMovementController(pos);
    }
}
