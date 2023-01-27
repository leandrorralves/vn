import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Exercise2Test {

    Exercise2 ex2;

    @Before
    public void setUpStream() {
        ex2 = new Exercise2(new JSONArray("[\n" +
                "  {\n" +
                "    country:\"US\",\n" +
                "    languages: [\"en\"]\n" +
                "  },\n" +
                "  {\n" +
                "    country:\"BE\",\n" +
                "    languages: [\"nl\",\"fr\",\"de\"]\n" +
                "  },\n" +
                "  {\n" +
                "    country:\"NL\",\n" +
                "    languages: [\"nl\",\"fy\"]\n" +
                "  },\n" +
                "  {\n" +
                "    country:\"DE\",\n" +
                "    languages: [\"de\"]\n" +
                "  },\n" +
                "  {\n" +
                "    country:\"ES\",\n" +
                "    languages: [\"es\"]\n" +
                "  }\n" +
                "]"));
    }

    @Test
    public void getNumberOfCountriesInTheWorld() {
        assertEquals(5, ex2.getNumberOfCountriesInTheWorld());
    }

    @Test
    public void findCountryWithMostLanguagesByLanguageDE() {
        assertEquals("BE", ex2.findCountryWithMostLanguagesByLanguage("de"));
    }

    @Test
    public void getOfficialLangCount() {
        Map<String, Integer> countriesMap = new HashMap();

        countriesMap.put("DE",1);
        countriesMap.put("BE",3);
        countriesMap.put("US",1);
        countriesMap.put("NL",2);
        countriesMap.put("ES",1);

        assertEquals(countriesMap, ex2.getLanguageCountFromCountries());
    }

    @Test
    public void findCountryWithHighestNumberOfLanguages() {
        assertEquals("BE", ex2.findCountryWithHighestNumberOfLanguages());
    }

    @Test
    public void findMostCommonLanguage() {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("de");
        languages.add("nl");

        assertTrue(ex2.findMostCommonLanguage().contains("de"));
        assertTrue(ex2.findMostCommonLanguage().contains("nl"));
    }
}