import com.google.gson.Gson;
import java.awt.Dimension;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ventana extends javax.swing.JFrame {
    public Ventana() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cupFlex1 = new CupFlex();
        cupFlex2 = new CupFlex();
        cupFlex3 = new CupFlex();
        cupFlex4 = new CupFlex();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_entrada = new javax.swing.JTextArea();
        btn_automata = new javax.swing.JButton();
        btn_analizar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultadosCadenas = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        imagenes = new javax.swing.JComboBox<>();
        imagenActual = new javax.swing.JPanel();
        imagenActualLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");

        jButton3.setText("Guardar como");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        txt_entrada.setColumns(20);
        txt_entrada.setRows(5);
        jScrollPane1.setViewportView(txt_entrada);

        btn_automata.setText("Generar autómata");
        btn_automata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_automataActionPerformed(evt);
            }
        });

        btn_analizar.setText("Analizar entrada");
        btn_analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_automata, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_analizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_automata)
                    .addComponent(btn_analizar))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));

        resultadosCadenas.setColumns(20);
        resultadosCadenas.setRows(5);
        jScrollPane2.setViewportView(resultadosCadenas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));

        imagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenActualLayout = new javax.swing.GroupLayout(imagenActual);
        imagenActual.setLayout(imagenActualLayout);
        imagenActualLayout.setHorizontalGroup(
            imagenActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenActualLayout.createSequentialGroup()
                .addComponent(imagenActualLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        imagenActualLayout.setVerticalGroup(
            imagenActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenActualLayout.createSequentialGroup()
                .addComponent(imagenActualLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagenActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagenes, 0, 287, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_automataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_automataActionPerformed
        analizarSintactico();        
    }//GEN-LAST:event_btn_automataActionPerformed

    private void btn_analizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analizarActionPerformed
        
        int cantidadConjunto = CUP$Sintax$actions.conjuntos.size();
        int cantidadArbol = CUP$Sintax$actions.raices.size();
        int cantidadTablas = CUP$Sintax$actions.tablas.size();
        
        conjuntos = CUP$Sintax$actions.conjuntos;
        lexemas = CUP$Sintax$actions.lexemas;
        raices = CUP$Sintax$actions.raices;
        
        for(int i = 0 ; i < conjuntos.size(); i++){
            Conjunto conjunto = (Conjunto) conjuntos.get(i);
            System.out.println(conjunto.getLista());
        }
        
        for(int i = 0; i < cantidadArbol; i++){
            // Creando arbol y tabla
            Raiz raiz = (Raiz) raices.get(i);
            Arbol arbol = raiz.getRaiz();
            String nombre = raiz.getNombre();
            recorrerArbol(arbol);
            
            crearDot(nombre+"Arbol", graphviz);
            crearImagen(nombre+"Arbol");
            imagenes.addItem(nombre + "Arbol"); 
            
            Tabla tabla = (Tabla) CUP$Sintax$actions.tablas.get(i);
            Transiciones tablaTransicion = new Transiciones(tabla, arbol.getPrimeros());
            tablaTransicion.obtenerGrupos();
            tablaTransicion.crearTransiciones();
            tablaTransicion.crearTablaTransicionesGrafica();
            
            graphvizTabla = tablaTransicion.construirTablaSiguientes();
            crearDot(nombre+"Siguientes", graphvizTabla);
            crearImagen(nombre+"Siguientes");
            imagenes.addItem(nombre + "Siguientes"); 
            
            graphvizTablaTransicion = tablaTransicion.construirTablaTransiciones();
            crearDot(nombre+"Transiciones", graphvizTablaTransicion);
            crearImagen(nombre+"Transiciones");
            imagenes.addItem(nombre + "Transiciones");
            
            
            graphvizDiagrama = tablaTransicion.construirAutomata();
            crearDot(nombre+"Automata",graphvizDiagrama);
            crearImagen(nombre+"Automata");
            imagenes.addItem(nombre + "Automata");
            
            graphviz = "";
            graphvizTabla = "";
            graphvizTablaTransicion = "";
            graphvizDiagrama = "";
            
            tablasTransicion.add(tablaTransicion);
        }    
        Lexema lex;
        Raiz raiz;
        Transiciones automata;
        List<Resultado> list = new ArrayList<>();
        for(int i = 0; i < lexemas.size(); i++){
            lex = (Lexema) lexemas.get(i);
            for(int j = 0; j < raices.size(); j++){
                raiz = (Raiz) raices.get(j);
                automata = (Transiciones) tablasTransicion.get(j);
                if(lex.getNombre().equals(raiz.getNombre())){
                    String lexArreglado = lex.getCadena().substring(1, lex.getCadena().length() - 1);
                    AnalizadorLexico analizar = new AnalizadorLexico(lexArreglado,automata.getTransiciones(),conjuntos, lex.getNombre());
                    
                    try {
                        Resultado resultado = analizar.pasarCaracter();
                        resultadosCadenas.append("La cadena "+ resultado.getCadena() +" " + resultado.getAprobado() + " por el automata "+ resultado.getAutomata() +"\n");
                        list.add(resultado);
                    } catch (InterruptedException ex) {}
                }
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        try{
            File file = new File("resultados.json");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(json);
            // Close the BufferedWriter object to ensure that all data is written to the file
            bufferedWriter.close();
        }catch(Exception e){
            
        }
        
        
    }//GEN-LAST:event_btn_analizarActionPerformed

    private void imagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenesActionPerformed
        String ruta = "C:\\Users\\Cristian\\Documents\\NetBeansProjects\\Proyecto1\\" + (String) imagenes.getSelectedItem() + ".png";
        
        ImageIcon imagen = new ImageIcon(ruta);
        Image imagenAjustada = imagen.getImage().getScaledInstance(imagenActual.getWidth(), imagenActual.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagenFinal = new ImageIcon(imagenAjustada);    
        imagenActualLabel.setIcon(imagenFinal);
    }//GEN-LAST:event_imagenesActionPerformed

    public String graphviz = "";
    public String graphvizTabla = "";
    public String graphvizDiagrama = "";    
    public String graphvizTablaTransicion = "";
    public LinkedList tablasTransicion = new LinkedList();
    public LinkedList conjuntos = new LinkedList();
    public LinkedList lexemas = new LinkedList();
    public LinkedList raices = new LinkedList();
    
    private void crearImagen(String nombre){
        String dotFilePath = "C:/Users/Cristian/Documents/NetBeansProjects/Proyecto1/"+nombre+".dot";
        String pngFilePath = "C:/Users/Cristian/Documents/NetBeansProjects/Proyecto1/"+nombre+".png";
        
        try {
            // Create a ProcessBuilder object
            ProcessBuilder builder = new ProcessBuilder("C:/Program Files/Graphviz/bin/dot.exe", "-Tpng", dotFilePath, "-o", pngFilePath);
            
            // Start the process
            Process process = builder.start();
            
            // Wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Conversion complete.");
            } else {
                System.err.println("Conversion failed with exit code " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void crearDot(String nombre, String contenido){
        try{
            File archivo = new File(nombre+".dot");
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            contenido = "digraph G{\n"+ contenido + "\n}";
            bw.write(contenido);
            bw.close();
        }catch(Exception ex){
            System.out.println("Error al intentar crear archivo");
        }
    }
    
    private void recorrerArbol(Arbol raiz){
        if(raiz == null){
            return;
        }else{     
            // Id actual, id izq e id der
            
            graphArbol(raiz);
            
            // Crear el nodo
            recorrerArbol(raiz.ramaIzq);
            recorrerArbol(raiz.ramaDer);  
        }
    }
    
    private void graphArbol(Arbol raiz){
        String id = String.valueOf(raiz.getId());
        String valor = raiz.getValor();
        String anulabilidad = raiz.getAnulabilidad();
        String primeros = raiz.getPrimerosText();
        String ultimos = raiz.getUltimosText();
        
        if(valor.charAt(0) == '"'){
            valor = valor.substring(1, valor.length()-1);
        }
        
        graphviz += "Nodo"+id+"[shape=none label=<<table border=\"0\" cellpadding=\"4\" cellspacing=\"0\">\n";
        graphviz += "<tr>\n<td colspan=\"3\">"+anulabilidad+"</td>\n</tr>";
        graphviz+= "<tr><td>"+primeros+"</td>";
        graphviz += "<td bgcolor=\"#336699\">"+valor+"</td>";
        graphviz += "<td>"+ultimos+"</td>\n</tr>\n</table>>];";
       // graphviz += "Nodo"+ id +"[label=\"" + valor +"\"];\n";
            
        if(raiz.ramaIzq != null){
           String idIzq = String.valueOf(raiz.ramaIzq.getId());
           graphviz += "Nodo" + id + "->Nodo" + idIzq + "\n";
        }
        if(raiz.ramaDer != null){
            String idDer = String.valueOf(raiz.ramaDer.getId());
            graphviz += "Nodo" + id + "->Nodo" + idDer + "\n";
        }
    }
    
    
    private void analizarLexico(){
        String contenido = txt_entrada.getText();
        LexerCup lexer = new LexerCup(new StringReader(contenido));
    }
    
    private void analizarSintactico(){
        String contenido = txt_entrada.getText();
        Sintax sintaxis = new Sintax(new LexerCup(new StringReader(contenido)));
        
        try{
            sintaxis.parse();
            System.out.println("Sintaxis y lexemas correctos");
        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_analizar;
    private javax.swing.JButton btn_automata;
    private CupFlex cupFlex1;
    private CupFlex cupFlex2;
    private CupFlex cupFlex3;
    private CupFlex cupFlex4;
    private javax.swing.JPanel imagenActual;
    private javax.swing.JLabel imagenActualLabel;
    private javax.swing.JComboBox<String> imagenes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea resultadosCadenas;
    private javax.swing.JTextArea txt_entrada;
    // End of variables declaration//GEN-END:variables
}
