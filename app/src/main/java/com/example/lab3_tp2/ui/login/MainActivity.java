package com.example.lab3_tp2.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab3_tp2.R;
import com.example.lab3_tp2.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUsuario, etPsw;
    private Button btLogin, btRegistrarse;
    private ViewModelMain vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMain.class);

        etUsuario = findViewById(R.id.etUsuario);
        etPsw = findViewById(R.id.etContrasenia);
        btLogin = findViewById(R.id.btLogin);
        btRegistrarse = findViewById(R.id.btRegistrarse);

        iniciarVista();
    }

    public void iniciarVista(){
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.iniciar(etUsuario.getText().toString(), etPsw.getText().toString());
            }
        });

        btRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                i.putExtra("flag", false);
                startActivity(i);
            }
        });
    }
}
