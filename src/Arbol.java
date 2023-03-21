
import java.util.HashSet;
import java.util.LinkedList;

public class Arbol implements Cloneable{
    public Arbol ramaIzq;
    public Arbol ramaDer;
    private int id;
    private String valor;
    private LinkedList primeros;
    private LinkedList ultimos;
    private boolean anulabilidad;
    public int idAux;
    public int idHojas;
    public boolean cambiadoMas = false;
    public Tabla hojas;
    public Arbol copia;
    
    public Arbol(String valor, int id){
        this.valor = valor;
        this.id = id;
        this.anulabilidad = false;
        this.ramaIzq = null;
        this.ramaDer = null;
        this.primeros = new LinkedList();
        this.ultimos = new LinkedList();
    }
    
    public String getValor(){
        return valor;
    }
    
    public int getId(){
        return id;
    }
    
    public void setAnulabilidad(){
        if(valor.equals("*") || valor.equals("?")){
            anulabilidad = true;
        }else if(valor.equals(".")){
            if(ramaDer.anulabilidad == true && ramaIzq.anulabilidad == true){
                anulabilidad = true;
                return;
            }
            anulabilidad = false;
        }else if(valor.equals("|")){
            if(ramaDer.anulabilidad == true || ramaIzq.anulabilidad == true){
                anulabilidad = true;
                return;
            }
            anulabilidad = false;
        }else if(valor.equals("+")){
            if(ramaIzq.anulabilidad == true){
                anulabilidad = true;
                return;
            }
            anulabilidad = false;
        }
    }
    
    public void setUltimosOr(){
        int cantIzq = ramaIzq.ultimos.size();
        int cantDer = ramaDer.ultimos.size();
        
        for(int i = 0; i < cantIzq; i++){
            ultimos.add(ramaIzq.ultimos.get(i));
        }
        
        for(int i = 0; i < cantDer; i++){
            ultimos.add(ramaDer.ultimos.get(i));
        }
    }
    
    public void setPrimerosOr(){
        int cantIzq = ramaIzq.primeros.size();
        int cantDer = ramaDer.primeros.size();
        
        for(int i = 0; i < cantIzq; i++){
            primeros.add(ramaIzq.primeros.get(i));
        }
        
        for(int i = 0; i < cantDer; i++){
            primeros.add(ramaDer.primeros.get(i));
        }
    }
    
    public void setUltimosAnd(){
        int cantDer = ramaDer.ultimos.size();
        if(ramaDer.anulabilidad == true){
            setUltimosOr();
        }else{
            for(int i = 0; i < cantDer; i++){
                ultimos.add(ramaDer.ultimos.get(i));
            }
        }
    }
    
    public void setPrimerosAnd(){
        int cantIzq = ramaIzq.primeros.size();
        if(ramaIzq.anulabilidad == true){
            setPrimerosOr();
        }else{
            for(int i = 0; i < cantIzq; i++){
                primeros.add(ramaIzq.primeros.get(i));
            }
        }
    }
    
    public void setPrimerosUltimos(){
        int cantIzqPrimeros = ramaIzq.primeros.size();
        int cantIzqUltimos = ramaIzq.ultimos.size();
        for(int i = 0; i < cantIzqPrimeros; i++){
            primeros.add(ramaIzq.primeros.get(i));
            
        }
        for(int i = 0; i < cantIzqUltimos; i++){
            ultimos.add(ramaIzq.ultimos.get(i));  
        } 
    }
    
    public void setHoja(int id){
        this.primeros.clear();
        this.ultimos.clear();
        this.primeros.add(id);
        this.ultimos.add(id);
    }
    
    public void mostrarNodo(){
        System.out.println("{ "+ valor +" - "+ anulabilidad +" - "+ primeros +" - "+ ultimos +" }");
    }
    
    public LinkedList getPrimeros(){
        return primeros;
    }
    
    public LinkedList getUltimos(){
        return ultimos;
    }
    
    public String getUltimosText(){
        String ultimos = "";
        for(int i = 0; i < this.ultimos.size(); i++){
            ultimos += this.ultimos.get(i);
            if(i+1 != this.ultimos.size()){
                ultimos += ", ";
            }
        }
        
        return ultimos;
    }
    
    public String getPrimerosText(){
        String primeros = "";
        for(int i = 0; i < this.primeros.size(); i++){
            primeros += this.primeros.get(i);
            if(i+1 != this.primeros.size()){
                primeros += ", ";
            }
        }
        
        return primeros;
    }
    
    public String getAnulabilidad(){
        if(anulabilidad){
            return "A";
        }
        return "N";
    }
    

    
    public void crearHojas(Arbol raiz){
        if(raiz == null){
            return;
        }else{
            raiz.setId(id+idAux);
            idAux++;
            
            if(raiz.ramaDer == null && raiz.ramaIzq == null){
                raiz.setHoja(idHojas);  
                hojas.setFila(idHojas,raiz.valor);
                idHojas++;
            }
            crearHojas(raiz.ramaIzq);
            crearHojas(raiz.ramaDer);  
        }
        
    }
    /*
    public void setForMasCiclo(Arbol raiz){
        while(raiz.primeros == null && raiz.ultimos == null){
            System.out.println("test");
            setForMas(raiz);
        }
    }
    
    public Arbol setForMas(Arbol raiz){
        if(raiz == null){
            return null;
        }else{
            raiz.setAnulabilidad();
            if(raiz.valor == "|"){
                raiz.setPrimerosOr();
                raiz.setUltimosOr();
            }else if(raiz.valor == "."){
                raiz.setPrimerosAnd();
                raiz.setUltimosAnd();    
            }else if(raiz.valor == "*"){
                raiz.setPrimerosUltimos();
            }   
        }
            setForMas(raiz.ramaIzq);
            setForMas(raiz.ramaDer);  
    }
*/
    
    public void recorrer(Arbol raiz){
        if(raiz == null){
            return;
        }else{
            System.out.println("ID: " + String.valueOf(raiz.id));
            System.out.println("Valor: " + String.valueOf(raiz.valor));
            System.out.println(raiz.primeros);
            System.out.println(raiz.ultimos);
            
            
            recorrer(raiz.ramaIzq);
            recorrer(raiz.ramaDer);  
        }
    }
    
    public Arbol recorrerStack(Arbol raiz){
        LinkedList pila = new LinkedList();
        LinkedList saves = new LinkedList();
        Arbol puntero = raiz;
        Arbol copia = new Arbol(puntero.valor,idAux);
        idAux++;
        pila.add(puntero);
        saves.add(copia);
        while(pila.size() != 0){
            if(puntero.ramaDer == null && puntero.ramaIzq == null){
                copia.setHoja(idHojas);
                hojas.setFila(idHojas,copia.valor);
                copia.anulabilidad = false;
                idHojas++;
                puntero = (Arbol) pila.remove(pila.size()-1);
                copia = (Arbol) saves.remove(saves.size()-1);
            }else if(puntero.ramaDer.cambiadoMas == false || puntero.ramaIzq.cambiadoMas == false){
                pila.add(puntero);
                saves.add(copia);
            }          
            if(puntero.ramaIzq != null && puntero.ramaIzq.cambiadoMas == false){
                copia.ramaIzq = new Arbol(puntero.ramaIzq.valor,idAux);
                idAux++;
                puntero = puntero.ramaIzq;
                copia = copia.ramaIzq;
                puntero.cambiadoMas = true;
                
            }else if(puntero.ramaDer != null && puntero.ramaDer.cambiadoMas == false){
                copia.ramaDer = new Arbol(puntero.ramaDer.valor,idAux);
                idAux++;
                puntero = puntero.ramaDer;
                copia = copia.ramaDer;
                puntero.cambiadoMas = true;
            }
        }
        
        
        return setMas(copia);
    }
    
    public Arbol setMas(Arbol raiz){
        Arbol puntero = raiz;
        boolean cambio = false;
        boolean asignar = true;
        
        while(puntero.primeros.size() == 0){
            LinkedList pila = new LinkedList();
            puntero = raiz;
            pila.add(puntero);
            while(pila.size() != 0){
                if(puntero.primeros.size() == 0){
                    puntero.setAnulabilidad();
                    if(puntero.valor.equals("|") && puntero.ramaIzq.primeros.size() != 0 && puntero.ramaDer.primeros.size() != 0){
                        puntero.setPrimerosOr();
                        puntero.setUltimosOr();
                    }else if(puntero.valor.equals(".") && puntero.ramaIzq.primeros.size() != 0 && puntero.ramaDer.primeros.size() != 0){
                        puntero.setPrimerosAnd();
                        puntero.setUltimosAnd();    
                    }else if(puntero.valor.equals("*") && puntero.ramaIzq.primeros.size() != 0){
                        puntero.setPrimerosUltimos();
                    }
                }            
                if(puntero.ramaDer == null && puntero.ramaIzq == null){
                    puntero = (Arbol) pila.remove(pila.size()-1);
                }else if(puntero.ramaDer.cambiadoMas == cambio || puntero.ramaIzq.cambiadoMas == cambio){
                    pila.add(puntero);
                }          

                if(puntero.ramaIzq != null && puntero.ramaIzq.cambiadoMas == cambio){
                    puntero = puntero.ramaIzq;
                    puntero.cambiadoMas = asignar;

                }else if(puntero.ramaDer != null && puntero.ramaDer.cambiadoMas == cambio){
                    puntero = puntero.ramaDer;
                    puntero.cambiadoMas = asignar;
                }
            }
            
            if(cambio==false){
                cambio = true;
                asignar = false;
            }else{
                cambio = false;
                asignar = true;
            }
            
        }
        return puntero;
    }
    

    
    public void setId(int id){
        this.id = id;
    }
    
}


