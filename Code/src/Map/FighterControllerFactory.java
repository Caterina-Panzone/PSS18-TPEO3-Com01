package Map;

import Controllers.EnemyMovementController;
import Controllers.FighterMovementController;
import GameObjects.LittlePonny;

public class FighterControllerFactory extends AbstractControllerFactory {

    public FighterControllerFactory(){}

    @Override
    public EnemyMovementController createController(LittlePonny pos) {
        return new FighterMovementController(pos);
    }
}
