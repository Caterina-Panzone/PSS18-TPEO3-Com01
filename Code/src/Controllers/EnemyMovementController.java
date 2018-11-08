package Controllers;

import Assets.Paths;
import GameObjects.Enemy;
import Map.Map;

import javax.swing.*;

import GameObjects.MovingObject;
public abstract class EnemyMovementController<E extends Enemy> extends MovementController<E> {




    public EnemyMovementController(){

        Map.getInstance().add(this);
    }





    @Override
    public void update(Map map)
    {
        if (controlled.isAlive()) {
            super.update(map);


        }
        else
            destroyMe(map);
    }

    public Enemy getEnemy(){
        return controlled;
    }

    @Override
    public void destroyMe(Map map) {
        Map.getInstance().getFormation().removeCont(this);
        super.destroyMe(map);
    }

    public abstract void activate();

    public abstract void setBehaviour(Behaviour be);
}
