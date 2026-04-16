package pe.edu.usat.medicalapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import pe.edu.usat.medicalapp.adapter.EspecialidadAdaptador;
import pe.edu.usat.medicalapp.adapter.MedicoAdaptador;
import pe.edu.usat.medicalapp.databinding.FragmentEspecialidadesBinding;
import pe.edu.usat.medicalapp.databinding.FragmentMedicosBinding;
import pe.edu.usat.medicalapp.datos.DatosClinica;
import pe.edu.usat.medicalapp.modelo.Especialidad;
import pe.edu.usat.medicalapp.modelo.Medico;


public class MedicosFragment extends Fragment {

    FragmentMedicosBinding binding;
    ArrayList<Medico> listaMedicos;
    MedicoAdaptador medicoAdaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMedicosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Cargar las especialidades y medicos
        DatosClinica.cargarDatosInicialesEspecialidad();
        DatosClinica.cargarDatosInicialesMedicos();

        // Cargar las especialidades en el autocompleteTextView
        cargarEspecialidades();

        //Instanciar el arraylist de médicos por especialidad
        listaMedicos = new ArrayList<>();

        //Instanciar el adaptador
        medicoAdaptador = new MedicoAdaptador(listaMedicos);

        // Configurar el recyclerView
        binding.rvMedicos.setLayoutManager(new LinearLayoutManager(requireContext()));
        // Asignar el adaptador al recyclerView
        binding.rvMedicos.setAdapter(medicoAdaptador);

        // Al seleccionar un item (especialidad) del AutoCompleteTextView se debe mostrar los medicos pertenencientes a dicha especialidad
        binding.actvEspecialidad.setOnItemClickListener((parent, view1, position, id) -> {
            String especialidadSeleccionada = binding.actvEspecialidad.getText().toString().trim();
            filtrarMedicosPorEspecialidad(especialidadSeleccionada);
        });

        //Seleccionar de manera automatica la primera especialidad
        if (! DatosClinica.listaEspecialidades.isEmpty()){
            String especialidad = DatosClinica.listaEspecialidades.get(0).getNombre();
            binding.actvEspecialidad.setText(especialidad,false);
            filtrarMedicosPorEspecialidad(especialidad);
        }

    }

    private void filtrarMedicosPorEspecialidad(String especialidadSeleccionada) {
        // Limpiar el arrayList
        listaMedicos.clear();
        //Obtener los médicos que pertenezcan a la especialidad seleccionada
        listaMedicos = DatosClinica.obtenerListaMedicosPorEspecialidad(especialidadSeleccionada);

        //Enviar al adaptador la lista de médicos de la especialidad seleccionada
        medicoAdaptador.actualizarLista(listaMedicos);


    }

    private void cargarEspecialidades() {
        ArrayAdapter<Especialidad> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                DatosClinica.listaEspecialidades
        );
        binding.actvEspecialidad.setAdapter(adapter);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}