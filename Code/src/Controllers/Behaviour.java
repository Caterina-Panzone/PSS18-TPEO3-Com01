package Controllers;

import GameObjects.Vector2;

public abstract class Behaviour {

    protected Vector2 direc;
    protected MovementPattern m;

    public abstract Vector2 getDir();

    protected void updateDir(){


        float x = m.getX();


        float y =  m.getY();

        Vector2 vec = new Vector2(x,y);
        direc = vec;//.norma();
    }

}
