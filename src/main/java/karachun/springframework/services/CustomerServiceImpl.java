package karachun.springframework.services;

import karachun.springframework.domain.Customer;
import karachun.springframework.domain.DomainObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("John");
        customer1.setLastName("Ceana");
        customer1.setEmail("example1@mail.com");
        customer1.setPhoneNumber("8800555");
        customer1.setAddressLineOne("address line one");
        customer1.setAddressLineTwo("address line two");
        customer1.setCity("Los Angeles");
        customer1.setState("California");
        customer1.setZipCode("000000");

        domainMap.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Adam");
        customer2.setLastName("Sendler");
        customer2.setEmail("example2@mail.com");
        customer2.setPhoneNumber("8800777");
        customer2.setAddressLineOne("address line one");
        customer2.setAddressLineTwo("address line two");
        customer2.setCity("New York City");
        customer2.setState("New York");
        customer2.setZipCode("222222");

        domainMap.put(customer2.getId(), customer2);
    }
}
