package ducttape.beans;

import ducttape.entities.Product;
import ducttape.managers.ProductManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@RequestScoped
@Named
public class ProductsBean {
    @Inject
    ProductManager productManager;

    private String filter;
    private boolean asc;


    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public List<Product> getProducts() {
        return productManager.listProducts(asc, filter);
    }
}
