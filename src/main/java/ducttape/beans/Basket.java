package ducttape.beans;

import ducttape.entities.Customer;
import ducttape.entities.Product;
import ducttape.entities.WebOrder;
import ducttape.managers.OrderPlaced;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@ConversationScoped
@Named
public class Basket implements Serializable{
    @Inject
    Conversation conversation;

    private Customer customer = new Customer();

    public Customer getCustomer() {
        return customer;
    }

    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if(conversation.isTransient()) {
            conversation.begin();
        }

        products.add(product);
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Product product : products) {
            total = total.add(product.getPrice());
        }

        return total;
    }

    @Inject @OrderPlaced
    Event<WebOrder> webOrderEvent;

    public String checkout() {
        System.out.println("Order from: " + customer.getName());

        if(!conversation.isTransient()) {
            conversation.end();
        }

        webOrderEvent.fire(new WebOrder(new Date(), products, customer));

        return "index.xhtml?faces-redirect=true";
    }
}
