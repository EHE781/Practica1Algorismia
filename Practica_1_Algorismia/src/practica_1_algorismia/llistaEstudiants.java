/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_1_algorismia;

import javax.swing.JOptionPane;

/**
 *
 * @author tomeu
 */
public class llistaEstudiants implements interficieLlista<nodoEstudiant> {

    private nodoEstudiant primer;

    public llistaEstudiants() {
        primer = null;
    }

    @Override
    public void borrar(String nom) {
        nodoEstudiant aux = primer;
        //Cas llista buida
        if (primer == null) {
            JOptionPane.showMessageDialog(null, "No existeix");
        } else {
            //Cas primer element == nom
            if (primer.getEstudiant().getNom().equals(nom) && primer.seguent() == null) {
                primer = null;
            } else {
                if (primer.getEstudiant().getNom().equals(nom) && primer.seguent() != null) {
                    primer = primer.seguent();
                } else {
                    //Cercar en tota la llista fins trobar nom o arribar al final
                    while (aux.seguent() != null && !aux.seguent().getEstudiant().getNom().equals(nom)) {
                        aux = aux.seguent();
                    }
                    //Si es l'últim element no ha pogut trobar nom, pertant...
                    if (aux.seguent() == null) {
                        JOptionPane.showMessageDialog(null, "No existeix");
                        //Si no entra al if es perque ha trobat el nom
                    } else {
                        //Cas ultim node s'ha de borrar
                        if (aux.seguent().seguent() == null) {
                            nodoEstudiant borrar = aux.seguent();
                            borrar = null;
                            //Cas element entre altres dos elements
                        } else {
                            nodoEstudiant borrar = aux.seguent();
                            aux.setSeg(borrar.seguent());
                            borrar = null;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(nodoEstudiant elem) {
        if (primer == null) {
            primer = elem;
        } else {
            nodoEstudiant aux = primer;
            nodoEstudiant ant = primer;
            while (aux.seguent() != null) {
                if ((elem.getEstudiant().getNom().compareTo(aux.getEstudiant().getNom())) < 0) {
                    //Cas primer element llista
                    if(ant==aux){
                        primer = elem;
                        elem.setSeg(ant);
                        break;
                    }
                    ant.setSeg(elem);
                    elem.setSeg(aux);
                    break;
                }
                ant = aux;
                aux = aux.seguent();
            }
            //Tant com si son iguals o el nou element es superior, el ficarem després de aux:
                //If innecesari, més posat per el break;
            if ((elem.getEstudiant().getNom().compareTo(aux.getEstudiant().getNom())) >= 0) {
                aux.setSeg(elem);
            }
        }
    }

    @Override
    public nodoEstudiant trobar(String nom) {
        nodoEstudiant aux = primer;
        //Cas llista buida
        if (primer == null) {
            return null;
        } else {
            //Cercar en tota la llista fins trobar nom o arribar al final
            while (aux.seguent() != null && !aux.getEstudiant().getNom().equals(nom)) {
                aux = aux.seguent();
            }
            //Si es l'últim element i no conté el nom cercat
            if (aux.seguent() == null && !aux.getEstudiant().getNom().equals(nom)) {
                JOptionPane.showMessageDialog(null, "No existeix");
                return null;
                //Si no entra al if es perque ha trobat el nom
            } else {
                return aux;
            }
        }
    }
}
