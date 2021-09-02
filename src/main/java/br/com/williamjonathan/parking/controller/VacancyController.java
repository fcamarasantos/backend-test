package br.com.williamjonathan.parking.controller;

import br.com.williamjonathan.parking.model.form.VacancyForm;
import br.com.williamjonathan.parking.service.VacancyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    VacancyServiceImpl vacancyService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid VacancyForm form) {
        return vacancyService.create(form);
    }
}
