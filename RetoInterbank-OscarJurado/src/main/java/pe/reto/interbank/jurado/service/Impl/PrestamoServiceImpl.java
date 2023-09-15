package pe.reto.interbank.jurado.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.reto.interbank.jurado.dto.PrestamoDto;
import pe.reto.interbank.jurado.model.Cliente;
import pe.reto.interbank.jurado.model.Cuota;
import pe.reto.interbank.jurado.model.Prestamo;
import pe.reto.interbank.jurado.repository.ClienteRepository;
import pe.reto.interbank.jurado.repository.CuotaRepository;
import pe.reto.interbank.jurado.repository.PrestamoRepository;
import pe.reto.interbank.jurado.service.PrestamoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CuotaRepository cuotaRepository;
    public Prestamo generarPrestamo( PrestamoDto prestamo){
        double montoPrestamo = prestamo.getMonto();
        double tasaInteres = prestamo.getTasaInteres() / 100.0;
        Integer numeroCuotas = prestamo.getNumeroCuotas();

        double numero = 123.456789; // El número que deseas redondear

        // Redondear el número a dos decimales
        double numeroRedondeado = Math.round(numero * 100.0) / 100.0;

        LocalDate fechaPrestamo =LocalDate.now();
        Cliente clientePrest=clienteRepository.findById(prestamo.getId_cliente()).get();

        Prestamo prestamo1=new Prestamo();
        prestamo1.setFechaPrestamo(fechaPrestamo);
        prestamo1.setTasaInteres(prestamo.getTasaInteres());
        prestamo1.setCliente(clientePrest);
        prestamo1.setMonto(montoPrestamo);
        prestamo1.setNumeroCuotas(prestamo.getNumeroCuotas());
        //N.º, FechaVencimiento_de_Cuota, Mensualidad, Intereses, Capital y saldo



        List<Cuota> listaCuota=new ArrayList<>();
        double saldo = montoPrestamo;

        for (int cuotaNumero = 1; cuotaNumero <= numeroCuotas; cuotaNumero++) {

            LocalDate fechaVencimiento=obtenerFecha(fechaPrestamo,cuotaNumero);
            double cuotaMensual =calcularCuotaMensual(montoPrestamo,numeroCuotas);
            double intereses = Math.round(saldo * tasaInteres / 12.0 * 100.0) / 100.0;
            double capital = Math.round(montoPrestamo/(1+tasaInteres/(12*100)) * 100.0) / 100.0;
            saldo -= cuotaMensual;

            Cuota cuota = new Cuota();
            cuota.setFechaVencimiento(fechaVencimiento);
            cuota.setMensualidad(cuotaMensual);
            cuota.setIntereses(intereses);
            cuota.setCapital(capital);
            cuota.setSaldo(saldo);

            listaCuota.add(cuota);

            cuotaRepository.save(cuota);



        }
        prestamo1.setCuotasList(listaCuota);

        return prestamoRepository.save(prestamo1);
    }


    private double calcularCuotaMensual(double monto,int numeroCuotas) {

        double cuota = monto / numeroCuotas;
        return cuota;
    }
    public  LocalDate obtenerFecha(LocalDate fech, Integer n ){
        Integer mesActual=fech.getMonthValue();
        Integer añoActual=fech.getYear();
        Integer nroMes=mesActual+n;
        LocalDate year=fech;
        if(nroMes>12){
            mesActual=nroMes-12;
            LocalDate month=fech.withMonth(mesActual);
            Integer añosIncrement=(nroMes-mesActual)/12;
            year =month.withYear(añoActual+añosIncrement);
        }else{
            year=fech.withMonth(nroMes);
        }

        return year;
    }
}
