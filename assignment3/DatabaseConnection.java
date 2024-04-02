import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnection {

      private static DatabaseConnection instance;
      private Map<String, String> config;

      private DatabaseConnection() {
            loadConfigFromFile();
      }

      public static synchronized DatabaseConnection getInstance() {
            if (instance == null) {
                  instance = new DatabaseConnection();
            }
            return instance;
      }

      private void loadConfigFromFile() {
            String configFilePath = "/path/to/config.yaml"; // Change this to your config file path

            try {
                  String fileExtension = configFilePath.substring(configFilePath.lastIndexOf('.') + 1);

                  switch (fileExtension.toLowerCase()) {
                        case "yaml":
                        case "yml":
                              loadYamlConfig(configFilePath);
                              break;
                        default:
                              throw new IllegalArgumentException("Unsupported configuration file format: " + fileExtension);
                  }
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      private void loadYamlConfig(String configFilePath) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(configFilePath));
            String line;
            config = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                  String[] parts = line.split(":");
                  if (parts.length >= 2) {
                        config.put(parts[0].trim(), parts[1].trim());
                  }
            }
            reader.close();
      }

      public void executeQuery(String query) {}

      public Map<String, String> getConnectionInfo() {
            if (config == null) {
                  throw new IllegalStateException("Configuration not loaded");
            }
            return config;
      }

      public static void main(String[] args) {
            DatabaseConnection dbConn1 = DatabaseConnection.getInstance();
            DatabaseConnection dbConn2 = DatabaseConnection.getInstance();

            System.out.println("Are both instances the same? " + (dbConn1 == dbConn2));

            Map<String, String> connectionInfo = dbConn1.getConnectionInfo();
            if (connectionInfo != null) {
                  System.out.println("Connection information:");
                  for (Map.Entry<String, String> entry : connectionInfo.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                  }
            }
      }
}
