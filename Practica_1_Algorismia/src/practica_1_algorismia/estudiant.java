/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_1_algorismia;

/**
 *
 * @author tomeu
 */
public class estudiant {
    private String nom;
    private String dni;
    private llistaAssignatures llista;
    
    public estudiant (String nom , String dni){
        this.nom = nom;
        this.dni = dni;
        llista = new llistaAssignatures();
    }
    
    public String imprimirEstudiant(){
        return "Estudiant:\n\nNOM : "+nom+"\nDNI : "+dni+"\n";
    }
    
}