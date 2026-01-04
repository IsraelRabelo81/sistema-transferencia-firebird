package br.com.iprsolucoes.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBFConfig {
    private Properties properties;
    private final String CONFIG_FILE = "dbf-config.properties";

    public DBFConfig() {
        properties = new Properties();
        loadConfig();
    }

    private void loadConfig() {
        try(InputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            createDefaultConfig();
        }
    }

    private void createDefaultConfig() {
        properties.setProperty("dbf.export.path", "C:/dbf_export/");
        properties.setProperty("dbf.encoding", "CP1252");
        properties.setProperty("dbf.create.index", "false");
        properties.setProperty("dbf.overwrite.existing", "true");

        saveConfig();
    }

    public void saveConfig() {

    }
}
