package PowerUps;

import Assets.SpriteDepot;
import Collisions.PowerUpCollider;
import Controllers.*;
import GameObjects.Player;
import GameObjects.Vector2;
import Map.Map;

public class ShieldPU extends AbstractPU {
    int power;

    public ShieldPU(Vector2 dir){
        ubication = dir;
        controller = new PowerUpMovementController(this, new PowerUpBehaviour());
        c = new PowerUpCollider(this);
        health = 1;
        sprite = SpriteDepot.SHIELD;
        speed = 1;
        power = 50;
        Map.getInstance().add(this);
    }

    @Override
    public void trigger() {
        Player.getInstance().getShield().add(power);

    }

    @Override
    public void update(Map map) {
        if(health == 1){
            updatePosition(map);
            super.update(map);
        }
        else
            destroySelf();
    }

    @Override
    public void destroySelf() {

        super.destroySelf();
    }
}
