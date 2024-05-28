import javax.swing.*;
import java.util.ArrayList;

public class ComputadorPortatil extends Equipo {
    private int sistemaOperativo;
    private int procesador;
    private ArrayList<ComputadorPortatil> computadoresPortatiles = new ArrayList<>();

    public ComputadorPortatil() {
    }

    public ComputadorPortatil(String serial, String marca, float tamaño, float precio, float peso, boolean disponible, int sistemaOperativo, int procesador) {
        super(serial, marca, tamaño, precio, peso, disponible);
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public int getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(int sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getProcesador() {
        return procesador;
    }

    public void setProcesador(int procesador) {
        this.procesador = procesador;
    }

    public ArrayList<ComputadorPortatil> getComputadoresPortatiles() {
        return computadoresPortatiles;
    }

    public void setComputadoresPortatiles(ArrayList<ComputadorPortatil> computadoresPortatiles) {
        this.computadoresPortatiles = computadoresPortatiles;
    }

    public ComputadorPortatil registrarComputadorPortatil() {
        String serial = "";
        do{serial = JOptionPane.showInputDialog("Ingrese el serial del computador portátil: ");
            if (serial.length() == 0){
                JOptionPane.showMessageDialog(null, "Serial no válido.");
            }    
        }while(serial.length() == 0);
        String marca = "";
        do{marca = JOptionPane.showInputDialog("Ingrese la marca del computador portátil: ");
            if (marca.length() == 0){
                JOptionPane.showMessageDialog(null, "Marca no válida.");
            }    
        }while(marca.length() == 0);
        float tamaño = 0;
        do{tamaño = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño del computador portátil:"));
            if (tamaño <= 0){
                JOptionPane.showMessageDialog(null, "Tamaño no válido.");
            }    
        }while(tamaño <= 0);
        float precio = 0;
        do{precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del computador portátil:"));
            if (precio < 0){
                JOptionPane.showMessageDialog(null, "Valor no válido.");
            }    
        }while(precio < 0);
        float peso = 0;
        do{peso = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso del computador portátil:"));
            if (peso <= 0){
                JOptionPane.showMessageDialog(null, "Peso no válido.");
            }    
        }while(peso <= 0);
        int sistemaOperativo = 0;
        do{sistemaOperativo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el sistema operativo del computador portátil:\n" +
                "1.Windows 7 \n" +
                "2.Windows 10\n" +
                "3.Windows 11"));
                if(sistemaOperativo<1 || sistemaOperativo>3){
                    JOptionPane.showMessageDialog(null, "Seleccione una opción correcta.");
                }
        }while(sistemaOperativo<1 || sistemaOperativo>3);
        int procesador = 0;
        do{procesador=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el procesador del computador portátil:\n" +
                "1.AMD Ryzen \n" +
                "2.Intel Core i5"));
                if(procesador<1 || procesador>2){
                    JOptionPane.showMessageDialog(null, "Seleccione una opción correcta.");
                }
        }while(procesador<1 || procesador>2);
        boolean disponible = true;
        ComputadorPortatil portatil = new ComputadorPortatil(serial, marca, tamaño, precio, peso, disponible,sistemaOperativo, procesador);
        computadoresPortatiles.add(portatil);
        return portatil;
    }
    public void buscarEquipoIngenieria(String serial) {
        for (ComputadorPortatil portatil : computadoresPortatiles ){
            if(portatil.getSerial().equals(serial)){
                JOptionPane.showMessageDialog(null, portatil);
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE :,(");
            }
        }
    }

}
