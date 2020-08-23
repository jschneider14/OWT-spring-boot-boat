package ch.owt.boat.service;

import ch.owt.boat.dao.BoatRepository;
import ch.owt.boat.entity.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatServiceImpl implements BoatService {

    @Autowired
    private BoatRepository boatRepository;

    @Override
    public List<Boat> findAll() {
        return this.boatRepository.findAll();
    }

    @Override
    public Boat findById(Long theId) {
        Optional<Boat> result = boatRepository.findById(theId);

        Boat theBoat;
        if (result.isPresent()) {
            theBoat = result.get();
        } else {
            throw new RuntimeException("Did not find boat id - " + theId);
        }
        return theBoat;
    }

    @Override
    public Boat save(Boat boat) {
        return this.boatRepository.save(boat);
    }

    @Override
    public void deleteById(Long theId) {
        this.boatRepository.deleteById(theId);
    }
}
