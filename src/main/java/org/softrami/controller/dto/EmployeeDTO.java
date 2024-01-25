package org.softrami.controller.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    //@NotNull(message = "El campo nombre no puede ser nulo")
    @NotNull
    private String name;
    @NotNull
    @Size(min = 3, max = 10)
    private String lastName;
    @NotBlank
    //@Pattern(regexp = ) --> Se usa para expresiones regulares
    @Email
    private String email;

    //@CreditCardNumber --> Se usa para tarjeta de credito
    private Long phone;
    @Min(18)
    @Max(25)
    private byte age;
    @Digits(integer=2, fraction=2)
    private double height;
    @AssertTrue
    //@AssertFalse
    private boolean married;

    //@Past
    @Future
    private LocalDate dateOfBirth;

    @Valid
    private DepartmentDTO departmentDTO;

    /*@NotEmpty --> Se usa para valida que una lista no venga vacío
    List<Integer> numbers;*/
}
