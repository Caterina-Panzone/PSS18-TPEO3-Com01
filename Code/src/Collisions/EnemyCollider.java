package Collisions;


import GameObjects.Enemy;

public class EnemyCollider extends Collider {
    float da�o;

    public EnemyCollider(Enemy o) {
        super(o);
        da�o = o.getKamikazeDamage();
        v = new EnemyVisitor(da�o);
    }



    @Override
    public void accept(Visitor v) {
        v.visitEnemy(this);
    }


}
