package GameObjects;

import Assets.Paths;
import GUI.Controller;
import Map.Map;

import javax.swing.*;
import java.net.URL;
import java.util.Vector;

public class Player extends  Shooter{
	//Controller c;
	private int dano;
	private int attackSpeed;
	private boolean loaded;
	private long time;
	private int gunPosition;
	boolean isFiring;


	public Player() {
		health = 200;
		speed = 5;
		time=0;
		x = 218;
		y = 680;
		dir = new Vector2(0,0);
		//c = cont;
		dano = 20;
		sprite = new ImageIcon(Paths.NAVE);
		attackSpeed = 300;
		boolean loaded = true;
		gunPosition = 125 ;
		isFiring = false;


	}

	//probablemente vaya mas arriba en jerarquia
	public void setDirec(Vector2 vect) {
		dir = vect;
		
	}

	public void setSprite(Icon s){
		sprite = s;
	}

	public void fire(){
		isFiring = true;

	}

	public void stopFiring(){
		isFiring = false;
	}
	

	
	public void update() {
		//dir = c.getDirection();
		if (time < System.currentTimeMillis())
			loaded = true;
		if (loaded && isFiring){
			loaded = false;
			time = System.currentTimeMillis() + attackSpeed;
			Bullet b = new PlayerBullet(dano, (int)x + gunPosition,(int) y);
				Map.getInstance().newBullet((x + gunPosition), y, b);
			gunPosition = ((gunPosition + 80)%160) ;

		}
		super.update();

	}
	
	
	
	
	
	

}
