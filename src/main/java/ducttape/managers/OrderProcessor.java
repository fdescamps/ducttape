package ducttape.managers;

import ducttape.entities.WebOrder;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Stateless
public class OrderProcessor {
    @PersistenceContext
    EntityManager em;

    public void handleOrder(@Observes @OrderPlaced WebOrder webOrder) {
        em.persist(webOrder);
    }
}
