
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class geisternetzMeldenController implements Serializable {
    
    private Geisternetz neuesGeisternetz = null;
    private Standort neuerStandort = null;
    

    @Inject
    private GhostNetFishing ghostNetFishing;
    
    
    public String startseite(){
        return "index.xhtml";
    }
    
    // getter & setter

    public Geisternetz getNeuesGeisternetz() {
        return neuesGeisternetz;
    }

    public Standort getNeuerStandort() {
        return neuerStandort;
    }

    public void setNeuesGeisternetz(Geisternetz neuesGeisternetz) {
        this.neuesGeisternetz = neuesGeisternetz;
    }

    public void setNeuerStandort(Standort neuerStandort) {
        this.neuerStandort = neuerStandort;
    }
    
    
}
