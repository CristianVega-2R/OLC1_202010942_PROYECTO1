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
        
        char letras [] = {'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char numeros [] = {'0','1','2','3','4','5','6','7','8','9'};
        
        boolean soloSimbolosInicio = true;
        boolean soloSimbolosFin = true;
        boolean agregar = true;
        
        for(int i = 0; i < letras.length; i++){
            if(letras[i]==cInicio){
                soloSimbolosInicio = false;
            }
            if(letras[i]==cFin){
                soloSimbolosFin = false;
            }
        }
        
        if(soloSimbolosInicio == true || soloSimbolosFin == true){
            soloSimbolosInicio = true;
            soloSimbolosFin = true;
            for(int i = 0; i < numeros.length; i++){
                if(numeros[i]==cInicio){
                    soloSimbolosInicio = false;
                }
                if(numeros[i]==cFin){
                    soloSimbolosFin = false;
                }
            }
        }
        
        for(int i = asciiInicio; i <= asciiFin; i++){
            char caracter = (char) i;
            agregar = true;
            if(soloSimbolosInicio == true || soloSimbolosFin == true){
                for(int j = 0; j < letras.length; j++){
                    if(caracter == letras[j]){
                        agregar = false;
                    }
                }

                for(int j = 0; j < numeros.length; j++){
                    if(caracter == numeros[j]){
                        agregar = false;
                    }
                } 
            }
            
            if(agregar == true){
                lista.add(caracter);
            }
            
        }
        
        
    }
    
    public LinkedList getLista(){
        return lista;
    }
    
    public String getNombre(){
        return nombre;
    }
    
}
