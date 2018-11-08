package Map;

import Controllers.EnemyMovementController;
import Controllers.HybridMovementController;
import GameObjects.GameObject;

public class HybridControllerFactory extends AbstractControllerFactory {
    public HybridControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(GameObject pos) {
        return new HybridMovementController();
    }
}
