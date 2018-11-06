package GameObjects;

import Assets.Configs;
import Map.Map;

import javax.swing.*;

public abstract class Ship extends MovingObject {



    public void fire() {
        isFiring = true;

    }

    public void stopFiring() {
        isFiring = false;
    }






    @Override
    protected void updatePosition(Map map) {
        float x = ubication.getX();
        float y = ubication.getY();

        dir = dir.max(maxSpeed);
        x += dir.getX() * speed;

        if(x < -fieldMarginX )
            x = Configs.getConfigs().getCanvasWidth() + fieldMarginX;
        if (x > Configs.getConfigs().getCanvasWidth() + fieldMarginX)
            x = -fieldMarginX;

        y += dir.getY() * speed;
        if(x < -fieldMarginY )
            y = Configs.getConfigs().getCanvasWidth() + fieldMarginY;
        if (y > Configs.getConfigs().getCanvasWidth() + fieldMarginY)
            y = -fieldMarginY;

        ubication = new Vector2(x,y);
    }
}


