package kevinquarta.GestionePrenotaione.repositories;

import kevinquarta.GestionePrenotaione.entities.Postazione;
import kevinquarta.GestionePrenotaione.entities.Prenotazione;
import kevinquarta.GestionePrenotaione.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    List<Prenotazione> findByUtente(Utente utente);

}
