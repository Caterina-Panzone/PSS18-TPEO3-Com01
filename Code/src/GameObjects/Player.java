package GameObjects;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.PlayerCollider;
import Map.*;

import javax.swing.*;

public class Player extends  Shooter{
	protected final float playerSpeed = 8.6f;
	protected int damage;
	protected int attackSpeed;
	protected boolean loaded;
	protected long time;
	protected int gunPosition;

	// --------- alternar balas -----
	protected float gunPhaseShift;
	//-------------------------


	protected static Vector2 initialPosition = new Vector2(218,680);
	protected int playerAttackSpeed = 500;

	private static Player instance = null;

	public static Player getInstance() {
		if (instance == null)
			instance = new Player();
		return instance;
	}

	private Player() {
		health = 200;
		speed = playerSpeed;
		time=0;
		ubication = initialPosition;
		dir = Vector2.ORIGIN();
		damage = 0;
		sprite = SpriteDepot.NAVE;
		attackSpeed = playerAttackSpeed;
		loaded = true;
		isFiring = false;
		gunPosition = -7;
		gunPhaseShift = 40;
		height = sprite.getIconHeight();
		width = sprite.getIconWidth();
		c = new PlayerCollider(this);

	}

	//probablemente vaya mas arriba en jerarquia



	
	public void update(Map map) {

		if (health > 0) {
			checkFire(map);
			updatePosition(map);
			super.update(map);
		} else {
			destroySelf();
			destroyMe(map);
			sprite = new ImageIcon();
			c.destroySelf();
		}

	}

	private void checkFire(Map map) {

		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && isFiring){
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;


			Vector2 ubBullet = getUbication().sum(Vector2.RIGHT(gunPosition+gunPhaseShift));
			Bullet b = new PlayerBullet(damage,ubBullet);
			map.add(b);
			gunPhaseShift *= -1;

		}

	}

	@Override
	protected void updatePosition(Map map) {
		map.onUpdate(this);
		float x = ubication.getX();
		float y = ubication.getY();


		x += dir.getX() * speed;
		if(x < 0 - width)
			x = Configs.getConfigs().canvasWidth + width;
		if (x > Configs.getConfigs().canvasWidth + width)
			x = 0 - width;

		y += dir.getY() * speed;
		if(y < 0 - (height/2) )
			y = 0 - (height/2);
		if (y > Configs.getConfigs().canvasHeight - (height*2))
			y = Configs.getConfigs().canvasHeight - (height*2);

		ubication = new Vector2(x,y);
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
	
	
	
	
	
	


