package ee.rlservice.spareparts.repository;

import ee.rlservice.spareparts.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UnitRepository extends JpaRepository<Unit, BigInteger> {
    Unit findFirstByOrderByIdDesc();
}
