package kevinquarta.GestionePrenotaione.repositories;


import kevinquarta.GestionePrenotaione.entities.Edificio;
import kevinquarta.GestionePrenotaione.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

//    QUERIES

    List<Edificio> findByCitta(String citta);

    List<Edificio> findByNome(String nome);

    List<Edificio> findByIndirizzo(String indirizzo);

    boolean existsByNomeAndCittaAndIndirizzo(String nome, String citta, String indirizzo);


}
