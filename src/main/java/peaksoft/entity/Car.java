package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Brand;
import peaksoft.enums.Model;

import java.time.LocalDate;

/**
 * Cars
 * 2023
 * macbook_pro
 **/
@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_id_gen",
            sequenceName = "car_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            generator = "car_id_gen",
            strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    @Enumerated(EnumType.STRING)
    private Model model;
    @OneToOne(cascade = CascadeType.ALL)
    private CarInfo carInfo;
    private LocalDate createAt;
    @ManyToOne()
    private User user;
}
