/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author santi
 */
public class Cliente {   
    private String nombre;
    private float saldo;
    private String correo;
    private String telefono;
    Pattern nameRegex= Pattern.compile("^[a-zA-Z\\s]+$");
    Pattern telefonoRegex= Pattern.compile("^[0-9]{9,10}+$");
    Pattern correoRegex= Pattern.compile("^[a-zA-Z0-9._-]{1,30}@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,3}+$");
            
    public Cliente(String nombre, float saldo, String correo, String telefono) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void registrarproducto(Producto pro){
        Arrays.listproducliente.add(pro);
    }

    public boolean validarnombre(String nombre){
        Matcher n= nameRegex.matcher(nombre);
        if(n.matches()==true){
            return true;
        }else{
            return false;
        }

        
    }
   
      public boolean validarcorreo(String correo){
        Matcher c =correoRegex.matcher(correo);
        if(c.matches()==true){
            return true;
        }else{
            return false;
        }

        
    }
       public boolean validartelefono(String telefono){
        Matcher t= telefonoRegex.matcher(telefono);
        if(t.matches()==true){
            return true;
        }else{
            return false;
        }

        
    }
}
