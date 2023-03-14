package peaksoft.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.ResponseCarsPage;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;
import peaksoft.entity.User;
import peaksoft.repository.CarRepository;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

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
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.getAllUser();
    }

    @Override
    public UserResponseProfile getUsers(Long id) {
        UserResponseProfile userResponseProfile = userRepository.getUsers(id)
                .orElseThrow(() -> new NoSuchElementException("this id = " + id + " not found"));
        List<ResponseCarsPage> allCars = carRepository.getAllCarsByUserId(id);
        userResponseProfile.setCarsPages(allCars);
        return userResponseProfile;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setRole(userRequest.getRole());
        userRepository.save(user);
        return new UserResponse(user.getEmail(), user.getPhoneNumber());
    }

    @Override
    public UserResponse getById(Long id) {
        return userRepository.getUserById(id)
                .orElseThrow(()-> new NoSuchElementException("this id = "+id+" not found"));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("this id = " + id + " not found"));
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setRole(userRequest.getRole());
        userRepository.save(user);
        return new UserResponse(user.getEmail(),user.getPhoneNumber());
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        userRepository.deleteById(id);
        return new SimpleResponse( "Deleted","this id = "+id+" successfully deleted...");
    }

}
