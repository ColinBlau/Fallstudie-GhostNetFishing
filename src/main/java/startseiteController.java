
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * Im <code>StartseiteController</code>-Objekt sind die Funktionen gekapselt,
 * die die Datenstruktur der Webseite beeinflusst,
 * die von der Startseite <code>index.xhtml</code> aufgerufen werden können.
 * </p>
 * <p>
 * Weil die <code>startseiteController</code> <code>@ViewScoped</code> ist,
 * wird jedem Nutzer der Webseite ein eigenes Objekt zugeordnet,
 * sodass mehrere Nutzer synchron die Webseite verwenden können.
 * Ansonsten würden sich die Nutzereingaben verschiedener Nutzer überschneiden
 * und unvorhergesehenes Verhalten der Webseite mit sich bringen.
 * </p>
 * @author colin
 */
@Named
@ViewScoped
public class startseiteController implements Serializable {
    
    /**
     * Verweis auf das <code>GhostNetFishing</code> Service-Objekt der Webseite
     */
    @Inject
    private GhostNetFishing ghostNetFishing;
    
    public startseiteController() {
    }
    
    
    /**
     * Leitet an die Seite <code>geisternetzMelden</code> weiter,
     * indem ein String ausgegeben wird der auf die Seite verweist.
     * @return  String mit dem Wert <code>"geisternetzMelden"</code>.
     */
    public String geisternetzMelden(){
        return "geisternetzMelden";
    }
    
    /**
     * Leitet ein <code>Geisternetz</code>-Objekt an das Service-Objekt <code>ghostNetFishing</code> weiter,
     * dessen <code>NetzStatus</code> auf <code>NetzStatus.GEBORGEN</code> gesetzt werden soll.
     * @param geisternetz  <code>Geisternetz</code>-Objekt dessen <code>NetzStatus</code>
     * auf <code>NetzStatus.GEBORGEN</code> gesetzt werden soll.
     */
    public void alsGeborgenMelden(Geisternetz geisternetz){
        ghostNetFishing.alsGeborgenMelden(geisternetz);
    }
    
    /**
     * Leitet ein <code>Geisternetz</code>-Objekt an das Service-Objekt <code>ghostNetFishing</code> weiter,
     * dessen <code>NetzStatus</code> auf <code>NetzStatus.VERSCHOLLEN</code> gesetzt werden soll.
     * @param geisternetz  <code>Geisternetz</code>-Objekt dessen <code>NetzStatus</code>
     * auf <code>NetzStatus.VERSCHOLLEN</code> gesetzt werden soll.
     */
    public void alsVerschollenMelden(Geisternetz geisternetz){
        ghostNetFishing.alsVerschollenMelden(geisternetz);
    }
    
    
    
    /**
     * Ruft lediglich die Methode <code>getGemeldeteGeisternetze()</code> des Service-Objekts
     * von <code>GhostNetFishing</code> auf und gibt die gleich Liste aus.
     * @return Liste aller <code>Geisternetz</code>-Objekte
     * mit der <code>NetzStatus</code> Ausprägung <code>NetzStatus.GEMELDET</code>.
     */
    public List<Geisternetz> getZuGemeldeteGeisternetze(){
        return ghostNetFishing.getGemeldeteGeisternetze();
    }
    
    /**
     * Ruft lediglich die Methode <code>getZuBergendeGeisternetze()</code> des Service-Objekts
     * von <code>GhostNetFishing</code> auf und gibt die gleich Liste aus.
     * @return Liste aller <code>Geisternetz</code>-Objekte
     * mit der <code>NetzStatus</code> Ausprägung <code>NetzStatus.BERGUNG_BEVORSTEHEND</code>.
     */
    public List<Geisternetz> getZuBergendeGeisternetze(){
        return ghostNetFishing.getZuBergendeGeisternetze();
    }
}
