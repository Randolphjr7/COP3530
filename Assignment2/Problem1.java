/**************************************************************
 Purpose/Description: Compute a set with only elements found in L1 but not in L2
 Author’s Panther ID: 3022407
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Problem1 {
    /*
    Given two sorted lists, L1 and L2, complete a following procedure in Java to compute:
    L1 \ L2 = { x | x E L1 and x not-in L2 } using only the basic list operators (next(), hasNext(),
    and compareTo()) and one loop.
    */
    public static void main(String[] args) {

        // Create empty lists
        List<Integer> list1 =  new ArrayList<>();
        List<Integer> list2 =  new ArrayList<>();
        List<Integer> list3 =  new ArrayList<>();
        List<Integer> list4 =  new ArrayList<>();
        List<Integer> list5 =  new ArrayList<>();
        List<Integer> list6 =  new ArrayList<>();
        List<String> list7 =  new ArrayList<>();
        List<String> list8 =  new ArrayList<>();

        // empty lists to hold our intersections
        List<Integer> difference1 =  new ArrayList<>();
        List<Integer> difference2 =  new ArrayList<>();
        List<Integer> difference3 =  new ArrayList<>();

        List<String> difference4 =  new ArrayList<>();

        // assign values using collections
        Collections.addAll(list1, 1,3,5,7);
        Collections.addAll(list2, 2,4,6,8);

        Collections.addAll(list3, 2,4,6,8);
        Collections.addAll(list4, 3,4,6,9);

        Collections.addAll(list5, 3,4,6,9);
        Collections.addAll(list6, 4,6,9,10);

      Collections.addAll(list7, "a","b","c","d");
      Collections.addAll(list8, "c","d","f","g");


        // call difference method --> will print out the intersection
        difference(list2, list1, difference1);
        difference(list4, list3, difference2);
        difference(list5, list6, difference3);

        difference(list7, list8, difference4);


    }

    // generic method
    public static <AnyType extends Comparable<? super AnyType>>
    void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference)
    {
        // ListIterator extends the functionality of an Iterator for Lists
        // we declare & initialize our ListIterator to iterate through our
        // two lists
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();

        // variables which can hold any Type parameter that extends comparable
        AnyType item1 = null;
        AnyType item2 = null;

        // check if both lists are not empty
        if ( iterL1.hasNext() && iterL2.hasNext() )
        {
            // assignment of the next element returned from their respective lists,
            // L1 & L2, advance the ListIterator cursor
            item1 = iterL1.next();
            item2 = iterL2.next();
        }

        // while both elements are not null
        while (!(item2 == null && item1 == null)) {

            // element in list L1 is null
            if (item1 == null) {
                // assignment of next element of list L2, advance the cursor
                item2 = (iterL2.hasNext()) ? iterL2.next() : null;
            }

            // element in list L2 is null
            else if (item2 == null) {
                // add element of list L1 to difference list
                Difference.add(item1);
                // assignment of next element of list L1, advance the cursor
                item1 = (iterL1.hasNext()) ? iterL1.next() : null;
            }

            else {

                // compare items
                int result = item1.compareTo(item2);

                if(result == 0) {
                    // they are the same so ignore and move iterator cursor fwd
                    // along both lists L1 and L2
                    item1 = (iterL1.hasNext()) ? iterL1.next() : null;
                    item2 = (iterL2.hasNext()) ? iterL2.next() : null;
                }
                else if(result < 0) {
                    // elements are different, element in list L1 is smaller
                    // add to Difference list, move cursor fwd, get next element
                    Difference.add(item1);
                    item1 = (iterL1.hasNext()) ? iterL1.next() : null;
                }
                else {
                    // elements are different, element in list l2 is bigger
                    // move cursor for fwd, get next element
                    item2 = (iterL2.hasNext()) ? iterL2.next() : null;
                }

            }

        }
        System.out.println("DIFFERENCE: " + Difference);
    }


}





