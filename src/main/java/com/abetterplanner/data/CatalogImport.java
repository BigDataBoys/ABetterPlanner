package com.abetterplanner.backend;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class CatalogImport {
    public ArrayList<String> connectToClassSearch(String website) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Document document = Jsoup.connect(website).get();
        Elements element = document.select("#mp-itn b a");

        log(document.title());
        for (Element element1 : element) {
            log("%s\n\t%s", element1.attr("title"), element1.absUrl("href"));
        }

        return new ArrayList<String>();
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
