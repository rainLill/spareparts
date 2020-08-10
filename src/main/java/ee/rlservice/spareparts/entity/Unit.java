package ee.rlservice.spareparts.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigInteger;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @DecimalMin(value = "1")
    private BigInteger id;
    @Length(max = 5)
    private String unitName;
    private Boolean active;

    public Unit() {
    }

    public Unit(BigInteger id, String unitName, Boolean active) {
        this.id = id;
        this.unitName = unitName;
        this.active = active;
    }

    public BigInteger getId() {
        return id;
    }

    public Unit setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public Unit setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public Unit setActive(Boolean active) {
        this.active = active;
        return this;
    }
}
