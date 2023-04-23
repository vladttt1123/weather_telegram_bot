package org.vladyslav.handler.impl;

import io.restassured.response.Response;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static io.restassured.RestAssured.given;

public class APIRequests {

    public static String lutskToday() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.74;
        double lon = 25.32;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[0].temp.day");
        String tempMin = response.jsonPath().getString("daily[0].temp.min");
        String tempMax = response.jsonPath().getString("daily[0].temp.max");
        String tempMorn = response.jsonPath().getString("daily[0].temp.morn");
        String tempEve = response.jsonPath().getString("daily[0].temp.eve");
        String tempNight = response.jsonPath().getString("daily[0].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[0].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[0].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }


    public static String lutskTomorrow() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.74;
        double lon = 25.32;
        String units = "metric";
        String lang = "ua";

     Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

    String tempDay = response.jsonPath().getString("daily[1].temp.day");
    String tempMin = response.jsonPath().getString("daily[1].temp.min");
    String tempMax = response.jsonPath().getString("daily[1].temp.max");
    String tempMorn = response.jsonPath().getString("daily[1].temp.morn");
    String tempEve = response.jsonPath().getString("daily[1].temp.eve");
    String tempNight = response.jsonPath().getString("daily[1].temp.night");

    //getting sunrise time
    Long unixTimeSunRise  = response.jsonPath().getLong("daily[1].sunrise");
    Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
    LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
    String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
    String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

    //getting sunset time
    Long unixTimeSunSet = response.jsonPath().getLong("daily[1].sunset");
    Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
    LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
    String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
    String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

    String result =
            "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
            "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
            "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
            "Зранку: " + tempMorn + "°C \n" +
            "В обід: " +   tempDay + "°C \n" +
            "Ввечері: " + tempEve  + "°C \n"+
            "Вночі: " + tempNight + "°C \n" +
            "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
     return result;
    }

    public static String lutskAfterTomorrow() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.74;
        double lon = 25.32;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[2].temp.day");
        String tempMin = response.jsonPath().getString("daily[2].temp.min");
        String tempMax = response.jsonPath().getString("daily[2].temp.max");
        String tempMorn = response.jsonPath().getString("daily[2].temp.morn");
        String tempEve = response.jsonPath().getString("daily[2].temp.eve");
        String tempNight = response.jsonPath().getString("daily[2].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[2].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[2].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }

    public static String usychiToday() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.76;
        double lon = 25.07;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[0].temp.day");
        String tempMin = response.jsonPath().getString("daily[0].temp.min");
        String tempMax = response.jsonPath().getString("daily[0].temp.max");
        String tempMorn = response.jsonPath().getString("daily[0].temp.morn");
        String tempEve = response.jsonPath().getString("daily[0].temp.eve");
        String tempNight = response.jsonPath().getString("daily[0].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[0].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[0].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }
    public static String usychiTomorrow() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.76;
        double lon = 25.07;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[1].temp.day");
        String tempMin = response.jsonPath().getString("daily[1].temp.min");
        String tempMax = response.jsonPath().getString("daily[1].temp.max");
        String tempMorn = response.jsonPath().getString("daily[1].temp.morn");
        String tempEve = response.jsonPath().getString("daily[1].temp.eve");
        String tempNight = response.jsonPath().getString("daily[1].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[1].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[1].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }
    public static String usychiAfterTomorrow() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.76;
        double lon = 25.07;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[2].temp.day");
        String tempMin = response.jsonPath().getString("daily[2].temp.min");
        String tempMax = response.jsonPath().getString("daily[2].temp.max");
        String tempMorn = response.jsonPath().getString("daily[2].temp.morn");
        String tempEve = response.jsonPath().getString("daily[2].temp.eve");
        String tempNight = response.jsonPath().getString("daily[2].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[2].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[2].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }

    public static String kyivToday() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.45;
        double lon = 30.52;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[0].temp.day");
        String tempMin = response.jsonPath().getString("daily[0].temp.min");
        String tempMax = response.jsonPath().getString("daily[0].temp.max");
        String tempMorn = response.jsonPath().getString("daily[0].temp.morn");
        String tempEve = response.jsonPath().getString("daily[0].temp.eve");
        String tempNight = response.jsonPath().getString("daily[0].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[0].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[0].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }
    public static String kyivTomorrow() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.45;
        double lon = 30.52;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[1].temp.day");
        String tempMin = response.jsonPath().getString("daily[1].temp.min");
        String tempMax = response.jsonPath().getString("daily[1].temp.max");
        String tempMorn = response.jsonPath().getString("daily[1].temp.morn");
        String tempEve = response.jsonPath().getString("daily[1].temp.eve");
        String tempNight = response.jsonPath().getString("daily[1].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[1].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[1].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }
    public static String kyivAfterTomorrow() {
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall";
        String apiKey = "cf8f113802d487941c6d5e30130f847d";
        double lat = 50.45;
        double lon = 30.52;
        String units = "metric";
        String lang = "ua";

        Response response =    given()
                .param("lat", lat)
                .param("lon", lon)
                .param("units", units)
                .param("lang", lang)
                .param("appid", apiKey)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200).extract().response();

        String tempDay = response.jsonPath().getString("daily[2].temp.day");
        String tempMin = response.jsonPath().getString("daily[2].temp.min");
        String tempMax = response.jsonPath().getString("daily[2].temp.max");
        String tempMorn = response.jsonPath().getString("daily[2].temp.morn");
        String tempEve = response.jsonPath().getString("daily[2].temp.eve");
        String tempNight = response.jsonPath().getString("daily[2].temp.night");

        //getting sunrise time
        Long unixTimeSunRise  = response.jsonPath().getLong("daily[2].sunrise");
        Instant instantTimeSunrise = Instant.ofEpochSecond(unixTimeSunRise);
        LocalDateTime normalTimeSunRise =  LocalDateTime.ofInstant(instantTimeSunrise, ZoneId.systemDefault());
        String sunRiseHourStr = String.format("%02d", normalTimeSunRise.getHour());
        String sunRiseMinStr = String.format("%02d", normalTimeSunRise.getMinute());

        //getting sunset time
        Long unixTimeSunSet = response.jsonPath().getLong("daily[2].sunset");
        Instant instantTimeSunset = Instant.ofEpochSecond(unixTimeSunSet);
        LocalDateTime normalTimeSunSet =  LocalDateTime.ofInstant(instantTimeSunset, ZoneId.systemDefault());
        String sunSetHourStr = String.format("%02d", normalTimeSunSet.getHour());
        String sunSetMinStr = String.format("%02d", normalTimeSunSet.getMinute());

        String result =
                "☀️ Схід сонця: " + sunRiseHourStr + ":" + sunRiseMinStr + " \n" +
                        "\uD83E\uDD76 Мінімальна температура: " + tempMin + "°C  \n" +
                        "\uD83E\uDD75 Максимальна температура: " + tempMax + "°C \n" +
                        "Зранку: " + tempMorn + "°C \n" +
                        "В обід: " +   tempDay + "°C \n" +
                        "Ввечері: " + tempEve  + "°C \n"+
                        "Вночі: " + tempNight + "°C \n" +
                        "\uD83C\uDF24 Звхід сонця: " + sunSetHourStr + ":" +  sunSetMinStr;
        return result;
    }
}
