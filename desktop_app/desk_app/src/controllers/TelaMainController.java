package controllers;
import java.io.IOException;

import entidade.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaMainController {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label access;

    private Usuario usuario = Session.getCurrentUser();
    
    @FXML
    Label nomeCliente;

    // Ja esse .java é responsavel por todas as trocas de telas que tem
    // desde a tela 1 que seria a login ate a tela dos comodos

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaLogin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaMain.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzSala(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaSala.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }

    }

    public void MostrarLuzMaster(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote()) || "Pacote básico".equals(usuario.getPacote())) {    
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaMaster.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void MostrarLuzJardim(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaJardim.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void MostrarLuzQuarto1(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote()) || "Pacote básico".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaQuarto1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void MostrarLuzSalaDeEstar(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote())) {    
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaSalaDeEstar.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void switchToSeg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaSeguranca.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MostrarLuzSalaDeJantar(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaSalaDeJantar.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void MostrarLuzLavabo(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaLavabo.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void MostrarLuzCozinha(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCozinha.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void MostrarLuzBanheiro(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaBanheiro.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }

    public void MostrarLuzLavanderia(ActionEvent event) throws IOException {
        if("Pacote Master".equals(usuario.getPacote()) || "Pacote Vip".equals(usuario.getPacote())) {
            Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaLavanderia.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            access.setText("NO ACCESS");
        }
    }
}