package bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
    @JoinTable(
        	name = "link_panel_hotel",
        	joinColumns= @JoinColumn(name="id_hotel"), 
        	inverseJoinColumns = @JoinColumn(name="id_panel")
        )
    private Collection<Panel> panels;

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

	public Collection<Panel> getPanels() {
		return panels;
	}

	public void setPanels(Collection<Panel> panels) {
		this.panels = panels;
	}

    
}
