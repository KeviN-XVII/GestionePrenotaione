package kevinquarta.GestionePrenotaione.entities;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="prenotazioni")
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="dataPrenotazione",nullable = false)
    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name="id_utente",nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name="id_postazione",nullable = false)
    private Postazione postazione;

    public Prenotazione(LocalDate dataPrenotazione, Utente utente, Postazione postazione) {
        this.dataPrenotazione = dataPrenotazione;
        this.utente = utente;
        this.postazione = postazione;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataPrenotazione=" + dataPrenotazione +
                ", utente=" + utente +
                ", postazione=" + postazione +
                '}';
    }
}
