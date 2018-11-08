package Collisions;

import PowerUps.KamikazeShieldPU;

public class KamikazeShieldVisitor extends PlayerVisitor {

    public KamikazeShieldVisitor(){};

    @Override
    public void visitEnemy(EnemyCollider e) {
        e.getO().damage(10000);//deberiamos llamar a destruir?

    }


}
