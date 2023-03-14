package peaksoft.service;

import peaksoft.dto.request.CarRequest;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;

import java.util.List;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
public interface CarService {
    List<ResponseCarsPage> getAllCarsByUserid(Long id);

    void saveCar(Long id, CarRequest carRequest);

    List<ResponseCarsPage> getAllCars();

    ResponseCarInnerPage getCarsById(Long id);

    void updateCar(Long userId, Long id, CarRequest carRequest);

    void deleteById(Long id);
}
