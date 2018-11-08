package Map;

import Controllers.EnemyMovementController;
import Controllers.KamikazeMovementController;
import GameObjects.LittlePonny;

public class KamikazeControllerFactory extends AbstractControllerFactory {
    public KamikazeControllerFactory() {
    }

    @Override
    public EnemyMovementController createController(LittlePonny pos) {
        return new KamikazeMovementController(pos);
    }
}
