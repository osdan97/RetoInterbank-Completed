package pe.reto.interbank.jurado.controller;

import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.reto.interbank.jurado.dto.Mensaje;
import pe.reto.interbank.jurado.model.Cliente;
import pe.reto.interbank.jurado.repository.ClienteRepository;
import pe.reto.interbank.jurado.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> list() {
        List<Cliente> list = clienteService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody Cliente clienteEnt) {

        try {
            if (StringUtils.isBlank(clienteEnt.getDni()))
                return new ResponseEntity(new Mensaje("Es obligatorio ingresar el DNI"), HttpStatus.BAD_REQUEST);
            if (StringUtils.isBlank(clienteEnt.getNombre()))
                return new ResponseEntity(new Mensaje("Es obligatorio ingresar el nombre"), HttpStatus.BAD_REQUEST);
            if (StringUtils.isBlank(clienteEnt.getApellido()))
                return new ResponseEntity(new Mensaje("Es obligatorio ingresar el apellido"), HttpStatus.BAD_REQUEST);

            else {


                return new ResponseEntity<>(clienteService.save(clienteEnt), HttpStatus.CREATED);
            }
        }catch (Exception e)
        {
            return new ResponseEntity<>(new Mensaje(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/editar/{dni}")
    public ResponseEntity<?> updateByName(@PathVariable("dni") Integer dni, @RequestBody Cliente clienteEnt) {

        if(!clienteRepository.existsById(dni)){
            return new ResponseEntity(new Mensaje(" El dni no se encuentra registrado"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity( clienteService.editar(dni,clienteEnt), HttpStatus.OK);
    }


    @DeleteMapping("/darbaja/{id}")
    public ResponseEntity<?> delete(@PathVariable("dni") Integer dni) {
        if(!clienteRepository.existsById(dni)){
            return new ResponseEntity(new Mensaje(" El dni no se encuentra registrado"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(clienteService.darBaja(dni), HttpStatus.OK);
    }


}

