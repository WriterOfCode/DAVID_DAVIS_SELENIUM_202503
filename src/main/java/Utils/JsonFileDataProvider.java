package Utils;

import Core.UserDto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import com.google.gson.Gson; 
import com.google.gson.stream.JsonReader; 

public class JsonFileDataProvider {

    @DataProvider(name="JsonListOfUsers")
    public ArrayList<UserDto> jsonreader() throws FileNotFoundException {
        String filename = "D:\\eclipse-workspace\\DAVID_DAVIS_SELENIUM_202503\\src\\test\\resources\\users.json";
  
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
        ArrayList<UserDto> users =  gson.fromJson(reader,  UserDto.class);
        return users;
    }
}