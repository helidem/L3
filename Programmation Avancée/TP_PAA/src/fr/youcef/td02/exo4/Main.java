package fr.youcef.td02.exo4;

public class Main {
    public static void main(String[] args) {

        Integer[] tab = {7,1,98,1,6};
        System.out.println(moyenne(tab));

        Integer[] tab2;
        tab2 = tri(tab);
        for (int i = 0; i < tab2.length; i++) {
            System.out.println(tab2[i]);
        }
    }

    /**
     * Retourne l'element maximal d'une liste d'Integer
     *
     * @param list la liste d'Integer
     * @return l'element maximal de la liste
     */
    public static Integer max(Integer[] list) {
        Integer max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i]> max) {
                max = list[i];
            }
        }
        return max;
    }

    /**
     * Calcule la moyenne des éléments d'une liste d'Integer
     *
     * @param list la liste d'Integer
     * @return la moyenne des éléments de la liste
     */
    public static Double moyenne(Integer[] list) {
        Double moyenne = 0.0;
        for (int i = 0; i < list.length; i++) {
            moyenne += list[i];
        }
        return moyenne / list.length;
    }

    /**
     * Trie une liste d'Integer
     *
     * @param list la liste d'Integer
     * @return la liste triee
     */
    public static Integer[] tri(Integer[] list) {
        Integer[] sortedList = new Integer[list.length];
        for (int i = 0; i < list.length; i++) {
            sortedList[i] = max(list);
            list[i] = null;
        }
        return sortedList;
    }

    // methode qui retourne l'élément max d'une liste d'Objets grace à l'interface Comparable
    public static <T extends Comparable<T>> T maxComparable(T[] list) {
        T max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0) {
                max = list[i];
            }
        }
        return max;
    }

    // methode qui trie une liste d'Objets grace à l'interface Comparable
    public static <T extends Comparable<T>> T[] triComparable(T[] list) {
        T[] sortedList = (T[]) new Comparable[list.length];
        for (int i = 0; i < list.length; i++) {
            sortedList[i] = maxComparable(list);
            list[i] = null;
        }
        return sortedList;
    }

}
