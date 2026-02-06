package kevinquarta.GestionePrenotaione.services;


import kevinquarta.GestionePrenotaione.entities.Edificio;
import kevinquarta.GestionePrenotaione.entities.Postazione;
import kevinquarta.GestionePrenotaione.entities.TipoPostazione;
import kevinquarta.GestionePrenotaione.exceptions.ValidationException;
import kevinquarta.GestionePrenotaione.repositories.EdificioRepository;
import kevinquarta.GestionePrenotaione.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {

    private final PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public void savePostazione (Postazione newPostazione) {
        this.postazioneRepository.save(newPostazione);
    }

    public List<Postazione> findAll(){
        return this.postazioneRepository.findAll();
    }

    public List<Postazione> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipoPostazione, String citta){
        return postazioneRepository.findByTipoPostazioneAndEdificioCitta(tipoPostazione, citta);
    }

    public Postazione  findById(long id){
        return postazioneRepository.findById(id);
    }

}
