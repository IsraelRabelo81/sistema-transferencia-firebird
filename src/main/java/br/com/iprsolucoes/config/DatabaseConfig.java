package br.com.iprsolucoes.config;

import java.io.*;
import java.util.Properties;

public class DatabaseConfig {
    private Properties properties;
    private final String CONFIG_FILE = "database.properties";
    
    public DatabaseConfig() {
        properties = new Properties();
        loadConfig();
    }

    private void loadConfig() {
        try(InputStream input = new FileInputStream(CONFIG_FILE)){
            properties.load(input);
            
        } catch (Exception e) {
            createDefaultConfig();
        }
    }

    private void createDefaultConfig() {
        properties.setProperty("source.url", "jdbc:firebirdsql://localhost:3050/C:/source.fdb");
        properties.setProperty("source.user", "sysdba");
        properties.setProperty("source.password", "masterkey");

        properties.setProperty("target.url", "jdbc:firebirdsql://localhost:3050/C:/target.fdb");
        properties.setProperty("target.user", "sysdba");
        properties.setProperty("target.password", "masterkey");

        saveConfig();

    }

    private void saveConfig() {
        try(OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, "Database Configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSourceUrl() {
        return properties.getProperty("source.url");
    }

    public String getSourceUser() {
        return properties.getProperty("source.user");
    }

    public String getSourcePassword() {
        return properties.getProperty("source.password");
    }


    public String getTargetUrl() {
        return properties.getProperty("target.url");
    }

    public String getTargetUser() {
        return properties.getProperty("target.user");
    }

    public String getTargetPassword() {
        return properties.getProperty("tagert.password");
    }

}
