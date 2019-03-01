package project;

import java.io.File;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
	File textDoc = new File("BlowingInTheWind.txt");
	DocumentHelper dh = new DocumentHelper("BlowingInTheWind.txt");

	@Override
	public void start(Stage stage) throws Exception {
		MasterLinkedList masterList = new MasterLinkedList();
		List<String> tokens = dh.getTokens("[\\w]+");
		for (int i = 0; i < tokens.size() - 1; i++) {
			masterList.insertAfter(tokens.get(i), tokens.get(i + 1));
		}
		

		Pane mainPane = new Pane();
		HBox box = new HBox(5);
		VBox vBox = new VBox(10);
		ComboBox<File> textDocs = new ComboBox<File>();
		textDocs.getItems().addAll(textDoc);
		Button genButton = new Button("Generate");
		TextField word = new TextField();
		TextField length = new TextField();
		TextArea textArea = new TextArea();
		textArea.setWrapText(true);
		vBox.getChildren().addAll(box, textArea);
		box.setAlignment(Pos.CENTER);
		genButton.setOnAction(a -> {
			if (word.getText() == null || length.getText() == null) {
				// Alert
				Alert alert1 = new Alert(AlertType.ERROR);
				alert1.setContentText("Starting word and text lenght not found");
				alert1.showAndWait();
				return;
			}
			String startingWord = word.getText();
			String lengthOf = length.getText();
			int realLength = 0;
			try {
				realLength = Integer.parseInt(lengthOf);
			} catch (NumberFormatException e) {
				// Alert
				return;
			}
			if (masterList.find(startingWord) == null) {
				// Alert
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setContentText("First word is not found");
				alert2.showAndWait();
				return;
			}
			String text = "";
			MasterLink link = masterList.find(startingWord);
			Random random = new Random();
			while (realLength > 0) {
				int size = random.nextInt(link.getBabyList().getSize());
				BabyIterator babyIt = link.getBabyList().getIterator();
				while (size > 0) {
					babyIt.nextLink();
					size--;
				}
				BabyLink babyLink = babyIt.getCurrent();
				text += link.getiData() + " ";
				link = masterList.find(babyLink.getiData());
				realLength--;
			}
			
			text += link.getiData();
			textArea.setText(text);
		});
		box.getChildren().addAll(textDocs, word, length, genButton);
		mainPane.getChildren().addAll(vBox);
		Scene scene = new Scene(mainPane, 800, 300);
		stage.setScene(scene);
		stage.show();

	}

}
