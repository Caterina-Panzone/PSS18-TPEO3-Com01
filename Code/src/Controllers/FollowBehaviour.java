package Controllers;

import GameObjects.LittlePonny;
import GameObjects.Vector2;
public class FollowBehaviour extends Behaviour {

    protected Vector2 u;

    public FollowBehaviour(LittlePonny or, LittlePonny de){
        m = new FollowMovement(or, de);
    }

    public Vector2 getDir(){
        updateDir();
        return direc;
    }






}
