package Map;

import Controllers.EnemyMovementController;
import GameObjects.LittlePonny;

public abstract class AbstractControllerFactory {

    public abstract EnemyMovementController createController(LittlePonny pos);
}
