
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named
@ApplicationScoped
public class GhostNetFishing {
    
    private GeisternetzDAO geisternetzDAO;
    //private PersonDAO personDAO;
    private StandortDAO standortDAO;
    
    
    //primitive Testing
    private Geisternetz testNetz;
    
    private List<Geisternetz> gemeldeteGeisternetze;
    //private Geisternetz testNetz;

    public List<Geisternetz> getGemeldeteGeisternetze() {
        return gemeldeteGeisternetze;
    }

    public void setGemeldeteGeisterNetze(List<Geisternetz> gemeldeteGeisternetze) {
        this.gemeldeteGeisternetze = gemeldeteGeisternetze;
    }

    public GhostNetFishing(){
        this.geisternetzDAO = new GeisternetzDAO(); //IMPORTANT
        this.standortDAO = new StandortDAO(); //IMPORTANT
        
        ArrayList<Geisternetz> testListe = new ArrayList<>();
        testNetz = new Geisternetz(
                new Standort("46°14′06.70″N", "8°0′55.60″O"), "ca. 10m",NetzStatus.GEMELDET, null);
        testListe.add(testNetz);
        gemeldeteGeisternetze = testListe;
    }
    
    public void addTestnetz(){
        standortDAO.add(testNetz.getStandort());
        geisternetzDAO.add(testNetz);
    }
}