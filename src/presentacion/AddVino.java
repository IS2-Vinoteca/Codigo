package presentacion;

import javax.swing.*;

import negocio.SAImpVino;
import negocio.TransferVino;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class AddVino extends JDialog {

    private static final long serialVersionUID = 1L;

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

    public AddVino(JFrame parent) {
        super(parent, "Añadir Nuevo Vino", true);
        initComponents();
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(19, 2, 5, 10)); // Aumentar el espacio vertical entre componentes

        JLabel wineryLabel = new JLabel("Bodega:");
        wineryField = new JTextField();

        JLabel wineLabel = new JLabel("Vino:");
        wineField = new JTextField();

        JLabel yearLabel = new JLabel("Año:");
        Integer[] years = IntStream.rangeClosed(1800, 2024).boxed().toArray(Integer[]::new);
        yearComboBox = new JComboBox<>(years);

        JLabel ratingLabel = new JLabel("Rating:");
        Double[] ratings = crearArrayDouble(0.0, 5.0, 0.1);
        ratingComboBox = new JComboBox<>(ratings);

        JLabel num_reviewsLabel = new JLabel("Número de reviews:");
        Integer[] reviews = IntStream.rangeClosed(0, 200).boxed().toArray(Integer[]::new);
        reviewsComboBox = new JComboBox<>(reviews);

        JLabel reviewsgLabel = new JLabel("Reviews:");
        reviews_grpField = new JTextField();

        JLabel priceLabel = new JLabel("Precio:");
        priceField = new JTextField();

        JLabel regionLabel = new JLabel("Región:");
        regionField = new JTextField();

        JLabel typeLabel = new JLabel("Tipo:");
        typeField = new JTextField();

        JLabel bodyLabel = new JLabel("Body:");
        Integer[] body = IntStream.rangeClosed(0, 100).boxed().toArray(Integer[]::new);
        bodyComboBox = new JComboBox<>(body);

        JLabel acidityLabel = new JLabel("Acidez:");
        Integer[] acidity = IntStream.rangeClosed(0, 100).boxed().toArray(Integer[]::new);
        acidityComboBox = new JComboBox<>(acidity);

        JLabel acidity_levelLabel = new JLabel("Nivel de acidez:");
        String[] acidityLevels = {"high", "medium", "low"}; // Niveles de acidez
        acidity_levelComboBox = new JComboBox<>(acidityLevels); // JComboBox<String>

        JLabel tasteLabel = new JLabel("Sabor:");
        tasteField = new JTextField();

        JLabel accomp_mealLabel = new JLabel("Accompany meal:");
        accomp_mealField = new JTextField();

        JLabel categoryLabel = new JLabel("Categoría:");
        String[] categories = {"Red", "White", "Fortified", "Sparkling", "Rosé"}; // Categorías de vino
        categoryComboBox = new JComboBox<>(categories); // JComboBox<String>

        JLabel alcohol_percentageLabel = new JLabel("Porcentaje de Alcohol:");
        Double[] alcohol_percentage = crearArrayDouble(0.0, 100.0, 0.1);
        alcohol_percentageComboBox = new JComboBox<>(alcohol_percentage);

        JLabel uds_vinoLabel = new JLabel("Unidades de vino:");
        Integer[] uds_vino = IntStream.rangeClosed(0, 100).boxed().toArray(Integer[]::new);
        uds_vinoComboBox = new JComboBox<>(uds_vino);

        JLabel descriptionLabel = new JLabel("Descripcion:");
        descriptionField = new JTextField();

        panel.add(wineryLabel);
        panel.add(wineryField);
        panel.add(wineLabel);
        panel.add(wineField);
        panel.add(yearLabel);
        panel.add(yearComboBox);
        panel.add(ratingLabel);
        panel.add(ratingComboBox);
        panel.add(num_reviewsLabel);
        panel.add(reviewsComboBox);
        panel.add(reviewsgLabel);
        panel.add(reviews_grpField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(regionLabel);
        panel.add(regionField);
        panel.add(typeLabel);
        panel.add(typeField);
        panel.add(bodyLabel);
        panel.add(bodyComboBox);
        panel.add(acidityLabel);
        panel.add(acidityComboBox);
        panel.add(acidity_levelLabel);
        panel.add(acidity_levelComboBox); // Cambiado a JComboBox<String>
        panel.add(tasteLabel);
        panel.add(tasteField);
        panel.add(accomp_mealLabel);
        panel.add(accomp_mealField);
        panel.add(categoryLabel);
        panel.add(categoryComboBox); // Cambiado a JComboBox<String>
        panel.add(alcohol_percentageLabel);
        panel.add(alcohol_percentageComboBox);
        panel.add(uds_vinoLabel);
        panel.add(uds_vinoComboBox);
        panel.add(descriptionLabel);
        panel.add(descriptionField);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> agregarVino());

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());

        // Establecer un panel para los botones y agregar espacio entre ellos
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(agregarButton);
        buttonPanel.add(cancelarButton);

        panel.add(new JLabel()); // Espacio vacío para mantener el diseño
        panel.add(buttonPanel); // Agregar el panel de botones

        add(panel);
    }
    
    private void agregarVino() {
        try {
            // Obtener los valores de los campos de texto y JComboBox
        	String winery = wineryField.getText();
            String wine = wineField.getText();
            int year = (int) yearComboBox.getSelectedItem(); // Obtener el año seleccionado del combo box
            double rating = (double) ratingComboBox.getSelectedItem(); // Obtener el rating seleccionado del combo box
            int num_reviews = (int) reviewsComboBox.getSelectedItem(); // Obtener el número de reviews seleccionado del combo box
            String num_reviews_grp = reviews_grpField.getText();
            double price = Double.parseDouble(priceField.getText());
            String region = regionField.getText();
            String type = typeField.getText();
            int body = (int) bodyComboBox.getSelectedItem();
            int acidity = (int) acidityComboBox.getSelectedItem();
            String acidity_level = (String) acidity_levelComboBox.getSelectedItem(); // Obtener el nivel de acidez seleccionado del combo box
            String taste = tasteField.getText();
            String accomp_meal = accomp_mealField.getText();
            String category = (String) categoryComboBox.getSelectedItem(); // Obtener la categoría seleccionada del combo box
            double alcohol_percentage = (double) alcohol_percentageComboBox.getSelectedItem(); // Obtener el porcentaje de alcohol seleccionado del combo box
            int uds_vino = (int) uds_vinoComboBox.getSelectedItem();
            String description = descriptionField.getText();

            // Crear un objeto TransferVino con los datos recolectados
            TransferVino vino = new TransferVino(0, winery, wine, year, rating, num_reviews, num_reviews_grp, price, region,
                    type, body, acidity, acidity_level, taste, accomp_meal, category, alcohol_percentage, uds_vino,
                    description, 0); // Asumiendo que catalogo es 0

            // Llamar al método addVino de SAImpVino para agregar el vino a la base de datos
            SAImpVino saImpVino = SAImpVino.getInstance();
            int resultado = saImpVino.addVino(vino);

            if (resultado != -1) {
                JOptionPane.showMessageDialog(this, "El vino ha sido añadido con éxito", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El vino no ha sido añadido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Double[] crearArrayDouble(double inicio, double fin, double paso) {
        int cantidadElementos = (int) ((fin - inicio) / paso) + 1;
        Double[] array = new Double[cantidadElementos];
        DecimalFormat df = new DecimalFormat("#.#");

        for (int i = 0; i < cantidadElementos; i++) {
            String valor = df.format(inicio + i * paso); // Formatear el valor con el separador decimal correcto
            valor = valor.replace(",", "."); // Reemplazar las comas por puntos
            array[i] = Double.parseDouble(valor);
        }

        return array;
    }

}
