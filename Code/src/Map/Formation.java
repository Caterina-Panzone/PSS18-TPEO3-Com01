package Map;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.DummyCollider;
import Collisions.Visitor;
import Controllers.*;
import GameObjects.*;


import java.util.*;

public class Formation extends Enemy {

    protected List<EnemyMovementController> enemies;
    protected int lvl;
    protected java.util.Map<EnemyMovementController, OffsetPosition> contToPositionMap;
    protected List<AbstractControllerFactory> factories;
    Vector2 offset;
    int distX, distY;
    boolean initialized;

    private int cont = 0; //Contador para que los enemigos no se activen en el primer update

   public Formation(int d) {
       health = 1;
       speed = 0.19f;
       ubication = new Vector2(00, 00);
       dir = Vector2.ORIGIN();
       new FormationMovementEnemyMovementController(this);
       enemies = new LinkedList<>();
       lvl = d;
       sprite = SpriteDepot.FROZE;
       c = new DummyCollider(this);
       offset = new Vector2(0, 0);
       distX = 200;
       distY = 100;
       initialized = false;
       contToPositionMap = new HashMap<EnemyMovementController, OffsetPosition>();
       createFactories();
       Map.getInstance().add(this);
   }



    public void createEnemies(){
        int x = 0;
        EnemyMovementController c;
        OffsetPosition p;
        AbstractControllerFactory f = factories.get(x);
        for (int i = 0; i < 3;i++){
            for(int j = 0;j<5;j++){
                offset = new Vector2(j*distX, i*distY);
                //System.out.println(offset.getX() +" "+ offset.getY() + "Vector"+i+" "+j);
                p = new OffsetPosition(this, offset);

                c = f.createController(p);
                enemies.add(c);
                contToPositionMap.put(c, p);
                f = factories.get(x);
                x++;

            }
        }
        initialized = true;
    }


    public void affect(Visitor v){
       for(EnemyMovementController c : enemies){
           c.getEnemy().getCollider().accept(v); ///TODO: cambiar visitables de colisiones por nuevos visitales?
       }
   }



   public void update(Map map){

       if(initialized) {
           if (enemies.size() != 0) {
               cont++;
               Random rand = new Random();
               float aux = rand.nextFloat(); //CADA CIERTO TIEMPO MANDA A ACTIVAR UN CONTROLADOR
               int aux2 = rand.nextInt(enemies.size());
               if (aux < 0.01 && cont > 250) {
                   enemies.get(aux2).activate();
               }
               updatePosition(map);
               super.update(map);
           } else {
               destroySelf();
               initialized = false;
           }
       }
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


    private void createFactories(){
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
    }

    public void removeCont(EnemyMovementController e) {
       enemies.remove(e);
    }

    public void destroySelf() {


       System.out.println("termino el nivel");
        Map.getInstance().remove(this);
        Map.getInstance().newLevel();
    }

    private AbstractControllerFactory addEnemies(){
       LinkedList<AbstractControllerFactory> lista = new LinkedList<AbstractControllerFactory>();
       lista.add(new FighterControllerFactory());
       lista.add(new FollowerControllerFactory());
       lista.add(new HybridControllerFactory());
       lista.add(new HybridFollowerControllerFactory());
       lista.add(new KamikazeControllerFactory());

       Random rand = new Random();
       int i = rand.nextInt(lista.size());
       AbstractControllerFactory toRet  = lista.get(i);
       return toRet;

    }
}
