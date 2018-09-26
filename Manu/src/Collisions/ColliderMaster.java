package Collisions;

import java.util.Collection;
import java.util.LinkedList;

public class ColliderMaster {

    private static ColliderMaster instance;

    private ColliderMaster(){
        colliders = new LinkedList<>();
    }
    public static ColliderMaster getInstance() {
        if (instance == null){
            instance = new ColliderMaster();
        }
        return instance;
    }

    private Collection<Collider> colliders;


    public Collection<Collider> findCollisions(Collider c) {
        LinkedList<Collider> ret = new LinkedList<>();
        for(Collider co : colliders){
            if (co != c && c.intersects(co)){
                ret.add(co);
            }
        }
        return ret;
    }

    public void addCollider(Collider c){
        colliders.add(c);
    }
}
