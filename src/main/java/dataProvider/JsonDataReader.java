package dataProvider;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "Customer.json";
    private List<Customer> customerList;

    public JsonDataReader() throws IOException {
        customerList = getCustomerData();
    }

    private List<Customer> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(customerFilePath));
            Customer[] customers = gson.fromJson(bufferedReader, Customer[].class);
            return Arrays.asList(customers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path: " + customerFilePath);
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final testDataTypes.Customer getCustomerByName(String customerName) {
        return customerList.stream().filter(x -> x.firstName.equalsIgnoreCase(customerName)).findAny().get();
    }
}
