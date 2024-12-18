package com.exemplu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EvenimentRepository extends JpaRepository<Eveniment, Long> {
    List<Eveniment> findByData(LocalDate data);
    List<Eveniment> findByLocatie(String locatie);
}
