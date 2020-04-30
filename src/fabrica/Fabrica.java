package fabrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {

    private static EntityManagerFactory fabrica;
    
    static {
        fabrica = Persistence.createEntityManagerFactory("aulaPU");
    }
    
    public static EntityManagerFactory get() {
        return fabrica;
    }
}