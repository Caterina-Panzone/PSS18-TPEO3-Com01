package GameMaster;

import javax.management.ConstructorParameters;
import java.util.concurrent.Callable;

public class Timer implements Callable {
    private long current, ending;




    @ConstructorParameters(value = "Tiempo en milisegundos a esperar")
    public Timer(long t){
        current = System.currentTimeMillis();
        ending = current + t;
    }

    @Override
    public Object call() throws Exception {
        current = System.currentTimeMillis();
        return current>ending;
    }
}
