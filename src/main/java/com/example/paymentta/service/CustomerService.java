package com.example.paymentta.service;


import com.example.paymentta.entity.Customer;
import com.example.paymentta.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<CustomerRepository , Customer> {

//    @Autowired
//    private CustomerRepository customerRepository;
//    @Autowired
//    private CustomerConvertor customerConvertor ;

//    public void insert(CustomerDto customer) {
//
//        /*todo: add validation*/
//        Customer cm=customerConvertor.convent(customer);
//        cm.setInsertTimestamp(new Date());
//        customerRepository.save(cm);
//
//    }

//    public Customer getById(Long id) throws ServiceException {
//
//        Optional<Customer> customer = customerRepository.findById(id);
//
//        try {
//            return customer.orElseThrow();
//        } catch (Exception e) {
//
//            throw new ServiceException(e.getMessage(), "user not Found");
//        }
//
//
//    }

    public Customer withdraw(Customer c , Long amount) {

        if (c!= null && amount < c.getBalance()) {

            c.setBalance(c.getBalance() - amount);
            super.getRepository().save(c);

            return c;

        }
        return null;
    }

    public Customer deposit(Customer c ,Long amount) {

        if (c != null) {

            c.setBalance(c.getBalance() + amount);
            super.getRepository().save(c);
            return c;

        }
        return null;
    }

    public Customer GetByCardNumber(String cardNumber) {

        Customer c =  repository.findByCardNumber(cardNumber);
        if (c!= null){

            return c;
        }
        return null;

    }

    public Customer GetByAccountNumber(String account) {

        Customer c =  repository.findByAccountNumber(account);
        if (c!= null){

            return c;
        }
        return null;

    }

//
//
//    public Long accountBalance(String cardNumber) throws ServiceException {
//
//        Customer customer = customerRepository.findByCardNumber(cardNumber);
//
//        if (customer != null){
//
//            return customer.getBalance();
//        }else {
//
//            throw new ServiceException("user_not_found");
//        }
//
//    }
//    public void update(CustomerDto customerDto) throws ServiceException {
//        Customer customer =customerRepository.findById(customerDto.getId())
//                .orElseThrow(()->new ServiceException("customer not found"));
//        //Customer customer = customerConvertor.convent(customerDto) ;
//        change(customer,customerDto);
//        customerRepository.save(customer) ;
//
//    }
//    private void change(Customer customer, CustomerDto customerDto){
//
//        if(customerDto.getCardNumber()!= null) customer.setCardNumber(customerDto.getCardNumber());
//
//        if(customerDto.getAge()!= null) customer.setAge(customerDto.getAge());
//        if(customerDto.getBalance()!= null) customer.setBalance(customerDto.getBalance());
//        if(customerDto.getFirstName()!= null) customer.setFirstName(customerDto.getFirstName());
//        if(customerDto.getLastName()!= null) customer.setLastName(customerDto.getLastName());
//    }
}
