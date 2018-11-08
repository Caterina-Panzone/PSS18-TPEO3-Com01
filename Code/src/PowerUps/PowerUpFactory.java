package PowerUps;

@Deprecated
public class PowerUpFactory extends AbstractPowerUpFactory{

    int lvl;
    public PowerUpFactory(int l){
        lvl = l;
    }

    @Override
    AbstractPU newFroze() {
        return new FrozePU(null);
    }

    @Override
    AbstractPU newShield() {
        return new ShieldPU(null);
    }

    @Override
    AbstractPU newKamikazeShield() {
        return new KamikazeShieldPU(null);
    }

    @Override
    AbstractPU newPiercing() {
        return new PierceBulletPU(null);
    }
}
