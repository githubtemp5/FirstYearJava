public class temperature {

private double temperature;
private double min;
private double max;
private double increment;
    public temperature(double minimum, double maximum) {
        temperature = 15;
        increment = 5;
        min = minimum;
        max = maximum;

    }
    
    public double getTemperature(){
        return temperature;
    }
    
    public void warmer(){
        if(temperature + increment <= max){
            temperature += increment;
        }
    }
    
    public void cooler(){
        if(temperature - increment >= min){
            temperature -= increment;
        }
    }
    
    public void changeIncrement(double newIncrement){
        if(newIncrement >0){
            increment = newIncrement;
        }
    }
}
