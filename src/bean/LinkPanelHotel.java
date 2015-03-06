package bean;

import javax.persistence.*;

/**
 * @author baptiste
 * @version 1.0
 * @date 06/02/15
 */
@Entity
@Table(name = "link_panel_hotel", schema = "", catalog = "alpa_no")
public class LinkPanelHotel {
	
    @Id
    @Column(name = "id")
	private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id", nullable = false)
    private Hotel hotel;
    
    @ManyToOne
    @JoinColumn(name = "id_panel", referencedColumnName = "id", nullable = false)
    private Panel panel;

    public Hotel getHotelByIdHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }
}