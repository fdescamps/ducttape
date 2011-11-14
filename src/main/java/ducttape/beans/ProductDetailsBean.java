package ducttape.beans;

import ducttape.entities.Product;
import ducttape.managers.ProductManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@RequestScoped
@Named
public class ProductDetailsBean {
    private Product product;
    private long pid;

    @Inject
    ProductManager manager;

    public void loadProduct() {
        product = manager.findById(pid);
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
