package de.kaimon.schoolproject.kai;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.FileWriter;
import java.util.Map;

public class QuoteReader {
    public QuoteReader(String s) {
    }

    public static void main(String[] args) throws IOException {
        a();
    }

    static void a() throws IOException {
        lol();
        quotesj.stream().forEach(quoteModel -> {
            quoteModel.getQuote().stream().forEach(s -> {
                System.out.println(s);
            });
            System.out.println(quoteModel.getAuthor());
            System.out.println();
        });
        try (FileWriter file = new FileWriter("lol.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(quoteJsonArray.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static LinkedList<QuoteModel> quotesj = new LinkedList<QuoteModel>();
    static JSONArray quoteJsonArray = new JSONArray();
    static int counter = 0;

    private static void lol() throws IOException {
        JSONArray quotesJson = new JSONArray();
        LinkedList<String> quotes = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/de/kaimon/schoolproject/kai/Einfachezitate.txt"));
        reader.lines().forEach(s -> {
            if(s.length() > 0 && s.charAt(0) == '"' || s.length() > 0 && s.charAt(0) ==  '„'){
                quotes.add(s.substring(1,s.length()-1));
                quotesJson.add(s.substring(1,s.length()-1));
                return;
            }
            if(s.length() > 0 && s.charAt(0) == '-'){
                String author;
                author = s.substring(1, s.length() - 1);
                QuoteModel qm = new QuoteModel();
                quotes.stream().forEach(s1 -> qm.setQuote(s1));
                qm.setAuthor(author);
                quotesj.add(qm);
                Map<String, Object> map = new HashMap<>();
                map.put("quotes", quotesJson);
                map.put("author", author);
                map.put("id", counter);
                quoteJsonArray.add(JSONObject.toJSONString(map));
                counter ++;
                quotes.clear();
                quotesJson.clear();
            }
        });
    }

    private static String toSpace(@NotNull String in){
        int lenght = 1;
        for (int i = 0; i < in.length(); i++) {
            if(in.charAt(i) == ' '){
                lenght ++;
            }
        }
        String args = "";
        String str = in;
        for (int i = 0; i < lenght; i++) {
            args += "";
            int strlen = str.length();
            for (int a = 0; a < strlen; a++) {
                if(str.charAt(0) == ' '){
                    str = str.substring(1);
                    a = strlen;
                }
                else{
                    args += str.charAt(0);
                    str = str.substring(1);
                }
            }
        }
        return args;
    }
}
