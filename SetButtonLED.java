import grovepi.GrovePi;
import grovepi.Pin;
import grovepi.sensors.*;

/**
 This program turns on the LED for the selected event type and turns it off for the rest.
 This is done as feedback to users when they select an event type.
 **/

class SetButtonLED {
    
    int selection = 0;

	public static void main(String[] args) {

		GrovePi grovePi = new GrovePi();
        
        ButtonSensor foodBtn = grovePi.getDeviceFactory().createButtonSensor(Pin.DIGITAL_PIN_1);
        ButtonSensor drinksBtn = grovePi.getDeviceFactory().createButtonSensor(Pin.DIGITAL_PIN_2);
		ButtonSensor chillBtn = grovePi.getDeviceFactory().createButtonSensor(Pin.DIGITAL_PIN_3);
        
		Led foodLED = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_4);
        Led drinksLED = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_5);
        Led chillLED = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_6);

        //run the program forever
		while(true) {
            
            //enable LED for button that is pressed
            
            if(foodBtn.isPressed()) {
                foodLED.setState(true);
                drinksLED.setState(false);
                chillLED.setState(false);
                selection = 0;
            }
            
            if(drinksBtn.isPressed()) {
                foodLED.setState(false);
                drinksLED.setState(true);
                chillLED.setState(false);
                selection = 1;
            }
            
            if(chillBtn.isPressed()) {
                foodLED.setState(false);
                drinksLED.setState(false);
                chillLED.setState(true);
                selection = 2;
            }
		}
	}

    public int returnSelection {
        return selection;
    }
}
