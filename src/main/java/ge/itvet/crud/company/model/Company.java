package ge.itvet.crud.company.model;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Schema(description = "კომპანიის მოდელი")
public class Company {
    @Schema(description = "კომპანიის უნიკალური იდენტიფიკატორი", example = "1")
    private Long id;

    @NotBlank(message = "ბიზნეს სფერო არ უნდა იყოს ცარიელი")
    @Schema(description = "ბიზნეს სფერო", example = "ტექნოლოგიები")
    private String sphere;

    @NotBlank(message = "სახელწოდება არ უნდა იყოს ცარიელი")
    @Schema(description = "კომპანიის სახელწოდება", example = "Tech Corp")
    private String name;

    @Email(message = "მეილი უნდა იყოს სწორი ფორმატის")
    @Schema(description = "საკონტაქტო მეილი", example = "info@techcorp.com")
    private String mail;

    @PositiveOrZero(message = "კაპიტალი უნდა იყოს დადებითი ან ნული")
    @Schema(description = "საწყისი კაპიტალი", example = "100000.0")
    private Double capital;

    @PastOrPresent(message = "დაარსების თარიღი არ უნდა იყოს მომავალი")
    @Schema(description = "კომპანიის დაარსების თარიღი", example = "2020-01-01")
    private LocalDate releaseDate;
}
