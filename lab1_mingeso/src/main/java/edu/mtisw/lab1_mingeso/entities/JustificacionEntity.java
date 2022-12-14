package edu.mtisw.lab1_mingeso.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="justificacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JustificacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String fecha;
    private Long estado;
    private String rut_empleado_justificacion;

}
