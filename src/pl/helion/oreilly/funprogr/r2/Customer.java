package pl.helion.oreilly.funprogr.r2;

/**
 * Created by mucia on 04.11.15.
 */

import pl.helion.oreilly.funprogr.r3.Contract;
import pl.helion.oreilly.funprogr.r3.FunctionalConcepts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class Customer {

    static public ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContact = "";
    public String domain = "";
    public Boolean enabled = true;
    public Contract contract;

    public Customer() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public static List<String> getEnabledCustomerAddresses() {
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            public String call(Customer customer) {
                return customer.address;
            }
        });
    }

    public static List<String> getEnabledCustomerNames() {
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            public String call(Customer customer) {
                return customer.name;
            }
        });
    }

//    public static List<String> getDisabledCustomerNames() {
//        return Customer.getField(
//                FunctionalConcepts.filter(Customer.allCustomers,
//                        new Function1<Customer, Boolean>() {
//                            @Override
//                            public Boolean call(Customer customer) {
//                                return customer.enabled == false;
//                            }
//                        }),
//                new Function1<Customer, String>() {
//                    @Override
//                    public String call(Customer customer) {
//                        return customer.name;
//                    }
//                }
//        );
//    }

    public static List<String> getEnabledCustomerStates() {
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            public String call(Customer customer) {
                return customer.state;
            }
        });
    }

    public static List<String> getEnabledCustomerPrimaryContacts() {
        return Customer.getEnabledCustomerField(customer -> customer.primaryContact);
    }

    public static List<String> getEnabledCustomerDomains() {
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            @Override
            public String call(Customer customer) {
                return customer.domain;
            }
        });
    }

    public static List<Customer> getEnabledCustomers() {
        return Customer.getEnabledCustomerField(new Function1<Customer, Customer>() {
            public Customer call(Customer customer) {
                return customer;
            }
        });
    }

    public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> func) {
        List<B> outList = new ArrayList<>();
        for (Customer customer : Customer.allCustomers) {
            if (customer.enabled) {
                outList.add(func.call(customer));
            }
        }
        return outList;
    }

    public static <B> List<B> getField(List<Customer> inList,
                                       Function1<Customer, B> func) {
        List<B> outList = new ArrayList<>();
        for (Customer customer : inList) {
            outList.add(func.call(customer));
        }
        return outList;
    }

    public static final Function1<Customer, Boolean> EnabledCustomer = new Function1<Customer, Boolean>() {
        @Override
        public Boolean call(Customer customer) {
            return customer.enabled == true;
        }
    };

    public static final Function1<Customer, Boolean> DisabledCustomer = new Function1<Customer, Boolean>() {
        @Override
        public Boolean call(Customer customer) {
            return customer.enabled == false;
        }
    };


    public static List<String> getEnabledCustomerSomeoneEmail(String someone) {
        return Customer.getEnabledCustomerField(new Function1<Customer, String>() {
            @Override
            public String call(Customer customer) {
                return someone + "@" + customer.domain;
            }
        });
    }

    // R3

//    public static ArrayList<Customer> getCustomerById(ArrayList<Customer> inList,
//                                                      final Integer customer_id) {
//        return FunctionalConcepts.filter(inList,
//                new Function1<Customer, Boolean>() {
//                    public Boolean call(Customer customer) {
//                        return customer.id == customer_id;
//                    }
//                });
//    }


    /* TODO: Dodanie funkcji main */
    public static void main(String[] args) {
        Customer customer_1 = new Customer();
        customer_1.setId(1);
        customer_1.enabled = false;
        customer_1.name = "Czesław";
        customer_1.setState("Arizona");
        customer_1.setDomain("helion.pl");
        setContractFor(customer_1, 2009);

        Customer customer_2 = new Customer();
        customer_2.setId(2);
        customer_2.setEnabled(true);
        customer_2.setName("Wiesiek");
        customer_2.setState("Oregon");
        customer_2.setDomain("oreilly.pl");
        setContractFor(customer_2, 2010);

        Customer customer_3 = new Customer();
        customer_3.setId(3);
        customer_3.setEnabled(true);
        customer_3.setName("Roman");
        customer_3.setState("Kansas");
        customer_3.setDomain("funprog.pl");
        setContractFor(customer_3, 2011);

        Customer customer_4 = new Customer();
        customer_4.setId(4);
        customer_4.setEnabled(false);
        customer_4.setName("Wacław");
        customer_4.setState("Oklahoma");
        customer_4.setDomain("dupa.pl");
        setContractFor(customer_4, 2012);

        allCustomers.add(customer_1);
        allCustomers.add(customer_2);
        allCustomers.add(customer_3);
        allCustomers.add(customer_4);


/*        Contract.setContractForCustomer(2, false);
        Contract.setContractForCustomer(3, true);*/
//        System.out.println(getDisabledCustomerNames());
        System.out.println(getEnabledCustomerStates());
        System.out.println(getEnabledCustomerSomeoneEmail("Sauron"));


    }

    private static void setContractFor(Customer customer_2, int year) {
        Date date = new Date();
        date.setYear(year);
        date.setMonth(8);
        date.setMinutes(22);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        customer_2.contract = new Contract(calendar);
    }
}
