package ch.owt.boat.controller;

import ch.owt.boat.entity.BoatType;
import ch.owt.boat.exception.BoatAppNotFoundException;
import ch.owt.boat.service.BoatTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
@Tag(name = "Boat Type Controller", description = "The boat type API")
public class BoatTypeController {
    
    @Autowired
    private BoatTypeService boatTypeService;

    // expose /boat-types and return list of boat-types
    @GetMapping("/boat-types")
    public List<BoatType> findAll() {
        return boatTypeService.findAll();
    }

    // add mapping for GET /boat-types/{boatTypeId}
    @GetMapping("/boat-types/{boatTypeId}")
    public BoatType getBoatType(@PathVariable Long boatTypeId) {

        BoatType theBoatType = null;
        try {
            theBoatType = boatTypeService.findById(boatTypeId);
        } catch (Exception e) {
            throw new BoatAppNotFoundException("Boat type id not found - " + boatTypeId);
        }

        return theBoatType;
    }

    // add mapping for POST /boat-types
    @PostMapping("/boat-types")
    public BoatType addBoatType(@RequestBody BoatType theBoatType) {

        // also just in case they pass an id in JSON .. set id to 0
        // this is to force a save of new item ... instead of update
        theBoatType.setId(0L);

        boatTypeService.save(theBoatType);

        return theBoatType;

    }

    // add mapping for PUT /boat-types
    @PutMapping("/boat-types")
    public BoatType updateBoatType(@RequestBody BoatType theBoatType) {

        boatTypeService.save(theBoatType);
        return theBoatType;

    }

    // add mapping for DELETE /boat-types
    @DeleteMapping("/boat-types/{boatTypeId}")
    public ResponseEntity deleteBoatType(@PathVariable Long boatTypeId) {

        BoatType theBoatType = null;
        try {
            theBoatType = boatTypeService.findById(boatTypeId);
        } catch (Exception e) {
            throw new BoatAppNotFoundException("Boat type id not found - " + boatTypeId);
        }

        boatTypeService.deleteById(boatTypeId);
        return ResponseEntity.noContent().build();

    }
}
