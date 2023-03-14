package peaksoft.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.entity.Car;

import java.util.List;
import java.util.Optional;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
/**
 * private LocalDate year_of_issue;
 *    private String  engine;
 *    private String  color;
 *    private BigDecimal price;
 *    private LocalDate created_at;
 *    private User owner;
 *    private String phone_number;**/
@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("select new peaksoft.dto.response.ResponseCarsPage(c.brand,c.model,c.carInfo.yearOfIssue) from User u join u.cars c where u.id = ?1")
    List<ResponseCarsPage> getAllCarsByUserId(Long userId);

    @Query("select new peaksoft.dto.response.ResponseCarsPage(c.brand,c.model,c.carInfo.yearOfIssue) from Car c")
    List<ResponseCarsPage> getAllCars();
    @Query("select new peaksoft.dto.response.ResponseCarInnerPage(c.carInfo.yearOfIssue,c.carInfo.engine,c.carInfo.color,c.carInfo.price,c.createAt,c.user,c.user.phoneNumber) from Car c where c.id = ?1")
    Optional<ResponseCarInnerPage> getCarsById(Long id);
}
