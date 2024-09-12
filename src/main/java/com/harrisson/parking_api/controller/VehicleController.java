package com.harrisson.parking_api.controller;

import com.harrisson.parking_api.model.Vehicle;
import com.harrisson.parking_api.service.VehicleService;
import com.harrisson.parking_api.to.VehicleData;
import com.harrisson.parking_api.to.VehicleDataDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = "Vehicle", description = "Vehicle API")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @Operation(summary = "Create a new vehicle", description = "Create a new vehicle")
    @PostMapping
    public ResponseEntity<VehicleDataDetails> createVehicle(@RequestBody @Valid VehicleData vehicleData, UriComponentsBuilder uriBuilder) {
        var vehicle = new Vehicle(vehicleData);
        service.save(vehicle);
        var uri = uriBuilder.path("/vehicles/getById/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).body(new VehicleDataDetails(vehicle));
    }

    @Operation(summary = "List all vehicles", description = "List all vehicles")
    @GetMapping("/{size}")
    public ResponseEntity<List<VehicleDataDetails>> getVehicles(@PathVariable Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        Page<VehicleDataDetails> vehiclesPage = service.getVehicles(pageable);
        return ResponseEntity.ok(vehiclesPage.getContent());
    }

    @Operation(summary = "Get a vehicle by ID", description = "Get a vehicle by ID")
    @GetMapping("getById/{id}")
    public ResponseEntity<VehicleData> getVehicleById(@PathVariable Long id) {
        var vehicle = service.getById(id);
        return ResponseEntity.ok(new VehicleData(vehicle));
    }

    @Operation(summary = "Update a vehicle", description = "Update a vehicle")
    @PutMapping("{id}")
    public ResponseEntity<VehicleDataDetails> updateVehicle(@PathVariable Long id, @RequestBody VehicleDataDetails vehicleDataDetails) {
        var vehicle = service.getById(id);
        vehicle.updateVehicle(vehicleDataDetails.toEntity());
        service.save(vehicle);
        return ResponseEntity.ok(new VehicleDataDetails(vehicle));
    }

    @Operation(summary = "Delete a vehicle", description = "Delete a vehicle")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        service.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search for a vehicle by plate", description = "Search for a vehicle by plate")
    @GetMapping("/searchByPlate")
    public ResponseEntity<Vehicle> searchByPlate(@RequestParam String plate) {
        var vehicle = service.getByPlate(plate);
        return ResponseEntity.ok(vehicle);
    }
}