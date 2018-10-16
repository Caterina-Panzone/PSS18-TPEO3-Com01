package GameObjects;

import Assets.SpriteDepot;
import Collisions.PlayerBulletCollider;

import javax.swing.*;

public class PlayerBullet extends Bullet {

	
	public PlayerBullet(int d,Vector2 ubication) {
		setUbication(ubication);
		da�o = d;
		dir = new Vector2(0, -1);
		speed = 6.3f;
		sprite = SpriteDepot.LASER;
		health = 1;
		height = sprite.getIconHeight();
		width = sprite.getIconWidth();
		c = new PlayerBulletCollider(this);


	}
	
	
	public int getDa�o()
	{
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
