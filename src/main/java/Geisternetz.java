
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Geisternetz {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Standort standort;
    private String geschaetzteGroesse;
    private NetzStatus status;
    @OneToOne
    private Person bergendePerson;
    
    
    /* test instanz
    public Geisternetz(){
        this.id = 1;
        this.standort = new Standort("62.454", "375.232");
        this.geschaetzteGroesse = "ca. 10m";
        this.status = NetzStatus.GEMELDET;
        this.bergendePerson = null;
    }
    */

    public Geisternetz(Standort standort, String geschaetzteGroesse, NetzStatus status, Person bergendePerson) {
        this.standort = standort;
        this.geschaetzteGroesse = geschaetzteGroesse;
        this.status = status;
        this.bergendePerson = bergendePerson;
    }
    
    
    
    //getters & setters

    public int getId() {
        return id;
    }

    public Standort getStandort() {
        return standort;
    }

    public String getGeschaetzteGroesse() {
        return geschaetzteGroesse;
    }

    public NetzStatus getStatus() {
        return status;
    }

    public Person getBergendePerson() {
        return bergendePerson;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStandort(Standort standort) {
        this.standort = standort;
    }

    public void setGeschaetzteGroesse(String geschaetzteGroesse) {
        this.geschaetzteGroesse = geschaetzteGroesse;
    }

    public void setStatus(NetzStatus status) {
        this.status = status;
    }

    public void setBergendePerson(Person bergendePerson) {
        this.bergendePerson = bergendePerson;
    }
    
}