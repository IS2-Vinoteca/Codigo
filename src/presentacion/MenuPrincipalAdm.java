package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalAdm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;

public MenuPrincipalAdm(Controller controller) {
		
		super("Menu") ;
    	initGUI() ;
	}

    private void initGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(CENTER_ALIGNMENT);
        setContentPane(mainPanel);
        mainPanel.setBackground(new Color(128, 0, 0));

        mainPanel.add(Box.createVerticalStrut(30));

        JLabel menuLabel = new JLabel("MENU PRINCIPAL ADMINISTRADOR");
        menuLabel.setAlignmentX(CENTER_ALIGNMENT);
        menuLabel.setForeground(Color.WHITE);
        menuLabel.setOpaque(true);
        menuLabel.setBackground(new Color(128, 0, 0));
        menuLabel.setPreferredSize(new Dimension(500, 50));
        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuLabel.setFont(new Font(menuLabel.getFont().getName(), Font.BOLD, 24));
        mainPanel.add(menuLabel);

        mainPanel.add(Box.createVerticalStrut(20));

        JButton usuarioButton = new JButton("Usuario");
        usuarioButton.setAlignmentX(CENTER_ALIGNMENT);
        usuarioButton.setBackground(Color.GRAY);
        usuarioButton.setForeground(Color.WHITE);
        usuarioButton.setFont(usuarioButton.getFont().deriveFont(Font.BOLD));
        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoUsuario();
            }
        });
        mainPanel.add(usuarioButton);

        mainPanel.add(Box.createVerticalStrut(20));

        JButton vinosButton = new JButton("Vinos");
        vinosButton.setAlignmentX(CENTER_ALIGNMENT);
        vinosButton.setBackground(Color.GRAY);
        vinosButton.setForeground(Color.WHITE);
        vinosButton.setFont(vinosButton.getFont().deriveFont(Font.BOLD));
        vinosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirDialogoVino();
            }
        });
        mainPanel.add(vinosButton);

        mainPanel.add(Box.createVerticalStrut(20));

        JButton mainButton = new JButton("Menu Principal");
        mainButton.setAlignmentX(CENTER_ALIGNMENT);
        mainButton.setBackground(Color.GRAY);
        mainButton.setForeground(Color.WHITE);
        mainButton.setFont(mainButton.getFont().deriveFont(Font.BOLD));
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
                setVisible(false);
            }
        });
        mainPanel.add(mainButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // DIALOGOS
    // USUARIO
    
    private void abrirDialogoUsuario() {
        JPanel usuarioPanel = new JPanel();
        usuarioPanel.setLayout(new BoxLayout(usuarioPanel, BoxLayout.Y_AXIS));
        usuarioPanel.setAlignmentX(CENTER_ALIGNMENT);

        usuarioPanel.add(Box.createVerticalStrut(20));

        JButton agregarUsuarioButton = new JButton("Agregar Usuario");
        agregarUsuarioButton.setAlignmentX(CENTER_ALIGNMENT);
        agregarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	nuevoUsuario();
            }
        });
        usuarioPanel.add(agregarUsuarioButton);

        usuarioPanel.add(Box.createVerticalStrut(20));

        JButton listadoUsuariosButton = new JButton("Listado Usuarios");
        listadoUsuariosButton.setAlignmentX(CENTER_ALIGNMENT);
        listadoUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	listadoUsuario();
            }
        });
        usuarioPanel.add(listadoUsuariosButton);

        usuarioPanel.add(Box.createVerticalStrut(20));

        JButton consultaUsuarioButton = new JButton("Consulta de Usuario");
        consultaUsuarioButton.setAlignmentX(CENTER_ALIGNMENT);
        consultaUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	consultaUsuario();
            }
        });
        usuarioPanel.add(consultaUsuarioButton);

        JOptionPane.showMessageDialog(null, usuarioPanel, "Menú Usuario", JOptionPane.PLAIN_MESSAGE);
    }

    // VINOS
    
    private void abrirDialogoVino() {
        JPanel vinoPanel = new JPanel();
        vinoPanel.setLayout(new BoxLayout(vinoPanel, BoxLayout.Y_AXIS));
        vinoPanel.setAlignmentX(CENTER_ALIGNMENT);

        vinoPanel.add(Box.createVerticalStrut(20));

        JButton agregarVinoButton = new JButton("Agregar Vino");
        agregarVinoButton.setAlignmentX(CENTER_ALIGNMENT);
        agregarVinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	nuevoVino();
            }
        });
        vinoPanel.add(agregarVinoButton);

        vinoPanel.add(Box.createVerticalStrut(20));

        JButton listadoVinosButton = new JButton("Listado Vino");
        listadoVinosButton.setAlignmentX(CENTER_ALIGNMENT);
        listadoVinosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	listadoVino();
            }
        });
        vinoPanel.add(listadoVinosButton);

        JOptionPane.showMessageDialog(null, vinoPanel, "Menú Vino", JOptionPane.PLAIN_MESSAGE);
    }
    
    // METODOS EXTRAS
    // USUARIO
    
    private void nuevoUsuario() {
    	AddUsuario nuevoUsuario = new AddUsuario(this);
        nuevoUsuario.setVisible(true);
    }
  
    private void listadoUsuario() {
    	AccionesUsuario pruebas = new AccionesUsuario(this, "");
    	pruebas.setVisible(true);
    }
    
    private void consultaUsuario() {
    	AccionesUsuario pruebas = new AccionesUsuario(this, "buscar");
    	pruebas.setVisible(true);
    }
    
    // VINOS
    
    private void nuevoVino() {
    	AddVino nuevoVino = new AddVino(this);
        nuevoVino.setVisible(true);
    }
  
    private void listadoVino() {
    	AccionesVino pruebas = new AccionesVino(this, "");
    	pruebas.setVisible(true);
    }
    
}
