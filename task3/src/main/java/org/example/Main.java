package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String str1 = args[1];//"values.json";
        String str2 = args[0];//"tests.json";
        JSONParser parser = new JSONParser();
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> value = new ArrayList<>();

        try (FileReader fr = new FileReader(str1)){
            JSONObject obj = (JSONObject) parser.parse(fr);
            JSONArray values = (JSONArray) obj.get("values");
            for (Object it: values){
                JSONObject valuesObj = (JSONObject) it;
                id.add((int) ((long) valuesObj.get("id")));
                value.add((String) valuesObj.get("value"));
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }

        try (FileReader fr = new FileReader(str2)){
            JSONObject obj = (JSONObject) parser.parse(fr);
            JSONArray tests = (JSONArray) obj.get("tests");
            new test(tests, id, value);
            System.out.println("\n\n\n"+obj);
            try (PrintWriter out = new PrintWriter(new FileWriter("report.json"))) {
                out.write(obj.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }
    public static class test{
        public test(JSONArray tests,ArrayList<Integer> id,ArrayList<String> value) {
            for (Object it: tests){
                JSONObject valuesObj = (JSONObject) it;
                System.out.println(valuesObj);
                long idObjLong = (long)valuesObj.get("id");
                int  idObj = (int) idObjLong;
                for(int i = 0; i < id.size(); i++){
                    if(idObj == id.get(i)){
                        valuesObj.put("value",value.get(i));
                    }
                }
                System.out.println(valuesObj);
                if((JSONArray) valuesObj.get("values") != null){
                    new test((JSONArray) valuesObj.get("values"),id,value);
                }
            }
        }
    }
}