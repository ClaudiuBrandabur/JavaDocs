package ro.teamnet.zerotohero.reflection;

import ro.teamnet.zerotohero.reflection.demoobjects.Child;
import ro.teamnet.zerotohero.reflection.demoobjects.MyNumber;
import ro.teamnet.zerotohero.reflection.demoobjects.MyPrimeNumber;
import ro.teamnet.zerotohero.reflection.demoobjects.WeekDay;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


import static sun.reflect.misc.FieldUtil.getField;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {

    public int number;
    private static int age;

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //TODO get the class for a String object, and print it
        String word = "reflections";
        System.out.println("class for a String object: " + word.getClass().getSimpleName());

        //TODO get the class of an Enum, and print it
        Enum firstDay = WeekDay.Monday;
        System.out.println("class of an Enum: " + firstDay.getClass().getSimpleName());

        //TODO get the class of a collection, and print it
        ArrayList<String> ReflectionArray = new ArrayList<>();
        ReflectionArray.add("Exception!!");
        System.out.println("class of a collection: " + ReflectionArray.getClass().getSimpleName());

        //TODO get the class of a primitive type, and print it
        System.out.println("class of a primitive type: " + int.class);

        //TODO get and print the class for a field of primitive type
        System.out.println("class for a field of primitive type: "
                + getField(ClassReflectionDemoMain.class, "number").getType());
        System.out.println("class for a field of primitive type: "
                + ClassReflectionDemoMain.class.getDeclaredField("number").getType());

        //TODO get and print the class for a primitive type, using the wrapper class
        Double number = 12.55;
        System.out.println("class for a primite type, using wrapper class: " + number.getClass().getSimpleName());

        //TODO get the class for a specified class name
        System.out.println("class for a specified class name: "
                + Class.forName("ro.teamnet.zerotohero.reflection.ClassReflectionDemoMain").getSimpleName());

        //TODO get the superclass of a class, and print it
        //TODO get the superclass of the superclass above, and print it
        System.out.println("superclass of a class: " + Child.class.getSuperclass().getSimpleName());
        System.out.println("superclass of superclass of a class: "
                + Child.class.getSuperclass().getSuperclass().getSimpleName());

        //TODO get and print the declared classes within some other class
        System.out.print("Declared classes within MyNumber class: ");
        Class[] currentClass = MyNumber.class.getDeclaredClasses();
        for (int i = 0; i < currentClass.length; i++)
            System.out.print(i + 1 + ": " + currentClass[i].getSimpleName() + " ; ");

        //TODO print the number of constructors of a class
        System.out.println("\nnumber of contructors of MyNumber class: " + MyNumber.class.getConstructors().length);

        //TODO get and invoke a public constructor of a class
        try {
            MyNumber a = MyNumber.class.getConstructor().newInstance();
            System.out.println(a.getClass().getSimpleName());
        } catch (InstantiationException e) {
            System.out.println("1: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("2: " + e);
        } catch (InvocationTargetException e) {
            System.out.println("3: " + e);
        } catch (NoSuchMethodException e) {
            System.out.println("4: " + e);
        }

        try {
            Constructor[] a = MyNumber.class.getConstructors();
            MyNumber b = null;
            for (int i = 0; i < a.length; i++) {
                if (a[i].getParameterTypes().length == 2)
                    b = (MyNumber) a[i].newInstance(4, 4);

            }
            System.out.println(b.getClass().getSimpleName());
        } catch (InstantiationException e) {
            System.out.println("5: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("6: " + e);
        } catch (InvocationTargetException e) {
            System.out.println("7: " + e);
        }

        //TODO get and print the class of one private field
        MyNumber privateObject = new MyNumber(4,5);
        Field privateField = MyNumber.class.getDeclaredField("aNumber");
        privateField.setAccessible(true);
        System.out.println(privateField.getType());

        //TODO set and print the value of one private field for an object
        System.out.println(privateObject.getaNumber());
        privateObject.setaNumber(5);
        System.out.println(privateObject.getaNumber());

        //TODO get and print only the public fields class
        Field[] currentFields = MyNumber.class.getFields();
        for(int i=0; i<currentFields.length; i++)
            System.out.println(currentFields[i].getType().getSimpleName());

        //TODO get and invoke one public method of a class
        MyNumber object = new MyNumber(5,6);
        Class c = object.getClass();
        Method myMethod = c.getMethod("add", int.class, int.class);
        System.out.println( myMethod.invoke(object,9,9) );

        //TODO get and invoke one inherited method of a class
        MyPrimeNumber prime = new MyPrimeNumber(5,6, 7, 8);
        Class clasa = prime.getClass();
        Method myPrimeMethod = clasa.getSuperclass().getMethod("add", int.class, int.class);
        System.out.println( myPrimeMethod.invoke(object,15,21) );

        //TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
        //TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
        //what do you observe?


    }
}
