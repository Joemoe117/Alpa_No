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
	
    @Id
    @Column(name = "id")
    private int id;
    
    @Basic
    @Column(name = "name")
    private String name;
    
    @OneToMany
    @JoinColumn(name = "id_plane")
    private Collection<Flight> flights;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Collection<Flight> getFlightsById() {
        return flights;
    }

    public void setFlightsById(Collection<Flight> flights) {
        this.flights = flights;
    }
}
