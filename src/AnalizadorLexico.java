import java.util.LinkedList;

public class AnalizadorLexico {
    private String entrada;
    private String nombreAutomata;
    private Tabla automata;
    private LinkedList conjuntos;
    private int estado = 0;
    private int posicion = 0;
     
    public AnalizadorLexico(String entrada, Tabla automata, LinkedList conjuntos, String nombreAutomata){
        this.entrada = entrada;
        this.automata = automata;
        this.conjuntos = conjuntos;
        this.nombreAutomata = nombreAutomata;
    }
    
    public boolean buscarCoincidenciaConjunto(char caracter, String conjunto){
        Conjunto conjSeleccionado = null;
        for(int i = 0; i < conjuntos.size(); i++){
            conjSeleccionado = (Conjunto) conjuntos.get(i);
            if(conjSeleccionado.getNombre().equals(conjunto)) break;
        }
        
        LinkedList caracteres = conjSeleccionado.getLista();
        char caracterAux = ' ';
        for(int i = 0; i < caracteres.size(); i++){
            caracterAux = (char) caracteres.get(i);
            if(caracterAux == caracter) return true;
        }
        return false;
    }
    
    public Resultado resultado;
    public String errores = "";
    
    public Resultado pasarCaracter() throws InterruptedException{
        LinkedList transiciones;
        LinkedList tokens;
        Resultado result;
        
        
        
        while(comprobarFinalCadena() == false){
            transiciones = automata.getFila(estado).getColumna();
            tokens = automata.getFila(estado).getTokens();
            for(int i = 0; i < transiciones.size(); i++){
                String tokenActual = (String) tokens.get(i);
                char puntero = entrada.charAt(posicion);
                if(tokenActual.charAt(0)!='"'){
                    if(buscarCoincidenciaConjunto(puntero,tokenActual)){
                        estado = (int) transiciones.get(i);
                        posicion++;
                        break;
                    }
                }else{
                    if(tokenActual.charAt(1) == puntero){
                        estado = (int) transiciones.get(i);
                        posicion++;
                        break;
                    } 
                }
                if(i == transiciones.size() - 1){
                    return new Resultado(nombreAutomata, entrada, "no aprobado");
                }
            }
            
        }
        
        return resultado;
    }
    
    public boolean comprobarFinalCadena(){
        if(entrada.length() <= posicion){
            for(int i = 0; i < automata.getFila(estado).getTokens().size(); i++){
                if(automata.getFila(estado).getTokens().get(i).equals("#")){
                    resultado = new Resultado(nombreAutomata, entrada, "aprobado");
                    return true;
                }
            }
            resultado = new Resultado(nombreAutomata, entrada, "no aprobado");
            return true;
        }
        return false;
    }
}
