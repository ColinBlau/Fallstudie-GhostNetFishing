
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;


/**
 * Klasse des zentralen Service-Objekt der Webseite
 * @author colin
 */
@Named
@ApplicationScoped
public class GhostNetFishing {
    
    private final GeisternetzDAO geisternetzDAO;
    //private final PersonDAO personDAO;
    private final StandortDAO standortDAO;
    

    public GhostNetFishing(){
        this.geisternetzDAO = new GeisternetzDAO();
        this.standortDAO = new StandortDAO();
        
        //getZuBergendeGeisternetze().get(0).setBergendePerson(new Person("Max Mustermann","+49 1395 2671240"));
        /*  //deprecated test-instances
        ArrayList<Geisternetz> testListe = new ArrayList<>();
        testNetz = new Geisternetz(
                new Standort("46°14′06.70″N", "8°0′55.60″O"), "ca. 10m",NetzStatus.GEMELDET, null);
        testListe.add(testNetz);
        gemeldeteGeisternetze = testListe;
        */
    }
    
    /**
     * Gibt das durchgegebene <code>Geisternetz</code>-Objekt weiter an das <code>GeisternetzDAO</code>-Objekt,
     * um zur Datenbank hinzugefügt zu werden.
     * Davor muss hier dafür zusätzlich das gleiche mit dem zugehörigen <code>Standort</code>-Objekt durchgeführt werden.
     * @param geisternetz 
     */
    public void addGeisternetz(Geisternetz geisternetz){
        standortDAO.add(geisternetz.getStandort());
        geisternetzDAO.add(geisternetz);
    }
    
    /**
     * Setzt den <code>NetzStatus</code> des durchgegebenen <code>Geisternetz</code>-Objektes
     * auf <code>NetzStatus.GEBORGEN</code> und gibt dieses weiter an das <code>GeisternetzDAO</code>-Objekt
     * um in der Datenbank aktualiersiert werden zu können.
     * @param geisternetz das zu bearbeitende <code>Geisternetz</code>-Objekt
     */
    public void alsGeborgenMelden(Geisternetz geisternetz){
        geisternetz.setStatus(NetzStatus.GEBORGEN);
        geisternetzDAO.save(geisternetz);
    }
    
    /**
     * Setzt den <code>NetzStatus</code> des durchgegebenen <code>Geisternetz</code>-Objektes
     * auf <code>NetzStatus.VERSCHOLLEN</code> und gibt dieses weiter an das <code>GeisternetzDAO</code>-Objekt
     * um in der Datenbank aktualiersiert werden zu können.
     * @param geisternetz das zu bearbeitende <code>Geisternetz</code>-Objekt
     */
    public void alsVerschollenMelden(Geisternetz geisternetz){
        geisternetz.setStatus(NetzStatus.VERSCHOLLEN);
        geisternetzDAO.save(geisternetz);
    }
    
    
    
    // getter & setter
    
    /**
     * Ruft <code>findeGemeldete()</code> des <code>GeisternetzDAO</code>-Objekts auf
     * und gibt die erhaltene Liste aus.
     * @return Liste aller <code>Geisternetz</code>-Objekte
     * mit der <code>NetzStatus</code> Ausprägung <code>NetzStatus.GEMELDET</code>.
     */
    public List<Geisternetz> getGemeldeteGeisternetze() {
        return geisternetzDAO.findeGemeldete();
    }
    
    /**
     * Ruft <code>findeZuBergende()</code> des <code>GeisternetzDAO</code>-Objekts auf
     * und gibt die erhaltene Liste aus.
     * @return Liste aller <code>Geisternetz</code>-Objekte
     * mit der <code>NetzStatus</code> Ausprägung <code>NetzStatus.BERGUNG_BEVORSTEHEND</code>.
     */
    public List<Geisternetz> getZuBergendeGeisternetze(){
        return geisternetzDAO.findeZuBergende();
    }
    
}