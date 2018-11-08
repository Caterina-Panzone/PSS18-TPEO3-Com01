package Collisions;

public class PlayerBulletVisitor extends Visitor {

    float d;

    public PlayerBulletVisitor(float d){
        this.d = d;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {
            e.getO().damage(d);

    }



    @Override
    public void visitEnemyBarricade(EnemyBarricadeCollider b) {
        b.getO().damage(d);
    }

    @Override
    public void visitBarricade(BarricadeCollider b) {
        b.getO().damage(d);
    }

    @Override
    public void visitPowerUp(PowerUpCollider b) {
        b.getO().damage(d);
    }


}
