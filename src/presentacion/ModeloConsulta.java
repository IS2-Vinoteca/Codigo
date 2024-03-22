package presentacion;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class ModeloConsulta extends JDialog {
    //fijarse en la clase AddUsuario -> usar clase DBConnection
	private static final String URL = "jdbc:mysql://localhost:3306/is2_vinoteca_bbdd";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "rootmysqlis2"; //cada una su contraseña (esto lo borraremos cuando se utilice la clase DBConnection)

    public ModeloConsulta(JFrame parent) {
        super(parent, "Consultar vinos", true);
        initGUI();
        pack();
        setLocationRelativeTo(parent);
    }
    
    private void initGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setContentPane(mainPanel);

        JLabel lblNombreVino = new JLabel("Nombre del Vino:");
        JTextField txtNombreVino = new JTextField(20);
        JButton btnConsulta = new JButton("Consultar");
        JTextArea txtAreaResultado = new JTextArea(10, 30);

        btnConsulta.addActionListener(e -> {
            String nombreVino = txtNombreVino.getText();
            String resultado = realizarConsulta(nombreVino);
            txtAreaResultado.setText(resultado);
        });

        mainPanel.add(lblNombreVino);
        mainPanel.add(txtNombreVino);
        mainPanel.add(btnConsulta);
        mainPanel.add(new JScrollPane(txtAreaResultado));

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cambio aquí
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
   
    
    //ya está implementado en DAOImpVino, comentar aqui y corregir código
    public String realizarConsulta(String nombreVino) {
        String resultados = "";
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultado = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            String sql = "SELECT * FROM vinos WHERE wine = ?";
            consulta = conexion.prepareStatement(sql);
            consulta.setString(1, nombreVino);
            resultado = consulta.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String wine = resultado.getString("wine");
                int year = resultado.getInt("year");
                double rating = resultado.getDouble("rating");
                int num_reviews = resultado.getInt("num_reviews");
                String num_reviews_grp = resultado.getString("num_reviews_grp");
                String region = resultado.getString("region");
                double price = resultado.getDouble("price");

                resultados += "ID: " + id + ", Wine: " + wine + ", Year: " + year + ", Rating: " + rating
                        + ", Num_reviews: " + num_reviews + ", Num_reviews_grp: " + num_reviews_grp + ", Region: "
                        + region + ", Price: " + price + "\n";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultados = "Error al realizar la consulta: " + e.getMessage();
        } finally {
            try {
                if (resultado != null)
                    resultado.close();
                if (consulta != null)
                    consulta.close();
                if (conexion != null)
                    conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultados;
    }
}


