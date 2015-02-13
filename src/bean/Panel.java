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
    private int idFlight;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private Collection<LinkPanelHotel> linkPanelHotelsById;
    private Flight flightByIdFlight;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_flight")
    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Panel panel = (Panel) o;

        if (id != panel.id) return false;
        if (idFlight != panel.idFlight) return false;
        if (dateBegin != null ? !dateBegin.equals(panel.dateBegin) : panel.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(panel.dateEnd) : panel.dateEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idFlight;
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "panelByIdPanel")
    public Collection<LinkPanelHotel> getLinkPanelHotelsById() {
        return linkPanelHotelsById;
    }

    public void setLinkPanelHotelsById(Collection<LinkPanelHotel> linkPanelHotelsById) {
        this.linkPanelHotelsById = linkPanelHotelsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_flight", referencedColumnName = "id", nullable = false)
    public Flight getFlightByIdFlight() {
        return flightByIdFlight;
    }

    public void setFlightByIdFlight(Flight flightByIdFlight) {
        this.flightByIdFlight = flightByIdFlight;
    }
}
