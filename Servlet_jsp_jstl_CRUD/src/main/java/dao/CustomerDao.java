package dao;

import model.Customer;

import java.util.*;

public class CustomerDao {
    private static final Map<Integer, Customer> listCustomer = new HashMap<Integer, Customer>();

    static {
        initCustomer();
    }

    private static void initCustomer() {
        Customer customer1 = new Customer(1, "Tung", "0987654321", "tung@gmail.com");
        Customer customer2 = new Customer(2, "Nho", "0987654325", "Nho@gmail.com");
        Customer customer3 = new Customer(3, "Bun", "0987654322", "Bun@gmail.com");
        Customer customer4 = new Customer(4, "Bo", "0987654323", "Bo@gmail.com");
        Customer customer5 = new Customer(5, "Miu", "0987654331", "Miu@gmail.com");
        listCustomer.put(customer1.getId(), customer1);
        listCustomer.put(customer2.getId(), customer2);
        listCustomer.put(customer3.getId(), customer3);
        listCustomer.put(customer4.getId(), customer4);
        listCustomer.put(customer5.getId(), customer5);
    }

    //        Viết phương thức xử lý get thông tin chi tiết của customer theo id

    public static Customer findById(int customerId) {
        Customer customer = listCustomer.get(customerId);
        return customer;
    }

    //    Thêm mới 1 customer
    public static void addCustomer(Customer customer) {
        listCustomer.put(customer.getId(), customer);
    }


    //    Update customer
    public static Customer updateCustomer(Customer customer) {
        listCustomer.put(customer.getId(), customer);
        return customer;
    }

    //    delete Customer
    public static void deleteCustomer(int customerId) {
        listCustomer.remove(customerId);
    }

    //    Lấy tấtr cả danh sách customer
    public static List<Customer> findAllCustomer() {
        Collection<Customer> customers = listCustomer.values();
        List<Customer> list = new ArrayList<Customer>();
        list.addAll(customers);
        return list;
    }

}
