package kevinquarta.GestionePrenotaione.services;


import kevinquarta.GestionePrenotaione.entities.Prenotazione;
import kevinquarta.GestionePrenotaione.entities.Utente;
import kevinquarta.GestionePrenotaione.exceptions.ValidationException;
import kevinquarta.GestionePrenotaione.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class PrenotazioneService {

    private PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public void savePrenotazione(Prenotazione newPrenotazione) {
        if(prenotazioneRepository.existsByPostazioneIdAndDataPrenotazione(newPrenotazione.getPostazione().getId(),newPrenotazione.getDataPrenotazione()))
        throw new ValidationException("Postazione già prenotata per quella data e postazione");
        if(prenotazioneRepository.existsByUtenteIdAndDataPrenotazione(newPrenotazione.getUtente().getId(),newPrenotazione.getDataPrenotazione()))
            throw new ValidationException("Postazione già prenotata dall'utente per quella data ");
        this.prenotazioneRepository.save(newPrenotazione);
    }
}
