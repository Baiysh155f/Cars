package peaksoft.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.UserResponse;
import peaksoft.dto.response.UserResponseProfile;
import peaksoft.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select new peaksoft.dto.response.UserResponse(u.email, u.phoneNumber)from User u")
    List<UserResponse> getAllUser();
    @Query("select new peaksoft.dto.response.UserResponse(u.email,u.phoneNumber)from User u where u.id = ?1")
    Optional<UserResponse> getUserById(Long id);
    Optional<User> findByEmail(String email);
    @Query("select new peaksoft.dto.response.UserResponseProfile(u.email, u.phoneNumber)from User u where u.id= ?1")
    Optional<UserResponseProfile> getUsers(Long id);
}
