package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import integracion.DAOImpUsuario;
import negocio.SAImpUsuario;
import negocio.TransferUsuario;


public class AccionesUsuario extends JDialog {

		private JTextField idField;
		private JTextField nifField;
		//private JTextField empresaField;

		public AccionesUsuario(JFrame parent, String accion) {
			super(parent, "buscar usuario", true);
			
			if(accion == "buscar")
				buscarUsuario();
			else
				listarUsuarios();
			
			pack();
			setLocationRelativeTo(parent);
		}

		
		//BUSCAR UN USUARIO POR NIF -> FUNCIONA
		private void buscarUsuario() {
		    JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

		    JLabel nombreLabel = new JLabel("NIF del usuario:");
		    nifField = new JTextField();

		    panel.add(nombreLabel);
		    panel.add(nifField);

		    JButton buscarButton = new JButton("Buscar");
		    buscarButton.addActionListener(e -> {
		        String nifText = nifField.getText();
		        
		        try {
		            int nif = Integer.parseInt(nifText);
		            	           
		           
		            TransferUsuario user = new TransferUsuario();
		            SAImpUsuario saImpUsuario = new SAImpUsuario(user);
		            user = saImpUsuario.buscarUsuario(nif);

		            
		            if (user != null) {
		                JOptionPane.showMessageDialog(null, "El usuario existe:\n" + user.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                JOptionPane.showMessageDialog(null, "No existe el usuario", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        } catch (NumberFormatException ex) {
		            // Manejar el caso en que el texto del NIF no sea un número válido
		            JOptionPane.showMessageDialog(null, "El NIF debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        // Cerrar el diálogo
		        dispose();
		    });

		    panel.add(buscarButton);

		    add(panel);
		}

	



	//LISTAR TODOS LOS USUARIOS -> FUNCIONA

		 private void listarUsuarios() {
		        JPanel panel = new JPanel(new BorderLayout());

		        // Crear tabla para mostrar usuarios
		        String[] columnNames = {"NIF", "Nombre", "Email"};
		        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		        JTable table = new JTable(tableModel);

		        // Agregar scroll pane a la tabla
		        JScrollPane scrollPane = new JScrollPane(table);

		        // Obtener la lista de usuarios
		        TransferUsuario user = new TransferUsuario();
		        SAImpUsuario saImpUsuario = new SAImpUsuario(user);
		        List<TransferUsuario> lista_usuarios = saImpUsuario.buscarUsuarios();

		        // Verificar si la lista de usuarios es null
		        if (lista_usuarios != null) {
		            // Agregar cada usuario a la tabla
		            for (TransferUsuario usuario : lista_usuarios) {
		                Object[] rowData = {usuario.getNif(), usuario.getNombre(), usuario.getEmail()};
		                tableModel.addRow(rowData);
		            }
		        } else {
		            JOptionPane.showMessageDialog(this, "La lista de usuarios es null.", "Error", JOptionPane.ERROR_MESSAGE);
		        }

		        // Agregar la tabla al panel
		        panel.add(scrollPane, BorderLayout.CENTER);

		        // Crear botón para eliminar usuario seleccionado
		        JButton eliminarButton = new JButton("Eliminar Usuario");
		        eliminarButton.addActionListener(e -> {
		            // Obtener el índice de la fila seleccionada
		            int selectedRow = table.getSelectedRow();
		            if (selectedRow != -1) {
		                // Obtener el ID del usuario seleccionado
		                int id = (int) tableModel.getValueAt(selectedRow, 0);
		                // Llamar al método para eliminar el usuario
		                TransferUsuario usuario = new TransferUsuario();
		                SAImpUsuario saImpUser = new SAImpUsuario(user);
		                boolean eliminado = saImpUser.eliminarUsuario(id);
		                if (eliminado) {
		                    JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                    // Actualizar la tabla después de eliminar el usuario
		                    tableModel.removeRow(selectedRow);
		                } else {
		                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        });

		        // Crear botón para cancelar
		        JButton cancelarButton = new JButton("Cancelar");
		        cancelarButton.addActionListener(e -> dispose());

		        // Agregar los botones al panel
		        JPanel buttonPanel = new JPanel();
		        buttonPanel.add(eliminarButton);
		        buttonPanel.add(cancelarButton);
		        panel.add(buttonPanel, BorderLayout.SOUTH);

		        add(panel);
		    }
		

		
}
