import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene la implementación de una aplicación para realizar operaciones
 * con personas.
 *
 * @author BraynerMoncada
 */
public class Main extends Application {
    private static List<Persona> personas = new ArrayList<>();
    private Label Resultado;
    public static void main(String[] args) {
        launch();
    }
    ComboBox<String> ComboBoxPersona1 =  new ComboBox<>(); //Elegir primera persona
    ComboBox<String> ComboBoxPersona2 = new ComboBox<>();//Elegir segunda persona entre las no seleccionadas en P1

    /**
     * Inicializa la interfaz gráfica de la aplicación.
     *
     * @param stage el objeto Stage que representa la ventana principal de la aplicación
     * @throws Exception si ocurre un error al inicializar la interfaz gráfica
     */
    @Override
    public void start(Stage stage) throws Exception {
        GridPane ventana = new GridPane();
        Scene scene = new Scene(ventana, 450,180);
        //Crear elementos de la interfaz
        Label indicacion1 = new Label("AGREGAR PERSONAS:");
        Label indicacion2 = new Label("OPERACIONES");
        Label labelNombre = new Label("Nombre:");
        TextField campoNombre = new TextField();
        Label labelProvincia = new Label("Provincia:");
        ComboBox<String> comboBoxProvincia = new ComboBox<>();//ComboBox de provincias
        comboBoxProvincia.getItems().addAll("San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón");
        ComboBoxPersona1.getItems().addAll(String.valueOf(personas));
        Label persona1 = new Label("Persona 1");
        Label persona2 = new Label("Persona 2");
        Label labelEdad = new Label("Edad:");
        TextField campoEdad = new TextField();
        Resultado = new Label("Resultado: -");
        Button botonAgregar = new Button("Agregar Persona");
        Button suma = new Button("+");
        Button resta = new Button("-");
        Button multiplicar = new Button("*");
        Button division = new Button("/");

        //Evento del button agregar persona
        botonAgregar.setOnAction(e -> agregarPersona(campoNombre.getText(), comboBoxProvincia.getValue(), campoEdad.getText()));

        /**

         Maneja el evento del botón "Sumar".
         @param ComboBoxPersona1 el ComboBox con la persona 1 seleccionada.
         @param ComboBoxPersona2 el ComboBox con la persona 2 seleccionada.
         @param Resultado el Label donde se mostrará el resultado de la operación.
         */

        suma.setOnAction(e -> {
            String nombre1 = ComboBoxPersona1.getValue();
            String nombre2 = ComboBoxPersona2.getValue();
            if (nombre1 != null && nombre2 != null && !nombre1.equals(nombre2)) {
                int edad1 = buscarEdadPersona(nombre1);
                int edad2 = buscarEdadPersona(nombre2);
                int resultado = edad1 + edad2;
                Resultado.setText("Resultado: " + resultado);
            }
        });

        /**
         Maneja el evento del botón "Restar".
         @param ComboBoxPersona1 el ComboBox con la persona 1 seleccionada.
         @param ComboBoxPersona2 el ComboBox con la persona 2 seleccionada.
         @param Resultado el Label donde se mostrará el resultado de la operación.
         */
        resta.setOnAction(e -> {
            String nombre1 = ComboBoxPersona1.getValue();
            String nombre2 = ComboBoxPersona2.getValue();
            if (nombre1 != null && nombre2 != null && !nombre1.equals(nombre2)) {
                int edad1 = buscarEdadPersona(nombre1);
                int edad2 = buscarEdadPersona(nombre2);
                int resultado = edad1 - edad2;
                Resultado.setText("Resultado: " + resultado);
            }
        });

        /**
         Maneja el evento del botón "Multiplicar".
         @param ComboBoxPersona1 el ComboBox con la persona 1 seleccionada.
         @param ComboBoxPersona2 el ComboBox con la persona 2 seleccionada.
         @param Resultado el Label donde se mostrará el resultado de la operación.
         */
        multiplicar.setOnAction(e -> {
            String nombre1 = ComboBoxPersona1.getValue();
            String nombre2 = ComboBoxPersona2.getValue();
            if (nombre1 != null && nombre2 != null && !nombre1.equals(nombre2)) {
                int edad1 = buscarEdadPersona(nombre1);
                int edad2 = buscarEdadPersona(nombre2);
                int resultado = edad1 * edad2;
                Resultado.setText("Resultado: " + resultado);
            }
        });

        /**
         Maneja el evento del botón "Multiplicar".
         @param ComboBoxPersona1 el ComboBox con la persona 1 seleccionada.
         @param ComboBoxPersona2 el ComboBox con la persona 2 seleccionada.
         @param Resultado el Label donde se mostrará el resultado de la operación.
         */
        division.setOnAction(e -> {
            String nombre1 = ComboBoxPersona1.getValue();
            String nombre2 = ComboBoxPersona2.getValue();
            if (nombre1 != null && nombre2 != null && !nombre1.equals(nombre2)) {
                int edad1 = buscarEdadPersona(nombre1);
                int edad2 = buscarEdadPersona(nombre2);
                int resultado = edad1 / edad2;
                Resultado.setText("Resultado: " + resultado);
            }
        });




        //Posiciones
        GridPane.setConstraints(indicacion1, 1, 6);
        GridPane.setConstraints(labelNombre, 0, 7);
        GridPane.setConstraints(campoNombre, 1, 7);
        GridPane.setConstraints(labelProvincia, 0,9 );
        GridPane.setConstraints(comboBoxProvincia, 1, 9);
        GridPane.setConstraints(botonAgregar, 1, 12);
        GridPane.setConstraints(labelEdad, 0, 10);
        GridPane.setConstraints(campoEdad, 1, 10);
        GridPane.setConstraints(Resultado, 0, 1);

        GridPane.setConstraints(indicacion2, 5, 6);
        GridPane.setConstraints(persona1, 5, 9);
        GridPane.setConstraints(ComboBoxPersona1, 6, 9);
        GridPane.setConstraints(persona2, 5, 10);
        GridPane.setConstraints(ComboBoxPersona2, 6, 10);
        GridPane.setConstraints(suma, 5, 12);
        GridPane.setConstraints(resta, 6, 12);
        GridPane.setConstraints(multiplicar, 7, 12);
        GridPane.setConstraints(division, 8, 12);




        //Colocar elementos en ventana
        ventana.getChildren().addAll(indicacion1,indicacion2,labelNombre,campoNombre,labelProvincia,comboBoxProvincia,ComboBoxPersona1,
                ComboBoxPersona2,labelEdad,campoEdad,botonAgregar,Resultado,persona1,persona2,suma,resta,multiplicar,
                division);

        stage.setScene(scene);
        stage.setTitle("Calculadora Personas");
        stage.show();

    }

    /**
     * Busca la edad de una persona en la lista de personas.
     *
     * @param nombre el nombre de la persona a buscar
     * @return la edad de la persona si se encuentra, o 0 si no se encuentra
     */
    public static int buscarEdadPersona(String nombre) {
        for (Persona p : personas) {
            if (p.getNombre().equals(nombre)) {
                return p.getEdad();
            }
        }
        return 0;
    }

    /**
     * Agrega una nueva persona a la lista de personas.
     *
     * @param nombre el nombre de la persona
     * @param provincia la provincia de la persona
     * @param edad la edad de la persona
     */
    private void agregarPersona(String nombre, String provincia, String edadStr) {
        // Validar que se haya ingresado un nombre y una edad válida
        if (nombre.isEmpty() || edadStr.isEmpty()) {
            return;
        }
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
            if (edad <= 0) {
                return;
            }
        } catch (NumberFormatException e) {
            return;
        }
        // Validar que no se hayan agregado 4 personas
        if (personas.size() == 4) {
            return;
        }
        // Agregar persona a la lista
        personas.add(new Persona(nombre, provincia, edad));
        actualizarComboBox();// Se actualiza el ComboBox cada vez que se agrega una persona a la lista


    }

    /**

     Actualiza los ComboBox de personas con los nombres de las personas existentes y deshabilita la selección
     del elemento seleccionado en el ComboBoxPersona1 en el ComboBoxPersona2.
     */
    private void actualizarComboBox() {
        ComboBoxPersona1.getItems().clear();
        ComboBoxPersona2.getItems().clear();
        for(Persona persona : personas) {
            ComboBoxPersona1.getItems().add(persona.getNombre());
            ComboBoxPersona2.getItems().add(persona.getNombre());
        }
        // Deshabilitar el elemento seleccionado en ComboBoxPersona1 en ComboBoxPersona2
        if (ComboBoxPersona1.getSelectionModel().getSelectedItem() != null) {
            String selectedItem = ComboBoxPersona1.getSelectionModel().getSelectedItem();
            ComboBoxPersona2.getItems().stream().filter(item -> item.equals(selectedItem))
                    .findFirst()
                    .ifPresent(item -> ComboBoxPersona2.getItems().remove(item));
        }
    }

}