package ingis.microgreenappapi.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class PlantingMedium {
    @Id
    @GeneratedValue
    private int mediumId;
    private static int nextId = 1;

    @Size(max = 50, message = "Description to long!")
    private String mediumType;

    private Integer qty;


//    @OneToMany
//    private Tray TrayId;

    public PlantingMedium(String mediumType, Integer qty, Tray trayId) {
        this.mediumType = mediumType;
        this.qty = qty;
        this.mediumId = nextId;
        nextId++;
    }

    public PlantingMedium() {}

    public String getMediumType() {
        return mediumType;
    }

    public void setMediumType(String mediumType) {
        this.mediumType = mediumType;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

//    public Tray getTrayId() {
//        return TrayId;
//    }
//
//    public void setTrayId(Tray trayId) {
//        TrayId = trayId;
//    }

    public int getMediumId() {
        return mediumId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantingMedium that = (PlantingMedium) o;
        return mediumId == that.mediumId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediumId);
    }

    @Override
    public String toString() {
        return "PlantingMedium{" +
                "mediumType='" + mediumType + '\'' +
                '}';
    }
}
