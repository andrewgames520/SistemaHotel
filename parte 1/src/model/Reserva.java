package model;

public class Reserva {
    StatusReserva statusReserva;

    public Reserva(StatusReserva statusReserva) {
        this.statusReserva = statusReserva;
    }

    @Override
    public String toString() {
        System.out.println("Status da reserva " + statusReserva);;
        return null;
    }
}
