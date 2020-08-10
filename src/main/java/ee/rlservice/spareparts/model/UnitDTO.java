package ee.rlservice.spareparts.model;

import java.math.BigInteger;

public class UnitDTO {

    private BigInteger id;
    private String unitName;
    private boolean active;

    public BigInteger getId() {
        return id;
    }

    public UnitDTO setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public UnitDTO setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public UnitDTO setActive(boolean active) {
        this.active = active;
        return this;
    }
}
