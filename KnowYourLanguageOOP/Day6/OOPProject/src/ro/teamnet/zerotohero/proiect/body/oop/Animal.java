package ro.teamnet.zerotohero.proiect.body.oop;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public abstract class Animal {

    public abstract void mananca(Object object);
    public abstract void seJoaca();
    public abstract void faceBaie();
    public void doarme(){
        System.out.println("Animalul doarme");
    }

    public Animal() {
        System.out.println("Animal nou!");
    }
}
