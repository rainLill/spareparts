package ee.rlservice.spareparts.service;

import ee.rlservice.spareparts.entity.Unit;
import ee.rlservice.spareparts.model.UnitDTO;

import java.math.BigInteger;
import java.util.List;

public interface UnitService {

    List<UnitDTO> getAllUnits();

    UnitDTO getUnit(BigInteger unitId);

    List<UnitDTO> changeUnit(Unit unit);

    List<UnitDTO> deleteUnit(BigInteger unitId);

    List<UnitDTO> addUnit(Unit unit);

}
