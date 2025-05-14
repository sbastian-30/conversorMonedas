package cl.com.conversor.service;

import cl.com.conversor.model.ExchangeRate;
import cl.com.conversor.util.JsonUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class CurrencyService {
    private static final String API_KEY;

    // CurrencyService.java
    static {
        try (InputStream input = CurrencyService.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            API_KEY = prop.getProperty("API_KEY");
        } catch (Exception e) {
            throw new RuntimeException("Error cargando API Key", e);
        }
    }


    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double getExchangeRate(String from, String to) throws Exception {
        String urlStr = BASE_URL + API_KEY + "/pair/" + from + "/" + to;
        URL url = new URL(urlStr);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Error: " + connection.getResponseCode());
        }

        try (InputStream response = connection.getInputStream()) {
            ExchangeRate exchangeRate = JsonUtils.parseExchangeRate(response);
            return exchangeRate.getConversion_rate();
        }
    }
}
