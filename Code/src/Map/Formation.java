package Map;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.DummyCollider;
import Collisions.Visitor;
import Controllers.*;
import GameObjects.*;
import PowerUps.AbstractPowerUpFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Formation extends Enemy {

    protected Collection<EnemyMovementController> enemies;
    protected AbstractPowerUpFactory puf;
    protected int lvl;
    protected java.util.Map<EnemyMovementController, OffsetPosition> contToPositionMap;
    protected List<AbstractControllerFactory> factories;
    Vector2 offset;
    int distX, distY;

   public Formation(int d){
       health = 1;
       speed = 0.19f;
       ubication = new Vector2(300, 100);
       dir = Vector2.ORIGIN();
       new FormationMovementController(this);
       enemies = new LinkedList<>();
       lvl = d;
       sprite = SpriteDepot.FROZE;
       c = new DummyCollider(this);
       offset = new Vector2(-20, 0);
       distX = 180;
       distY = 100;
       createFactories();
       Map.getInstance().add(this);
       contToPositionMap = new HashMap<EnemyMovementController, OffsetPosition>();


   }



    public void createEnemies() {
        int x = 0;
        EnemyMovementController c;
        OffsetPosition p;
        AbstractControllerFactory f = factories.get(x);
        for (int i = 0; i < 3;i++){
            for(int j = 0;j<5;j++){
                offset = new Vector2(j*distX, i*distY);
                p = new OffsetPosition(this, offset);
                c = f.createController(p);
                enemies.add(c);
                contToPositionMap.put(c, p);
                x++;
                f = factories.get(x);

            }
        }
    }


    public void affect(Visitor v){
       for(EnemyMovementController c : enemies){
           c.getEnemy().getCollider().accept(v); ///TODO: cambiar visitables de colisiones por nuevos visitales?
       }
   }



   public void update(Map map){

       if(enemies.size() != 0) {
           updatePosition(map);
           super.update(map);
       }
       else
            destroySelf();
   }

    @Override
    protected void updatePosition(Map m) {
        float x = ubication.getX();
        float y = ubication.getY();

        dir = dir.max(maxSpeed);

        x += dir.getX() * speed;
        if(x < -fieldMarginX )
            x = Configs.getConfigs().getCanvasWidth() + fieldMarginX;
        if (x > Configs.getConfigs().getCanvasWidth() + fieldMarginX)
            x = -fieldMarginX;

        y += dir.getY() * speed;
        if(y < -fieldMarginY )
            y = Configs.getConfigs().getCanvasHeight() + fieldMarginY;
        if (y > Configs.getConfigs().getCanvasHeight() + fieldMarginY)
            y = -fieldMarginY;

        ubication = new Vector2(x,y);

    }


    private void createFactories() {
        factories = new LinkedList<AbstractControllerFactory>();
        factories.add(new KamikazeControllerFactory());
        factories.add(new KamikazeControllerFactory());
        factories.add(new KamikazeControllerFactory());
        factories.add(new KamikazeControllerFactory());
        factories.add(new KamikazeControllerFactory());
        factories.add(new FighterControllerFactory());
        factories.add(new FighterControllerFactory());
        factories.add(new FighterControllerFactory());
        factories.add(new FighterControllerFactory());
        factories.add(new FighterControllerFactory());
        factories.add(new HybridControllerFactory());
        factories.add(new HybridControllerFactory());
        factories.add(new HybridControllerFactory());
        factories.add(new HybridControllerFactory());
        factories.add(new HybridControllerFactory());
        factories.add(new HybridControllerFactory());
        //TODO:Revisar porque falla con 15 elementos
    }

    public void removeCont(EnemyMovementController e) {
       enemies.remove(e);
    }

    public void destroySelf() {
        System.out.println("se fue");
        //Map.getInstance().remove(this);
        Map.getInstance().newLevel();


    }
}
