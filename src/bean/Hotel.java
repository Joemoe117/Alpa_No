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
    private int id;
    private String name;
    private Collection<LinkPanelHotel> linkPanelHotelsById;

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

        Hotel hotel = (Hotel) o;

        if (id != hotel.id) return false;
        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "hotelByIdHotel")
    public Collection<LinkPanelHotel> getLinkPanelHotelsById() {
        return linkPanelHotelsById;
    }

    public void setLinkPanelHotelsById(Collection<LinkPanelHotel> linkPanelHotelsById) {
        this.linkPanelHotelsById = linkPanelHotelsById;
    }
}
