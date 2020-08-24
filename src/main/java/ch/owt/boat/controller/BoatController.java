package ch.owt.boat.controller;

import ch.owt.boat.entity.Boat;
import ch.owt.boat.exception.BoatAppNotFoundException;
import ch.owt.boat.service.BoatServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Boat Controller", description = "The boat API")
public class BoatController {

    @Autowired
    private BoatServiceImpl boatService;

    // expose /boats and return list of boats
    @GetMapping("/boats")
    public List<Boat> findAll() {
        return boatService.findAll();
    }

    // add mapping for GET /boats/{boatId}
    @GetMapping("/boats/{boatId}")
    public Boat getBoat(@PathVariable Long boatId) {

        Boat theBoat = null;
        try {
            theBoat = boatService.findById(boatId);
        } catch (Exception ex) {
            throw new BoatAppNotFoundException("Boat id not found - " + boatId);
        }

        return theBoat;
    }

    // add mapping for POST /boats
    @PostMapping("/boats")
    public ResponseEntity<Boat> addBoat(@RequestBody Boat theBoat) throws Exception {

        // also just in case they pass an id in JSON .. set id to 0
        // this is to force a save of new item ... instead of update
        theBoat.setId(0L);
        theBoat = boatService.save(theBoat);

        ResponseEntity responseEntity = null;
        try {
            responseEntity = ResponseEntity
                                .created(new URI("/boats/" + theBoat.getId()))
                                .body(theBoat);
        } catch (URISyntaxException ex) {
            throw new Exception(ex);
        }
        return responseEntity;
    }

    // add mapping for PUT /boats
    @PutMapping("/boats")
    public ResponseEntity<Boat> updateBoat(@RequestBody Boat theBoat) throws Exception {

        boatService.save(theBoat);
        return ResponseEntity.ok(theBoat);

    }

    // add mapping for DELETE /boats
    @DeleteMapping("/boats/{boatId}")
    public ResponseEntity deleteBoat(@PathVariable Long boatId) {

        Boat theBoat = null;
        try {
            theBoat = boatService.findById(boatId);
        } catch (Exception e) {
            throw new BoatAppNotFoundException("Boat id not found - " + boatId);
        }

        boatService.deleteById(boatId);
        return ResponseEntity.noContent().build();

    }

}
