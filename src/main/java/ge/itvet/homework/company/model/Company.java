package ge.itvet.homework.company.model;


import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class Company {
    private Long id;

    @NotBlank(message = "ბიზნეს სფერო არ უნდა იყოს ცარიელი")
    private String sphere;

    @NotBlank(message = "სახელწოდება არ უნდა იყოს ცარიელი")
    private String name;

    @Email(message = "მეილი უნდა იყოს სწორი ფორმატის")
    private String mail;

    @PositiveOrZero(message = "კაპიტალი უნდა იყოს დადებითი ან ნული")
    private Double capital;

    @PastOrPresent(message = "დაარსების თარიღი არ უნდა იყოს მომავალი")
    private LocalDate releaseDate;
}
