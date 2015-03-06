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
public class Panel {
    private int id;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private Collection<LinkPanelHotel> panels;
    private Flight flight;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_begin")
    public Timestamp getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Timestamp dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Basic
    @Column(name = "date_end")
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    @OneToMany()
    @JoinColumn(name = "id_flight")
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
