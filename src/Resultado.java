public class Resultado {
    private String automata;
    private String cadena;
    private String aprobado;
    
    public Resultado(String automata, String cadena, String aprobado){
        this.automata = automata;
        this.cadena = cadena;
        this.aprobado = aprobado;
    }
    
    public String getAutomata(){
        return automata;
    }
    public String getCadena(){
        return cadena;
    }   
    public String getAprobado(){
        return aprobado;
    }
}
