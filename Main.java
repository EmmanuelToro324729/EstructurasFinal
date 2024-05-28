import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        EstudianteIngenieria estudianteIngenieria = new EstudianteIngenieria();
        EstudianteDiseno estudianteDiseno = new EstudianteDiseno();
        TabletaGrafica tablet = new TabletaGrafica();
        ComputadorPortatil pc = new ComputadorPortatil();
        GestionPrestamos gestionPrestamos = new GestionPrestamos();
        int opt;
        do {
            opt=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción:\n" +
                    "1. Registrar estudiante de ingeniería.\n" +
                    "2. Registrar estudiante de diseño.\n"+
                    "3. Registrar Portatil.\n"+
                    "4. Registrar Tablet.\n"+
                    "5. Salir de la apicación."));

            switch (opt) {
                case 1:
                    estudianteIngenieria.registrarEstudianteIngenieria();
                    estudianteIngenieria.menuEstudiantesIngenieria(estudianteIngenieria);
                    break;
                case 2:
                    estudianteDiseno.registrarEstudianteDiseno();
                    estudianteDiseno.menuEstudiantesDiseno(estudianteDiseno);
                    break;
                case 3:
                    int optPc=0;
                    do{
                        pc.registrarComputadorPortatil();
                        do {optPc=Integer.parseInt(JOptionPane.showInputDialog("¿Desea ingresar otro computador?\n1. Si.\n2. No."));
                            if(optPc<1 || optPc >2){
                                JOptionPane.showMessageDialog(null,"Error, elija la opción correcta");
                            }
                        }while(optPc<1 || optPc >2);
                    }while(optPc!=2);
                    break;
                case 4:  
                    int optTg=0;
                    do{
                        tablet.registrarTabletaGrafica();
                        do{ optTg=Integer.parseInt(JOptionPane.showInputDialog("¿Desea ingresar otra tableta?\n1. Si.\n2. No."));
                            if(optTg<1 || optTg>2){
                                JOptionPane.showMessageDialog(null,"Error, elija la opción correcta");
                            }
                        }while((optTg<1 || optTg>2));
                    }while(optTg!=2);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,"Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }while (opt!=5);
    }
}





