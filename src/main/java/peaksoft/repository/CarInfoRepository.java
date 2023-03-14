package peaksoft.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Car;
import peaksoft.entity.CarInfo;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Repository
@Transactional
public interface CarInfoRepository extends JpaRepository<CarInfo,Long> {
}
