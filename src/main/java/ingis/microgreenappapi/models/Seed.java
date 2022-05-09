package ingis.microgreenappapi.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Seed {

    @Id
    @GeneratedValue
//    @ManyToMany
    private int seedId;
    private static int nextId = 1;

    @NotBlank
    @Size(max = 50, message = "Name too long!")
    private String seedName;
    private Integer seedingDensity;
    private Boolean seedPresoak;
    private Integer blackoutTime;
    private Integer harvestTime;
    private Integer lot;
    private Integer qty;
    private String status;

    public Seed(String seedName, Integer seedingDensity, Boolean seedPresoak,  Integer blackoutTime, Integer harvestTime, Integer lot ,Integer qty, String status) {

        this.seedName = seedName;
        this.seedingDensity = seedingDensity;
        this.seedPresoak = seedPresoak;
        this.blackoutTime = blackoutTime;
        this.harvestTime = harvestTime;
        this.qty = qty;
        this.lot = lot;
        this.status = status;
        this.seedId = nextId;
        nextId++;
    }

    // model for inventory page
    public Seed() {}

    public Seed(String seedName, Integer qty, Integer lot, String status ) {
        this.seedName = seedName;
        this.qty = qty;
        this.lot = lot;
        this.status = status;

    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    public Integer getSeedingDensity() {
        return seedingDensity;
    }

    public void setSeedingDensity(Integer seedingDensity) {
        this.seedingDensity = seedingDensity;
    }

    public Boolean getSeedPresoak() {
        return seedPresoak;
    }

    public void setSeedPresoak(Boolean seedPresoak) {
        this.seedPresoak = seedPresoak;
    }

    public Integer getBlackoutTime() {
        return blackoutTime;
    }

    public void setBlackoutTime(Integer blackoutTime) {
        this.blackoutTime = blackoutTime;
    }

    public Integer getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(Integer harvestTime) {
        this.harvestTime = harvestTime;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return seedId;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "seedId=" + seedId +
                ", seedName='" + seedName + '\'' +
                ", seedingDensity=" + seedingDensity +
                ", seedPresoak=" + seedPresoak +
                ", blackoutTime=" + blackoutTime +
                ", harvestTime=" + harvestTime +
                ", qty=" + qty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seed seed = (Seed) o;
        return seedId == seed.seedId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seedId);
    }

}
