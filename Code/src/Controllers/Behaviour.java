package Controllers;

import GameObjects.Vector2;

public abstract class Behaviour {

    protected Vector2 direc;
    protected MovementPattern m;

    public abstract Vector2 getDir();


}
