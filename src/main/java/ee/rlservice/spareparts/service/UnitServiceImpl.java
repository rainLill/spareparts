package ee.rlservice.spareparts.service;

import ee.rlservice.spareparts.entity.Unit;
import ee.rlservice.spareparts.model.UnitDTO;
import ee.rlservice.spareparts.repository.UnitRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitServiceImpl implements UnitService{

    Logger log = LoggerFactory.getLogger(this.getClass());

    UnitRepository unitRepository;
    ModelMapper modelMapper;

    public UnitServiceImpl(UnitRepository unitRepository, ModelMapper modelMapper) {
        this.unitRepository = unitRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UnitDTO> getAllUnits() {

        List<UnitDTO> unitDTOList;
        unitDTOList = unitRepository.findAll()
                .stream()
                .map(unit -> modelMapper.map(unit, UnitDTO.class))
                .collect(Collectors.toList());
        log.info("Unit list generated");
        return unitDTOList;
    }

    @Override
    public UnitDTO getUnit(BigInteger unitId) {
        Optional<Unit> currentUnit;
        currentUnit = unitRepository.findById(unitId);

        if (currentUnit.isPresent()) {
            UnitDTO result;
            result = modelMapper.map(currentUnit.get(), UnitDTO.class);

            return result;
        }
// TODO: Log no units found!
        return null;
    }

    @Override
    public List<UnitDTO> changeUnit(Unit unit) {
        unitRepository.save(unit);
        return getAllUnits();
    }

    @Override
    public List<UnitDTO> deleteUnit(BigInteger unitid) {
        Optional<Unit> currentUnit;
        currentUnit = unitRepository.findById(unitid);

        if (currentUnit.isPresent()) {
            Unit updatedUnit;
            updatedUnit = currentUnit.get()
                    .setActive(false);
            unitRepository.save(updatedUnit);
            return getAllUnits();
            //TODO: Log unit deleted
        }

        //TODO: Log unit delete failed!

        return getAllUnits();
    }

    @Override
    public List<UnitDTO> addUnit(Unit unit) {
        unitRepository.save(unit);
        return getAllUnits();
    }
}
