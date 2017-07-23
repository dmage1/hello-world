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
        Customer customer = new Customer();
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
                System.out.println("Employee class not found");
                c.printStackTrace();
            }
        }
        return customerList;
    }

    public void saveCustomerList(List<Customer> customerList) {

        LOGGER.info("saveCustomerList()");

        String fileName = "Customer.ser";
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("Customer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customerList);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in Customer.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}