package ro.teamnet.zerotohero.proiect.body.oop;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public class VeterinarZoo implements AngajatZoo {

    private int bonus = 0;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal!");
        if(animal instanceof AnimalZooFeroce)
            animal.faceBaie();
        calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        bonus += valoareBonusPerAnimal * 2;
    }


}
