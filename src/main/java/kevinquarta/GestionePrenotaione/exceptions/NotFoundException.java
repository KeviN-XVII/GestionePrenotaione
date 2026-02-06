package kevinquarta.GestionePrenotaione.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("La risorsa con "+ id + " non è stata trovata!");
    }
}
