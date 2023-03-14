package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.CarRequest;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.entity.Car;
import peaksoft.entity.CarInfo;
import peaksoft.entity.User;
import peaksoft.repository.CarInfoRepository;
import peaksoft.repository.CarRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.CarService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final CarInfoRepository carInfoRepository;

    public CarServiceImpl(CarRepository carRepository, UserRepository userRepository, CarInfoRepository carInfoRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.carInfoRepository = carInfoRepository;
    }

    @Override
    public List<ResponseCarsPage> getAllCarsByUserid(Long id) {
        return carRepository.getAllCarsByUserId(id);
    }

    @Override
    public void saveCar(Long id, CarRequest carRequest) {
        CarInfo carInfo = new CarInfo();
        Car car = new Car();
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("this id = " + id + " not found"));
        car.setModel(carRequest.getModel());
        car.setBrand(carRequest.getBrand());
        car.setUser(user);
        car.setCreateAt(LocalDate.now());

        carInfo.setPrice(carRequest.getPrice());
        carInfo.setColor(carRequest.getColor());
        carInfo.setYearOfIssue(carRequest.getYear_of_issue());
        carInfo.setEngine(carRequest.getEngine());

        carInfo.setCar(car);
        car.setCarInfo(carInfo);
        carRepository.save(car);
        carInfoRepository.save(carInfo);
    }

    @Override
    public List<ResponseCarsPage> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public ResponseCarInnerPage getCarsById(Long id) {
        return carRepository.getCarsById(id).orElseThrow(()-> new NoSuchElementException("this id = " + id + " not found"));
    }

    @Override
    public void updateCar(Long userId, Long id, CarRequest carRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("this id = " + id + " not found"));
        CarInfo carInfo = new CarInfo();
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("this id = " + id + " not found"));
        car.setModel(carRequest.getModel());
        car.setBrand(carRequest.getBrand());
        car.setUser(user);
        car.setCreateAt(LocalDate.now());

        carInfo.setPrice(carRequest.getPrice());
        carInfo.setColor(carRequest.getColor());
        carInfo.setYearOfIssue(carRequest.getYear_of_issue());
        carInfo.setEngine(carRequest.getEngine());

        carInfo.setCar(car);
        car.setCarInfo(carInfo);
        carRepository.save(car);
        carInfoRepository.save(carInfo);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
