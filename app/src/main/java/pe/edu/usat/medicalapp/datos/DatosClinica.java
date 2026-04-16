package pe.edu.usat.medicalapp.datos;

import java.util.ArrayList;
import pe.edu.usat.medicalapp.R;

import pe.edu.usat.medicalapp.modelo.Cita;
import pe.edu.usat.medicalapp.modelo.Especialidad;
import pe.edu.usat.medicalapp.modelo.Medico;

public class DatosClinica {
    // Lista para gestionar las especialidades medicas
    public static ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();

    //Lista para gestionar médicos
    public static ArrayList<Medico> listaMedicos = new ArrayList<>();

    //Lista para gestionar citas medicas
    public static ArrayList<Cita> listaCitas = new ArrayList<>();

    public static void cargarDatosInicialesEspecialidad(){
        if (listaEspecialidades.isEmpty()) {
            listaEspecialidades.add(new Especialidad(
                    "Pediatria",
                    "Atencion medica especializada para niños y adolescentes",
                    R.drawable.pediatria));

            listaEspecialidades.add(new Especialidad(
                    "Cardiologia",
                    "Diagnostico y tratamiento de enfermedades del corazón",
                    R.drawable.cardiologia));

            listaEspecialidades.add(new Especialidad(
                    "Dermatologia",
                    "Atencion integral en enfermedades y cuidados de la piel",
                    R.drawable.dermatologia));

        }
    }

    public static void cargarDatosInicialesMedicos(){
        listaMedicos.add(new Medico(
                "Dra. María López",
                "Pediatria",
                "Lunes a Viernes - 8:00 a.m. a 1:00 p.m.",
                "101",
                R.drawable.account_circle_24px
        ));

        listaMedicos.add(new Medico(
                "Dr. José Rivera",
                "Pediatria",
                "Lunes, Miércoles y Viernes - 2:00 p.m. a 6:00 p.m.",
                "102",
                R.drawable.account_circle_24px
        ));

        listaMedicos.add(new Medico(
                "Dr. Carlos Ramírez",
                "Cardiologia",
                "Lunes, Miércoles y Viernes - 3:00 p.m. a 7:00 p.m.",
                "202",
                R.drawable.account_circle_24px
        ));

        listaMedicos.add(new Medico(
                "Dra. Andrea Castillo",
                "Dermatologia",
                "Martes y Jueves - 9:00 a.m. a 2:00 p.m.",
                "203",
                R.drawable.account_circle_24px
        ));
    }

    public static ArrayList<Medico> obtenerListaMedicosPorEspecialidad(String especialidad){
        ArrayList<Medico> lista = new ArrayList<>();
        for(Medico m:listaMedicos){
            if(m.getEspecialidad().equals(especialidad)){
                lista.add(m);
            }
        }
        return lista;
    }

}
