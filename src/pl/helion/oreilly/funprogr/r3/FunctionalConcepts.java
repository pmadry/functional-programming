package pl.helion.oreilly.funprogr.r3;

import pl.helion.oreilly.funprogr.r2.Function1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mucia on 08.11.15.
 */
public class FunctionalConcepts {
    public static ArrayList<Customer> filter(ArrayList<Customer> inList,
                                             Function1<Customer, Boolean> test) {
        ArrayList<Customer> outList = new ArrayList<>();
        for (Customer customer : inList) {
            if (test.call(customer)) {
                outList.add(customer);
            }
        }
        return outList;
    }

    public static void foreach(List<Customer> inList, Foreach1<Customer> func) {
        for(Customer customer : inList) {
            func.call(customer);
        }
    }

    public static <A1,B> List<B> map(List<A1> inList, Function1<A1,B> func) {
        ArrayList<B> outList = new ArrayList<>();
        for(A1 obj : inList) {
            outList.add(func.call(obj));
        }
        return outList;
    }
}
