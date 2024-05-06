package presentacion;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import negocio.SAImpVentas;
import negocio.TransferVentas;

public class ModeloVenta extends JDialog{
	
	
	   public ModeloVenta(JFrame parent, String accion) {
		   super(parent, "listado", true);
			
			if(accion == "incidencias")
				listadoIncidencias();
			else
				listadoVentas();
			
			pack();
			setLocationRelativeTo(parent);
		}
	
	   private void listadoIncidencias() {
		    JPanel panel = new JPanel(new BorderLayout());

		    // Crear tabla para mostrar incidencias
		    String[] columnNames = {"ID Venta", "Producto", "Fecha", "Detalles", "Estado"};
		    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		    JTable table = new JTable(tableModel);

		    // Agregar scroll pane a la tabla
		    JScrollPane scrollPane = new JScrollPane(table);

		    // Obtener la lista de incidencias
		    // Aquí debes llamar al método del controlador para obtener la lista de incidencias
		   SAImpVentas saImpVentas = SAImpVentas.getInstance(); 
		   List<TransferVentas> listaIncidencias = saImpVentas.listadoIncidencias();

		    // Verificar si la lista de incidencias es null
		    if (listaIncidencias != null) {
		        // Agregar cada incidencia a la tabla
		        for (TransferVentas incidencia : listaIncidencias) {
		            Object[] rowData = {incidencia.getId(), incidencia.getProducto(), incidencia.getFecha(), incidencia.getDetalles(), incidencia.getIncidencia()};
		            tableModel.addRow(rowData);
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "La lista de incidencias es null.", "Error", JOptionPane.ERROR_MESSAGE);
		    }

		    // Agregar la tabla al panel
		    panel.add(scrollPane, BorderLayout.CENTER);

		    // Agregar el panel al JFrame
		    setContentPane(panel);
		    pack();
		    setLocationRelativeTo(null);
		}


	private void listadoVentas() {
        JPanel panel = new JPanel(new BorderLayout());

        // Crear tabla para mostrar ventas
        String[] columnNames = {"ID", "Fecha", "Producto", "Cantidad", "Precio", "Incidencia"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Agregar scroll pane a la tabla
        JScrollPane scrollPane = new JScrollPane(table);

        // Obtener la lista de ventas
        // Aquí debes llamar al método del controlador para obtener la lista de ventas
       SAImpVentas saImpVentas = SAImpVentas.getInstance(); 
       List<TransferVentas> listaventas = saImpVentas.listadoVentas();

        // Verificar si la lista de ventas es null
        if (listaventas != null) {
            // Agregar cada venta a la tabla
            for (TransferVentas venta : listaventas) {
                Object[] rowData = {venta.getId(), venta.getFecha(), venta.getProducto(), venta.getCantidad(), venta.getPrecio(), venta.getIncidencia()};
                tableModel.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(this, "La lista de ventas es null.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Agregar la tabla al panel
        panel.add(scrollPane, BorderLayout.CENTER);
        
     // Crear botones para aceptar venta, generar incidencia y cerrar ventana
        JButton aceptarVentaButton = new JButton("Aceptar Venta");
        aceptarVentaButton.addActionListener(e -> {
            // Obtener el índice de la fila seleccionada
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Obtener el ID de la venta seleccionada
                int idVenta = (int) tableModel.getValueAt(selectedRow, 0);
                // Eliminar la venta de la base de datos     
                SAImpVentas impVentas = SAImpVentas.getInstance();   
                boolean eliminado = impVentas.eliminarVenta(idVenta);
                if (eliminado) {
                    JOptionPane.showMessageDialog(this, "Venta aceptada y eliminada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Actualizar la tabla después de eliminar la venta
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una venta para aceptar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton generarIncidenciaButton = new JButton("Generar Incidencia");
        generarIncidenciaButton.addActionListener(e -> {
            // Obtener el índice de la fila seleccionada
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Obtener el ID de la venta seleccionada
                int idVenta = (int) tableModel.getValueAt(selectedRow, 0);
                
                // Crear y configurar un JDialog para ingresar los detalles de la incidencia
                JDialog dialog = new JDialog(this, "Detalles de la incidencia", true);
                JTextField detallesField = new JTextField(20);
                JButton confirmarButton = new JButton("Confirmar");
                confirmarButton.addActionListener(ev -> {
                    // Obtener los detalles de la incidencia ingresados por el usuario
                    String detallesIncidencia = detallesField.getText();
                    
                    // Cambiar el estado de incidencia de la venta en la base de datos
                    SAImpVentas ventas = SAImpVentas.getInstance();                    
                    boolean actualizado = ventas.actualizarIncidencia(idVenta, "1", detallesIncidencia);
                    if (actualizado) {
                        JOptionPane.showMessageDialog(dialog, "Incidencia generada para la venta seleccionada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose(); // Cerrar el diálogo después de confirmar
                    } else {
                        JOptionPane.showMessageDialog(dialog, "No se pudo generar la incidencia.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                });
                
                // Configurar el diseño del diálogo
                JPanel panelincidencia = new JPanel(new BorderLayout());
                panelincidencia.add(new JLabel("Detalles de la incidencia:"), BorderLayout.NORTH);
                panelincidencia.add(detallesField, BorderLayout.CENTER);
                panelincidencia.add(confirmarButton, BorderLayout.SOUTH);
                dialog.add(panelincidencia);
                
                dialog.pack();
                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una venta para generar una incidencia.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton cerrarVentanaButton = new JButton("Cerrar Ventana");
        cerrarVentanaButton.addActionListener(e -> dispose());

        // Agregar los botones al panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(aceptarVentaButton);
        buttonPanel.add(generarIncidenciaButton);
        buttonPanel.add(cerrarVentanaButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        // Agregar el panel al JFrame
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }
	

}
