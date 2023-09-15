package pe.reto.interbank.jurado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.reto.interbank.jurado.dto.PrestamoDto;
import pe.reto.interbank.jurado.model.Cuota;
import pe.reto.interbank.jurado.repository.CuotaRepository;
import pe.reto.interbank.jurado.service.PrestamoService;

@RestController
@RequestMapping("api/prestamo")
@CrossOrigin(origins = "*")
public class PrestamoController {
    @Autowired
    PrestamoService prestamoService;
    @Autowired
    CuotaRepository cuotaRepository;
    @PostMapping("/simular")
    public ResponseEntity<?> registrar(@RequestBody PrestamoDto prestamoEnt) {


        return new ResponseEntity( prestamoService.generarPrestamo( prestamoEnt), HttpStatus.OK);
    }

    @PostMapping("/cuota")
    public ResponseEntity<?> registrarcuota(@RequestBody Cuota cuotaEnt) {


        return new ResponseEntity( cuotaRepository.save(cuotaEnt), HttpStatus.OK);
    }

}
