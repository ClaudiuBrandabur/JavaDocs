package ro.teamnet.zerotohero.proiect.body.main;

import ro.teamnet.zerotohero.proiect.body.oop.*;
import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaAnimalException;
import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaOmException;
import ro.teamnet.zerotohero.proiect.exceptions.AnimalPeCaleDeDisparitieException;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class GradinaZooMain {

    public static void main(String[] args) {

        System.out.println("Welcome to ZOO! :) \nPlease buy a ticket!");

        AnimalZooRar animal1 = new AnimalZooRar("Pinguin");
        AnimalZooRar animal2 = new AnimalZooRar("Elefant","Africa");
        AnimalZooRar animal3 = new AnimalZooRar();

        AnimalZooFeroce animalFeroce = new AnimalZooFeroce();

        AngajatZoo angajat1 = new IngrijitorZoo();
        IngrijitorZoo angajat2 = new IngrijitorZoo();

        AngajatZoo angajat3 = new VeterinarZoo();
        VeterinarZoo angajat4 = new VeterinarZoo();

        System.out.println(animal1.getNume());
        System.out.println(animal1.getNumeTaraDeOrigine());
        System.out.println(animal2.getNume());
        System.out.println(animal2.getNumeTaraDeOrigine());

        angajat3.lucreaza(animal1);
        angajat3.lucreaza(animal2);
        angajat3.lucreaza(animal3);

        angajat4.lucreaza(animal1);
        angajat4.lucreaza(animal2);
        angajat4.lucreaza(animal3);

        angajat1.lucreaza(animal1);
        angajat1.lucreaza(animal2);
        angajat1.lucreaza(animal3);

        angajat2.lucreaza(animal1);
        angajat2.lucreaza(animal2);
        angajat2.lucreaza(animal3);

        try {
            angajat2.lucreaza(animal1,null);
            angajat2.lucreaza(animal1,angajat1);
            angajat2.lucreaza(animal1,new String("Mancare"));
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie1: "+e.getMessage());
            //e.printStackTrace();
        }

        try {
            angajat2.lucreaza(animalFeroce);
            angajat2.lucreaza(animalFeroce,null);
            angajat2.lucreaza(animalFeroce, new String("Mancare"));
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie2: "+e.getMessage());
            //e.printStackTrace();
        }

        System.out.println("Finish!\n\n");

        // noi structuri try/catch/finally

        try {
            angajat2.lucreaza(animal1,null);
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie3: "+e.getMessage());
        }
        try {
            angajat2.lucreaza(animal1,angajat1);
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie4: "+e.getMessage());
        } catch (AnimalManancaOmException e1) {
            System.out.println("Exceptie4.1: "+e1.getMessage());
        }
        try {
            angajat2.lucreaza(animal1,new String("Mancare"));
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie5: "+e.getMessage());
        }


        try {
            angajat2.lucreaza(animalFeroce,null);
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie2: "+e.getMessage());
        }
        try {
            angajat2.lucreaza(animalFeroce, new String("Mancare"));
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie2: "+e.getMessage());
        } finally {
            System.out.println("Va mai asteptam!");
        }

        System.out.println("Finish 2 !!!\n");

        System.out.println("Bonusul angajatului2: "+angajat2.getBonus());

        try {
            angajat2.lucreaza(animal1,animal2);
        } catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("Exceptie4: "+e.getMessage());
        } catch (AnimalManancaOmException e1) {
            System.out.println("Exceptie4.1: "+e1.getMessage());
        } catch (AnimalManancaAnimalException e2) {
            System.out.println("Exceptie4.2: "+e2.getMessage());
        }

        System.out.println("Finish 3!\n");

    }

}
