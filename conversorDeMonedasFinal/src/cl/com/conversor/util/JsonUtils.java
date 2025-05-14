package cl.com.conversor.util;

import com.google.gson.Gson;
import cl.com.conversor.model.ExchangeRate;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static ExchangeRate parseExchangeRate(InputStream inputStream) {
        return gson.fromJson(new InputStreamReader(inputStream), ExchangeRate.class);
    }
}
