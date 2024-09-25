# WeatherApp

A simple command-line Java application that fetches and displays weather information from a public API. This project demonstrates basic Java programming, API handling, JSON parsing, and GUI implementation with `javax.swing`.

## Features

- Fetches real-time weather data for any city.
- Displays temperature, humidity, and weather condition.
- Simple GUI using `JButton` and `JTextField`.
- Uses `org.json` for parsing JSON data from the weather API.

## Requirements

- Java JDK 8 or above
- [json-20240303.jar](https://mvnrepository.com/artifact/org.json/json/20240303) (for JSON parsing)

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/duhitsayu/WeatherApp.git
2. **Download the required** `json.jar`:
    -Download `json-20240303.jar` from Maven Repository.
    -Place the `json-20240303.jar` in your project directory.

3. **Compile the project (via command line)**:
   ```bash
   javac -cp .;json-20240303.jar WeatherApp.java
   
4. **Run the project**:
   ```bash
   java -cp .;json-20240303.jar WeatherApp 

## Usage

-When the program starts, a simple GUI will be displayed.
-Enter a city name in the text field and press the Get Weather button.
-The weather data (temperature, humidity, and condition) will be displayed.

## Screenshot
 ![Screenshot 2024-09-25 151835](https://github.com/user-attachments/assets/db8a63bf-39dc-4c93-97fc-5ca3693ca77c)


## Dependencies
-`org.json` library for parsing JSON data.
     - Download `json20240303.jar`.

## API Used
-**OpenWeatherMap API**: A free API providing weather data for cities around the world.
     .[OpenWeatherMap](https://openweathermap.org/api) (for api data).

## Contributing
Feel free to contribute to this project by forking the repository and submitting a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is open-source and available under the [`MIT License`].

    
