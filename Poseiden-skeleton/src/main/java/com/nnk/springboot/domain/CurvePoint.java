package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Table(name = "curvepoint")
public class CurvePoint {
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }
    // TODO: Map columns in data table CURVEPOINT with corresponding java fields
}
