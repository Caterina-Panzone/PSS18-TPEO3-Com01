package PowerUps;

@Deprecated
public class PowerUpFactory extends AbstractPowerUpFactory{

    int lvl;
    public PowerUpFactory(int l){
        lvl = l;
    }

    @Override
    AbstractPU newFroze() {
        return new FrozePU();
    }

    @Override
    AbstractPU newShield() {
        return new ShieldPU();
    }

    @Override
    AbstractPU newKamikazeShield() {
        return new KamikazeShieldPU();
    }

    @Override
    AbstractPU newPiercing() {
        return new PierceBulletPU();
    }
}
