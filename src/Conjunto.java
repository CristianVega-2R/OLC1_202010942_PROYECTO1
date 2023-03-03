import java.util.LinkedList;

public class Conjunto {
    private String nombre = "";
    private LinkedList lista = new LinkedList();
    
    public static void main(String [] args){
        Conjunto conj = new Conjunto();
        conj.setNombre("nombre");
        conj.setRango("!","z");
        System.out.println(conj.getLista());
    }
    
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    
    public void setCaracter(String caracter){
        char c = caracter.toCharArray()[0];
        lista.add(c);
    }
    
    public void setRango(String caracterInicio, String caracterFin){
        char cInicio = caracterInicio.toCharArray()[0];
        char cFin = caracterFin.toCharArray()[0];
        int asciiInicio = (int) cInicio;
        int asciiFin = (int) cFin;
        
        for(int i = asciiInicio; i <= asciiFin; i++){
            lista.add((char) i);
        }
    }
    
    public LinkedList getLista(){
        return lista;
    }
    
    public String getNombre(){
        return nombre;
    }
    
}
