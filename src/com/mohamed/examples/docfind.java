package com.mohamed.examples;

import com.mongodb.*;

/**
 * Created by dba on 5/25/15.
 */
public class docfind extends connection {

    public static void main(String[] args) {
        DB dbtest = connection.conn();
        DBCollection coll = dbtest.getCollection("temp");

        try {
//            -------------get one fild and values--------------
            BasicDBObject query = new BasicDBObject();
            BasicDBObject select = new BasicDBObject();
            select.put("MAR",1);
            select.put("APR",1);
//            select.put("JAN",1);
            select.put("_id",1);
            DBCursor cursor = coll.find(query,select);
            BasicDBObject obj= (BasicDBObject)cursor.next();
            for (int j=0;j<4;j++){
                int m,a,id;
                id=Integer.parseInt(obj.getString("_id"));
                m= Integer.parseInt(obj.getString("MAR"));
                a= Integer.parseInt(obj.getString("APR"));
                if (id==j){
                    while(cursor.hasNext()){
                        int ma,ap;
                        BasicDBObject object = (BasicDBObject)cursor.next();
                        ma= Integer.parseInt(object.getString("MAR"));
                        ap=Integer.parseInt(object.getString("APR"));
                        System.out.print(m-ma);
                        System.out.print(a-ap);
                    }
                }

            }
/*            for (int i=0;i<4;i++){
                int ma,ap;
                while (cursor.hasNext()) {
                    BasicDBObject obj = (BasicDBObject)cursor.next();
                    ma= Integer.parseInt(obj.getString("MAR"));
                    ap=Integer.parseInt(obj.getString("APR"));
                    System.out.println(ma-ap);

                }
            }
*/
        }
        catch (MongoException e){
            System.out.println(e.getClass().getCanonicalName());
        }
    }
}
