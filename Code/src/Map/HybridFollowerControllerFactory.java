package Map;

import Controllers.EnemyMovementController;
import Controllers.HybridFollowerMovementController;
import Controllers.KamikazeMovementController;
import GameObjects.LittlePonny;

public class HybridFollowerControllerFactory extends AbstractControllerFactory{

    public HybridFollowerControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(LittlePonny pos) {
        return new HybridFollowerMovementController(pos);
    }
}
