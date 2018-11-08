package Controllers;

import GameObjects.Vector2;

import java.text.Normalizer;

public class FormationBehaviour extends Behaviour {

    private float radioGral = 0.86f;

    public FormationBehaviour(){
        direc = Vector2.LEFT();
        m = new Lemniscata();//Sinusoidal();
    }

    public Vector2 getDir(){
        updateDir();
        return direc;
    }


    private void updateDir(){
        float x = m.getX();


        float y =  m.getY();

        direc = (new Vector2(x,y));
        direc = direc.prod(radioGral);
    }

}
