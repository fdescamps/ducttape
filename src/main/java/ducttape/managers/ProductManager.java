package ducttape.managers;

import ducttape.entities.Product;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Author Paul Bakker - paul.bakker.nl@gmail.com
 */
@Stateless
public class ProductManager {
    @PersistenceContext
    EntityManager em;

    public List<Product> listProducts() {
        return listProducts(true, null);
    }

    public List<Product> listProducts(boolean asc, String filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);

        Root<Product> product = query.from(Product.class);
        query.select(product);

        if(asc) {
            query.orderBy(cb.asc(product.get("price")));
        } else {
            query.orderBy(cb.desc(product.get("price")));
        }

        if(filter != null && filter.length() > 0) {
            query.where(cb.like(product.<String>get("name"), filter + "%"));
        }

        return em.createQuery(query).getResultList();

    }

    public Product findById(long pid) {
        return em.find(Product.class, pid);
    }
}
