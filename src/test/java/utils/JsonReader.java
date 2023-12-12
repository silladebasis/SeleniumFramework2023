package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import dataModel.UserData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    private static ObjectMapper objectMapper;
    private static TypeFactory typeFactory;
    private static FileInputStream inputStream;
    private static List<UserData> data = null;
    private static List<UserData> getData(){
        objectMapper = new ObjectMapper();
        typeFactory =objectMapper.getTypeFactory();
        try {
            inputStream = new FileInputStream("src/test/resources/TestData/data.json");
            data =objectMapper.readValue(inputStream,typeFactory.constructCollectionType(List.class,UserData.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public UserData getUsers(String id){
        return getData().stream().filter(userData -> userData.getId().equalsIgnoreCase(id)).findFirst().get();
    }
}
