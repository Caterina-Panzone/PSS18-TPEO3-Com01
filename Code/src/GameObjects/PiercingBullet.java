package GameObjects;

import Assets.SpriteDepot;
import Collisions.PiercingBulletCollider;
import Collisions.PlayerBulletCollider;
import Map.Map;

public class PiercingBullet extends PlayerBullet {

    public PiercingBullet(float damage, Vector2 u) {
        setUbication(ubication);
        daño = damage;
        dir = new Vector2(0, -1);
        speed = 6.3f;
        sprite = SpriteDepot.LASER;
        health = 1;
        ubication = u;
        c = new PiercingBulletCollider(this);
        Map.getInstance().add(this);
    }
}
