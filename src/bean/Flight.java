package bean;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
@Table(name = "flight")
public class Flight {
	
    @Id
    @Column(name = "id")
    private int id;
    
    @Basic
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "id_plane", referencedColumnName = "id", nullable = false)
    private Plane plane;
    
    @OneToMany(mappedBy = "panels")
    private Collection<Panel> panels;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Plane getPlaneByIdPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Collection<Panel> getPanelsById() {
        return panels;
    }

    public void setPanels(Collection<Panel> panels) {
        this.panels = panels;
    }
}
