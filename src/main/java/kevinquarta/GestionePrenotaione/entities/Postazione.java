package kevinquarta.GestionePrenotaione.entities;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name="postazioni")
@NoArgsConstructor
public class Postazione {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="descrizione")
    private String descrizione;

    @Column(name="numMax")
    private int numMaxOccupanti;

    @Column(name="tipoPostazione")
    @Enumerated(EnumType.STRING)
    private tipoPostazione tipoPostazione;

    @Column(name="libero")
    private boolean libero;


    @ManyToOne
    @JoinColumn(name="id_edificio",nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, int numMaxOccupanti, tipoPostazione tipoPostazione, boolean libero, Edificio edificio) {
        this.descrizione = descrizione;
        this.numMaxOccupanti = numMaxOccupanti;
        this.tipoPostazione = tipoPostazione;
        this.libero = libero;
        this.edificio = edificio;
    }

    public long getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getNumMaxOccupanti() {
        return numMaxOccupanti;
    }

    public void setNumMaxOccupanti(int numMaxOccupanti) {
        this.numMaxOccupanti = numMaxOccupanti;
    }

    public tipoPostazione getTipoPostazione() {
        return tipoPostazione;
    }

    public void setTipoPostazione(tipoPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
    }

    public boolean isLibero() {
        return libero;
    }

    public void setLibero(boolean libero) {
        this.libero = libero;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", numMaxOccupanti=" + numMaxOccupanti +
                ", tipoPostazione=" + tipoPostazione +
                ", libero=" + libero +
                ", edificio=" + edificio +
                '}';
    }
}
