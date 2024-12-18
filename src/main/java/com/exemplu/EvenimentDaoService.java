package com.exemplu;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EvenimentDaoService {
    private static List<Eveniment> eveniments=new ArrayList<>();
    static {
        eveniments.add(new Eveniment(Long.valueOf("1"),"denumire1","locatie1", LocalDate.parse("2024-06-20"), LocalTime.parse("19:00"),20));
        eveniments.add(new Eveniment(Long.valueOf("2"),"denumire2","locatie2", LocalDate.parse("2024-07-20"), LocalTime.parse("19:00"),21));
        eveniments.add(new Eveniment(Long.valueOf("3"),"denumire3","locatie3", LocalDate.parse("2024-06-29"), LocalTime.parse("19:00"),22));
    }
    public List<Eveniment> findAll() {
        return eveniments;
    }
    public Eveniment findById(Long id) {
        Optional<Eveniment> eveniment=eveniments.stream().filter(e -> e.getId().equals(id)).findFirst();
        return eveniment.orElse(null);
    }
    public void save(Eveniment eveniment) {
        eveniments.add(eveniment);
    }
    public boolean deleteById(Long id) {
        return eveniments.removeIf(e -> e.getId().equals(id));
    }
}
