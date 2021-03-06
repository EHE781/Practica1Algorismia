/*
Clase llistaCursos
 */
package practica_1_algorismia;

/**
 *
 * @authors Damián Gebhard , Emanuel Hegedus , Bartomeu Capó
 */
public class llistaCursos implements interficieLlista<curs>{
    private curs primer;
    public llistaCursos(){
        primer = null;
    }
    public curs getPrimer(){
        return this.primer;
    }
    @Override
    public void insertar(curs elem) {
        if(trobar(String.valueOf(elem.getCodi())) == null){
            curs aux;
            aux = primer;
            primer = elem;
            elem.seg = aux;
        }else{
            System.out.println("Element ja existeix");
        }   
    }

    @Override
    public curs trobar(String codi) {
        curs aux = primer;
        if (primer != null) {
            while (aux.codi != Integer.parseInt(codi) && aux.seg != null) {
                aux = aux.seg;
            }
            if (aux.codi == Integer.parseInt(codi)) {
                return aux;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void borrar(String codi) {
        curs aux,paux;
        int cod = Integer.parseInt(codi);
        paux = null;
        aux = primer;
        if(primer == null){
            System.out.println("Llista buida");
        }
        else{
            if(primer.getCodi() == cod){
                primer = primer.seg;
            }
            else{
                while(aux.getCodi() != cod && aux.seg != null){
                    paux = aux;
                    aux = aux.seg;
                }
                if(aux.getCodi() == cod){
                    paux.seg = aux.seg;
                }
                else{
                    System.out.println("Element no existeix");
                }
            } 
        }     
    }

    @Override
    public String imprimir() {
        String res = "";
        curs aux = primer;
        while(aux != null){
            if(aux instanceof FP){
                FP aux1 = (FP) aux;
                res += aux1.imprimir();
                res += "\n";
            }
            else{
                batxiller aux2 = (batxiller) aux;
                res += aux2.imprimir();
                res += "\n";
            }
            aux = aux.seg;
        }
        return res;
    }

    @Override
    public boolean buida() {
        return primer == null;
    }

   
    
}
