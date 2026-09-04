package model;

import java.util.Comparator;

public class ComparadorPorNumero implements Comparator<Quarto> {
    @Override
    public int compare(Quarto o1, Quarto o2) {
        if (o1.getNumero()<o2.getNumero()) {
            return -1;
        } else if (o1.getNumero()>o2.getNumero()) {
            return 1;
        }
        return 0;
    }
}
