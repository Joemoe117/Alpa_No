package bean;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
public class Flight {
    private int id;
    private int idPlane;
    private String description;
    private Plane planeByIdPlane;
    private Collection<Panel> panelsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_plane")
    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (id != flight.id) return false;
        if (idPlane != flight.idPlane) return false;
        if (description != null ? !description.equals(flight.description) : flight.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPlane;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_plane", referencedColumnName = "id", nullable = false)
    public Plane getPlaneByIdPlane() {
        return planeByIdPlane;
    }

    public void setPlaneByIdPlane(Plane planeByIdPlane) {
        this.planeByIdPlane = planeByIdPlane;
    }

    @OneToMany(mappedBy = "flightByIdFlight")
    public Collection<Panel> getPanelsById() {
        return panelsById;
    }

    public void setPanelsById(Collection<Panel> panelsById) {
        this.panelsById = panelsById;
    }
}
