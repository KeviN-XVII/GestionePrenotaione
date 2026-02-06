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

    @Column(name="descrizione",nullable = false)
    private String descrizione;

    @Column(name="numMax",nullable = false)
    private int numMaxOccupanti;

    @Column(name="tipoPostazione",nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    @ManyToOne
    @JoinColumn(name="id_edificio",nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, int numMaxOccupanti, TipoPostazione tipoPostazione, Edificio edificio) {
        this.descrizione = descrizione;
        this.numMaxOccupanti = numMaxOccupanti;
        this.tipoPostazione = tipoPostazione;
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

    public TipoPostazione getTipoPostazione() {
        return tipoPostazione;
    }

    public void setTipoPostazione(TipoPostazione tipoPostazione) {
        this.tipoPostazione = tipoPostazione;
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
                ", edificio=" + edificio.getNome() +
                '}';
    }
}
