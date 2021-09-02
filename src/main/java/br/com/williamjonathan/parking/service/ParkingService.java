package br.com.williamjonathan.parking.service;

import br.com.williamjonathan.parking.model.form.ParkingForm;
import br.com.williamjonathan.parking.model.form.ParkingUpdateForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ParkingService {

    ResponseEntity<?> create(ParkingForm form);

    ResponseEntity<?> readById(Long id);
    ResponseEntity<?> readAll();

    ResponseEntity<?> update(ParkingUpdateForm parkingUpdateForm, Long id);

    ResponseEntity<?> delete(Long id);
}

