package com.mohamed.examples;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by dba on 5/28/15.
 */
public class fileTOmongo {
    public static void main(String[] args) {
        try{
            DB dbconn = connection.conn();
            DBCollection coll = dbconn.getCollection("temp");
            coll.drop();
            File file = new File("/home/dba/Desktop/DataMining/data.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedread = new BufferedReader(fileReader);
            String line = bufferedread.readLine();
            int i=0;
            while (line != null){
                StringTokenizer tokenizer = new StringTokenizer(line,",");
                String cityname = tokenizer.nextToken();
                int jan = Integer.parseInt(tokenizer.nextToken());
                int fub = Integer.parseInt(tokenizer.nextToken());
                int mar = Integer.parseInt(tokenizer.nextToken());
                int apr = Integer.parseInt(tokenizer.nextToken());
                int may = Integer.parseInt(tokenizer.nextToken());
                int jun = Integer.parseInt(tokenizer.nextToken());
                int jul = Integer.parseInt(tokenizer.nextToken());
                int aug = Integer.parseInt(tokenizer.nextToken());
                int sep = Integer.parseInt(tokenizer.nextToken());
                int oct = Integer.parseInt(tokenizer.nextToken());
                int nov = Integer.parseInt(tokenizer.nextToken());
                int dec = Integer.parseInt(tokenizer.nextToken());

                BasicDBObject ins = new BasicDBObject();
                ins.append("_id",i);
                ins.append("cityname",cityname);ins.append("JAN",jan);
                ins.append("FEB",fub);ins.append("MAR",mar);
                ins.append("APR",apr);ins.append("MAY",may);
                ins.append("JUN",jun);ins.append("JUL",jul);
                ins.append("AUG",aug);ins.append("SEP",sep);
                ins.append("OCT",oct);ins.append("NOV",nov);
                ins.append("DEC",dec);

                WriteResult result = coll.insert(ins);
                line=bufferedread.readLine();
                i=i+1;
            }
            System.out.println("Everything ok");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
