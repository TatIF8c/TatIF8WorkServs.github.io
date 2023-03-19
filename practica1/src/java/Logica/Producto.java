/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author santi
 */
public class Producto {
    private String producto;
    private float presio;
    private int existencias;
    Pattern nameRegex= Pattern.compile("^[a-zA-Z\\s]{3,9999999}+$");


    public Producto(){
        
    }
    public Producto(String producto, float presio, int existencias) {
        this.producto = producto;
        this.presio = presio;
        this.existencias=existencias;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPresio() {
        return presio;
    }

    public void setPresio(float presio) {
        this.presio = presio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    public boolean validarProducto(String produ){
        Matcher n= nameRegex.matcher(produ);
        if(n.matches()==true){
            return true;
        }else{
            return false;
        }

    }
    public boolean norrepetirproducto(String produ){
        for (Producto pro : Arrays.listprodu) {
            if(pro.getProducto().equals(produ)){
                return false;
            }
          
            
        }
        return true;
    }
  
 
}
