package GameObjects;

import Assets.Paths;

import javax.swing.*;

public class PlayerBullet extends Bullet {

	
	public PlayerBullet(int d, int x, int y) {
		this.x = x;
		this.y = y;
		da�o = d;
		dir = new Vector2(0, -1);
		speed = 2;
		sprite = new ImageIcon(Paths.LASER);
	}
	
	
	public int getDa�o() {
		// TODO Auto-generated method stub
		return 0;
	}

}
