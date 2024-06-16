package com.pruebaKonecta.casoUno.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

@Service
public class NominaService {

    private static final String API_KEY = "zavfpQjky3yT3EvL5G5cU6RZCVUSCs62"; // Reemplazar con tu API Key de Calendarific
    private static final String COUNTRY = "CO"; // Colombia
    private static final String YEAR = "2024"; // Año específico
    private static final Set<LocalDate> festivosColombianos2024 = new HashSet<>();

    static {
        try {
            obtenerFestivos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void obtenerFestivos() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://calendarific.com/api/v2/holidays?&api_key=" + API_KEY + "&country=" + COUNTRY + "&year=" + YEAR)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

                if (jsonObject.has("response")) {
                    JsonObject responseObj = jsonObject.getAsJsonObject("response");

                    if (responseObj.has("holidays")) {
                        JsonArray holidays = responseObj.getAsJsonArray("holidays");

                        for (JsonElement holidayElement : holidays) {
                            JsonObject holiday = holidayElement.getAsJsonObject();
                            JsonObject dateObj = holiday.getAsJsonObject("date");

                            // Obtener el objeto ISO y parsear la fecha
                            if (dateObj.has("iso")) {
                                String isoDate = dateObj.get("iso").getAsString();

                                // Extraer la fecha sin el offset de zona horaria
                                String dateWithoutOffset = isoDate.split("T")[0];

                                try {
                                    LocalDate date = LocalDate.parse(dateWithoutOffset, DateTimeFormatter.ISO_LOCAL_DATE);
                                    festivosColombianos2024.add(date);
                                } catch (DateTimeParseException e) {
                                    System.out.println("Error al parsear la fecha: " + isoDate);
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        System.out.println("No se encontró el arreglo 'holidays' en la respuesta");
                    }
                } else {
                    System.out.println("No se encontró el objeto 'response' en la respuesta");
                }
            } else {
                System.out.println("Error al obtener los festivos: " + response.message());
            }
        }
    }

    public static LocalDate calculateNextPayDate(LocalDate date) {
        // Si la fecha ingresada es hábil, devolver esa fecha
        if (isDiaHabil(date)) {
            return date;
        }

        // Si la fecha ingresada no es hábil, encontrar el último día hábil anterior
        LocalDate lastHabilDate = date;
        while (!isDiaHabil(lastHabilDate)) {
            lastHabilDate = lastHabilDate.minusDays(1);
        }

        return lastHabilDate;
    }

    private static boolean isDiaHabil(LocalDate date) {
        // Excluir fines de semana
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return false;
        }

        // Excluir festivos
        if (festivosColombianos2024.contains(date)) {
            return false;
        }

        // Si no es fin de semana ni festivo, es hábil
        return true;
    }
}

