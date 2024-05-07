package presentacion;

import javax.swing.*;

import negocio.SAImpVino;
import negocio.TransferVino;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class EditVino extends JDialog {

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
    private JComboBox<Integer> catalogoComboBox;
    private TransferVino vino;

    public EditVino(JDialog parent, TransferVino vino) {
        super(parent, "Editar Vino", true);
        this.vino = vino;
        initComponents();
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(19, 2, 5, 10)); // Aumentar el espacio vertical entre componentes

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(String.valueOf(vino.getId()));
        idField.setEditable(false);
        
        JLabel wineryLabel = new JLabel("Bodega:");
        wineryField = new JTextField(vino.getWinery());

        JLabel wineLabel = new JLabel("Vino:");
        wineField = new JTextField(vino.getWine());

        JLabel yearLabel = new JLabel("Año:");
        Integer[] years = IntStream.rangeClosed(1800, 2024).boxed().toArray(Integer[]::new);
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setSelectedItem(vino.getYear());

        JLabel ratingLabel = new JLabel("Rating:");
        Double[] ratings = crearArrayDouble(0.0, 5.0, 0.1);
        ratingComboBox = new JComboBox<>(ratings);
        ratingComboBox.setSelectedItem(vino.getRating());

        JLabel num_reviewsLabel = new JLabel("Número de reviews:");
        Integer[] reviews = IntStream.rangeClosed(0, 200).boxed().toArray(Integer[]::new);
        reviewsComboBox = new JComboBox<>(reviews);
        reviewsComboBox.setSelectedItem(vino.getNum_reviews());

        JLabel reviewsgLabel = new JLabel("Reviews:");
        reviews_grpField = new JTextField(vino.getNum_reviews_grp());

        JLabel priceLabel = new JLabel("Precio:");
        priceField = new JTextField(String.valueOf(vino.getPrice()));

        JLabel regionLabel = new JLabel("Región:");
        regionField = new JTextField(vino.getRegion());

        JLabel typeLabel = new JLabel("Tipo:");
        typeField = new JTextField(vino.getType());

        JLabel bodyLabel = new JLabel("Body:");
        Integer[] body = IntStream.rangeClosed(0, 100).boxed().toArray(Integer[]::new);
        bodyComboBox = new JComboBox<>(body);
        bodyComboBox.setSelectedItem(vino.getBody());

        JLabel acidityLabel = new JLabel("Acidez:");
        Integer[] acidity = IntStream.rangeClosed(0, 100).boxed().toArray(Integer[]::new);
        acidityComboBox = new JComboBox<>(acidity);
        acidityComboBox.setSelectedItem(vino.getAcidity());

        JLabel acidity_levelLabel = new JLabel("Nivel de acidez:");
        String[] acidityLevels = {"high", "medium", "low"}; 
        acidity_levelComboBox = new JComboBox<>(acidityLevels); 
        acidity_levelComboBox.setSelectedItem(vino.getAcidity_level());

        JLabel tasteLabel = new JLabel("Sabor:");
        tasteField = new JTextField(vino.getTaste());

        JLabel accomp_mealLabel = new JLabel("Accompany meal:");
        accomp_mealField = new JTextField(vino.getAccomp_meal());

        JLabel categoryLabel = new JLabel("Categoría:");
        String[] categories = {"Red", "White", "Fortified"}; 
        categoryComboBox = new JComboBox<>(categories); 
        categoryComboBox.setSelectedItem(vino.getCategory());

        JLabel alcohol_percentageLabel = new JLabel("Porcentaje de Alcohol:");
        Double[] alcohol_percentage = crearArrayDouble(0.0, 100.0, 0.1);
        alcohol_percentageComboBox = new JComboBox<>(alcohol_percentage);
        alcohol_percentageComboBox.setSelectedItem(vino.getAlcohol_percentage());

        JLabel uds_vinoLabel = new JLabel("Unidades de vino:");
        Integer[] uds_vino = IntStream.rangeClosed(0, 100).boxed().toArray(Integer[]::new);
        uds_vinoComboBox = new JComboBox<>(uds_vino);
        uds_vinoComboBox.setSelectedItem(vino.getUds_vino());

        JLabel descriptionLabel = new JLabel("Descripcion:");
        descriptionField = new JTextField(vino.getDescription());
        
        
        JLabel catalogoLabel = new JLabel("Catalogo:");
        Integer[] catalogo = IntStream.rangeClosed(0, 1).boxed().toArray(Integer[]::new);
        catalogoComboBox = new JComboBox<>(catalogo);
        catalogoComboBox.setSelectedItem(vino.getCatalogo());

        panel.add(idLabel);
        panel.add(idField);
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
        panel.add(acidity_levelComboBox); 
        panel.add(tasteLabel);
        panel.add(tasteField);
        panel.add(accomp_mealLabel);
        panel.add(accomp_mealField);
        panel.add(categoryLabel);
        panel.add(categoryComboBox);
        panel.add(alcohol_percentageLabel);
        panel.add(alcohol_percentageComboBox);
        panel.add(uds_vinoLabel);
        panel.add(uds_vinoComboBox);
        panel.add(descriptionLabel);
        panel.add(descriptionField);
        panel.add(catalogoLabel);
        panel.add(catalogoComboBox);

        JButton agregarButton = new JButton("Actualizar");
        agregarButton.addActionListener(e -> actualizarVino());

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
    
    private void actualizarVino() {
        try {
            // Obtener los valores de los campos de texto y JComboBox
        	int id = Integer.parseInt(idField.getText());
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
            int catalogo = (int) catalogoComboBox.getSelectedItem();

            // Crear un objeto TransferVino con los datos recolectados
            TransferVino vino = new TransferVino(id, winery, wine, year, rating, num_reviews, num_reviews_grp, price, region,
                    type, body, acidity, acidity_level, taste, accomp_meal, category, alcohol_percentage, uds_vino,
                    description, catalogo); // Asumiendo que catalogo es 0

            // Llamar al método actualizarVino de SAImpVino para actualizar el vino en la base de datos
            SAImpVino saImpVino = SAImpVino.getInstance();
            saImpVino.actualizarVino(vino);

            JOptionPane.showMessageDialog(this, "El vino ha sido actualizado con éxito", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
            dispose();
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
