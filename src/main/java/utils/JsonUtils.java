package utils;

import config.Environment;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonUtils {
    public static Reader reader;
    public String generateStringFromResource(String path) {
        String jsonData="";
        try{
            jsonData=new String(Files.readAllBytes(Paths.get(path)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonData;
    }
}
