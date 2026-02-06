package kevinquarta.GestionePrenotaione.services;


import kevinquarta.GestionePrenotaione.entities.Utente;
import kevinquarta.GestionePrenotaione.exceptions.ValidationException;
import kevinquarta.GestionePrenotaione.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente(Utente newUtente){
//        controllo che l'email non sia già utilizzata
        if(utenteRepository.existsByEmail(newUtente.getEmail()))throw new ValidationException("Email "+ newUtente.getEmail()+" già registrata!");
        if(newUtente.getNome().length()<2)throw new ValidationException("Il nome deve essere più lungo");
        this.utenteRepository.save(newUtente);
        log.info("Utente salvato con successo!");
    }

    public Utente findByNomeAndCognome(String nome, String cognome) {
        return this.utenteRepository.findByNomeAndCognome(nome,cognome);
    }

    public Utente findByEmail(String email) {
        return this.utenteRepository.findByEmail(email);
    }


    public List<Utente> findAll(){
        return this.utenteRepository.findAll();
    }








}
