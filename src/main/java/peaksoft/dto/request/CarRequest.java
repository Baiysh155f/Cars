package peaksoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entity.User;
import peaksoft.enums.Brand;
import peaksoft.enums.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Getter
@Setter
@AllArgsConstructor
public class CarRequest {
    private LocalDate year_of_issue;
    private String  engine;
    private String  color;
    private BigDecimal price;
    private LocalDate created_at;
    private Model model;
    private Brand brand;
    private User owner;
    private String phone_number;
}
