package pl.helion.oreilly.funprogr.r3

/**
 * Created by mucia on 07.11.15.
 */
public class Contract {

    public final Calendar begin_date;
    public final Calendar end_date;
    public final Boolean enabled;

    public Contract(Calendar begin_date, Calendar end_date, Boolean enabled) {
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.end_date = Calendar.getInstance();
        this.end_date.setTimeInMillis(this.begin_date.getTimeInMillis());
        this.end_date.add(Calendar.YEAR, 2);
        this.enabled = enabled;
    }

    public static List<Customer> setContractForCustomerList(List<Integer> ids, final Boolean status) {

        Customer.allCustomers.collect { customer ->
            if( ids.indexOf(customer.customer_id) >= 0) {
                new Customer(
                        customer.customer_id,
                        customer.name,
                        customer.state,
                        customer.domain,
                        customer.enabled,
                        new Contract(
                                customer.contract.begin_date,
                                customer.contract.end_date,
                                status
                        ),
                        customer.contacts
                )
            } else {
                customer
            }

        }

    }


    @Override
    public String toString() {
        return "Contract starts at " + begin_date.getTime() + " and finishes at " + end_date.getTime();
    }
}


