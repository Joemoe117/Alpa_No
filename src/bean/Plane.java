package bean;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
public class Plane {
    private int id;
    private String name;
    private Collection<Flight> flightsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (id != plane.id) return false;
        if (name != null ? !name.equals(plane.name) : plane.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "planeByIdPlane")
    public Collection<Flight> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(Collection<Flight> flightsById) {
        this.flightsById = flightsById;
    }
}
