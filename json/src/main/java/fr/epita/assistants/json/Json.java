package fr.epita.assistants.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Json {
    public static void addToJson(String key, String value, String path)
    {
        final ObjectMapper mapper = new ObjectMapper();
        Map<String, String> jsonMap = new HashMap<>();
        try {
            File file = new File(path);
            if (file.exists()) {
                try {
                    jsonMap = mapper.readValue(file, new TypeReference<Map<String, String>>() {
                    });
                } catch (IOException e) {}
            }
            else
                file.createNewFile();

            jsonMap.put(key, value);
            String jsonString = mapper.writeValueAsString(jsonMap);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(jsonString);
            writer.close();
            //mapper.writeValue(file, jsonString);

        } catch (IOException e) {

        }
    }
}
