package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import negocio.SAImpVino;
import negocio.TransferVino;


public class AccionesVino extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTextField idField;
    private JTextField wineryField;
    private JTextField wineField;
    private JComboBox<Integer> yearComboBox;
    private JComboBox<Double> ratingComboBox;
    private JComboBox<Integer> reviewsComboBox;
    private JTextField reviews_grpField;
    private JTextField priceField;
    private JTextField regionField;
    private JTextField typeField;
    private JComboBox<Integer> bodyComboBox;
    private JComboBox<Integer> acidityComboBox;
    private JComboBox<String> acidity_levelComboBox;
    private JTextField tasteField;
    private JTextField accomp_mealField;
    private JComboBox<String> categoryComboBox;
    private JComboBox<Double> alcohol_percentageComboBox;
    private JComboBox<Integer> uds_vinoComboBox;
    private JTextField descriptionField;

    public AccionesVino(JFrame parent, String accion) {
        super(parent, "Gestión de vinos", true);

        if (accion.equals("buscar"))
            buscarVino();
        else
            listarVinos();

        pack();
        setLocationRelativeTo(parent);
    }

    private void buscarVino() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel idLabel = new JLabel("ID del vino:");
        idField = new JTextField(20);

        panel.add(idLabel);
        panel.add(idField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> {
            String idText = idField.getText();

            try {
                int id = Integer.parseInt(idText);

                TransferVino vino = new TransferVino();
                SAImpVino saImpVino = SAImpVino.getInstance();
                vino = saImpVino.buscarVino(id);

                if (vino != null) {
                    JOptionPane.showMessageDialog(null, "El vino existe:\n" + vino.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el vino", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El ID debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }

            dispose();
        });

        panel.add(buscarButton);

        add(panel);
    }

    private void listarVinos() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear tabla para mostrar vinos
        String[] columnNames = {"ID", "Bodega", "Vino", "Año", "Rating", "Número reviews", "Precio", "Unidades", "Catalogo"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Agregar scroll pane a la tabla
        JScrollPane scrollPane = new JScrollPane(table);

        // Obtener la lista de vinos
        SAImpVino saImpVino = SAImpVino.getInstance();
        List<TransferVino> lista_vinos = saImpVino.buscarVinos();

        // Verificar si la lista de vinos es null
        if (lista_vinos != null) {
            // Agregar cada vino a la tabla
            for (TransferVino vino : lista_vinos) {
                Object[] rowData = {vino.getId(), vino.getWinery(), vino.getWine(), vino.getYear(), vino.getRating(), vino.getNum_reviews_grp(), vino.getPrice(), vino.getUds_vino(), vino.getCatalogo()};
                tableModel.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(this, "La lista de vinos es null.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Agregar la tabla al panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Crear botón para actualizar vino seleccionado
        JButton actualizarButton = new JButton("Actualizar Vino");
        actualizarButton.addActionListener(e -> {
            // Obtener el índice de la fila seleccionada
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Obtener el ID del vino seleccionado
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                // Llamar al método para actualizar el vino
                SAImpVino saVino = SAImpVino.getInstance();
                TransferVino vino = saVino.buscarVino(id);
                // Aquí puedes implementar la lógica para actualizar el vino
                
                actualizarVino(vino);
                
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vino para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Crear botón para eliminar vino seleccionado
        JButton eliminarButton = new JButton("Eliminar Vino");
        eliminarButton.addActionListener(e -> {
            // Obtener el índice de la fila seleccionada
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                // Obtener el ID del vino seleccionado
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                // Llamar al método para eliminar el vino
                SAImpVino saVino = SAImpVino.getInstance();
                TransferVino vino = saVino.buscarVino(id);
                saVino.eliminarVino(vino);
                vino = saVino.buscarVino(id);
                
                if (vino == null) {
                    JOptionPane.showMessageDialog(this, "Vino eliminado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Actualizar la tabla después de eliminar el vino
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar el vino", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un vino para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Crear botón para cancelar
        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());

        // Agregar los botones al panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(actualizarButton); // Añadir botón de actualizar antes del botón de eliminar
        buttonPanel.add(eliminarButton);
        buttonPanel.add(cancelarButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }
    
    private void actualizarVino(TransferVino vino) {
    	EditVino editVino = new EditVino(this, vino);
    	editVino.setVisible(true);
    	
    }
}
