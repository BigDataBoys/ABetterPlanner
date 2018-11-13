package com.abetterplanner.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.*;

import org.json.*;

public class CatalogImport {

    @SuppressWarnings("unchecked")
    public void connectToClassSearch(String website) throws IOException {
        Document schedule = parseFile(new File("schedule.html"));
        ArrayList<Element> courseNumber = new ArrayList<>(),
                buildingRoom = new ArrayList<>(),
                time = new ArrayList<>(),
                instructor = new ArrayList<>(),
                classNumber = new ArrayList<>();
        HashMap<String, ArrayList<Element>> courseMap = new HashMap<>();

        for (int i = 0; i < Integer.parseInt(schedule.getElementsByAttributeValue("id", "test").text().replaceAll("[A-Za-z\\W]*", "")); i++) {
            String formattedTableID = String.format("%02d", 1 + i);
            courseNumber.add(schedule.getElementsByAttributeValue("class", "ClassTitle").get(i));
            buildingRoom.add(schedule.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID +"_TableCell2").get(0));
            time.add(schedule.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID + "_TableCell1").get(0));
            instructor.add(schedule.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID +"_TableCell4").get(0));
            classNumber.add(schedule.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID + "_TableCell13").get(0));
        }

        for (int i = 0; i < courseNumber.size(); i++){
            ArrayList<Element> temp = new ArrayList<>();
            temp.add(buildingRoom.get(i));
            temp.add(time.get(i));
            temp.add(instructor.get(i));
            temp.add(classNumber.get(i));
            courseMap.put(courseNumber.get(i).text(), temp);
        }

        print(courseNumber, classNumber, buildingRoom, time, instructor);
        convertToJson(courseMap);
    }

    private void convertToJson(HashMap<String, ArrayList<Element>> courseMap) {
        for (int i = 0; i < courseMap.size(); i++) {
            JSONObject jsonFile = new JSONObject();


        }
    }

    private Document parseFile(File file) throws IOException{
         return Jsoup.parse(file, "UTF-8");
    }

    private void print(ArrayList<Element>... courses){
        System.out.printf("Course Number\t\tClass Number\t\tRoom\t\tTime\t\t\t\t\tInstructor\n");
        for (int i = 0; i < courses[0].size(); i++) {
            System.out.printf("\t%s\t\t\t\t%s\t\t\t%s\t\t%s\t\t%s\n", courses[0].get(i).text(), courses[1].get(i).text(), courses[2].get(i).text(), courses[3].get(i).text(), courses[4].get(i).text());
        }
    }
}
