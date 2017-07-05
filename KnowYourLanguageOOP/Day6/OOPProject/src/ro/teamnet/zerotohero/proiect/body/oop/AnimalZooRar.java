package ro.teamnet.zerotohero.proiect.body.oop;

import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaAnimalException;
import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaOmException;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class AnimalZooRar extends Animal {

    public String nume;
    public String numeTaraDeOrigine;

    public AnimalZooRar() {
    }

    public AnimalZooRar(String nume) {
        this.nume = nume;
        this.numeTaraDeOrigine = "Default Land";
    }

    public AnimalZooRar(String nume, String numeTaraDeOrigine) {
        this.nume = nume;
        this.numeTaraDeOrigine = numeTaraDeOrigine;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumeTaraDeOrigine() {
        return numeTaraDeOrigine;
    }

    public void setNumeTaraDeOrigine(String numeTaraDeOrigine) {
        this.numeTaraDeOrigine = numeTaraDeOrigine;
    }

    @Override
    public void mananca(Object object) {
        if (object instanceof AngajatZoo)
            throw new AnimalManancaOmException("Animal Rar Mananca Om Exception");
        if (object instanceof Animal)
            throw new AnimalManancaAnimalException("Animal Rar Mananca Animal Exception");
        System.out.println("AnimalulZooRar mananca");
    }

    @Override
    public void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");
        doarme();
    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
    }



}
