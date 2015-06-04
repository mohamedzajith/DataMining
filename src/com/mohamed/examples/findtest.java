package com.mohamed.examples;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import java.util.List;

/**
 * Created by dba on 6/1/15.
 */
public class findtest {
    public static void main(String[] args) {
        DB dbtest = connection.conn();
        DBCollection collection = dbtest.getCollection("temp");
        List distinctCity = collection.distinct("cityname");
        for(int i = 0; i < distinctCity.size(); i++) {
            BasicDBObject query = new BasicDBObject();
            query.put("cityname", distinctCity.get(i));
            BasicDBObject project = new BasicDBObject();
            project.put("JAN", 1);
            project.put("FEB", 1);
            project.put("_id", 0);
            DBCursor cursorDoc = collection.find(query, project);
            while(cursorDoc.hasNext()) {
                BasicDBObject object = (BasicDBObject) cursorDoc.next();
                Integer currentValuejan = object.getInt("JAN");
                Integer currentValuefeb = object.getInt("FEB");
                DBCursor allData = collection.find(new BasicDBObject(), project);
                while(allData.hasNext()) {
                    BasicDBObject allDataObject = (BasicDBObject) allData.next();
                    Integer allDataJanValuejan = allDataObject.getInt("JAN");
                    Integer allDataJanValuefeb = allDataObject.getInt("FEB");
                    Integer result = (currentValuejan - allDataJanValuejan)+(currentValuefeb - allDataJanValuefeb);
                    System.out.print("  " + result + "  ");
                }
                System.out.println();
            }
        }
    }

}
