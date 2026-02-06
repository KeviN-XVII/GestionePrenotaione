package kevinquarta.GestionePrenotaione.services;


import kevinquarta.GestionePrenotaione.entities.Prenotazione;
import kevinquarta.GestionePrenotaione.exceptions.ValidationException;
import kevinquarta.GestionePrenotaione.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {

    private PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public void savePrenotazione(Prenotazione newPrenotazione) {
        if(prenotazioneRepository.existsByPostazioneAndDataPrenotazione(newPrenotazione.getPostazione(),newPrenotazione.getDataPrenotazione()))
        throw new ValidationException("Postazione già prenotata per quella data e postazione");
        if(prenotazioneRepository.existsByUtenteAndDataPrenotazione(newPrenotazione.getUtente(),newPrenotazione.getDataPrenotazione()))
            throw new ValidationException("Postazione già prenotata dall'utente per quella data ");
        this.prenotazioneRepository.save(newPrenotazione);
    }
}
