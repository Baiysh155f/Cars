package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;
import peaksoft.repository.UserRepository;
import peaksoft.service.UserService;

import java.util.List;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public UserResponse saveUser(@RequestBody UserRequest userRequest){
       return userService.saveUser(userRequest);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id,@RequestBody UserRequest userRequest){
        return userService.updateUser(id,userRequest);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        return userService.getById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return userService.deleteById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}/profile")
    public UserResponseProfile profile(@PathVariable Long id){
        return userService.getUsers(id);
    }
}
