package com.sunglowsys.domain;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class HotelInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String totalInventory;

    public HotelInventory(){}

    public HotelInventory(String totalInventory) {
        this.totalInventory = totalInventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(String totalInventory) {
        this.totalInventory = totalInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        HotelInventory that = (HotelInventory) o;
        return Objects.equals (id, that.id) && Objects.equals (totalInventory, that.totalInventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash (id, totalInventory);
    }

    @Override
    public String toString() {
        return "HotelInventory{" +
                "id=" + id +
                ", totalInventory='" + totalInventory + '\'' +
                '}';
    }
}
