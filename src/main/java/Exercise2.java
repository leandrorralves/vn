import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exercise2 {

    private JSONArray countries;

    public Exercise2(JSONArray countries) {
        this.countries = countries;
    }

    //returns the number of countries in the world
    public int getNumberOfCountriesInTheWorld() {
        return countries.length();
    }

    //finds the country with the most official languages, where they officially speak German (de).
    public String findCountryWithMostLanguagesByLanguage(String language) {
        int maxLanguages = 1;
        String countryName = "";

        for (int i = 0; i < countries.length(); i++) {
            JSONObject country = (JSONObject) countries.get(i);
            JSONArray countryLanguages = (JSONArray) country.get("languages");
            boolean found = false;

            for (int j = 0; j < countryLanguages.length(); j++) {
                String countryLanguage = countryLanguages.getString(j);
                if (countryLanguage.equals(language))
                    found = true;
            }

            if (found && countryLanguages.length() > maxLanguages) {
                maxLanguages = countryLanguages.length();
                countryName = country.getString("country");
            }
        }
        return countryName;
    }

    //that counts all the official languages spoken in the listed countries.
    public Map<String, Integer> getLanguageCountFromCountries() {
        Map<String, Integer> countriesMap = new HashMap();

        for (int i = 0; i < countries.length(); i++) {
            JSONObject country = (JSONObject) countries.get(i);
            countriesMap.put(country.getString("country"), ((JSONArray) country.get("languages")).length());
        }
        return countriesMap;
    }

    //to find the country with the highest number of official languages.
    public String findCountryWithHighestNumberOfLanguages() {
        Map<String, Integer> countriesMap = getLanguageCountFromCountries();
        int maxLanguages = 1;
        String countryName = "";

        for (Map.Entry<String, Integer> country : countriesMap.entrySet()) {
            if (country.getValue() > maxLanguages) {
                maxLanguages = country.getValue();
                countryName = country.getKey();
            }
        }
        return countryName;
    }

    //to find the most common official language(s), of all countries.
    public ArrayList<String> findMostCommonLanguage() {

        Map<String, Integer> languagesMap = new HashMap<>();
        int maxLanguages = 1;


        for (int i = 0; i < countries.length(); i++) {
            JSONObject country = (JSONObject) countries.get(i);
            JSONArray countryLanguages = (JSONArray) country.get("languages");

            for (int j = 0; j < countryLanguages.length(); j++) {
                String countryLanguage = countryLanguages.getString(j);
                languagesMap.merge(countryLanguage, 1, Integer::sum);
            }
        }
        maxLanguages = getTotalLanguagesByCountries(languagesMap);

        return getLanguagesByTotal(languagesMap, maxLanguages);
    }

    private int getTotalLanguagesByCountries(Map<String, Integer> languagesMap){
        int maxLanguages = 1;

        for (Map.Entry<String, Integer> language : languagesMap.entrySet()) {
            if (language.getValue() > maxLanguages) {
                maxLanguages = language.getValue();
            }
        }
        return maxLanguages;
    }

    private ArrayList<String> getLanguagesByTotal(Map<String, Integer> languagesMap, int totalLanguages) {
        ArrayList<String> commonLanguages = new ArrayList<>();

        for (Map.Entry<String, Integer> language : languagesMap.entrySet()) {
            if (language.getValue().equals(totalLanguages)) {
                commonLanguages.add(language.getKey());
            }
        }
        return commonLanguages;
    }
}
