package pe.reto.interbank.jurado.service;

import org.springframework.stereotype.Service;
import pe.reto.interbank.jurado.dto.PrestamoDto;
import pe.reto.interbank.jurado.model.Prestamo;

public interface PrestamoService {
    Prestamo generarPrestamo(PrestamoDto prestamo);
}
