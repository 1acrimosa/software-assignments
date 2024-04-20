import java.util.ArrayList;
import java.util.List;

class WeatherData {
      private String location;      //location
      private double temperature;   //temperature
      private String condition;     //condition

      public WeatherData(String location, double temperature, String condition) {
            this.location = location;
            this.temperature = temperature;
            this.condition = condition;
      }

      public String getLocation() {
            return location;
      }
      public double getTemperature() {
            return temperature;
      }
      public String getCondition() {
            return condition;
      }
}


interface WeatherServiceAdapter {
      List<WeatherData> fetchWeatherData();
}

class WeatherAPI1Adapter implements WeatherServiceAdapter {
      private WeatherAPI1 weatherAPI1;

      public WeatherAPI1Adapter(WeatherAPI1 weatherAPI1) {
            this.weatherAPI1 = weatherAPI1;
      }

      @Override
      public List<WeatherData> fetchWeatherData() {
            List<WeatherData> weatherDataList = new ArrayList<>();
            List<WeatherAPI1Data> api1DataList = weatherAPI1.getData();
            if (api1DataList != null) { // Check if api1DataList is not null
                  for (WeatherAPI1Data api1Data : api1DataList) {
                        String location = api1Data.location;
                        double temperature = api1Data.temperature;
                        String condition = api1Data.condition;

                        WeatherData weatherData = new WeatherData(location, temperature, condition);
                        weatherDataList.add(weatherData);
                  }
            } else {
                  System.out.println("Weather data from Weather API 1 is null.");
            }
            return weatherDataList;
      }

//      public WeatherAPI1 getWeatherAPI1() {
//            return weatherAPI1;
//      }
//
//      public void setWeatherAPI1(WeatherAPI1 weatherAPI1) {
//            this.weatherAPI1 = weatherAPI1;
//      }
}



class WeatherAPI2Adapter implements WeatherServiceAdapter {
      private WeatherAPI2 weatherAPI2;

      public WeatherAPI2Adapter(WeatherAPI2 weatherAPI2) {
            this.weatherAPI2 = weatherAPI2;
      }

      @Override
      public List<WeatherData> fetchWeatherData() {
            List<WeatherData> weatherDataList = new ArrayList<>();
            List<WeatherAPI2Data> api2DataList = weatherAPI2.getData();
            if (api2DataList != null) { // Check if api2DataList is not null
                  for (WeatherAPI2Data api2Data : api2DataList) {
                        String location = api2Data.location;
                        double temperature = api2Data.temperature;
                        String condition = api2Data.condition;

                        WeatherData weatherData = new WeatherData(location, temperature, condition);
                        weatherDataList.add(weatherData);
                  }
            } else {
                  System.out.println("Weather data from Weather API 2 is null.");
            }
            return weatherDataList;
      }

//      public WeatherAPI2 getWeatherAPI2() {
//            return weatherAPI2;
//      }
//
//      public void setWeatherAPI2(WeatherAPI2 weatherAPI2) {
//            this.weatherAPI2 = weatherAPI2;
//      }
}



class WeatherAPI1 {
      public List<WeatherAPI1Data> getData() {
            // I don't know what to return
            return null;
      }
}

class WeatherAPI1Data {
      public String location;
      public double temperature;
      public String condition;
}

class WeatherAPI2 {
      public List<WeatherAPI2Data> getData() {
            // I don't know what to return if really
            return null;
      }
}

class WeatherAPI2Data {
      public String location;
      public double temperature;
      public String condition;
}

public class Ex3 {
      public static void main(String[] args) {

            // So, here we can create so many API's how many we want.

            WeatherServiceAdapter api1Adapter = new WeatherAPI1Adapter(new WeatherAPI1());
            WeatherServiceAdapter api2Adapter = new WeatherAPI2Adapter(new WeatherAPI2());

            List<WeatherData> api1WeatherData = api1Adapter.fetchWeatherData();
            List<WeatherData> api2WeatherData = api2Adapter.fetchWeatherData();

            displayWeatherData(api1WeatherData);
            displayWeatherData(api2WeatherData);
      }

      private static void displayWeatherData(List<WeatherData> weatherDataList) {
            for (WeatherData weatherData : weatherDataList) {
                  System.out.println("Location: " + weatherData.getLocation());
                  System.out.println("Temperature: " + weatherData.getTemperature());
                  System.out.println("Condition: " + weatherData.getCondition());
                  System.out.println();
            }
      }
}
