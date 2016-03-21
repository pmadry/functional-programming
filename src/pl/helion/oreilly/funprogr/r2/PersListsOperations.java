package pl.helion.oreilly.funprogr.r2;

    import java.util.*;
    import java.lang.*;
    import java.io.*;
/**
 * Created by mucia on 21.01.16.
 */
public class PersListsOperations {
        static int listLength(List a){
            if(a.isEmpty()) return 0;
            else
                return (1 + listLength(listRest(a)));
        }
        static List listRest(List a){
            return(a.subList(1, a.size()));
        }
        static void cons(String a, List<String> b){
            b.add(a);
        }

        static List myConcat(List a, List b){
            if(a.isEmpty()) return b;
            else
                return(a);
        }
        public static void main (String[] args) throws java.lang.Exception
        {

            List<String> list = new LinkedList<>();
            List<String> list2 = new LinkedList<>();
            list.add("dupa");
            list.add("kot");
            list.add("kotek");
            list2.add("syf");
            list2.add("kila");
            list2.add("eurokomunista");
            System.out.println(list2.get(0));
            System.out.println(list2.isEmpty());
            //	list2.subList(1, 2);
            System.out.println(list2.subList(1, 3));
            System.out.println(list2.size());
            System.out.println("List rest: ");
            System.out.println(listRest(list2));
            System.out.println("My List length: ");
            System.out.println(listLength(list2));
//            list.push("konik");
            System.out.println(list);

        }


}
