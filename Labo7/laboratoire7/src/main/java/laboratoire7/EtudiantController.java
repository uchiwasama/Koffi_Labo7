package laboratoire7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/** Contrôleur (C) : logique de l'application. */
public class EtudiantController implements Initializable {

    @FXML private TableView<Etudiant> tableView;
    @FXML private TableColumn<Etudiant, Number> colNumDA;
    @FXML private TableColumn<Etudiant, String> colNom;
    @FXML private TableColumn<Etudiant, String> colPrenom;
    @FXML private TableColumn<Etudiant, Number> colMoyenne;

    @FXML private TextField NumDA;
    @FXML private TextField Nom;
    @FXML private TextField Prenom;
    @FXML private TextField Moyenne;

    private final ObservableList<Etudiant> donnees = FXCollections.observableArrayList(
            new Etudiant(1, "nom1", "prenom1", 34.5),
            new Etudiant(2, "nom2", "prenom2", 74.5),
            new Etudiant(3, "nom3", "prenom3", 64.5),
            new Etudiant(4, "nom4", "prenom4", 85.0));

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colNumDA.setCellValueFactory(c -> c.getValue().numDAProperty());
        colNom.setCellValueFactory(c -> c.getValue().nomProperty());
        colPrenom.setCellValueFactory(c -> c.getValue().prenomProperty());
        colMoyenne.setCellValueFactory(c -> c.getValue().moyenneProperty());

        tableView.setItems(donnees);
    }

    @FXML
    protected void ajouterEtudiant(ActionEvent event) {
        try {
            tableView.getItems().add(new Etudiant(
                    Integer.parseInt(NumDA.getText().trim()),
                    Nom.getText(),
                    Prenom.getText(),
                    Double.parseDouble(Moyenne.getText().trim())));
            NumDA.setText("");
            Nom.setText("");
            Prenom.setText("");
            Moyenne.setText("");
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR,
                    "Le numéro de DA doit être un entier et la moyenne un nombre.").showAndWait();
        }
    }
}