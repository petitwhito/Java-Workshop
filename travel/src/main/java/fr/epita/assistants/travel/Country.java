package fr.epita.assistants.travel;

import  com.opencsv.*;
import org.apache.commons.collections.map.HashedMap;

import java.io.FileReader;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Country {

    public String countryName;
    public ZoneId countryZone;
    public Map<String, Integer> travelTimes = new HashMap<>();
    public Country(String countryName, String countryZone, String inputFilePath) {
        ZoneId zoneId = ZoneId.of(countryZone);
        this.countryZone = zoneId;
        this.countryName = countryName;
        this.travelTimes = initTravelTimes(inputFilePath);
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) {
        Map<String, Integer> temp = new HashMap<>();
        try {

            FileReader filereader = new FileReader(inputFilePath);

            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> r = csvReader.readAll();
            for (int i = 0; i < r.size(); i++)
            {
                String c = r.get(i)[0];
                String d = r.get(i)[1];
                if (c.equals(countryName)) {
                    temp.put(d, Integer.valueOf(r.get(i)[2]));
                }
                else if (d.equals(countryName)) {
                    temp.put(c, Integer.valueOf(r.get(i)[2]));
                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
