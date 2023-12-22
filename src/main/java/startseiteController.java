
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

@Named
@ViewScoped
public class startseiteController implements Serializable {

    @Inject
    private GhostNetFishing ghostNetFishing;
    
    
    public startseiteController() {
    }
    
    
    public String geisternetzMelden(){
        return "geisternetzMelden";
    }
    
    public String zurBergungAnmelden(){
        return "zurBergungAnmelden";
    }
}
