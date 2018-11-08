package Map;

import Controllers.EnemyMovementController;
import Controllers.FollowerMovementController;
import GameObjects.GameObject;

public class FollowerControllerFactory extends AbstractControllerFactory {

    public FollowerControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(GameObject pos) {
        return new FollowerMovementController(pos);
    }
}
