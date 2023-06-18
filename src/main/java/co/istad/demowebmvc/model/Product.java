package co.istad.demowebmvc.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    @NotBlank
    @Size(min = 4,max = 30)
    private String name;
    @NotBlank
    private String description;
    @NotNull
    @Positive
    @Max(value = 10000)
    private Double price;

}
