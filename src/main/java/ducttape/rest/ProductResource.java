package ducttape.rest;

import ducttape.entities.Product;
import ducttape.managers.ProductManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Path("products")
@Stateless
public class ProductResource {

    @Inject
    ProductManager manager;

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Product> getProducts() {
        return manager.listProducts();
    }
}
