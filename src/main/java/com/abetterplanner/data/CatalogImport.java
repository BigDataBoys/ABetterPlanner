package com.abetterplanner.data;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

public class CatalogImport {

    @SuppressWarnings("unchecked")
    public void parseHTMLFile() throws IOException {
        File folderOfCourses = new File("src/main/resources/courses/spring2019");
        File[] listOfFiles = folderOfCourses.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            Document courseCatalog = parseFile(listOfFiles[i]);
            ArrayList<Element> courseNumber = new ArrayList<>(),
                    buildingRoom = new ArrayList<>(),
                    time = new ArrayList<>(),
                    instructor = new ArrayList<>(),
                    classNumber = new ArrayList<>();

            for (int j = 0; j < Integer.parseInt(courseCatalog.getElementsByAttributeValue("id", "test").text().replaceAll("[A-Za-z\\W]*", "")); j++) {
                String formattedTableID = String.format("%02d", 1 + j);
                courseNumber.add(courseCatalog.getElementsByAttributeValue("class", "ClassTitle").get(j));
                buildingRoom.add(courseCatalog.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID + "_TableCell2").get(0));
                time.add(courseCatalog.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID + "_TableCell1").get(0));
                instructor.add(courseCatalog.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID + "_TableCell4").get(0));
                classNumber.add(courseCatalog.getElementsByAttributeValue("id", "ctl00_ContentPlaceHolder1_Repeater1_ctl" + formattedTableID + "_TableCell13").get(0));
            }
            addToDatabase(mergeToMap(courseNumber, classNumber, buildingRoom, time, instructor));
        }
    }

    private Document parseFile(File file) throws IOException {
        return Jsoup.parse(file, "UTF-8");
    }

    private HashMap<String, HashMap<String, CourseObject>> mergeToMap(ArrayList<Element> courseNumber, ArrayList<Element> classNumber, ArrayList<Element> buildingRoom, ArrayList<Element> time, ArrayList<Element> instructor) {

        HashMap<String, HashMap<String, CourseObject>> courseMap = new HashMap<>();

        for (int i = 0; i < courseNumber.size(); i++) {
            HashMap<String, CourseObject> courseMapObject = new HashMap<>();

            CourseObject courseOffering = new CourseObject();
            courseOffering.building = buildingRoom.get(i).text();
            courseOffering.time = time.get(i).text();
            courseOffering.instructor = instructor.get(i).text();

            courseMapObject.put(classNumber.get(i).text(), courseOffering);

            if (courseMap.containsKey(courseNumber.get(i).text())) {
                courseMap.get(courseNumber.get(i).text()).put(classNumber.get(i).text(), courseOffering);
            } else {
                courseMap.put(courseNumber.get(i).text(), courseMapObject);
            }
        }

        return courseMap;
    }

    /**
     * Sample Response
     * cs_courses = {
     * "CS 1280": {
     * "31639": {
     * "building":"3 2632",
     * "time":"7:00 PM–8:15 PM TuTh",
     * "instructor":"Johannsen,David L"
     * }
     * "31640": {
     * "building":"3 2632",
     * "time":"2:30 PM–3:45 PM MW",
     * "instructor":"Nguyen,Thanh V"
     * }
     * }
     * }
     */
    private void addToDatabase(HashMap<String, HashMap<String, CourseObject>> courses) throws UnknownHostException {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://10.0.128.177:27017"));
        MongoDatabase courseDatabase = mongoClient.getDatabase("dev");
        MongoCollection<org.bson.Document> courseCollection = courseDatabase.getCollection("course");

        org.bson.Document coursesDocument = new org.bson.Document();

        for (Map.Entry<String, HashMap<String, CourseObject>> entry : courses.entrySet()) {
            org.bson.Document courseNumberDocument = new org.bson.Document();
            for (Map.Entry<String, CourseObject> course : entry.getValue().entrySet()) {
                org.bson.Document courseDocument = new org.bson.Document().append("building", course.getValue().building).append("time", course.getValue().time).append("instructor", course.getValue().instructor);
                courseNumberDocument.append(course.getKey(), courseDocument);
            }
            coursesDocument.append(entry.getKey(), courseNumberDocument);
        }
        courseCollection.insertOne(coursesDocument);
    }

    class CourseObject {
        String building;
        String time;
        String instructor;
    }
}
