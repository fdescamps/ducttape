package ducttape.managers;

import ducttape.entities.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Singleton
@Startup
public class TestDataInserter {
    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void insert() {
        for(int i =1; i <= 5; i++) {
            em.persist(new Product(i + " product", new BigDecimal(10 * i)));
        }
    }
}
