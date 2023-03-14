package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Brand;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Entity
@Table(name = "car_info")
@Getter
@Setter
@NoArgsConstructor
public class CarInfo {
    @Id
    @SequenceGenerator(name = "car_info_id_gen",sequenceName = "car_info_id_seq",allocationSize = 1)
    @GeneratedValue(generator = "car_info_id_gen",strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate yearOfIssue;
    private String engine;
    private String color;
    private BigDecimal price;
    @OneToOne(mappedBy = "carInfo")
    private Car car;
}
