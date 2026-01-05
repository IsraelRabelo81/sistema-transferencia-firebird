package br.com.iprsolucoes.config;

import java.io.*;
import java.util.Properties;

public class DatabaseConfig {
    private static final String CONFIG_FILE = System.getProperty("user.dir") + File.separator + "config" + File.separator
            + "database.properties";
    private final Properties properties = new Properties();

    public DatabaseConfig() {
        loadConfig();
    }

    private void loadConfig() {
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (FileNotFoundException e) {
            createDefaultConfig();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar database.properties", e);
        }
    }

    private void createDefaultConfig() {
        new File("config").mkdirs();

        properties.setProperty("firebird.url", "jdbc:firebirdsql://localhost:3050/C:/source.fdb");
        properties.setProperty("firebird.user", "sysdba");
        properties.setProperty("firebird.password", "masterkey");

        saveConfig();

    }

    private void saveConfig() {
        try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, "Firebird Configuration");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar database.properties", e);
        }
    }

    public String getUrl() {
        return properties.getProperty("firebird.url");
    }

    public String getUser() {
        return properties.getProperty("firebird.user");
    }

    public String getPassword() {
        return properties.getProperty("firebird.password");
    }
}
