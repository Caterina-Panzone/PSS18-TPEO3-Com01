package Map;

import Controllers.EnemyMovementController;
import Controllers.HybridFollowerMovementController;
import GameObjects.GameObject;

public class HybridFollowerControllerFactory extends AbstractControllerFactory{

    public HybridFollowerControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(GameObject pos) {
        return new HybridFollowerMovementController(pos);
    }
}
