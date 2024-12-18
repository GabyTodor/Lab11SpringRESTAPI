package com.exemplu;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="evenimente")
public class Eveniment {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denumire, locatie;
    private LocalDate data;
    private LocalTime timpul;
    private float pret;

    public Eveniment(Long id, String denumire, String locatie, LocalDate data, LocalTime timpul, float pret) {
        this.id = id;
        this.denumire = denumire;
        this.locatie = locatie;
        this.data = data;
        this.timpul = timpul;
        this.pret = pret;
    }

    public Eveniment() {
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getTimpul() {
        return timpul;
    }

    public void setTimpul(LocalTime timpul) {
        this.timpul = timpul;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", locatie='" + locatie + '\'' +
                ", data=" + data +
                ", timpul=" + timpul +
                ", pret=" + pret +
                '}';
    }
}
