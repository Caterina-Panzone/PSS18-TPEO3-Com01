package PowerUps;

import GameObjects.Vector2;

@Deprecated
public class PowerUpFactory extends AbstractPowerUpFactory{

    int lvl;
    public PowerUpFactory(int l){
        lvl = l;
    }


    AbstractPU newFroze() {
        return new FrozePU(null);
    }


    AbstractPU newShield() {
        return new ShieldPU(null);
    }


    AbstractPU newKamikazeShield() {
        return new KamikazeShieldPU(null);
    }

    AbstractPU newPiercing() {
        return new PierceBulletPU(null);
    }

    @Override
    public AbstractPU newPowerUp(Vector2 pos) {
        return null;
    }
}
