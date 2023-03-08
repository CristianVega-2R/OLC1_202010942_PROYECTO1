import java.util.LinkedList;
import java.util.Set;

public class Transiciones {
    private Tabla tablaEstados = new Tabla();
    private Tabla tablaSiguientes = new Tabla();
    private Tabla tablaTransiciones = new Tabla();
    private Tabla tablaTransicionesGrafica = new Tabla();
    
    public static void main(String [] args){
        Tabla tablaSiguiente = new Tabla();
        LinkedList inicios = new LinkedList();
        inicios.add(1);
        inicios.add(2);
        LinkedList siguientes = new LinkedList();
        siguientes.add(0);
        LinkedList inicios2 = new LinkedList();
        inicios2.add(3);
        inicios2.add(4);
        inicios2.add(5);
        inicios2.add(6);
        LinkedList siguientes2 = new LinkedList();
        siguientes2.add(2);
        LinkedList primerEstado = new LinkedList();
        primerEstado.add(6);
        primerEstado.add(5);
        primerEstado.add(4);
        primerEstado.add(3);
        primerEstado.add(1);
        
        tablaSiguiente.setFila(1,"f");
        tablaSiguiente.setFila(2,"e");
        tablaSiguiente.setFila(3,"d");
        tablaSiguiente.setFila(4,"c");
        tablaSiguiente.setFila(5,"b");
        tablaSiguiente.setFila(6,"a");
        tablaSiguiente.setFila(0,"#");
        tablaSiguiente.setColumnas(inicios, siguientes);
        tablaSiguiente.setColumnas(inicios2, siguientes2);
        Transiciones tablaTransicion = new Transiciones(tablaSiguiente,primerEstado);
        tablaTransicion.obtenerGrupos();
        tablaTransicion.crearTransiciones();
        tablaTransicion.crearTablaTransicionesGrafica();
        
    }
    
    public Transiciones(Tabla tablaSiguientes, LinkedList primeros){
        this.tablaSiguientes = tablaSiguientes;
        agregarColumna(primeros);
    }
    
    public void obtenerGrupos(){
        boolean aprobado = true;
        LinkedList columnaSiguiente, columnaTransicion;
        for(int i = 0; i < tablaSiguientes.getFilas(); i++){
            aprobado = true;
            columnaSiguiente = tablaSiguientes.getColumna(i);
            for(int j = 0; j < tablaEstados.getFilas(); j++){
                
                columnaTransicion = tablaEstados.getColumna(j);
                if(!comprobarExistencia(columnaSiguiente, columnaTransicion)){
                    aprobado = false;
                }
            }
            if(aprobado)agregarColumna(columnaSiguiente);
        }
    }
    
    public boolean comprobarExistencia(LinkedList elementosTransicion, LinkedList elementosSiguiente){
        int nsiguiente = elementosSiguiente.size();
        int ntransicion = elementosTransicion.size();
        int cantidadReprobado = 0;
        boolean aprobado = true;
        
        if(nsiguiente != ntransicion) return true;
        
        for(int i = 0; i < elementosSiguiente.size(); i++){
            aprobado = true;
            for(int j = 0; j < elementosTransicion.size(); j++){
                if(elementosSiguiente.get(i) == elementosTransicion.get(j)) aprobado = false; 
            }
            if(aprobado == false) cantidadReprobado++;
        }
        if(cantidadReprobado == nsiguiente) return false;
        return true;
    }
    
    public void agregarColumna(LinkedList columna){
        int estado = tablaEstados.getFilas();
        tablaEstados.setFila(estado);
        
        for(int i = 0; i < columna.size(); i++){
            int elemento = (Integer) columna.get(i);
            tablaEstados.setColumna(estado, elemento);
        }
    }
    
    public Tabla getEstados(){
        return tablaEstados;
    }
    
    public Tabla getTransiciones(){
        return tablaTransiciones;
    }
    
    public Tabla getTransicionesGrafica(){
        return tablaTransicionesGrafica;
    }
    
    public void crearTransiciones(){
        LinkedList estadoSiguiente;
        int transicion = 0;
        String conjunto = "";
        // Checar cada uno de los estados e ir elemento por elemento
        for(int i = 0; i < tablaEstados.getFilas(); i++){
            tablaTransiciones.setFila(tablaEstados.getEncabezado(i));
            LinkedList transiciones = tablaEstados.getColumna(i);
            for(int j = 0; j < transiciones.size(); j++){
                int movimiento = (Integer) transiciones.get(j); // Transicion actual, buscarla en los siguientes
                Fila fila = buscarIndice(movimiento);
                // Ver a que estado hace referencia esta fila
                estadoSiguiente = fila.getColumna();
                transicion = buscarEstado(estadoSiguiente);
                conjunto = fila.getToken();
                tablaTransiciones.setColumna(i, transicion, conjunto);
            }
        }
    }
    
    public Fila buscarIndice(int indice){
        Fila fila = null;
        for(int i = 0; i < tablaSiguientes.getFilas(); i++){
            if(tablaSiguientes.getEncabezado(i) == indice) return tablaSiguientes.getFila(i);
        
        }
        return fila;
    }
    
    public boolean compararEstados(LinkedList columnaSiguiente, LinkedList columnaEstado){
        if(columnaSiguiente.size() != columnaEstado.size()) return false;
        
        for(int i = 0; i < columnaSiguiente.size(); i++){
            if(columnaSiguiente.get(i) != columnaEstado.get(i)) return false;
        }
        return true;
    }
    
    public int buscarEstado(LinkedList estado){
        for(int i = 0; i < tablaEstados.getFilas(); i++){
            if(compararEstados(estado,tablaEstados.getColumna(i))) return tablaEstados.getEncabezado(i);
        }
        return 0;
    }
    
    public String construirAutomata(){
        String automata = "";
        Fila filaActual;
        LinkedList estadosSiguientes;
        LinkedList tokens;
        int estado = 0;
        int estadoSiguiente = 0;
        String token = "";
        Fila transicion;
        for(int i = 0; i < tablaTransiciones.getFilas()-1; i++){
            filaActual = tablaTransiciones.getFila(i);
            estado = tablaTransiciones.getEncabezado(i);
            estadosSiguientes = filaActual.getColumna();
            tokens = filaActual.getTokens();
            automata += "Nodo" + String.valueOf(estado) + "[label=\"S"+ String.valueOf(estado) +"\"];\n";
            for(int j = 0; j < estadosSiguientes.size(); j++){
                estadoSiguiente = (int) estadosSiguientes.get(j);
                token = (String) tokens.get(j);
                if(token.charAt(0) == '"'){
                    token = token.substring(1, token.length()-1);
                }
                if(String.valueOf(token).equals("#")){
                    automata += "Nodo"+String.valueOf(estado)+"[style=\"rounded\", penwidth=2, peripheries=2];\n";
                }else{
                    automata += "Nodo"+ String.valueOf(estado) + "->Nodo" + String.valueOf(estadoSiguiente) + "[label=\""+ token +"\"];\n";
                }
                
                
            }
        }
        return automata;
        
    }
    
    public String construirTablaSiguientes(){
        String tabla = "node[shape=none];\ntable[label=<<table border=\"1\" cellborder=\"1\" cellspacing=\"0\">\n";
        LinkedList columnaActual;
        int encabezado = 0;
        String token = "";
        for(int i = 0; i < tablaSiguientes.getFilas(); i++){
            columnaActual = tablaSiguientes.getColumna(i);
            encabezado = tablaSiguientes.getEncabezado(i);
            token = tablaSiguientes.getToken(i);
            tabla += "<tr>\n<td>"+token+"</td>\n<td>"+encabezado+"</td>\n<td>\"";
            for(int j = 0; j < columnaActual.size(); j++){
                tabla+=String.valueOf(columnaActual.get(j));
                if(j!=columnaActual.size()-1) tabla+=", ";
            }
            tabla+="\"</td>\n</tr>\n";
        }
        tabla += "</table>>];\n";
        return tabla;
    }
    
    public void crearTablaTransicionesGrafica(){
        agregarEncabezadosGrafica();
        llenarTabla();
        LinkedList transiciones;
        LinkedList caracteres;
        LinkedList estadoCorrespondiente;
        int posInsertar = 0;
        for(int i = 0; i < tablaTransiciones.getFilas(); i++){
           transiciones = tablaTransiciones.getFila(i).getColumna();
           caracteres = tablaTransiciones.getFila(i).getTokens();
           estadoCorrespondiente = tablaTransicionesGrafica.getFila(i+1).getTokens();
           for(int j = 0; j < transiciones.size(); j++){
               posInsertar = buscarEncabezadoGrafica((String) caracteres.get(j));
               String valor = String.valueOf(transiciones.get(j));
               estadoCorrespondiente.set(posInsertar,valor);
           }
        }
    }
    
    public void llenarTabla(){
        for(int i = 0; i < tablaTransiciones.getFilas(); i++){
            tablaTransicionesGrafica.setFila(i);
            for(int j = 0; j < tablaSiguientes.getFilas(); j++){
                tablaTransicionesGrafica.setColumna(i, 0, "");
            }
        }
        
    }
    
    public void agregarEncabezadosGrafica(){
        tablaTransicionesGrafica.setFila(-1);
        for(int i = 0; i < tablaSiguientes.getFilas(); i++){
            tablaTransicionesGrafica.setColumna(-1,0,tablaSiguientes.getToken(i));
        }
    }
    
    public int buscarEncabezadoGrafica(String elemento){
        for(int i = 0; i < tablaSiguientes.getFilas(); i++){
            if(tablaSiguientes.getToken(i).equals(elemento)) return i;
        }
        return 0;
    }
    
    public String construirTablaTransiciones(){
        String tabla = "node[shape=none];\ntable[label=<<table border=\"1\" cellborder=\"1\" cellspacing=\"0\">\n";
        LinkedList columnaActual;
        String token = "";
        int encabezado;
        for(int i = 0; i < tablaTransicionesGrafica.getFilas()-1; i++){
            columnaActual = tablaTransicionesGrafica.getFila(i).getTokens();
            encabezado = tablaTransicionesGrafica.getEncabezado(i);
            tabla += "<tr>\n<td>"+encabezado+"</td>\n";
            for(int j = 0; j < columnaActual.size(); j++){
                tabla+="<td>\n";
                tabla+=String.valueOf(columnaActual.get(j));
                tabla+="</td>\n";
            }
            tabla+="</tr>\n";
        }
        tabla += "</table>>];\n";
        return tabla;
    }
}
