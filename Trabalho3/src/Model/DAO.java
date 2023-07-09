package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.ControladorGeral;


public class DAO {
	public int inserir(ControladorGeral dados) {
		int resposta = 0;
		try {
			Connection conexao = new ConexaoBanco().getConexao();
			PreparedStatement inserir=
			conexao.prepareStatement("insert into rodadas "
					+ "(NomedoJogadordavez, CartaEscolhida, FrasedaDica, EscolhadoJogador1, EscolhadoJogador2, EscolhadoJogador3, EscolhadoJogador4, PontosdoJogador1, PontosdoJogador2, PontosdoJogador3, PontosdoJogador4)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?)");
			
			inserir.setString(1, dados.getJogadorDaVez());
			inserir.setString(2, dados.getCartaDaVez());
			inserir.setString(3, dados.getDicaDaVez());
			inserir.setString(4, dados.getCartasDaRodada().get(0));
			inserir.setString(5, dados.getCartasDaRodada().get(1));
			inserir.setString(6, dados.getCartasDaRodada().get(2));
			if(dados.getCartasDaRodada().size() == 4) 
				inserir.setString(7, dados.getCartasDaRodada().get(3));
			else
				inserir.setString(7, " ");
			inserir.setInt(8, dados.getPontuacoes()[0]);
			inserir.setInt(9, dados.getPontuacoes()[1]);
			inserir.setInt(10, dados.getPontuacoes()[2]);
			if(dados.getPontuacoes().length == 4 )
				inserir.setInt(11, dados.getPontuacoes()[3]);
			else
				inserir.setInt(11, 0);
			
			resposta = inserir.executeUpdate();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}
