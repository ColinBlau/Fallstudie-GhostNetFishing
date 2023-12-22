
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;


@Named
@ApplicationScoped
public class GhostNetFishing {
    
    private final GeisternetzDAO geisternetzDAO;
    //private final PersonDAO personDAO;
    private final StandortDAO standortDAO;
    

    public GhostNetFishing(){
        this.geisternetzDAO = new GeisternetzDAO();
        this.standortDAO = new StandortDAO();
        
        /*  //deprecated test-instances
        ArrayList<Geisternetz> testListe = new ArrayList<>();
        testNetz = new Geisternetz(
                new Standort("46°14′06.70″N", "8°0′55.60″O"), "ca. 10m",NetzStatus.GEMELDET, null);
        testListe.add(testNetz);
        gemeldeteGeisternetze = testListe;
        */
    }
    
    
    //should work
    public void addGeisternetz(Geisternetz geisternetz){
        standortDAO.add(geisternetz.getStandort());
        geisternetzDAO.add(geisternetz);
    }
    
    
    // getter & setter
    public List<Geisternetz> getGemeldeteGeisternetze() {
        return geisternetzDAO.findeGemeldete();
    }
}