package Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLTableController {

    @FXML
    private TableView<DataModel> tableView;

    @FXML
    private TableColumn<DataModel, String> col1;

    @FXML
    private TableColumn<DataModel, String> col2;

    @FXML
    private TableColumn<DataModel, String> col3;

    @FXML
    private TableColumn<DataModel, String> col4;

    public void initialize() {
        // Initialize columns
        col1.setCellValueFactory(new PropertyValueFactory<>("property1"));
        col2.setCellValueFactory(new PropertyValueFactory<>("property2"));
        col3.setCellValueFactory(new PropertyValueFactory<>("property3"));
        col4.setCellValueFactory(new PropertyValueFactory<>("property4"));

        // Connect to the database and populate the table
        loadData();
    }

    private void loadData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root",
                    "ROOT@123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM new_table");

            ObservableList<DataModel> data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                DataModel row = new DataModel(
                        resultSet.getString("column1"),
                        resultSet.getString("column2"),
                        resultSet.getString("column3"),
                        resultSet.getString("column4"));
                data.add(row);
            }

            tableView.setItems(data);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DataModel class represents a row in the table
    public static class DataModel {
        private final String property1;
        private final String property2;
        private final String property3;
        private final String property4;

        public DataModel(String property1, String property2, String property3, String property4) {
            this.property1 = property1;
            this.property2 = property2;
            this.property3 = property3;
            this.property4 = property4;
        }

        // Getter methods
        public String getProperty1() {
            return property1;
        }

        public String getProperty2() {
            return property2;
        }

        public String getProperty3() {
            return property3;
        }

        public String getProperty4() {
            return property4;
        }
    }
}
