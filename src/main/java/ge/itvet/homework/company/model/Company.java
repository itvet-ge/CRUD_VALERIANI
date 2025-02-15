package ge.itvet.homework.company.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@ApiModel(description = "კომპანიის მოდელი")
public class Company {
    @ApiModelProperty(value = "კომპანიის უნიკალური იდენტიფიკატორი", example = "1")
    private Long id;

    @NotBlank(message = "ბიზნეს სფერო არ უნდა იყოს ცარიელი")
    @ApiModelProperty(value = "ბიზნეს სფერო", example = "ტექნოლოგიები")
    private String sphere;

    @NotBlank(message = "სახელწოდება არ უნდა იყოს ცარიელი")
    @ApiModelProperty(value = "კომპანიის სახელწოდება", example = "Tech Corp")
    private String name;

    @Email(message = "მეილი უნდა იყოს სწორი ფორმატის")
    @ApiModelProperty(value = "საკონტაქტო მეილი", example = "info@techcorp.com")
    private String mail;

    @PositiveOrZero(message = "კაპიტალი უნდა იყოს დადებითი ან ნული")
    @ApiModelProperty(value = "საწყისი კაპიტალი", example = "100000.0")
    private Double capital;

    @PastOrPresent(message = "დაარსების თარიღი არ უნდა იყოს მომავალი")
    @ApiModelProperty(value = "კომპანიის დაარსების თარიღი", example = "2020-01-01")
    private LocalDate releaseDate;
}
