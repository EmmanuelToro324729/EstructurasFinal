import javax.swing.*;
import java.util.ArrayList;

public class TabletaGrafica extends Equipo {
    private int almacenamiento;
    private ArrayList<TabletaGrafica> tabletasGraficas = new ArrayList<>();

    public TabletaGrafica(String serial, String marca, float tamaño, float precio, float peso,boolean disponible, int almacenamiento) {
        super(serial, marca, tamaño, precio, peso, disponible);
        this.almacenamiento = almacenamiento;
    }

    public TabletaGrafica() {

    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public ArrayList<TabletaGrafica> getTabletasGraficas() {
        return tabletasGraficas;
    }

    public void setTabletasGraficas(ArrayList<TabletaGrafica> tabletasGraficas) {
        this.tabletasGraficas = tabletasGraficas;
    }

    public TabletaGrafica registrarTabletaGrafica() {
        String serial = "";
        do{serial = JOptionPane.showInputDialog("Ingrese el serial de la tableta gráfica: ");
            if (serial.length() == 0){
                JOptionPane.showMessageDialog(null, "Serial no válido.");
            }    
        }while(serial.length() == 0);
        String marca = "";
        do{marca = JOptionPane.showInputDialog("Ingrese la marca de la tableta gráfica: ");
            if (marca.length() == 0){
                JOptionPane.showMessageDialog(null, "Marca no válida.");
            }    
        }while(marca.length() == 0);
        float tamaño = 0;
        do{tamaño = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño de la tableta gráfica:"));
            if (tamaño <= 0){
                JOptionPane.showMessageDialog(null, "Tamaño no válido.");
            }    
        }while(tamaño <= 0);
        float precio = 0;
        do{precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio de la tableta gráfica:"));
            if (precio < 0){
                JOptionPane.showMessageDialog(null, "Valor no válido.");
            }    
        }while(precio < 0);
        float peso = 0;
        do{peso = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso de la tableta gráfica:"));
            if (peso <= 0){
                JOptionPane.showMessageDialog(null, "Peso no válido.");
            }    
        }while(peso <= 0);
        int almacenamiento = 0;
        do{almacenamiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el almacenamiento de la tableta gráfica:\n" +
        "1. 256GB \n" +
        "2. 512GB \n" +
        "3. 1TB"));
            if (almacenamiento < 1 || almacenamiento>3){
                JOptionPane.showMessageDialog(null, "Seleccione una opción correcta.");
            }    
        }while(almacenamiento < 1 || almacenamiento>3);
        
        boolean disponible = true;
        TabletaGrafica tableta = new TabletaGrafica(serial, marca, tamaño, precio, peso, disponible,almacenamiento);
        tabletasGraficas.add(tableta);
        return tableta;
    }
}
