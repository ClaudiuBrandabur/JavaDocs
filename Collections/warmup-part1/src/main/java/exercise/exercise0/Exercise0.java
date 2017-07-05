package exercise.exercise0;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    ArrayList<String> MyList = new ArrayList<String>();

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)
        for ( int i = 0; i < 4; i++ )
            MyList.add("elem "+i);

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator<String> myIterator = MyList.listIterator();

        while (myIterator.hasNext())
            System.out.println(myIterator.next() + " are indexul urmator: " + myIterator.nextIndex() + ";");

        System.out.println("");
        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        for ( int i = 0; i < 4; i++ )
            System.out.println(MyList.get(i));

        System.out.println("");
        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for (String list: MyList) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 e0 = new Exercise0();
        e0.iterateThroughList();
    }
}
