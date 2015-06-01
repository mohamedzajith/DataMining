package com.mohamed.examples;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;

/**
 * Created by dba on 5/28/15.
 */
public class docinsert {
    public static void main(String[] args) {
        DB dbconn = connection.conn();
        DBCollection coll = dbconn.getCollection("temp");
        coll.drop();

        BasicDBObject ins = new BasicDBObject();
        ins.append("name","mohamed");
        ins.append("age",25);

        WriteResult result = coll.insert(ins);
    }
}
