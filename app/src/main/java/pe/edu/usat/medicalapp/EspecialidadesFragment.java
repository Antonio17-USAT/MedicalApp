package pe.edu.usat.medicalapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pe.edu.usat.medicalapp.adapter.EspecialidadAdaptador;
import pe.edu.usat.medicalapp.databinding.FragmentEspecialidadesBinding;
import pe.edu.usat.medicalapp.databinding.FragmentInicioBinding;
import pe.edu.usat.medicalapp.datos.DatosClinica;
import pe.edu.usat.medicalapp.modelo.Especialidad;


public class EspecialidadesFragment extends Fragment {
    FragmentEspecialidadesBinding binding;
    ArrayList<Especialidad> listaEspecialidads;
    EspecialidadAdaptador especialidadAdaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEspecialidadesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Cargar las especialidades almacenadas en el array
        DatosClinica.cargarDatosInicialesEspecialidad();
        listaEspecialidads = DatosClinica.listaEspecialidades;
        especialidadAdaptador = new EspecialidadAdaptador(listaEspecialidads);

        // Configurar el recyclerView
        binding.rvEspecialidades.setLayoutManager(new LinearLayoutManager(requireContext()));
        // Asignar el adaptador al recyclerView
        binding.rvEspecialidades.setAdapter(especialidadAdaptador);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}