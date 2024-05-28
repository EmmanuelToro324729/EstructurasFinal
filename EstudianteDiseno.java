import javax.swing.*;
import java.util.ArrayList;

public class EstudianteDiseno extends Estudiante {
    private int modalidad;
    private int asignaturas;
    private ArrayList<EstudianteDiseno> estudiantesDiseno = new ArrayList<>();

    public EstudianteDiseno(int cedula, String nombre, String apellido, int telefono, int modalidad, int asignaturas) {
        super(cedula, nombre, apellido, telefono);
        this.modalidad = modalidad;
        this.asignaturas = asignaturas;
    }

    public EstudianteDiseno() {
    }

    public int getModalidad() {
        return modalidad;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }



    public EstudianteDiseno registrarEstudianteDiseno() {
        int cedula=0;
        do{cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cédula del estudiante: "));
            if (cedula<0){
                JOptionPane.showMessageDialog(null, "Cédula no váida.");
            }
        }while(cedula<0);

        String name=""; 
        do{name = JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
            if (name.length()==0){
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            }    
        }while(name.length()==0);
        String lastName="";
        do{ lastName= JOptionPane.showInputDialog("Ingrese el apellido del estudiante: ");
            if (lastName.length()==0){
                JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío.");
            }    
        }while(lastName.length()==0);
        int telefono=0;
        do{ telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del estudiante: "));
            if (telefono<0){
                JOptionPane.showMessageDialog(null, "Teléfono no váido.");
            }
        }while(telefono<0);
        int modalidad=0;
        do{ modalidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la modalidad:\n1.Virtual.\n2. Presencial."));
            if (modalidad!=1 && modalidad !=2){
                JOptionPane.showMessageDialog(null, "Modalidad no váida.");
            }
        }while(modalidad!=1 && modalidad !=2);
        int numAsignaturas=0;
        do{ numAsignaturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de asignaturas: "));
            if (numAsignaturas<0 || numAsignaturas>10){
                JOptionPane.showMessageDialog(null, "Número de asignaturas no permitido.");
            }
        }while(numAsignaturas<0 || numAsignaturas>10);

        EstudianteDiseno estudiante = new EstudianteDiseno(cedula,name,lastName,telefono,modalidad,numAsignaturas);

        estudiantesDiseno.add(estudiante);

        JOptionPane.showMessageDialog(null, "ESTUDIANTE CREADO");
        return estudiante;
    }

    public EstudianteDiseno buscarEstudianteDiseno(int cedula) {
        for (EstudianteDiseno estudiante : estudiantesDiseno) {
            if (estudiante.getCedula() == cedula) {
                return estudiante;
            }
        }
        return null;
    }
    public static void menuEstudiantesDiseno(EstudianteDiseno modelo) {
        GestionPrestamos gestion = new GestionPrestamos();
        int opcion = 0;
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Menú Estudiantes de Diseño:\n" +
                    "1. Registrar préstamo de equipo.\n" +
                    "2. Modificar préstamo de equipo.\n" +
                    "3. Devolución de equipo.\n" +
                    "4. Buscar equipo.\n" +
                    "5. Volver al menú principal.\n" +
                    "Ingrese una opción:"));
        
            switch (opcion) {
                case 1:
                    gestion.registrarPrestamoDiseno(modelo);
                      
                    break;
                case 2:
                //AQUI SE PIDE EL NOMBRE; APELLIDO; TELEFONO Y SEMESTRE, etc
                    String nombre = JOptionPane.showInputDialog("INGRESA EL NOMBRE.");
                    String apellido = JOptionPane.showInputDialog("INGRESA EL APELLIDO.");
                    int telefono = Integer.parseInt(JOptionPane.showInputDialog("INGRESA EL TELEFONO."));
                    int modalidad = Integer.parseInt(JOptionPane.showInputDialog("INGRESA LA MODALIDAD:\n1. VIRTUAL.\n2. PRESENCIAL."));
                    int asignaturas =  Integer.parseInt(JOptionPane.showInputDialog("INGRESA EL NÚMERO DE ASIGNATURAS."));
                    String serial = JOptionPane.showInputDialog("INGRESA EL SERIAL.");
                    gestion.modificarPrestamoDiseno(modelo, telefono, apellido, nombre, modalidad, asignaturas, telefono, serial );
                    break;
                case 3:
                    String SerialDevol = JOptionPane.showInputDialog("INGRESE SERIAL");
                    gestion.devolucionEquipoDiseno(SerialDevol);
                    break;
                case 4:
                    //PEDIR SERIAL
                    String SerialBuscar = JOptionPane.showInputDialog("INGRESE SERIAL");
                    gestion.buscarEquipoDiseno(SerialBuscar);
                    break;
                case 5:
                    System.out.println("Devolviendo al menú principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }    
        }while(opcion!=5);
    }
}