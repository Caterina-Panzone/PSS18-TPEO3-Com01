package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyBulletCollider;

import javax.swing.*;

public class EnemyFighterBullet extends EnemyBullet {

    int da�o;

    public EnemyFighterBullet(int d, Vector2 u) {
        setUbication(u);
        da�o = d;
        dir = new Vector2(0, 1);
        speed = 18.5f;
        sprite = SpriteDepot.ENEMYBULLET1;
        height = sprite.getIconHeight();
        width = sprite.getIconWidth();
        c = new EnemyBulletCollider(this);

    }

    @Override
    public int getDa�o() {
        return da�o;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getWidth() {
        return width;
    }
}
