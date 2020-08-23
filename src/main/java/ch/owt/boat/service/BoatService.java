package ch.owt.boat.service;

import ch.owt.boat.entity.Boat;

import java.util.List;

public interface BoatService {

    List<Boat> findAll();

    Boat findById(Long theId);

    Boat save(Boat employee);

    void deleteById(Long theId);

}
