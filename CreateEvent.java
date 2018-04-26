import grovepi.GrovePi;
import grovepi.Pin;
import grovepi.sensors.*;

/**
 This program creates an event then sends it to the server (placeholder).
 **/

class CreateEvent {

	public static void main(String[] args) {

		GrovePi grovePi = new GrovePi();
        
        //button is used for this demo, in reality they confirm by dropping ball in the Yes section
        ButtonSensor confirmBtn = grovePi.getDeviceFactory().createButtonSensor(Pin.DIGITAL_PIN_7);

		while(true) {
            
            //user confirms event
            if(confirmBtn.isPressed()) {
                int selection = SetButtonLED.selection;
                int date = grovePi.analogRead(Pin.ANALOG_PIN_0);
                int time = grovePi.analogRead(Pin.ANALOG_PIN_1);
                
                sendToServer(selection, date, time);
            }

			int light = grovePi.analogRead(Pin.ANALOG_PIN_0) / 10;
			grovePi.analogWrite(Pin.DIGITAL_PIN_3, 125-light);
		}
	}
    
    public void sendToServer(int selection, int date, int time) {
        //this will convert date and time into actual figures
        //then send data to the server
    }
}
