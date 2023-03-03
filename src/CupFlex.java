
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CupFlex {
    public static void main(String [] args) throws IOException, Exception{
        String rutaFlex = "C:\\Users\\Cristian\\Documents\\NetBeansProjects\\Proyecto1\\src\\Gramatica.flex";
        String rutaCup = "C:\\Users\\Cristian\\Documents\\NetBeansProjects\\Proyecto1\\src\\Gramatica.cup";
        String [] rutasCup = {"-parser", "Sintax", rutaCup};
        
        File archivo = new File(rutaFlex);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutasCup);
        
        String rutaViejaSym = "C:\\Users\\Cristian\\Documents\\NetBeansProjects\\Proyecto1\\sym.java";
        String rutaNuevaSym = "C:\\Users\\Cristian\\Documents\\NetBeansProjects\\Proyecto1\\src\\sym.java";
        String rutaViejaSintax = "C:\\Users\\Cristian\\Documents\\NetBeansProjects\\Proyecto1\\Sintax.java";
        String rutaNuevaSintax = "C:\\Users\\Cristian\\Documents\\NetBeansProjects\\Proyecto1\\src\\Sintax.java";
        
        if(Files.exists(Paths.get(rutaNuevaSym))) Files.delete( Paths.get(rutaNuevaSym));
        Files.move(Paths.get(rutaViejaSym),Paths.get(rutaNuevaSym));
        if(Files.exists(Paths.get(rutaNuevaSintax))) Files.delete(Paths.get(rutaNuevaSintax));
        Files.move(Paths.get(rutaViejaSintax),Paths.get(rutaNuevaSintax));
    }
}
