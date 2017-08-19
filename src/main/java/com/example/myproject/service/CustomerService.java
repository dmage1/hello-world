package com.example.myproject.service;

import com.example.myproject.domain.Customer;
import com.example.myproject.domain.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository dao;

    public Customer getCustomer(int id) {
        LOG.info("getCustomer({})", id);
        return dao.getCustomer(id);
    }

    public List<Customer> getCustomers() {
        LOG.info("getCustomers()");
        return dao.getCustomers();
    }

    public List<Customer> saveCustomer(Customer customer) {
        LOG.info("saveCustomer()");
        List<Customer> customerList = dao.getCustomers();
        customerList.add(customer);
        dao.saveCustomerList(customerList);
        return dao.getCustomers();
    }

    public List<Customer> deleteCustomer(int id) {
        LOG.info("deleteCustomer({})", id);
        List<Customer> customerList = dao.getCustomers();
        Iterator itr = customerList.iterator();
        while (itr.hasNext()) {
            Customer cust = (Customer) itr.next();
            if (cust.getId() == id) itr.remove();
        }
        dao.saveCustomerList(customerList);
        return dao.getCustomers();
    }

    public List<Customer> saveCustomers(List<Customer> customerList) {
        LOG.info("saveCustomers()");
        dao.saveCustomerList(customerList);
        return dao.getCustomers();
    }
}
