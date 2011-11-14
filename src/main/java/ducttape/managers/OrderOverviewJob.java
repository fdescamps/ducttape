package ducttape.managers;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Stateless
public class OrderOverviewJob {

    @PersistenceContext
    EntityManager em;

    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void generate() {
        Long count = em.createQuery("select count(o.id) from WebOrder o", Long.class).getSingleResult();

        System.out.println("Currently there are " + count + " orders in the system");
    }
}
