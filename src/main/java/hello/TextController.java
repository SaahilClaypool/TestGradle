package hello;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Saahil on 1/25/2017.
 */
public class TextController {
    @FXML
    private TextField loan;

    @FXML
    private TextField rate;
    @FXML
    private TextField months;

    @FXML
    private TextArea output;

    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    //Constructor
    public TextController() {

    }
    @FXML
    private void initialize(){
    }

    @FXML
    private void printOutput(){
        String loan_string = loan.getText();
        double loan_d= Double.parseDouble(loan_string);
        String rate_string = rate.getText();
        double rate_d = Double.parseDouble(rate_string) / 12;
        String months_string = months.getText();
        double months_i = Integer.parseInt(months_string);

        double res = loan_d * ( rate_d / (1 - Math.pow((1 + rate_d) , - months_i)
        ));

        output.setText("" + res);

    }
}
