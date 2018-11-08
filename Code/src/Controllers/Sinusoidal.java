package Controllers;

public class Sinusoidal extends MovementPattern {

    public Sinusoidal() {
        ampx = 0.00000000543f;
        ampy = 000f;
    }

    @Override
    public float getX() {
        updateT();
        return t*ampx ;
    }

    @Override
    public float getY() {
        updateT();
        return (float) Math.sin(t*2)*  ampy;
    }
}
