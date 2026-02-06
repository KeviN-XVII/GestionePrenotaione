package kevinquarta.GestionePrenotaione.repositories;

import kevinquarta.GestionePrenotaione.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Utente findByNomeAndCognome(String nome, String cognome);

    Utente findByEmail(String emailUtente);

    boolean existsByEmail(String email);

}
