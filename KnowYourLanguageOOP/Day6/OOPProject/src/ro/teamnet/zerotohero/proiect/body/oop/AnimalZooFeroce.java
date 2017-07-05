package ro.teamnet.zerotohero.proiect.body.oop;

import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaAnimalException;
import ro.teamnet.zerotohero.proiect.exceptions.AnimalManancaOmException;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class AnimalZooFeroce extends Animal {



    @Override
    public void mananca(Object object) {
        if (object instanceof AngajatZoo)
            throw new AnimalManancaOmException("Animal Feroce Mananca Om Exception");
        if (object instanceof Animal)
            throw new AnimalManancaAnimalException("Animal Feroce Mananca Animal Exception");
        System.out.println("AnimalZooFeroce mananca");
    }

    @Override
    public void seJoaca() {
        System.out.println("AnimalZooFeroce se joaca");
        doarme();
    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalZooFeroce face baie");
    }

    @Override
    public void doarme(){
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }

}
