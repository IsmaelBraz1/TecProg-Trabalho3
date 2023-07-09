package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public ConexaoBanco() {

		this.host = "127.0.0.1";
		this.banco = "rodada"; 
		this.usuario = "root"; 
		this.senha = ""; 
	}

	public Connection getConexao() {
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException ex) {
			System.out.println("Conexão com MYSQL não realizada");
			ex.printStackTrace();
		}
		return null;
	}
}
