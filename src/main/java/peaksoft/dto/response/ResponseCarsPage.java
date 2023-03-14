package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.Banner;
import peaksoft.enums.Brand;
import peaksoft.enums.Model;

import java.time.LocalDate;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Getter
@Setter
@AllArgsConstructor
public class ResponseCarsPage {
  private Brand brand;
  private Model model;
  private LocalDate year_of_issue;
}
