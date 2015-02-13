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
    private int idPanel;
    private int idHotel;
    private Hotel hotelByIdHotel;
    private Panel panelByIdPanel;

    @Basic
    @Column(name = "id_panel")
    public int getIdPanel() {
        return idPanel;
    }

    public void setIdPanel(int idPanel) {
        this.idPanel = idPanel;
    }

    @Basic
    @Column(name = "id_hotel")
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id", nullable = false)
    public Hotel getHotelByIdHotel() {
        return hotelByIdHotel;
    }

    public void setHotelByIdHotel(Hotel hotelByIdHotel) {
        this.hotelByIdHotel = hotelByIdHotel;
    }

    @ManyToOne
    @JoinColumn(name = "id_panel", referencedColumnName = "id", nullable = false)
    public Panel getPanelByIdPanel() {
        return panelByIdPanel;
    }

    public void setPanelByIdPanel(Panel panelByIdPanel) {
        this.panelByIdPanel = panelByIdPanel;
    }

    private String id;

}
