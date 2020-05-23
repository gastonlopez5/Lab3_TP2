package com.example.lab3_tp2.ui.registro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab3_tp2.R;
import com.example.lab3_tp2.model.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private EditText etDni, etApellido, etNombre, etEmail, etPws;
    private Button btGuardar;
    private Boolean flag;
    private ViewModelRegistro vm;
    private Usuario usuario = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etDni = findViewById(R.id.etDni);
        etApellido = findViewById(R.id.etApellido);
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etMail);
        etPws = findViewById(R.id.etContrasenia);
        btGuardar = findViewById(R.id.btGuardar);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegistro.class);

        iniciarVista();
    }

    public void iniciarVista(){
        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setDni(Long.parseLong(etDni.getText().toString()));
                usuario.setApellido(etApellido.getText().toString());
                usuario.setNombre(etNombre.getText().toString());
                usuario.setEmail(etEmail.getText().toString());
                usuario.setPassword(etPws.getText().toString());

                vm.guardarUsuario(usuario);


            }
        });

        vm.getUsuarioMLD().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                etDni.setText(usuario.getDni()+"");
                etApellido.setText(usuario.getApellido());
                etNombre.setText(usuario.getNombre());
                etEmail.setText(usuario.getEmail());
                etPws.setText(usuario.getPassword());
            }
        });

        Intent i = getIntent();
        vm.leerUsuaio(i.getBooleanExtra("flag", false));
    }
}
