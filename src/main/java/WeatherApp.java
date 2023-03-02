import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import org.json.JSONObject;
import javax.swing.*;   //  I Called it to use simple GUI

public class WeatherApp {
    static JFrame pic;
    public final static String apiKey = "253fe6e8f2bd47cf97745159232502";   //  <--- Copy of API_KEY
    public static void main(String[] args)  {
        //In this section I make label and Frame to use this app in file instead of in terminal--->
        pic = new JFrame("City's Weather");
        pic.setVisible(true);
        pic.setSize(1000, 100);
        pic.setLayout(new FlowLayout());
        JLabel l1 = new JLabel("Which Location That You Look For ?");
        pic.add(l1);
        JTextField Location = new JTextField(20);
        pic.add(Location);
        JButton e = new JButton("Click");
        pic.add(e);

        //This thing below says that when you click on it, it closes the page --->
        e.addActionListener((ActionEvent e1) -> {

            String s = e1.getActionCommand();

            if (s.equals("Click")) {

                pic.setVisible(false);
                // open new page --->
                pic = new JFrame("City's Weather Result");
                pic.setVisible(true);
                pic.setSize(900, 100);
                pic.setLayout(new FlowLayout());
                String city = Location.getText();

                //I make Error message for the null answer--->
                if (getWeatherData(city) == null) {

                    pic.setVisible(false);
                    JFrame frame = new JFrame("City's Weather Result");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(frame ,"Sorry! The City does not Found or your Net is Weak!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);

                }

                else {

                    JSONObject WeatherJson = new JSONObject(Objects.requireNonNull(getWeatherData(city)));

                    //in this part I try to Show the weather's condition( Use it by JSON) --->
                    String Humid = Integer.toString(WeatherJson.getJSONObject("current").getInt("humidity"));
                    String Celsius_Temperature = Double.toString(WeatherJson.getJSONObject("current").getDouble("temp_c"));
                    String Wind_Speed = Double.toString(WeatherJson.getJSONObject("current").getDouble("wind_kph"));
                    String Wind_Direction = WeatherJson.getJSONObject("current").getString("wind_dir");
                    
                    //put the weathers condition to the page --->
                    JLabel l112 = new JLabel("Humid : ");
                    pic.add(l112);
                    JLabel l2 = new JLabel(String.valueOf(getHumidity(Humid)));
                    pic.add(l2);
                    JLabel l3 = new JLabel("%      ");
                    pic.add(l3);

                    JLabel l4 = new JLabel("Celsius Temperature : ");
                    pic.add(l4);
                    JLabel l5 = new JLabel(String.valueOf(getTemperature(Celsius_Temperature)));
                    pic.add(l5);
                    JLabel l6 = new JLabel(" C       ");
                    pic.add(l6);

                    JLabel l7 = new JLabel("Wind Speed : ");
                    pic.add(l7);
                    JLabel l8 = new JLabel(String.valueOf(getTemperature(Wind_Speed)));
                    pic.add(l8);
                    JLabel l9 = new JLabel(" km/h      ");
                    pic.add(l9);

                    JLabel l10 = new JLabel("Wind Direction : ");
                    pic.add(l10);
                    JLabel l11 = new JLabel(Wind_Direction);
                    pic.add(l11);

                }

            }

        });

    }

    /**
     * Retrieves weather data for the specified city.
     *
     * @param city the name of the city for which weather data should be retrieved
     * @return a string representation of the weather data, or null if an error occurred
     */
    public static String getWeatherData (String city){

        try {

            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                stringBuilder.append(line);

            }

            reader.close();
            return stringBuilder.toString();

        }

        // In this part if you delete the  "e.printStackTrace();" you can takeout this Error --->
        catch (Exception e) {

            return null;

        }

    }

    //By this Function we can change String to Double --->
    public static double getTemperature (String weatherJson){

        double answer = 0.0;
        answer = Double.parseDouble(weatherJson);
        return answer;

    }

    //By this Function we can change String to Int --->
    public static int getHumidity (String weatherJson){

        int answer = 0;
        answer = Integer.parseInt(weatherJson);
        return answer;

    }
}
