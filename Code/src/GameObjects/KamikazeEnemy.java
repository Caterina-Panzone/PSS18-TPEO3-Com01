package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.*;
import Map.Map;

public class KamikazeEnemy extends Enemy {

    public KamikazeEnemy(){

        health = 200;
        speed = 0.1f;
        ubication = posInicial;
        dir = Vector2.ORIGIN();
        kamikazeDamage = 150;
        sprite = SpriteDepot.ENEMY1;
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150;
        Map.getInstance().add(this);
    }

    public void update(Map map) {
        if (isAlive()) {

            updatePosition(map);
            super.update(map);
        } else {
            destroySelf();
            destroyMe(map);
        }
    }
}
