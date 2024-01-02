
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * <p>
 * Im <code>geisternetzMeldenController</code>-Objekt sind die Funktionen gekapselt,
 * die die Datenstruktur der Webseite beeinflusst,
 * die von der Seite <code>geisternetzMelden.xhtml</code> aufgerufen werden können.
 * </p>
 * <p>
 * Weil die <code>startseiteController</code> <code>@ViewScoped</code> ist,
 * wird jedem Nutzer der Webseite ein eigenes Objekt zugeordnet,
 * sodass mehrere Nutzer synchron die Webseite verwenden können.
 * Ansonsten würden sich die Nutzereingaben verschiedener Nutzer überschneiden
 * und unvorhergesehenes Verhalten der Webseite mit sich bringen.
 * </p>
 * 
 * @author colin
 */
@Named
@ViewScoped
public class GeisternetzMeldenController implements Serializable {
    
    /**
     * Hier neu erzeugtes <code>Geisternetz</code>-Objekt,
     * worin die Nutzereingaben von der <code>geisternetzMelden</code>-Seite gespeichert werden.
     */
    private Geisternetz neuesGeisternetz;
    /**
     * Hier neu erzeugtes <code>Standort</code>-Objekt,
     * worin dementsprechende Nutzereingaben von der <code>geisternetzMelden</code>-Seite gespeichert werden.
     */
    private Standort neuerStandort;
    
    /**
     * Verweis auf das <code>GhostNetFishing</code> Service-Objekt der Webseite
     */
    @Inject
    private GhostNetFishing ghostNetFishing;
    
    
    
    /**
     * Erzeugt bei Initialisierung ein neues <code>Geisternetz</code>-Objekt,
     * mit den hier definierten default-Werten für neue zu meldende Geisternetze
     * mit dem zugehörigen <code>Standort</code>-Objekt.
     */
    public GeisternetzMeldenController(){
        neuerStandort = new Standort();
        neuesGeisternetz = new Geisternetz(neuerStandort, "", NetzStatus.GEMELDET, null);
    }
    
    
    
    /**
     * Leitet an die Startseite <code>index.xhtml</code> zurück,
     * indem ein String mit dem Verweis auf die Seite zurückgegeben wird.
     * @return String mit dem Verweis auf die Startseite; mit dem Wert <code>"index.xhtml"</code>.
     */
    public String startseite(){
        return "index.xhtml";
    }
    
    /**
     * <p>
     * Leitet das in dieser Klasse erzeugte <code>Geisternetz</code>-Objekt
     * <code>neuesGeisternetz</code> an das Service-Objekt <code>ghostNetFishing</code> weiter,
     * damit es zur Datenbank hinzugefügt werden kann.
     * </p>
     * <p>
     * Im Anschluss wird nach der <code>startseite()</code>-Methode zur Startseite zurückgekehrt.
     * </p>
     * @return String mit dem Verweis auf die Startseite
     */
    public String add(){
        ghostNetFishing.addGeisternetz(neuesGeisternetz);
        return startseite();
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
