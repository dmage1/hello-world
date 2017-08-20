package com.example.myproject.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepository.class);
    @Autowired
    ResourceLoader loader;
    private List<Customer> list = new ArrayList<>();

    public Customer getCustomer(int id) {
        Customer customer = new Customer(id);
        List<Customer> list = getCustomers();
        for (Customer element : list) {
            if (element.getId() == id) {
                customer = element;
            }
        }
        return customer;
    }

    @SuppressWarnings("unchecked")
    public List<Customer> getCustomers() {

        LOGGER.info("UserDao.getAllUsers()");

        List<Customer> customerList = new ArrayList<>();
        String fileName = "Customer.ser";
        File file = new File(fileName);
        if (file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                customerList = (List<Customer>) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                LOGGER.error("Employee class not found " + c.getMessage());
                LOGGER.error(c.getStackTrace().toString());
            }
        }
        return customerList;
    }

    public void saveCustomerList(List<Customer> customerList) {

        LOGGER.info("saveCustomerList()");

        String fileName = "Customer.ser";
        File file = new File(fileName);
        if (file.exists()) {
            boolean result = file.delete();
            if (!result) {
                String msg = String.format("File %s not deleted", fileName);
                throw new RuntimeException(msg);
            }
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("Customer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customerList);
            out.close();
            fileOut.close();
            LOGGER.info("Serialized data is saved in Customer.ser");
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
            LOGGER.error("Error description ", ex);
        }
    }

}