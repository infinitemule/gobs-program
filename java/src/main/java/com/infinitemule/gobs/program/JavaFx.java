package com.infinitemule.gobs.program;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * 
 */
public class JavaFx extends Application {
  
  private static final String PENUS = "Penus Penus Penus Penus Penus Penus";
  
  private static final int WIDTH  = 530;
  private static final int HEIGHT = 530;
  
  @Override
  public void start(Stage stage) throws Exception {
    
    final TextArea textArea = TextAreaBuilder.create()
        .prefWidth(WIDTH)
        .prefHeight(HEIGHT)
        .wrapText(true) 
        .id("terminal")
        .text("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nGob's Program: Y/N?\n? ")        
        .build();

    
    textArea.positionCaret(999);
    
    textArea.setOnKeyReleased(new EventHandler<KeyEvent>() {
      @Override 
      public void handle(KeyEvent keyEvent) {                

        textArea.setText(textArea.getText(0, textArea.getText().length() - 1));
        textArea.positionCaret(999);
        
        String input = keyEvent.getCode().getName().toUpperCase();
        
        if("Y".equals(input) ||
           "N".equals(input)) {
        
          // Trying to replace lower case input with upper case.
          textArea.appendText(input + "\n");
          
          new Thread(new Runnable() {
            
            @Override public void run() {
              while(true) {             
                
                // This little delay helps create the scrolling effect.                
                try { Thread.sleep(50); } catch(InterruptedException e) {}
                
                textArea.appendText(PENUS + "\n");
              }
            }
            
          }).start();
          
        }
        else {          
          textArea.positionCaret(999);
        }
        
      }
    });
    
    StackPane root = new StackPane();
        
    root.getChildren().add(textArea);
    
    Scene scene = new Scene(root, WIDTH, HEIGHT);
    scene.getStylesheets().add(
        JavaFx.class.getResource("gobs-program.css").toExternalForm());
    
    stage.setTitle("Gob's Program");    
    stage.setScene(scene);    
    stage.show();
    
  }
  
  public static void main(String[] args) {    
    launch(args);
  }
  
}
