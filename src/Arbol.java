
import java.util.LinkedList;

public class Arbol {
    public Arbol ramaIzq;
    public Arbol ramaDer;
    private int id;
    private String valor;
    private LinkedList primeros;
    private LinkedList ultimos;
    private boolean anulabilidad;
    
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
        int cantDer = ramaDer.primeros.size();
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
}
