package integracion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import negocio.Vino;

public interface DAOVino {

	public List<Vino> buscarVinos();
	public Vino buscarVino(int id);
	public int addVino(Vino vino);
	public void actualizarVino(Vino vino);
	public void eliminarVino(Vino vino);
	public String realizarConsultaVino(String nombreVino); //hecho
	public String realizarConsultaBodega(String winery);
	
}
