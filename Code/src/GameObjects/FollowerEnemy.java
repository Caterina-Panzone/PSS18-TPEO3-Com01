package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Map.Map;

public class FollowerEnemy extends Enemy {


    public FollowerEnemy(){

        health = 200;
        speed = 0.1f;
        ubication = new Vector2(200,200);
        dir = Vector2.ORIGIN();
        kamikazeDamage = 150;
        sprite = SpriteDepot.ENEMY1;
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150;
        lvl = Map.getInstance().getLevel();
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