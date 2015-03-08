package bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
    @Column(name = "id")
    private int id;
    
    @Basic
    @Column(name = "name")
    private String name;
    
    @OneToMany
    @JoinColumn(name = "id_hotel")
    private Collection<LinkPanelHotel> panels;

    /**
     * Default constructor
     */
    public Hotel(){
    	panels = new ArrayList<>();
    }
    
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

    public Collection<LinkPanelHotel> getLinkPanelHotels() {
        return panels;
    }

    public void setLinkPanelHotels(Collection<LinkPanelHotel> panels) {
        this.panels = panels;
    }
}
