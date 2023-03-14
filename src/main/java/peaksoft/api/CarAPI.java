package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CarRequest;
import peaksoft.dto.response.ResponseCarInnerPage;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.entity.Car;
import peaksoft.service.CarService;

import java.util.List;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarAPI {
    private final CarService carService;
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @GetMapping()
    public List<ResponseCarsPage> getAllCarsByUserid(){
        return carService.getAllCars();
    }
    @PreAuthorize("hasAnyAuthority('VENDOR','ADMIN')")
    @PostMapping("/{id}/save")
    public SimpleResponse saveCars(@PathVariable Long id, @RequestBody CarRequest carRequest){
        carService.saveCar(id,carRequest);
        return new SimpleResponse("SAVED","this Cars saved..");
    }
    @PreAuthorize("hasAnyAuthority('VENDOR','ADMIN')")
    @GetMapping("/{id}")
    private ResponseCarInnerPage findById(@PathVariable Long id){
        return carService.getCarsById(id);
    }
    @PreAuthorize("hasAnyAuthority('VENDOR','ADMIN')")
    @PutMapping("/{id}/update")
    public SimpleResponse updateCars(@PathVariable Long id,Long userid, @RequestBody CarRequest carRequest) {
        carService.updateCar(userid, id, carRequest);
        return new SimpleResponse("Updated", "this Cars updated..");
    }
    @PreAuthorize("hasAnyAuthority('VENDOR','ADMIN')")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteById(@PathVariable Long id){
        carService.deleteById(id);
        return new SimpleResponse("Deleted","this id ="+id+" deleted in database..");
    }
}
