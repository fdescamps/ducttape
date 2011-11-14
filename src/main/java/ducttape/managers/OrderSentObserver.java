package ducttape.managers;

import ducttape.entities.WebOrder;

import javax.enterprise.event.Observes;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
public class OrderSentObserver {
    public void handleEvent(@Observes @OrderSent WebOrder webOrder) {
        System.out.println("Order sent to " + webOrder.getCustomer().getName());
    }
}
