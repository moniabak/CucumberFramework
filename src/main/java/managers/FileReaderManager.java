package managers;

import dataProvider.ConfigFileReader;

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

}
