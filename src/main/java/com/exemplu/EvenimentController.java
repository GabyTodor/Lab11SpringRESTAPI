package com.exemplu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evenimente")
public class EvenimentController {
    @Autowired
    private EvenimentRepository repository;
    @GetMapping
    public List<Eveniment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getByLocatie(@PathVariable String locatie) {
        return repository.findByLocatie(locatie);
    }

    @GetMapping("/data/{data}")
    public List<Eveniment> getByData(@PathVariable String data) {
        return repository.findByData(LocalDate.parse(data));
    }

//    @GetMapping
//    public Eveniment getById(@PathVariable Long id) {
//        Optional<Eveniment> eveniment = repository.findById(id);
//        if(eveniment.isPresent()) {
//            return eveniment.get();
//        }
//        else
//            throw new EvenimentNotFoundException("Evenimentul cu id "+ id+" nu e gasit");
//    }

    @PostMapping
    public void saveEveniment(@RequestBody Eveniment eveniment) {
        repository.save(eveniment);
    }

    @PutMapping("/{id}")
    public Eveniment updateEveniment(@PathVariable Long id, @RequestBody Eveniment newEveniment) {
        return repository.findById(id).map(eveniment -> {
            eveniment.setDenumire(newEveniment.getDenumire());
            eveniment.setLocatie(newEveniment.getLocatie());
            eveniment.setData(newEveniment.getData());
            eveniment.setTimpul(newEveniment.getTimpul());
            eveniment.setPret(newEveniment.getPret());
            return repository.save(eveniment);
        }).orElseThrow(()->new EvenimentNotFoundException("Evenimentul nu a fost gasit"));
    }

    @DeleteMapping("/{id}")
    public void deleteEveniment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
