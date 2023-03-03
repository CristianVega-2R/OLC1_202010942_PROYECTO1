import java.util.LinkedList;

public class Tabla {
    private LinkedList filas;
    
    public Tabla(){
        filas = new LinkedList();
    }
    
    public static void main(String[] args){
        LinkedList inicio = new LinkedList();
        inicio.add(1);
        inicio.add(2);
        inicio.add(3);
        LinkedList siguiente = new LinkedList();
        siguiente.add(4);
        siguiente.add(5);
        LinkedList inicio2 = new LinkedList();
        inicio2.add(1);
        inicio2.add(2);
        LinkedList siguiente2 = new LinkedList();
        siguiente2.add(1);
        siguiente2.add(2);
        siguiente2.add(3);
        siguiente2.add(4);
        siguiente2.add(5);
        Tabla tabla = new Tabla();
        tabla.setFila(1);
        tabla.setFila(2);
        tabla.setFila(3);
        
        tabla.setColumnas(inicio, siguiente);
        tabla.setColumnas(inicio2, siguiente2);
        tabla.mostrarTabla();
    }
     
    public void setFila(int hoja){
        filas.add(new Fila(hoja));
    }

    public void setFila(int hoja, String token){
        filas.add(new Fila(hoja,token));
    }
    
    public void setColumnas(LinkedList inicios, LinkedList siguientes){
        int ninicios = inicios.size();
        int nsiguientes = siguientes.size();
        for(int i = 0; i < ninicios; i++){
            for(int j = 0; j < nsiguientes; j++){
                int fila = (Integer) inicios.get(i);
                int valor = (Integer) siguientes.get(j);
                setColumna(fila,valor);
            }
        }
    }
    
    public void setColumna(int fila, int valor){
        int nfila = filas.size();
        for(int i = 0; i < nfila; i++){
            Fila filaActual = (Fila) filas.get(i);
            if(filaActual.getEncabezado() == fila){
                filaActual.setColumna(valor);
            }
        }
    }
    
    public void setColumna(int fila, int valor, String conjunto){
        int nfila = filas.size();
        for(int i = 0; i < nfila; i++){
            Fila filaActual = (Fila) filas.get(i);
            if(filaActual.getEncabezado() == fila){
                filaActual.setColumnaTransicion(valor,conjunto);
            }
        }
    }
    
    public LinkedList getColumna(int fila){
        Fila filaActual = (Fila) filas.get(fila);
        return filaActual.getColumna();
    }
    
    public int getEncabezado(int fila){
        Fila filaActual = (Fila) filas.get(fila);
        return filaActual.getEncabezado();
    }
    
    public Fila getFila(int fila){
        Fila filaActual = (Fila) filas.get(fila);
        return filaActual;
    }
    
    public String getToken(int fila){
        Fila filaActual = (Fila) filas.get(fila);
        return filaActual.getToken();
    }
    
    public int getFilas(){
        return filas.size();
    }
    
    public void mostrarTabla(){
        int nfilas = filas.size();
        String resultado = "";
        for(int i = 0; i < nfilas; i++){
            Fila filaActual = (Fila) filas.get(i);
            resultado += filaActual.getToken() + " | " + filaActual.getEncabezado() + " " + filaActual.mostrarFila() + "\n";
        }
        System.out.println(resultado);
    }
    
    public void mostrarTablaTransiciones(){
        int nfilas = filas.size();
        String resultado = "";
        for(int i = 0; i < nfilas; i++){
            Fila filaActual = (Fila) filas.get(i);
            resultado += filaActual.getToken() + " | " + filaActual.getEncabezado() + " " + filaActual.mostrarFilaTransiciones() + "\n";
        }
        System.out.println(resultado);
    } 
}