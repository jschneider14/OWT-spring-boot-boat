package ch.owt.boat.service;

import ch.owt.boat.dao.BoatTypeRepository;
import ch.owt.boat.entity.BoatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatTypeServiceImpl implements BoatTypeService{

    @Autowired
    private BoatTypeRepository boatTypeRepository;

    @Override
    public List<BoatType> findAll() {
        return this.boatTypeRepository.findAll();
    }

    @Override
    public BoatType findById(Long theId) {
        Optional<BoatType> result = boatTypeRepository.findById(theId);

        BoatType theBoatType;
        if (result.isPresent()) {
            theBoatType = result.get();
        } else {
            throw new RuntimeException("Did not find boat id - " + theId);
        }
        return theBoatType;
    }

    @Override
    public BoatType save(BoatType boatType) {
        return this.boatTypeRepository.save(boatType);
    }

    @Override
    public void deleteById(Long theId) {
        this.boatTypeRepository.deleteById(theId);
    }
}
