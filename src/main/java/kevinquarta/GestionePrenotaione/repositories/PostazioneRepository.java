package kevinquarta.GestionePrenotaione.repositories;

import kevinquarta.GestionePrenotaione.entities.Edificio;
import kevinquarta.GestionePrenotaione.entities.Postazione;
import kevinquarta.GestionePrenotaione.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    //    QUERIES
    List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipo,String citta);

    List<Postazione> findByEdificioNome(String edificioNome);

}
