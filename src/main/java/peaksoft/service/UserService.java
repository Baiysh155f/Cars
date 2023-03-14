package peaksoft.service;

import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;

import java.util.List;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponseProfile getUsers(Long id);
    UserResponse saveUser(UserRequest userRequest);

    UserResponse getById(Long id);

    UserResponse updateUser(Long id, UserRequest userRequest);

    SimpleResponse deleteById(Long id);
}
