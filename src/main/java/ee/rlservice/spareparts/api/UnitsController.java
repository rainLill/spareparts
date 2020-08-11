package ee.rlservice.spareparts.api;

import ee.rlservice.spareparts.entity.Unit;
import ee.rlservice.spareparts.model.UnitDTO;
import ee.rlservice.spareparts.service.UnitService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("settings/units")
@Validated
public class UnitsController {

    UnitService unitService;

    public UnitsController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping()
    public List<UnitDTO> getAllUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("unit")
    public UnitDTO geUnit(@RequestParam("unit") @DecimalMin(value = "1", message = "Unit ID value must be 1 or greater") BigInteger unitId) {
        return unitService.getUnit(unitId);
    }

    @PostMapping()
    public List<UnitDTO> addUnit(@Valid @RequestBody Unit unit) {
        return unitService.addUnit(unit);
    }

    @PutMapping()
    public List<UnitDTO> changeUnit(@RequestBody Unit unit) {
        return unitService.changeUnit(unit);
    }

    @DeleteMapping()
    public List<UnitDTO> deleteUnit(@RequestParam("unitId") BigInteger unitId) {
        return unitService.deleteUnit(unitId);
    }
}
