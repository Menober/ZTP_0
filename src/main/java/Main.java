import controller.InterfaceController;
import view.InterfaceView;


public class Main {
    public static void main(String[] args) {
        loop();
    }

    public static void loop() {
        String message = "";
        while (!"bye".equals(message)&&!"exit".equals(message)) {
            InterfaceView.printOptions();
            message = InterfaceView.readKeyboard();
            InterfaceController.chooseOption(message);
        }
    }

}
