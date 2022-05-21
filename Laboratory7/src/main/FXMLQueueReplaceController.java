/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import domain.Person;
import domain.PriorityLinkedQueue;
import domain.QueueException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

public class FXMLQueueReplaceController implements Initializable {

    PriorityLinkedQueue queue = new PriorityLinkedQueue();
    PriorityLinkedQueue queue2 = new PriorityLinkedQueue();
    Alert alert;

    @FXML
    private TextField TF_NAME;
    @FXML
    private ChoiceBox<String> ChoiceMood;
    @FXML
    private ChoiceBox<String> ChoicePriority;
    @FXML
    private TableView<List<String>> Tableview;
    @FXML
    private Button BTNENQUEUE;
    @FXML
    private Button BTNCLEAR;
    @FXML
    private TableColumn<List<String>, String> NameColumn;
    @FXML
    private TableColumn<List<String>, String> MoodColumn;
    @FXML
    private TableColumn<List<String>, String> PriorityColumn;
    ObservableList<String> mood = FXCollections.observableArrayList("happy", "sad", "angry", "sick");
    ObservableList<String> Priority = FXCollections.observableArrayList("low", "medium", "high");
    @FXML
    private BorderPane bp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChoiceMood.setItems(mood);
        ChoicePriority.setItems(Priority);

        this.queue = util.Utility.getPriorityLinkedQueue1();
        this.queue2 = util.Utility.getPriorityLinkedQueue2();

        NameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(0));
            }
        });
        MoodColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(1));
            }
        });
        PriorityColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<List<String>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<List<String>, String> data) {
                return new ReadOnlyObjectWrapper<>(data.getValue().get(2));
            }
        });
        if (this.queue != null && !this.queue.isEmpty()) {
            this.Tableview.setItems(getData());
        }
    }

    private ObservableList<List<String>> getData() {
        ObservableList<List<String>> data = FXCollections.observableArrayList();
        if (this.queue != null && !this.queue.isEmpty()) {
            try {
                PriorityLinkedQueue aux1 = new PriorityLinkedQueue();
                PriorityLinkedQueue aux2 = new PriorityLinkedQueue();
                while (!queue.isEmpty()) {
                    Person c = (Person) queue.front();
                    String priority = String.valueOf(queue2.front());
                    List<String> arrayList = new ArrayList<>();

                    arrayList.add(c.getName());
                    arrayList.add(c.getMood());
                    arrayList.add(priority);
                   
                    data.add(arrayList);
                    aux1.enQueue(queue2.deQueue(), 1);
                    aux2.enQueue(queue.deQueue(), 1);
                }
   
                while (!aux1.isEmpty() && !aux2.isEmpty()) {

                    queue2.enQueue(aux1.deQueue(), 1);
                    queue.enQueue(aux2.deQueue(), 1);
                }
            } catch (QueueException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return data;
    }

    @FXML
    private void enqueue(ActionEvent event) throws QueueException {
        try {
            if (TF_NAME.getText().equals("") || ChoiceMood == null || ChoicePriority == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Priority Queue Managment");
                alert.setHeaderText("ERROR");
                alert.setContentText("Fill all the spaces");
                alert.showAndWait();
            } else if (ChoiceMood.getValue().equalsIgnoreCase("happy")) {
                if (ChoicePriority.getValue().equalsIgnoreCase("medium")) {
                    queue2.enQueue(ChoicePriority.getValue(), 2);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 2);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("high")) {
                    queue2.enQueue(ChoicePriority.getValue(), 3);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 3);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("low")) {
                    queue2.enQueue(ChoicePriority.getValue(), 1);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 1);
                }
            } else if (ChoiceMood.getValue().equalsIgnoreCase("sad")) {
                if (ChoicePriority.getValue().equalsIgnoreCase("medium")) {
                    queue2.enQueue(ChoicePriority.getValue(), 2);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 2);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("high")) {
                    queue2.enQueue(ChoicePriority.getValue(), 3);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 3);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("low")) {
                    queue2.enQueue(ChoicePriority.getValue(), 1);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 1);
                }
            } else if (ChoiceMood.getValue().equalsIgnoreCase("sick")) {
                if (ChoicePriority.getValue().equalsIgnoreCase("medium")) {
                    queue2.enQueue(ChoicePriority.getValue(), 2);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 2);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("high")) {
                    queue2.enQueue(ChoicePriority.getValue(), 3);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 3);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("low")) {
                    queue2.enQueue(ChoicePriority.getValue(), 1);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 1);
                }
            } else if (ChoiceMood.getValue().equalsIgnoreCase("angry")) {
                if (ChoicePriority.getValue().equalsIgnoreCase("medium")) {
                    queue2.enQueue(ChoicePriority.getValue(), 2);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 2);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("high")) {
                    queue2.enQueue(ChoicePriority.getValue(), 3);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 3);
                } else if (ChoicePriority.getValue().equalsIgnoreCase("low")) {
                    queue2.enQueue(ChoicePriority.getValue(), 1);
                    queue.enQueue(new Person(TF_NAME.getText(), ChoiceMood.getValue()), 1);
                }
            }
        } catch (Exception ex) {
            System.err.println("ERROR " + ex);
        }
        FXMLMainMenuController.loadPage(getClass().getResource("FXMLQueueReplace.fxml"), bp);
    }

    @FXML
    private void clear(ActionEvent event) {
        queue.clear();
        queue2.clear();
        TF_NAME.setText("");
        ChoiceMood.setValue(null);
        ChoicePriority.setValue(null);
        Tableview.getItems().clear();

    }

}
