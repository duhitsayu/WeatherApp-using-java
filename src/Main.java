import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Main {
    private static final String API_KEY = "e33a985a6c00abbb2fad8d1d8f4eb9b1";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Weather App");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel cityLabel = new JLabel("Enter City:");
        cityLabel.setBounds(50, 30, 100, 20);
        frame.add(cityLabel);

        JTextField cityTextField = new JTextField();
        cityTextField.setBounds(150, 30, 150, 20);
        frame.add(cityTextField);

        JButton getWeatherButton = new JButton("Get Weather");
        getWeatherButton.setBounds(150, 60, 150, 30);
        frame.add(getWeatherButton);

        JLabel weatherInfoLabel = new JLabel("");
        weatherInfoLabel.setBounds(50, 100, 300, 50);
        frame.add(weatherInfoLabel);

        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityTextField.getText();
                if (!city.isEmpty()) {
                    String weatherData = getWeather(city);
                    if (weatherData != null) {
                        JSONObject json = new JSONObject(weatherData);
                        String weatherDescription = json.getJSONArray("weather").getJSONObject(0).getString("description");
                        double temp = json.getJSONObject("main").getDouble("temp");
                        int humidity = json.getJSONObject("main").getInt("humidity");

                        String weatherInfo = String.format("Temp: %.1f°C, %s, Humidity: %d%%", temp, weatherDescription, humidity);
                        weatherInfoLabel.setText(weatherInfo);
                    } else {
                        weatherInfoLabel.setText("Error fetching weather data.");
                    }
                } else {
                    weatherInfoLabel.setText("Please enter a city name.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static String getWeather(String city) {
        try {
            String urlString = String.format(API_URL, city, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}