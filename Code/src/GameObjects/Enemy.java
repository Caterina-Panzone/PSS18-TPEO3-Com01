package GameObjects;

import Assets.SpriteDepot;
import GUI.ScoreManager;
import Map.Map;

public abstract class Enemy extends Ship {

    protected int score;
    protected float Speed;
    protected float kamikazeDamage;
    protected int lvl = Map.getInstance().getLevel();
    protected Vector2 posInicial = new Vector2(400, 2900);

    public void destroySelf(){  //TODO: Cada destroy debria nullificar los atributos añadidos en su subclase y llamar a el super
        ScoreManager.getInstance().modificarScore(score);
        sprite = SpriteDepot.EXPLOSION;
        c.destroySelf();
    }

    public void damage(float d){
        health -= d;
    }



    public float getKamikazeDamage() {
        return kamikazeDamage;
    }
}
