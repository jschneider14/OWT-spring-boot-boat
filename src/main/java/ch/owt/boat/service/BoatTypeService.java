package ch.owt.boat.service;

import ch.owt.boat.entity.BoatType;

import java.util.List;

public interface BoatTypeService {

    List<BoatType> findAll();

    BoatType findById(Long theId);

    BoatType save(BoatType employee);

    void deleteById(Long theId);

}
