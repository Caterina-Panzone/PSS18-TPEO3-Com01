package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.*;
import Map.Map;

public class EnemyFighterOnlyShoot extends EnemyFighter {
    protected static float kamikazeDamage = 80;

    public EnemyFighterOnlyShoot(){


        health = 200;
        speed = 0.1f;
        time=0;
        ubication = posInicial;
        dir = Vector2.ORIGIN();
        damage = 5;
        sprite = SpriteDepot.ENEMY1;
        attackSpeed = fighterAttackSpeed;
        loaded = true;
        gunPosition = -7;
        gunPhaseShift = 40; //TODO actualizar valores al sprite nuevo
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150;
        new FighterFireController(this);
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




    public float getKamikazeDamage() {
        return kamikazeDamage;
    }


}
