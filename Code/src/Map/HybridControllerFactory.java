package Map;

import Controllers.EnemyMovementController;
import Controllers.HybridMovementController;
import GameObjects.LittlePonny;

public class HybridControllerFactory extends AbstractControllerFactory {
    public HybridControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(LittlePonny pos) {
        return new HybridMovementController();
    }
}
