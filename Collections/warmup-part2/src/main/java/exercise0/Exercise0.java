package exercise0;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // TODO Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // TODO Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        Map<String, String> firstMap = new HashMap<String, String>();
        firstMap.put("Mihai","Elev");
        firstMap.put("Andrei","Student");
        firstMap.put("Mircea","Avocat");
        firstMap.put("Mihai","Doctor");

        // TODO Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // TODO Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        for ( String s: firstMap.keySet() ) {
            System.out.println("Persoana "+ s +" este "+firstMap.get(s));
        }
        
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
