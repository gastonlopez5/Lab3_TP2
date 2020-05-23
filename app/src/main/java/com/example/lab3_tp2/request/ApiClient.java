package com.example.lab3_tp2.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.lab3_tp2.model.Usuario;

import java.io.*;

public class ApiClient {
    private static Context context;


    public static void guardar(Context context, Usuario usuario){
        try {
            File archivo = new File (context.getFilesDir(), "datos2.dat");
            FileOutputStream fo = new FileOutputStream(archivo);
            BufferedOutputStream bo = new BufferedOutputStream(fo);
            ObjectOutputStream oos = new ObjectOutputStream(bo);

            oos.writeObject(usuario);

            bo.flush();
            fo.close();

        } catch (IOException io) {
            Toast.makeText(context, "No se pudo conectar al archivo", Toast.LENGTH_LONG).show();
        }
    }

    public static Usuario leer(Context context){
        Usuario usuario = null;

        try {
            File archivo = new File (context.getFilesDir(), "datos2.dat");
            FileInputStream fi = new FileInputStream(archivo);
            BufferedInputStream bi = new BufferedInputStream(fi);
            ObjectInputStream ois = new ObjectInputStream(bi);

            usuario = (Usuario) ois.readObject();

            fi.close();

        } catch (IOException io) {
            Toast.makeText(context, "No se encontró el archivo", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException cnfe) {
            Toast.makeText(context, "No se encontró el objeto", Toast.LENGTH_LONG).show();
        }

        return usuario;
    }

    public static Usuario login(Context context, String mail, String pass){
        Usuario usuario = null;

        try {
            File archivo = new File (context.getFilesDir(), "datos2.dat");
            FileInputStream fi = new FileInputStream(archivo);
            BufferedInputStream bi = new BufferedInputStream(fi);
            ObjectInputStream ois = new ObjectInputStream(bi);

            usuario = (Usuario) ois.readObject();

            fi.close();

        } catch (IOException io) {
            Toast.makeText(context, "No se encontró el archivo", Toast.LENGTH_LONG).show();
        } catch (ClassNotFoundException cnfe) {
            Toast.makeText(context, "No se encontró el objeto", Toast.LENGTH_LONG).show();
        }

        if (mail.equals(usuario.getEmail()) && pass.equals(usuario.getPassword())){
            return usuario;
        }
        else {
            return null;
        }
    }
}
