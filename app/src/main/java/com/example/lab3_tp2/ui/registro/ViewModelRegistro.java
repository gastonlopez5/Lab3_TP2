package com.example.lab3_tp2.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lab3_tp2.model.Usuario;
import com.example.lab3_tp2.request.ApiClient;
import com.example.lab3_tp2.ui.login.MainActivity;

public class ViewModelRegistro extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> usuarioMLD;
    private Usuario usuario = null;

    public ViewModelRegistro(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Usuario> getUsuarioMLD(){
        if (usuarioMLD == null){
            usuarioMLD = new MutableLiveData<>();
        }
        return usuarioMLD;
    }

    public void guardarUsuario(Usuario usuario){
        ApiClient.guardar(context, usuario);

        Toast.makeText(context, "Ingrese nuevamente por favor", Toast.LENGTH_LONG).show();
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }

    public void leerUsuaio(Boolean flag){
        if (flag){
            usuario = ApiClient.leer(context);
            usuarioMLD.setValue(usuario);
        }
    }
}
