package com.example.lab3_tp2.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.lab3_tp2.model.Usuario;
import com.example.lab3_tp2.request.ApiClient;
import com.example.lab3_tp2.ui.registro.RegistroActivity;

public class ViewModelMain extends AndroidViewModel {
    Context context;
    Usuario usuario = null;

    public ViewModelMain(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void iniciar(String user, String pass){
        usuario = ApiClient.login(context, user, pass);

        if (usuario == null){
            Toast.makeText(context, "Usuario o Password incorrectos", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(context, RegistroActivity.class);
            i.putExtra("flag", true);
            context.startActivity(i);
        }
    }


}
