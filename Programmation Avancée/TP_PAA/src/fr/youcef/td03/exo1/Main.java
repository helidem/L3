package fr.youcef.td03.exo1;

public class Main {
    public static void main(String[] args) {
        DicoT9 dico = new DicoT9();
        dico.enregistrer("bonjour");
        dico.enregistrer("bonne");
        dico.enregistrer("comme");

        System.out.println(dico.recuperer("26663"));
        System.out.println(dico.recuperer("2665687"));
        System.out.println(dico.recuperer("123456"));
    }
}
