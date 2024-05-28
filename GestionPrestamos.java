import javax.swing.*;

// Clase para gestionar los préstamos
class GestionPrestamos {
    TabletaGrafica tablet = new TabletaGrafica();
    ComputadorPortatil portatil = new ComputadorPortatil();



//TODO REVISAR
    public void imprimirInventarioTotal() {
        StringBuilder inventario = new StringBuilder("Inventario Total:\n\nTabletas Gráficas:\n");
        for (TabletaGrafica tableta : tablet.getTabletasGraficas()) {
            inventario.append(tableta).append("\n");
        }
        inventario.append("\nComputadores Portátiles:\n");
        for (ComputadorPortatil portatil : portatil.getComputadoresPortatiles()) {
            inventario.append(portatil).append("\n");
        }//Imprime la lista
        JOptionPane.showMessageDialog(null, inventario.toString());
    }




    public void registrarPrestamoDiseno(EstudianteDiseno estudiante) {
        for (TabletaGrafica tableta : tablet.getTabletasGraficas()){
            if (tableta.isDisponible()){
                estudiante.setSerial(tableta.getSerial());
                JOptionPane.showMessageDialog(null, "Se te prestó la tablet " + tableta.getSerial());
            }else{
                JOptionPane.showMessageDialog(null, "No hay tabletas disponibles");
            }
        }
    }

    public Exception modificarPrestamoIngenieria(EstudianteIngenieria estudiante, String nuevoNombre, String nuevoApellido, int nuevoTelefono, int nuevoSemestre, float nuevoPromedio, String nuevoSerial) {
        try {
            // Validación de datos (puedes agregar más validaciones según tus necesidades)
            if (nuevoTelefono < 0 || nuevoSemestre < 1 || nuevoPromedio < 0) {
                throw new IllegalArgumentException("Datos inválidos");
            }

            // Actualización de atributos
            estudiante.setNombre(nuevoNombre);
            estudiante.setApellido(nuevoApellido);
            estudiante.setTelefono(nuevoTelefono);
            estudiante.setSemestre(nuevoSemestre);
            estudiante.setPromedio(nuevoPromedio);
            estudiante.setSerial(nuevoSerial);
        } catch (NumberFormatException e) {
            return e; // Manejo específico de excepción
        } catch (IllegalArgumentException e) {
            return e; // Manejo específico de excepción
        }
        return null;
    }

    public Exception modificarPrestamoDiseno(EstudianteDiseno estudiante, int cedula ,String nuevoNombre, String nuevoApellido, int nuevoTelefono,int modalidad, int nuevaAsignatura,String nuevoSerial) {
        estudiante.buscarEstudianteDiseno(cedula);

        if (estudiante != null) {
            try {
                estudiante.setNombre(nuevoNombre);
                estudiante.setApellido(nuevoApellido);
                estudiante.setTelefono(nuevoTelefono);
                estudiante.setModalidad(modalidad);
                estudiante.setAsignaturas(nuevaAsignatura);
                estudiante.setSerial(nuevoSerial);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor numérico válido.");
            } catch (IllegalArgumentException e) {
                return e;
            }
        }
        return null;
    }

    public void registrarPrestamoIngenieria(EstudianteIngenieria estudiante) {
        for (ComputadorPortatil computador : portatil.getComputadoresPortatiles()){
            if (computador.isDisponible()){
                estudiante.setSerial(computador.getSerial());
                JOptionPane.showMessageDialog(null, "Se te prestó el pc " + computador.getSerial());
            }else{
                JOptionPane.showMessageDialog(null, "No hay pc disponibles");
            }
        }
    }
    public void devolucionEquipoDiseno(String serial) {
        for (TabletaGrafica tablet : tablet.getTabletasGraficas() ){
            if(tablet.getSerial().equals(serial)){
                if (!tablet.isDisponible()){
                    tablet.setDisponible(true);
                    JOptionPane.showMessageDialog(null, "EL EQUIPO YA ESTA DISPONIBLE");
                }else {
                    JOptionPane.showMessageDialog(null, "El equipo !!!!!YA ESTABA¡¡¡¡¡¡ disponible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE :,(");
            }
        }
    }
   public void devolucionEquipoIngenieria(String serial) {
        for (ComputadorPortatil portatil : portatil.getComputadoresPortatiles() ){
            if(portatil.getSerial().equals(serial)){
                if (!portatil.isDisponible()){
                    portatil.setDisponible(true);
                    JOptionPane.showMessageDialog(null, "EL EQUIPO YA ESTA DISPONIBLE");
                }else {
                    JOptionPane.showMessageDialog(null, "el equipo !!!!!YA ESTABA¡¡¡¡¡¡ disponible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE :,(");
            }
        }
    }
    public void buscarEquipoDiseno(String serial) {
        for (TabletaGrafica tablet : tablet.getTabletasGraficas() ){
            if(tablet.getSerial().equals(serial)){
                JOptionPane.showMessageDialog(null, tablet);
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE :,(");
            }
        }
    }

    public void buscarEquipoIngenieria(String serial) {
        for (ComputadorPortatil portatil : portatil.getComputadoresPortatiles()){
            if(tablet.getSerial().equals(serial)){
                JOptionPane.showMessageDialog(null, portatil);
            }else{
                JOptionPane.showMessageDialog(null, "NO EXISTE :,(");
            }
        }
    }
}