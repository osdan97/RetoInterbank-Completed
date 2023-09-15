package pe.reto.interbank.jurado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.reto.interbank.jurado.model.Cliente;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDto {

    private Integer id_cliente;
    private double monto;

    private double tasaInteres;
    private int numeroCuotas;
}
