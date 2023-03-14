package peaksoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Role;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Getter
@Setter
@AllArgsConstructor
public class UserRequest {
    private String email;
    private String password;
    private Role role;
    private String phoneNumber;
}
