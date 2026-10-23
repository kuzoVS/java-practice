package com.example.practice2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ФИО не может быть пустым")
    @Size(min = 3, max = 100, message = "ФИО должно содержать от 3 до 100 символов")
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Неверный формат email")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Телефон не может быть пустым")
    @Pattern(regexp = "^\\+7\\d{10}$", message = "Телефон должен быть в формате +7XXXXXXXXXX")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotBlank(message = "Должность не может быть пустой")
    @Size(max = 50, message = "Должность не должна превышать 50 символов")
    @Column(name = "position", nullable = false, length = 50)
    private String position;

    @NotNull(message = "Зарплата обязательна")
    @DecimalMin(value = "0", inclusive = false, message = "Зарплата должна быть больше 0")
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    public Employee() {
    }

    public Employee(String fullName, String email, String phone, String position, BigDecimal salary, Boolean active) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.salary = salary;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
