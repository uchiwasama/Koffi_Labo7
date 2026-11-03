package laboratoire7;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** Modèle (M) : un étudiant, avec des propriétés JavaFX pour la TableView. */
public class Etudiant {
    private final IntegerProperty numDA = new SimpleIntegerProperty();
    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty prenom = new SimpleStringProperty();
    private final DoubleProperty moyenne = new SimpleDoubleProperty();

    public Etudiant(int numDA, String nom, String prenom, double moyenne) {
        this.numDA.set(numDA);
        this.nom.set(nom);
        this.prenom.set(prenom);
        this.moyenne.set(moyenne);
    }

    public int getNumDA()      { return numDA.get(); }
    public String getNom()     { return nom.get(); }
    public String getPrenom()  { return prenom.get(); }
    public double getMoyenne() { return moyenne.get(); }

    public IntegerProperty numDAProperty()   { return numDA; }
    public StringProperty nomProperty()      { return nom; }
    public StringProperty prenomProperty()   { return prenom; }
    public DoubleProperty moyenneProperty()  { return moyenne; }
}