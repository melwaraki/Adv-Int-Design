import grovepi.GrovePi;
import grovepi.Pin;
import grovepi.PinMode;
import grovepi.sensors.Led;

/**
 This program turns on an alert LED if a new event is received.
 This is done to alert the users to check the new event.
 **/

public class Alert {

	public static void main(String[] args) {
        
        GrovePi grovePi = new GrovePi();
        Led alertLED = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_4);
        
        //this will be changed automatically in real usage
        boolean receivedEvent = true
        
        //enable LED if an event is received
        alertLED.setState(receivedEvent)
	}

}
