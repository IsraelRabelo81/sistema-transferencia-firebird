package br.com.iprsolucoes.dao;

import br.com.iprsolucoes.config.DatabaseConfig;
import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConfig config = new DatabaseConfig();

    public static Connection getSourceConnection() throws SQLException {
        return DriverManager.getConnection(
                config.getSourceUrl(),
                config.getSourceUser(),
                config.getSourcePassword()
        );
    }

    public static Connection getTargetConnection() throws SQLException {
        return DriverManager.getConnection(
                config.getTargetUrl(),
                config.getTargetUser(),
                config.getTargetPassword()
        );
    }

}
