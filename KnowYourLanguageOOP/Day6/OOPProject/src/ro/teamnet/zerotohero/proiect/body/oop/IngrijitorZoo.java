package ro.teamnet.zerotohero.proiect.body.oop;

import ro.teamnet.zerotohero.proiect.exceptions.AnimalPeCaleDeDisparitieException;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class IngrijitorZoo implements AngajatZoo {

    private int bonus = 0;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonus += valoareBonusPerAnimal * 3;
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException {
        lucreaza(animal);
        animal.doarme();
        animal.faceBaie();
        animal.seJoaca();

        if (animal instanceof AnimalZooRar && mancare == null)
            throw new AnimalPeCaleDeDisparitieException("Animal pe care de disparitie!!!");

        animal.mananca(mancare);
        calculeazaBonusSalarial();
    }

}
