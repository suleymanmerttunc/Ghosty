package com.example.ghostymodel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatRoomController {


    @FXML
    private Label firstText, fourthText, secondText, thirdText;

    @FXML
    private Label lobbyText;

    @FXML
    private Label welcomeLabel;

    public void setTrends(String[] trends) {
        if (trends != null && trends.length >= 4) {
            firstText.setText(trends[0]);
            secondText.setText(trends[1]);
            thirdText.setText(trends[2]);
            fourthText.setText(trends[3]);
        }
    }

    public void setUsername(String username) {
        welcomeLabel.setText(username);
    }

    public void setLobbyText(String trendName) {
        lobbyText.setText(trendName);
    }

    @FXML
    void lobbyClicked(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("chatRoom.fxml"));
            Parent root = loader.load();

            // Controller'a erişmek içim
            ChatRoomController chatRoomController = loader.getController();

            // Trend verilerini gönder
            String[] trends = {
                    firstText.getText(),
                    secondText.getText(),
                    thirdText.getText(),
                    fourthText.getText()
            };
            chatRoomController.setTrends(trends);

            Label clickedLabel = (Label) event.getSource();
            chatRoomController.setLobbyText(clickedLabel.getText());

            // Kullanıcı ismini de göndermek için
            chatRoomController.setUsername(welcomeLabel.getText());

            Stage stage = new Stage();
            stage.setTitle("Ghosty");
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();

            ((Stage)(((javafx.scene.Node) event.getSource()).getScene().getWindow())).close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

