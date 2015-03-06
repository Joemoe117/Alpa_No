package bean;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
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
