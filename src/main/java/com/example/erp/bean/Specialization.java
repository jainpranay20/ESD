package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specialization_id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer credits;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "Specialization_Course", joinColumns = {@JoinColumn(name = "Specialization_id")},
            inverseJoinColumns = {@JoinColumn(name = "Course_id")})
    private List<Courses> courses;

    public Specialization() {
    }

    public Specialization(Integer specialization_id, String code, String name, String description, Integer year, Integer credits) {
        this.specialization_id = specialization_id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.credits = credits;
    }

    public Integer getSpecialization_id() {
        return specialization_id;
    }

    public void setSpecialization_id(Integer specialization_id) {
        this.specialization_id = specialization_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @JsonbTransient
    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
}
