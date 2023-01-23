package osu.opr.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osu.opr.erp.entity.Customer;
import osu.opr.erp.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@Valid @RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/")
    public List<Customer> findAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public Customer replaceCustomerbyId(@Valid @RequestBody Customer newCustomer,@PathVariable Long id){
        Customer customer = customerService.findById(id);
        customer.setAdress(newCustomer.getAdress());
        customer.setName(newCustomer.getName());
        customer.setNote(newCustomer.getNote());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerbyId(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}
