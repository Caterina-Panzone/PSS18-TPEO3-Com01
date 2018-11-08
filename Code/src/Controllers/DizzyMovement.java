package Controllers;

public class DizzyMovement extends MovementPattern {
    @Override
    public float getX() {
        return t;
    }

    @Override
    public float getY() {
        return (float) Math.cos(t)*t;
    }
}
