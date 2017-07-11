package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Claudiu.Brandabur on 07-Jul-17.
 */
public class Main {

    public void printMap(){

    }

    public static void main(String[] args) {

        Map<StudentA,BigDecimal> firstMap = new HashMap<StudentA, BigDecimal>();
        Map<StudentB,BigDecimal> secondMap = new HashMap<StudentB, BigDecimal>();
        Map<StudentC,BigDecimal> thirdMap = new HashMap<StudentC, BigDecimal>();
        Map<StudentD,BigDecimal> fourthMap = new HashMap<StudentD, BigDecimal>();

        firstMap.put(new StudentA("Andrei","Mihai"), new BigDecimal(21.00) );
        firstMap.put(new StudentA("Mircea","Costel"), new BigDecimal(22.00) );
        firstMap.put(new StudentA("Cosmin","Razvan"), new BigDecimal(23.00) );
        firstMap.put(new StudentA("Tudor","Nicolae"), new BigDecimal(19.00) );
        firstMap.put(new StudentA("Andrei","Mihai1"), new BigDecimal(212.00) );
        firstMap.put(new StudentA("Mircea","Costel2"), new BigDecimal(222.00) );
        firstMap.put(new StudentA("Cosmin","Razvan3"), new BigDecimal(232.00) );
        firstMap.put(new StudentA("Tudor","Nicolae4"), new BigDecimal(192.00) );

        secondMap.put(new StudentB("Andrei","Mihai"), new BigDecimal(21.00) );
        secondMap.put(new StudentB("Mircea","Costel"), new BigDecimal(22.00) );
        secondMap.put(new StudentB("Cosmin","Razvan"), new BigDecimal(23.00) );
        secondMap.put(new StudentB("Tudor","Nicolae"), new BigDecimal(19.00) );
        secondMap.put(new StudentB("Andrei","Mihai"), new BigDecimal(214.00) );
        secondMap.put(new StudentB("Mirceae","Costele"), new BigDecimal(224.00) );
        secondMap.put(new StudentB("Cosmine","Razvane"), new BigDecimal(234.00) );
        secondMap.put(new StudentB("Tudore","Nicolaee"), new BigDecimal(194.00) );

        thirdMap.put(new StudentC("Andrei","Mihai"), new BigDecimal(21.00) );
        thirdMap.put(new StudentC("Mircea","Costel"), new BigDecimal(22.00) );
        thirdMap.put(new StudentC("Cosmin","Razvan"), new BigDecimal(23.00) );
        thirdMap.put(new StudentC("Tudor","Nicolae"), new BigDecimal(19.00) );
        thirdMap.put(new StudentC("Andrei","Mihai"), new BigDecimal(216.00) );
        thirdMap.put(new StudentC("Mircea","Costel"), new BigDecimal(226.00) );
        thirdMap.put(new StudentC("Cosmin","Razvan"), new BigDecimal(236.00) );
        thirdMap.put(new StudentC("Tudor","Nicolae"), new BigDecimal(196.00) );

        fourthMap.put(new StudentD("Andrei","Mihai"), new BigDecimal(21.00) );
        fourthMap.put(new StudentD("Mircea","Costel"), new BigDecimal(22.00) );
        fourthMap.put(new StudentD("Cosmin","Razvan"), new BigDecimal(23.00) );
        fourthMap.put(new StudentD("Tudor","Nicolae"), new BigDecimal(19.00) );
        fourthMap.put(new StudentD("Andrei","Mihait"), new BigDecimal(219.00) );
        fourthMap.put(new StudentD("Mircea","Costel5"), new BigDecimal(229.00) );
        fourthMap.put(new StudentD("Cosmin","Razvant"), new BigDecimal(239.00) );
        fourthMap.put(new StudentD("Tudor","Nicolae"), new BigDecimal(199.00) );

        Iterator<Map.Entry<StudentA,BigDecimal>> itA = firstMap.entrySet().iterator();
        Iterator<Map.Entry<StudentB,BigDecimal>> itB = secondMap.entrySet().iterator();
        Iterator<Map.Entry<StudentC,BigDecimal>> itC = thirdMap.entrySet().iterator();
        Iterator<Map.Entry<StudentD,BigDecimal>> itD = fourthMap.entrySet().iterator();

        System.out.println("Map de StudentA:");
        while(itA.hasNext()){
            Map.Entry<StudentA,BigDecimal> aux = itA.next();
            System.out.println( "Studentul de tip A: "+ aux.getKey()+ " are varsta "+ aux.getValue() );
        }

        System.out.println("Map de StudentB:");
        while(itB.hasNext()){
            Map.Entry<StudentB,BigDecimal> aux = itB.next();
            System.out.println( "Studentul de tip B: "+ aux.getKey()+ " are varsta "+ aux.getValue() );
        }

        System.out.println("Map de StudentC:");
        while(itC.hasNext()){
            Map.Entry<StudentC,BigDecimal> aux = itC.next();
            System.out.println( "Studentul de tip C: "+ aux.getKey()+ " are varsta "+ aux.getValue() );
        }

        System.out.println("Map de StudentD:");
        while(itD.hasNext()){
            Map.Entry<StudentD,BigDecimal> aux = itD.next();
            System.out.println( "Studentul de tip D: "+ aux.getKey()+ " are varsta "+ aux.getValue() );
        }

    }

}
