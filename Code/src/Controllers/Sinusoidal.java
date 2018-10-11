package Controllers;

public class Sinusoidal extends MovementPattern {

    public Sinusoidal() {
        ampx = 0.00000543f;
        ampy = 0.07f;
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
