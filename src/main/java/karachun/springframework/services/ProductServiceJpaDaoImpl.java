package karachun.springframework.services;

import karachun.springframework.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl implements ProductService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Product> listAll() {

            EntityManager em = emf.createEntityManager();

            List<Product> result = em.createQuery("from Product", Product.class).getResultList();
            em.close();
            return result;

    }

    @Override
    public Product getById(Integer id) {

        EntityManager em = emf.createEntityManager();
        Product result = em.find(Product.class, id);
        em.close();
        return result;


    }

    @Override
    public Product saveOrUpdate(Product domainObject) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();
        em.close();
        return savedProduct;
    }

    @Override
    public void delete(Integer id) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
        em.close();

    }
}
