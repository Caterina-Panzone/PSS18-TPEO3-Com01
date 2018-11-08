package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Map.Map;

public class EnemyFighterHybrid extends EnemyFighter{

    protected int enemyHealth;

    public EnemyFighterHybrid(){
        enemyHealth = 200;
        health = enemyHealth;
        Speed = 0.1f;
        speed = Speed;
        time=0;
        ubication = posInicial;
        dir = Vector2.ORIGIN();
        damage = 0;
        kamikazeDamage = 80;
        sprite = SpriteDepot.ENEMY1;
        attackSpeed = fighterAttackSpeed;
        loaded = true;
        gunPosition = -7;
        gunPhaseShift = 40; //TODO actualizar valores al sprite nuevo
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
