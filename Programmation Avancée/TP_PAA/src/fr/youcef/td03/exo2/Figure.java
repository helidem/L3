package fr.youcef.td03.exo2;

public abstract class Figure {

    public Figure() {
    }

    public abstract double perimetre();

    public abstract double surface();

    public abstract Figure translation(fr.youcef.td02.Vecteur v);

    public String toString() {
        return getClass()+ ", Périmètre : " + perimetre() + " Surface : " + surface();
    }
}
