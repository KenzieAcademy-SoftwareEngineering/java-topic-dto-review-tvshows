package com.kenzie.app;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


class Main {


    public static void main(String[] args) throws IOException {
        try {
            //TODO: Search for a list of TV shows based on a name
            //Skip this step

            // TODO: Set up input file instead
            File jsonFile = new File("tvshow.json");
            File jsonListFile = new File("tvshow_list.json");
            File jsonNamedListFile = new File("tvshow_named_list.json");

            // TODO: Deserialize the JSON: Display the id number, show name, and description
            //Use ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            //Call readValue()
            // 1. input (String or file)
            // 2. DTO
            //Single TVShow
            //TVShowDTO tvShow = mapper.readValue(jsonFile, TVShowDTO.class);
            //System.out.println(tvShow.getSummary());

            TVShowNamedListDTO tvShowNamedList = mapper.readValue(jsonNamedListFile, TVShowNamedListDTO.class);

            //System.out.println(tvShowNamedList.getShows().get(0).getShow().getName());
            for (Shows tvShow : tvShowNamedList.getShows()) {
                System.out.println(tvShow.getShow().getName());
            }

        }
        catch(Exception e){
            System.out.println("Unexpected Exception:");
            System.out.println(e.getMessage());
        }
    }

    static class MyHttpClient {

        //TODO: Write sendGET method that takes URL and returns response
        public static String sendGET(String URLString) {

            //** Start of GET request algorithm
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(URLString);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            try {

                HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
                int statusCode = httpResponse.statusCode();
                if (statusCode == 200) {
                    return httpResponse.body();
                }
                else {
                    // String.format is fun! Worth a Google if you're interested
                    return String.format("GET request failed: %d status code received", statusCode);
                }
            } catch (IOException | InterruptedException e) {
                return e.getMessage();
            }

        }

        //TODO: Write sendPUT method that takes URL and JSON Body String and returns response
        public static String sendPUT(String URLString, String requestBody){
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(URLString);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            try {
                HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
                int statusCode = httpResponse.statusCode();
                if (statusCode == 201 || statusCode == 202) {
                    return httpResponse.body();
                }
                else if(statusCode == 422 || statusCode == 417){
                    return "Server reached. Unable to add fruit.";
                }
                else {
                    return String.format("PUT request failed: %d status code received", statusCode);
                }
            } catch (IOException | InterruptedException e) {
                return e.getMessage();
            }
        }
    }
}
