package Controllers;


import Assets.Configs;
import GameObjects.LittlePonny;
import GameObjects.Vector2;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class FollowMovement extends MovementPattern {
    protected Vector2 o, d;
    protected LittlePonny so, sd;
    float distX = Configs.getConfigs().getFieldWidth();
    float distY = Configs.getConfigs().getFieldHeigth();
    float x1;
    float x2;
    float y1;
    float y2;


    public FollowMovement(LittlePonny or, LittlePonny de) {
        so = or;
        sd = de;
    }
    @Override
    public float getX() {
        updateP();
        x2 = d.getX();
        x1 = o.getX();
        float dd = x2-x1;
        //float di = (distX - x2) + x1;
        float di = (distX - abs(dd));



        if(abs(di) <= abs(dd)) {
            System.out.println("va al borde");
            return di;
        }
        else
            return dd;
        //Calcula si es mas facil ir por izquierda o derecha (atravesando el borde del mapa)
        //NO funciona
    }

    private void updateP() {
        o = so.getUbication();
        d = sd.getUbication();
    }

    @Override
    public float getY() {
        updateP();
        y2 = d.getY();
        y1 = o.getY();

        return y2-y1;//return min(y2-y1, distY - y1 + y2) ;
    }



}
