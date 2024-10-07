package com.example.Repository.Impl;

import com.example.Model.Relatorio;
import com.example.Config.Connection;
import com.example.Repository.RelatorioRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatorioRepositoryImpl implements RelatorioRepository {

    @Override
    public void salvar(Relatorio relatorio) {
        String sql = "INSERT INTO relatorio (titulo, categoria) VALUES (?, ?)";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, relatorio.getTitulo());
            statement.setString(2, relatorio.getCategoria());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Relatorio> buscarPorUsuario(Long idUsuario) {
        List<Relatorio> relatorios = new ArrayList<>();
        String sql = "SELECT * FROM relatorio r " +
                     "JOIN preencher p ON r.id_relatorio = p.id_relatorio " +
                     "WHERE p.id_usuario = ?";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setLong(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Relatorio relatorio = new Relatorio();
                relatorio.setIdRelatorio(resultSet.getLong("id_relatorio"));
                relatorio.setTitulo(resultSet.getString("titulo"));
                relatorio.setCategoria(resultSet.getString("categoria"));

                relatorios.add(relatorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return relatorios;
    }

    @Override
    public Relatorio buscarPorId(Long idRelatorio) {
        String sql = "SELECT * FROM relatorio WHERE id_relatorio = ?";
        Relatorio relatorio = null;

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setLong(1, idRelatorio);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                relatorio = new Relatorio();
                relatorio.setIdRelatorio(resultSet.getLong("id_relatorio"));
                relatorio.setTitulo(resultSet.getString("titulo"));
                relatorio.setCategoria(resultSet.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return relatorio;
    }

    @Override
    public void atualizar(Relatorio relatorio) {
        String sql = "UPDATE relatorio SET titulo = ?, categoria = ? WHERE id_relatorio = ?";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, relatorio.getTitulo());
            statement.setString(2, relatorio.getCategoria());
            statement.setLong(3, relatorio.getIdRelatorio());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Long idRelatorio) {
        String sql = "DELETE FROM relatorio WHERE id_relatorio = ?";

        try (java.sql.Connection connection = Connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setLong(1, idRelatorio);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
