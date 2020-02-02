//I worked on the homework assignment alone, using only course materials.
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
* This class represents a Dog object.
* @author Chuyi Chen
* @version 1.0
*/
public class MessageBoard extends Application {
    /**
     * RE-WRITE THE start method in application
     * @param primaryStage the primary stage hold the scene
     * @throws Exception throws before compilation
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create A border pane
        BorderPane pane = new BorderPane();
        ListView<String> msg = new ListView<>();
        msg.setMinHeight(500);
        ObservableList<String> msgList = FXCollections.observableArrayList();

        TextField name = getTF("name");
        TextField message = getTF("message");
        Button send = new Button("Post Message");

        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!name.getText().isEmpty() && !message.getText().isEmpty()) {
                    //Text t = new Text(name.getText() + ": " + message.getText());
                    msgList.add(name.getText() + ": " + message.getText());
                    msg.setItems(msgList);
                    name.clear();
                    message.clear();
                }
            }
        });

        pane.setBottom(getHBox(name, message, send));
        pane.setTop(msg);

        primaryStage.setTitle("CS 1331 Message Board");
        primaryStage.setScene(new Scene(pane, 440, 530));
        primaryStage.setMinHeight(550);
        primaryStage.setMinWidth(440);
        primaryStage.show();
    }

    /**
     * get horizontal box for name, message, and post button nodes
     * @param name textfield for name
     * @param message textfield for message
     * @param send button for post message
     * @return the horizontal box
     */
    private HBox getHBox(TextField name, TextField message, Button send) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.getChildren().add(name);
        hBox.getChildren().add(message);
        hBox.getChildren().add(send);
        return hBox;
    }

    /**
     * Creates text field with hint
     * @param hint hint to remind what text should be put
     * @return the textfield with hint
     */
    private TextField getTF(String hint) {
        TextField result = new TextField();
        result.setPromptText(hint);
        return result;
    }

    /**
     * Main class to launch the application
     * @param args string array
     */
    public static void main(String[] args) {
        launch(args);
    }
}
