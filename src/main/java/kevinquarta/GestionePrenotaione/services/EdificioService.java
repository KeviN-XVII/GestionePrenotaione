package kevinquarta.GestionePrenotaione.services;


import kevinquarta.GestionePrenotaione.entities.Edificio;
import kevinquarta.GestionePrenotaione.exceptions.NotFoundException;
import kevinquarta.GestionePrenotaione.exceptions.ValidationException;
import kevinquarta.GestionePrenotaione.repositories.EdificioRepository;
import kevinquarta.GestionePrenotaione.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class EdificioService {

    private EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public void saveEdificio(Edificio newEdificio) {
        if(edificioRepository.existsByNomeAndCittaAndIndirizzo(newEdificio.getNome(), newEdificio.getCitta(), newEdificio.getIndirizzo()))throw new ValidationException("Edificio già esistente!");
        this.edificioRepository.save(newEdificio);
        log.info("Nuovo edificio : " + newEdificio.getNome() + " salvato correttamente!");
    }

    public Edificio findById(long edificioId){
     return edificioRepository.findById(edificioId).orElseThrow(()->new NotFoundException(edificioId));
    }
}
