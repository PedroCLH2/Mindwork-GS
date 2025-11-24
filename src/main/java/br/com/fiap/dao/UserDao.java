package br.com.fiap.dao;

import br.com.fiap.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserDao {

    @Inject
    DataSource dataSource;

    public List<User> listar() throws SQLException {
        List<User> lista = new ArrayList<>();

        String sql = "SELECT user_id, name, email, password, username, registration_date FROM users ORDER BY user_id";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUser_id(rs.getLong("user_id"));
                u.setNome(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setRegistration_date(rs.getDate("registration_date").toLocalDate());

                u.setSenha(rs.getString("password"));
                u.setNomeUser(rs.getString("username"));

                lista.add(u);
            }
        }
        return lista;
    }

    public void inserir(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password, username, registration_date) VALUES (?, ?, ?, ?, CURRENT_DATE)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"user_id"})) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getSenha());
            stmt.setString(4, user.getNomeUser());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.setUser_id(rs.getLong(1));
            }
        }
    }
}