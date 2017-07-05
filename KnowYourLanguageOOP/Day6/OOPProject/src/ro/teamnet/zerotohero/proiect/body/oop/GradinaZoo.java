package ro.teamnet.zerotohero.proiect.body.oop;

import java.util.Date;

/**
 * Created by Claudiu.Brandabur on 04-Jul-17.
 */
public final class GradinaZoo {

    private final String denumireGradinaZoo;
    private final Date dataDeschideriiGrafinii;
    private final AnimalZooRar animalRar;
    private final AngajatZoo angajatulLunii;

    public GradinaZoo(String denumireGradinaZoo, Date dataDeschideriiGrafinii, AnimalZooRar animalRar, AngajatZoo angajatulLunii) {
        this.denumireGradinaZoo = denumireGradinaZoo;
        this.dataDeschideriiGrafinii = dataDeschideriiGrafinii;
        this.animalRar = animalRar;
        this.angajatulLunii = angajatulLunii;
    }
}
