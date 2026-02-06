package kevinquarta.GestionePrenotaione.runners;

import kevinquarta.GestionePrenotaione.entities.*;
import kevinquarta.GestionePrenotaione.exceptions.ValidationException;
import kevinquarta.GestionePrenotaione.services.EdificioService;
import kevinquarta.GestionePrenotaione.services.PostazioneService;
import kevinquarta.GestionePrenotaione.services.PrenotazioneService;
import kevinquarta.GestionePrenotaione.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    private final EdificioService edificioService;
    private final PostazioneService postazioneService;
    private final PrenotazioneService prenotazioneService;
    private final UtenteService utenteService;

    public Runner(EdificioService edificioService, PostazioneService postazioneService, PrenotazioneService prenotazioneService, UtenteService utenteService) {
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.prenotazioneService = prenotazioneService;
        this.utenteService = utenteService;
    }

    @Override
    public void run(String... args) throws Exception {

//        EDIFICI
        Edificio edificioMilano = new Edificio("Edificio Milano","Via Garibaldi","Milano");
//        edificioService.saveEdificio(edificioMilano);

        Edificio edificioRoma = new Edificio("Edificio Roma","Via Francesco Totti","Roma");
//        edificioService.saveEdificio(edificioRoma);

//        POSTAZIONI
        Postazione postazione1 = new Postazione("Ufficio Privato",10, TipoPostazione.PRIVATO,edificioMilano);
//        postazioneService.savePostazione(postazione1);

        Postazione postazione2 = new Postazione("Postazone OpenSpace",20, TipoPostazione.OPENSPACE,edificioRoma);
//        postazioneService.savePostazione(postazione2);

//        UTENTI
        Utente Francesco = new Utente("Francesco","Totti","forzaroma@gmail.com");
//        utenteService.saveUtente(Francesco);

        Utente Riccardo = new Utente("Ricky","Kaka","kaka@gmail.com");
//        utenteService.saveUtente(Riccardo);

//        PRENOTAZIONI
        Prenotazione prenotazione1 = new Prenotazione(LocalDate.now(),Francesco,postazione1);
//        prenotazioneService.savePrenotazione(prenotazione1);



//        FIND BY DB

          Edificio edificioMilanoDB = edificioService.findById(1);
          Edificio edificioRomaDB = edificioService.findById(2);

          Postazione postazione1DB= postazioneService.findById(1);
          Postazione postazione2DB= postazioneService.findById(2);

          Utente francescoDB = utenteService.findByEmail("forzaroma@gmail.com");
          Utente riccardoDB = utenteService.findByEmail("kaka@gmail.com");

//            ERRORE PRENOTAZIONE STESSO GIORNO E UTENTE
          try {
              Prenotazione prenotazione2 = new Prenotazione(LocalDate.now(),francescoDB,postazione2DB);
              prenotazioneService.savePrenotazione(prenotazione2);

          } catch (ValidationException e) {
              log.error(e.getMessage());
          }
//            ERRORE PRENOTAZIONE STESSO GIORNO E POSTAZIONE
        try {
            Prenotazione prenotazione3 = new Prenotazione(LocalDate.now(),riccardoDB,postazione1DB);
            prenotazioneService.savePrenotazione(prenotazione3);

        } catch (ValidationException e) {
            log.error(e.getMessage());
        }
//      RICERCA POSTAZIONE INDICANDO TIPO E CITTA
       log.info(postazioneService.findByTipoPostazioneAndEdificioCitta(TipoPostazione.PRIVATO,"Milano").toString());























    }


}
