package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import peaksoft.entity.User;

import java.awt.*;
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
public class ResponseCarInnerPage {
   private LocalDate year_of_issue;
   private String  engine;
   private String  color;
   private BigDecimal price;
   private LocalDate created_at;
   private User owner;
   private String phone_number;
}
