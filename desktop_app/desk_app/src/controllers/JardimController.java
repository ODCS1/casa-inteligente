package controllers;
import java.io.IOException;

import dao.LedDAO;
import entidade.Usuario;
import estado_lampadas.EstadoLampJardim;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import serial.SerialCommunication;

public class JardimController {
    
    private Stage stage;
    private Scene scene;

    private Usuario usuario = Session.getCurrentUser();

    @FXML
    private Label access;
    @FXML
    private Label myLabel1, myLabel2, myLabel3, myLabel4;
    @FXML
    private CheckBox myCheckBox1, myCheckBox2, myCheckBox3, myCheckBox4;
    @FXML
    private ImageView myImageView1, myImageView2, myImageView3, myImageView4;

    Image myImage1_OFF = new Image(getClass().getResourceAsStream("/img/light-bulb.png"));
    Image myImage1_ON = new Image(getClass().getResourceAsStream("/img/light-bulb-on.png"));
    
    Image myImage2_OFF = new Image(getClass().getResourceAsStream("/img/light-bulb.png"));
    Image myImage2_ON = new Image(getClass().getResourceAsStream("/img/light-bulb-on.png"));

    Image myImage3_OFF = new Image(getClass().getResourceAsStream("/img/light-bulb.png"));
    Image myImage3_ON = new Image(getClass().getResourceAsStream("/img/light-bulb-on.png"));
    
    Image myImage4_OFF = new Image(getClass().getResourceAsStream("/img/light-bulb.png"));
    Image myImage4_ON = new Image(getClass().getResourceAsStream("/img/light-bulb-on.png"));

    @FXML
    public void change1(ActionEvent event) {
        boolean newState1 = myCheckBox1.isSelected();

        if(myCheckBox1.isSelected()) {
            myLabel1.setText("ON");
            myImageView1.setImage(myImage1_ON);
            EstadoLampJardim.setCheckedJardim1(true);
            SerialCommunication.enviarComandoParaArduino('0');
        } else {
            myLabel1.setText("OFF");
            myImageView1.setImage(myImage1_OFF);
            EstadoLampJardim.setCheckedJardim1(false);
            SerialCommunication.enviarComandoParaArduino('1');
        }

        LedDAO.atualizarEstadoLedJardim1(usuario.getId_cliente(), newState1);
    }

    @FXML
    public void change2(ActionEvent event) {
        boolean newState2 = myCheckBox2.isSelected();

        if(myCheckBox2.isSelected()) {
            myLabel2.setText("ON");
            myImageView2.setImage(myImage2_ON);
            EstadoLampJardim.setCheckedJardim2(true);
            SerialCommunication.enviarComandoParaArduino('2');
        } else {
            myLabel2.setText("OFF");
            myImageView2.setImage(myImage2_OFF);
            EstadoLampJardim.setCheckedJardim2(false);
            SerialCommunication.enviarComandoParaArduino('3');
        }

        LedDAO.atualizarEstadoLedJardim2(usuario.getId_cliente(), newState2);
    }

    @FXML
    public void change3(ActionEvent event) {
        boolean newState3 = myCheckBox3.isSelected();

        if(myCheckBox3.isSelected()) {
            myLabel3.setText("ON");
            myImageView3.setImage(myImage3_ON);
            EstadoLampJardim.setCheckedJardim3(true);
            SerialCommunication.enviarComandoParaArduino('4');
        } else {
            myLabel3.setText("OFF");
            myImageView3.setImage(myImage3_OFF);
            EstadoLampJardim.setCheckedJardim3(false);
            SerialCommunication.enviarComandoParaArduino('5');
        }

        LedDAO.atualizarEstadoLedJardim3(usuario.getId_cliente(), newState3);
    }

    @FXML
    public void change4(ActionEvent event) {
        boolean newState4 = myCheckBox4.isSelected();

        if(myCheckBox4.isSelected()) {
            myLabel4.setText("ON");
            myImageView4.setImage(myImage4_ON);
            EstadoLampJardim.setCheckedJardim4(true);
            SerialCommunication.enviarComandoParaArduino('g');
        } else {
            myLabel4.setText("OFF");
            myImageView4.setImage(myImage4_OFF);
            EstadoLampJardim.setCheckedJardim4(false);
            SerialCommunication.enviarComandoParaArduino('h');
        }

        LedDAO.atualizarEstadoLedJardim4(usuario.getId_cliente(), newState4);
    }
    
    @FXML
    public void initialize() {
        myCheckBox1.setSelected(EstadoLampJardim.isCheckedJardim1());
        if(myCheckBox1.isSelected()) {
            myLabel1.setText("ON");
            myImageView1.setImage(myImage1_ON);
        } else {
            myLabel1.setText("OFF");
            myImageView1.setImage(myImage1_OFF);
        }
        myCheckBox2.setSelected(EstadoLampJardim.isCheckedJardim2());
        if(myCheckBox2.isSelected()) {
            myLabel2.setText("ON");
            myImageView2.setImage(myImage2_ON);
        } else {
            myLabel2.setText("OFF");
            myImageView2.setImage(myImage2_OFF);
        }
        myCheckBox3.setSelected(EstadoLampJardim.isCheckedJardim3());
        if(myCheckBox3.isSelected()) {
            myLabel3.setText("ON");
            myImageView3.setImage(myImage3_ON);
        } else {
            myLabel3.setText("OFF");
            myImageView3.setImage(myImage3_OFF);
        }
        
        myCheckBox4.setSelected(EstadoLampJardim.isCheckedJardim4());
        if(myCheckBox4.isSelected()) {
            myLabel4.setText("ON");
            myImageView4.setImage(myImage4_ON);
        } else {
            myLabel4.setText("OFF");
        }
    }

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
