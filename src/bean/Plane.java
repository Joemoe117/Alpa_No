package bean;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
@Table(name = "plane")
public class Plane {
	
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany
    @JoinTable(
    		name = "flight",
    		joinColumns = @JoinColumn(name = "id_plane"),
    		inverseJoinColumns = @JoinColumn(name= "id")
    		)
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
    
    public Collection<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }
}
