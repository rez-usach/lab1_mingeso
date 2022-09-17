package edu.mtisw.lab1_mingeso.entities;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

@Entity
@Table(name="reloj")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RelojEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    private String fecha;
    private String hora;

    //Foranea
//    @ManyToOne
//    @JoinColumn(name = "rut_empleado_reloj")
//    private EmpleadoEntity empleado;
    private String rut_empleado_reloj;

    @Override
    public String toString() {
        return "RelojEntity{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", rut_empleado_reloj='" + rut_empleado_reloj + '\'' +
                '}';
    }

    public static void main(String[] args){
        List<RelojEntity> relojes = new ArrayList<RelojEntity>();

        String path = "C:\\Users\\roesc\\Desktop\\lab1_mingeso\\lab1_mingeso\\cargas\\marcaRelojEmpleados.txt";

        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                StringTokenizer columna = new StringTokenizer(linea,";");

                RelojEntity reloj = new RelojEntity();

                while (columna.hasMoreElements()){
                    reloj.setId(1);
                    reloj.setFecha(columna.nextElement().toString());
                    reloj.setHora(columna.nextElement().toString());
                    reloj.setRut_empleado_reloj(columna.nextElement().toString());
                }
                relojes.add(reloj);
                //System.out.println(scanner.nextLine());
            }
            scanner.close();

            relojes.forEach(
                    r->System.out.println(r)
            );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}