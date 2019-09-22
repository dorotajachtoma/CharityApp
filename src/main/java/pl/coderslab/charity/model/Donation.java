package pl.coderslab.charity.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String quantity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="categories_id")
    private Set<Category> categories = new HashSet<>();

    @OneToOne
    private Institution institution;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @Column(name = "pick_up_time")
    private String pickUpTime;

    @NotBlank
    @Column(name = "comment")
    private String pickUpComment;

}
