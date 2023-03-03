public class Raiz {
    private Arbol raiz;
    private String nombre;
    
    public Raiz(Arbol raiz, String nombre){
        this.raiz = raiz;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Arbol getRaiz(){
        return this.raiz;
    }
}
