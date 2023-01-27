import org.json.JSONArray;

public class RunExercise2 {

    public static void main(String[] args) {

        final JSONArray countries = new JSONArray("[\n" +
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
                "]");

        Exercise2 ex2 = new Exercise2(countries);

        try {
            System.out.println("The number of countries in the world: " + ex2.getNumberOfCountriesInTheWorld());
            System.out.println("The country with the most official languages, where they officially speak German (de): " + ex2.findCountryWithMostLanguagesByLanguage("de"));
            System.out.println("Counts all the official languages spoken in the listed countries: " + ex2.getLanguageCountFromCountries());
            System.out.println("The Country with the highest number of official languages: " + ex2.findCountryWithHighestNumberOfLanguages());
            System.out.println("The most common official language(s), of all countries: " + ex2.findMostCommonLanguage());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
