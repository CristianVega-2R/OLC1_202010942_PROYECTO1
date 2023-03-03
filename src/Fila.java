
import java.util.LinkedList;

public class Fila {
    private int encabezado;
    private LinkedList columnas;
    private LinkedList tokens = new LinkedList();
    private String token;
    
    
    public Fila(int encabezado){
        this.encabezado = encabezado;
        this.columnas = new LinkedList();
    }
    
    public Fila(int encabezado, String token){
        this.encabezado = encabezado;
        this.token = token;
        this.columnas = new LinkedList();
    }
    
    public void setColumna(int elemento){
        if(existeColumna(elemento)){
            columnas.add(elemento);
        }
    }
    
    public void setColumnaTransicion(int estado, String token){
        columnas.add(estado);
        tokens.add(token);
    }
    
    public LinkedList getColumna(){
        return columnas;
    }
    
    public LinkedList getTokens(){
        return tokens;
    }
    
    public boolean existeColumna(int elemento){
        int ncolumna = columnas.size();
        for(int i = 0; i < ncolumna; i++){
            int columna = (Integer) columnas.get(i);
            if(columna == elemento){
                return false;
            }
        }
        return true;
    }
    
    public int getEncabezado(){
        return encabezado;
    }
    
    public String getToken(){
        return token;
    }
    
    public String mostrarFila(){
        String fila = "| ";
        String aux = "";
        for(int i = 0; i < columnas.size(); i++){
            aux = String.valueOf(columnas.get(i));
            fila += aux + " | ";
        }
        return fila;
    }
    public String mostrarFilaTransiciones(){
        String fila = "| ";
        String aux = "";
        for(int i = 0; i < columnas.size(); i++){
            aux = "{ "+String.valueOf(columnas.get(i))+", "+tokens.get(i)+" }";
            fila += aux + " | ";
        }
        return fila;
    }
}
