
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

@Named
@ViewScoped
public class startseiteController implements Serializable {

    @Inject
    private GhostNetFishing ghostNetFishing;
    
    private NetzStatus selectedStatus = NetzStatus.GEMELDET;
    
    public startseiteController() {
    }
    
    
    public String geisternetzMelden(){
        return "geisternetzMelden";
    }
    
    public String zurBergungAnmelden(){
        return "zurBergungAnmelden";
    }
    
    public void alsGeborgenMelden(Geisternetz geisternetz){
        ghostNetFishing.alsGeborgenMelden(geisternetz);
    }
    
    public void alsVerschollenMelden(Geisternetz geisternetz){
        ghostNetFishing.alsVerschollenMelden(geisternetz);
    }
    
    // getter & setter

    public NetzStatus getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(NetzStatus selectedStatus) {
        this.selectedStatus = selectedStatus;
    }
    
}
