package pl.helion.oreilly.funprogr.r3;


public class Customer {
    public static List<Customer> allCustomers = new ArrayList<Customer>();
    public final Integer customer_id = 0;
    public final String name = "";
    public final String state = "";
    public final String domain = "";
    public final Boolean enabled = true;
    public final Contract contract = null;
    public final List<Contact> contacts = new ArrayList<Contact>();

    public Customer(Integer customer_id,
                    String name,
                    String state,
                    String domain,
                    Boolean enabled,
                    Contract contract,
                    List<Contact> contacts) {
        this.customer_id = customer_id;
        this.name = name;
        this.state = state;
        this.domain = domain;
        this.enabled = enabled;
        this.contract = contract;
        this.contacts = contacts;
    }

    public static ArrayList<Customer> getCustomerById(ArrayList<Customer> inList,
                                                      Integer customerId) {
        inList.findAll({ customer -> customer.id == customerId })
    }


    static def EnabledCustomer = { customer -> customer.enabled == true }
    static def DisabledCustomer = { customer -> customer.enabled == false }

    public static List<String> getDisabledCustomerNames() {
        Customer.allCustomers.findAll(DisabledCustomer).collect({ customer -> customer.name })
    }

    public static List<String> getEnabledCustomerStates() {
        Customer.allCustomers.findAll(EnabledCustomer).collect({ customer -> customer.state })
    }

    public static List<String> getEnabledCustomerSomeoneEmail(String someone) {
        Customer.allCustomers.findAll(EnabledCustomer).collect({ customer -> someone + "@" + customer.domain })
    }

    static def setContractForCustomer(Integer customer_id, final Boolean status) {
        Customer.allCustomers.findAll({ customer -> customer.id == customer_id })
                .collect({ customer -> customer.contract.setEnabled(status) })
                .each({ contract -> println contract })

    }

    public static void sendEnabledCustomersEmails(String text) {
        Customer.allCustomers.findAll { customer -> customer.enabled && customer.contract.enabled }
                .each { customer ->
            customer.contacts.findAll {
                contact -> contact.enabled
            }.each { contact -> contact.sendEmail(text) }
        }
    }


/*    public static void main(String[] args) {
        def customer_1 = new Customer()
        customer_1.setId(1)
        customer_1.enabled = false;
        customer_1.name = "Czesław"
        customer_1.setState("Arizona")
        customer_1.setDomain("helion.pl")
        setContractFor(customer_1, 2009)

        def customer_2 = new Customer()
        customer_2.setId(2)
        customer_2.setEnabled(true)
        customer_2.setName("Wiesiek")
        customer_2.setState("Oregon")
        customer_2.setDomain("oreilly.pl")
        setContractFor(customer_2, 2010)

        def customer_3 = new Customer()
        customer_3.setId(3)
        customer_3.setEnabled(true)
        customer_3.setName("Roman")
        customer_3.setState("Kansas")
        customer_3.setDomain("funprog.pl")
        setContractFor(customer_3, 2011)

        def customer_4 = new Customer()
        customer_4.setId(4)
        customer_4.setEnabled(false)
        customer_4.setName("Wacław")
        customer_4.setState("Oklahoma")
        customer_4.setDomain("dupa.pl")
        setContractFor(customer_4, 2012)

        allCustomers.addAll(customer_1, customer_2, customer_3, customer_4)


        setContractForCustomer(2, false)
        setContractForCustomer(3, true)
        println getDisabledCustomerNames()
        println getEnabledCustomerStates()
        println getEnabledCustomerSomeoneEmail("Sauron")
//        println customer_2.contract


    }

    private static void setContractFor(Customer customer_2, int year) {
        def date = new Date()
        date.setYear(year)
        date.setMonth(8)
        date.setMinutes(22)

        def calendar = Calendar.getInstance()
        calendar.setTime(date)
        customer_2.contract = new Contract(calendar)
    }*/

}
