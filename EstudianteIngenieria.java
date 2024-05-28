import javax.swing.*;
import java.util.ArrayList;

public class EstudianteIngenieria extends Estudiante {
    private int semestre;
    private float promedio;
    private ArrayList<EstudianteIngenieria> estudiantesIngenieria = new ArrayList<>();

    public EstudianteIngenieria(int cedula, String nombre, String apellido, int telefono, int semestre, float promedio) {
        super(cedula, nombre, apellido, telefono);
        this.semestre = semestre;
        this.promedio = promedio;
    }

    public EstudianteIngenieria() {

    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public EstudianteIngenieria registrarEstudianteIngenieria() {
        int cedula=0;
        do{cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del estudiante: "));
            if (cedula<0){
                JOptionPane.showMessageDialog(null, "Cédula no váida.");
            }
        }while(cedula<0);
        String name="";
        do{name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
            if (name.length() == 0){
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            }    
        }while(name.length() == 0);
        String lastName="";
        do{lastName = JOptionPane.showInputDialog("Ingrese el apellido del estudiante: ");
            if (lastName.length()==0){
                JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío.");
            }    
        }while(lastName.length()==0);
        int telefono=0;
        do{telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del estudiante: "));
            if (telefono<0){
                JOptionPane.showMessageDialog(null, "Teléfono no váido.");
            }
        }while(telefono<0);
        int numSemestre=0;
        do{numSemestre = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de semestres: "));
            if (numSemestre<0 || numSemestre>11){
                JOptionPane.showMessageDialog(null, "Semestre no váido.");
            }
        }while(numSemestre<0 || numSemestre>11);
        float prom=0;
        do{prom = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el promedio: "));
            if (prom<0 || prom>5){
                JOptionPane.showMessageDialog(null, "Promedio no váido.");
            }
        }while(prom<0 || prom>5);

        EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula,name,lastName,telefono, numSemestre,prom);

        estudiantesIngenieria.add(estudiante);
        JOptionPane.showMessageDialog(null, "ESTUDIANTE CREADO");
        return estudiante;
    }

    public EstudianteIngenieria buscarEstudianteIngenieria(int cedula) {
        for (EstudianteIngenieria estudiante : estudiantesIngenieria) {
            if (estudiante.getCedula() == cedula) {
                return estudiante;
            }
        }
        return null;
    }

    public static void menuEstudiantesIngenieria(EstudianteIngenieria modelo) {
        GestionPrestamos gestion = new GestionPrestamos();
        int opcion =0;
        do{opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer?\n" +
                "1. Registrar préstamo de equipo.\n" +
                "2. Modificar préstamo de equipo.\n" +
                "3. Devolución de equipo.\n" +
                "4. Buscar equipo.\n" +
                "5. Volver al menú principal.\n" +
                "Ingrese una opción:"));
            switch (opcion) {
                case 1:
                    gestion.registrarPrestamoIngenieria(modelo);
                    break;
                case 2:
                    //LO MISMO QUE EL CASO 4 DE ESTUDIANTE DISEÑO
                    String nombre = JOptionPane.showInputDialog("INGRESA EL NOMBRE.");
                    String apellido = JOptionPane.showInputDialog("INGRESA EL APELLIDO.");
                    int telefono = Integer.parseInt(JOptionPane.showInputDialog("INGRESA EL TELEFONO."));
                    int semestre = Integer.parseInt(JOptionPane.showInputDialog("INGRESA EL SEMESTRE:"));
                    int promedio =  Integer.parseInt(JOptionPane.showInputDialog("INGRESA EL PROMEDIO."));
                    String serial = JOptionPane.showInputDialog("INGRESA EL SERIAL.");
                    gestion.modificarPrestamoIngenieria(modelo, nombre, apellido, telefono, semestre, promedio, serial);
                    break;
                case 3:
                    //PEDIR SERIAL
                    String serialDevolucion = JOptionPane.showInputDialog("INGRESE SERIAL");
                    gestion.devolucionEquipoIngenieria(serialDevolucion);
                    break;
                case 4:
                    //PEDIR SERIAL
                    String serialBuscar = JOptionPane.showInputDialog("INGRESE SERIAL");
                    gestion.buscarEquipoIngenieria(serialBuscar);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Devolviendo al menú principal...");
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }while(opcion!=5);
    }


}
