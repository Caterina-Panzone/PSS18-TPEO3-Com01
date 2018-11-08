package PowerUps;

import GameObjects.Player;
import GameObjects.BasicWeapon;
import GameObjects.Weapon;

public class PiercingReverter implements Runnable {
    @Override
    public void run() {
        System.out.println("desactivo");
        Weapon w = new BasicWeapon(Player.getInstance().getDamage());
        Player.getInstance().setWeapon(w);


    }
}
