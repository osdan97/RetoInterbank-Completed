package pe.reto.interbank.jurado.model;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;


    @Column(name = "dni", nullable = false,unique = true)
    private String dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "distrito", nullable = false)
    private String distrito;

    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "telefono", nullable = false)
    private Integer telefono;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "estado", nullable = false)
    private Boolean estado;


}

