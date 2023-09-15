package pe.reto.interbank.jurado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TablaAmortizacionesDto {

    private Date FechaVencimiento_de_Cuota;
    private Double mensualidad ;
    private Double interes;
    private Double capital;
    private Double saldo;


}
