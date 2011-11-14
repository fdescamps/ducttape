package ducttape.managers;

import ducttape.entities.Product;
import ducttape.managers.ProductManager;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

@RunWith(Arquillian.class)
public class ProductManagerTest {
    @Inject
    private ProductManager productmanager;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClass(ProductManager.class)
                .addPackage(Product.class.getPackage())
                .addClass(TestDataInserter.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testIsDeployed() {
        Assert.assertNotNull(productmanager);
    }

    @Test
    public void testListProducts() {
        List<Product> products = productmanager.listProducts();
        assertThat(products.size(), is(5));
    }

    @Test
    public void testProductOrder() {
        assertThat(productmanager.listProducts(true, null).get(0).getId(), is(1l));

        assertThat(productmanager.listProducts(false, null).get(0).getId(), is(5l));
    }

    @Test
    public void testListById() {
        assertThat(productmanager.findById(1L).getId(), is(1l));
    }
}
