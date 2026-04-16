package pe.edu.usat.medicalapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pe.edu.usat.medicalapp.databinding.ItemEspecialidadBinding;
import pe.edu.usat.medicalapp.modelo.Especialidad;

public class EspecialidadAdaptador extends RecyclerView.Adapter<EspecialidadAdaptador.ViewHolder> {
    private ArrayList<Especialidad> listaEspecialidad;

    public EspecialidadAdaptador(ArrayList<Especialidad> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }

    public void actualizarListaEspecialidad(ArrayList<Especialidad> listaEspecialidad){
        this.listaEspecialidad = listaEspecialidad;
        // Con la finalidad de que el Recycler view se refresque, aplicamos notifyDataSetChanged()
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Permite vincular el adaptador con el archivo que contiene la plantialla MaterialCardView
        ItemEspecialidadBinding binding = ItemEspecialidadBinding.inflate
                (
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false

                );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Permite gestionar la inversion de los datos de la plantilla
        Especialidad especialidad = listaEspecialidad.get(position);
        holder.mostrarDatos(especialidad);
    }

    @Override
    public int getItemCount() {
        return listaEspecialidad.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Permite vincular la clase ViewHolder del adaptador con los controles de la plantilla MaterialCardView
        ItemEspecialidadBinding binding;

        public ViewHolder(ItemEspecialidadBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void mostrarDatos(Especialidad especialidad){
            binding.imgEspecialidad.setImageResource(especialidad.getImagen());
            binding.txtEspecialidad.setText(especialidad.getNombre());
            binding.txtDescripcionEspecialidad.setText(especialidad.getDescripcion());
        }
    }
}
