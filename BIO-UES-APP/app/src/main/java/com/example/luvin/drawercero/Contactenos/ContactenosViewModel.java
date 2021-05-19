package com.example.luvin.drawercero.Contactenos;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactenosViewModel extends ViewModel{
    private String nombre;
    private String email;
    private String mensaje;


    private  MutableLiveData<String> mText;

    public ContactenosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Especimen fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public ContactenosViewModel(String nombre, String email, String mensaje) {
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
