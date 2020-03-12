package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JsonDataReader;

import java.io.IOException;

/**
 * File Reader Manager as Singleton Design Pattern
 * The Singleton’s purpose is to control object creation,
 * limiting the number of objects to only one. Since there is only one Singleton instance,
 * any instance fields of a Singleton will occur only once per class, just like static fields.
 */
public class FileReaderManager {

    /**
     * Private static variable of the same class that is the only instance of the class
     */
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonDataReader jsonDataReader;

    /**
     * Private constructor to restrict instantiation of the class from other classes.
     * Clients cannot instantiate FileReaderManager instances.
     */
    private FileReaderManager() {
    }

    /**
     * Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.
     * The FileReaderManager class maintains a static reference to its own instance and returns that reference from the static getInstance() method.
     *
     * @return the instance of the class
     */
    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    /**
     * getConfigReader() method returns the instance of the ConfigFileReader but this method is not static.
     * So that client has to use the getInstance() method to access other public methods of the FileReaderManager like FileReaderManager.getInstance().getConfigReader()
     *
     * @return the instance of the ConfigFileReader
     * @throws IOException
     */
//    public ConfigFileReader getConfigReader() throws IOException {
//        return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
//    }

    /**
     * @return instance of the JsonDataReader
     * @throws IOException
     */
    public JsonDataReader getJsonReader() throws IOException {
        return (jsonDataReader == null) ? jsonDataReader = new JsonDataReader() : jsonDataReader;
    }
}
