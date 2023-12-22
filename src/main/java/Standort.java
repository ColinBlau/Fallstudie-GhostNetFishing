
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Standort {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String altitude;
    private String longitude;

    public Standort() {
    }
    
    public Standort(String altitude, String longitude){
        this.altitude = altitude;
        this.longitude = longitude;
    }
    
            
    //getters & setters

    public int getId() {
        return id;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
}