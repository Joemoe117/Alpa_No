package bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
@Table(name = "panel")
public class Panel {
	
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "date_begin")
    private Timestamp dateBegin;
    
    @Column(name = "date_end")
    private Timestamp dateEnd;
    
    @OneToMany()
    @JoinColumn(name = "id_panel")
    private Collection<LinkPanelHotel> panels;
    
    @ManyToOne
    @JoinColumn(name = "id_flight", referencedColumnName = "id", nullable = false)
    private Flight flight;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Timestamp getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Timestamp dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Collection<LinkPanelHotel> getPanels() {
        return panels;
    }

    public void setPanels(Collection<LinkPanelHotel> panels) {
        this.panels = panels;
    }

    @ManyToOne
    @JoinColumn(name = "id_flight", referencedColumnName = "id", nullable = false)
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
