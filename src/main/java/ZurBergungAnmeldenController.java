
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ZurBergungAnmeldenController implements Serializable {
    
    @Inject
    private GhostNetFishing ghostNetFishing;
    
    private Geisternetz currentGeisternetz;
    private Person bergendePerson;
    
    
    public ZurBergungAnmeldenController(){
        bergendePerson = new Person();
    }
    
    public String startseite(){
        return "index.xhtml";
    }
    
    public void addPersonToNetz(){
        ghostNetFishing.addPersonToNetz(currentGeisternetz, bergendePerson);
    }
    
    // setter & getter

    public Geisternetz getCurrentGeisternetz() {
        return currentGeisternetz;
    }

    public Person getBergendePerson() {
        return bergendePerson;
    }

    public void setCurrentGeisternetz(Geisternetz currentGeisternetz) {
        this.currentGeisternetz = currentGeisternetz;
    }

    public void setBergendePerson(Person bergendePerson) {
        this.bergendePerson = bergendePerson;
    }
    
}
