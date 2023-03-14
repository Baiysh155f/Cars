package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Getter
@Setter
public class UserResponseProfile {
    private String email;
    private String phone_number;
    private List<ResponseCarsPage> carsPages;

    public UserResponseProfile(String email, String phone_number) {
        this.email = email;
        this.phone_number = phone_number;
    }
}
