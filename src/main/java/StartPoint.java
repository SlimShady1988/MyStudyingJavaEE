import com.ee.admin.servlets.AdminEjbExampleServlet;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class StartPoint {
    public static void main(String[] args) throws IOException {

        StringWriter stringWriter = new StartPoint().getJsonWriter();
        System.out.println(stringWriter);
        FileWriter fileWriter = new FileWriter("Student.json");
        System.out.println(fileWriter);
        fileWriter.write(stringWriter.toString());
        fileWriter.close();
    }
    public StringWriter getJsonWriter () {
        StringWriter stringWriter = new StringWriter();
        JsonGenerator generator = Json.createGenerator(stringWriter);
        generator
                .writeStartObject()
                .writeStartObject("Student")
                .write("name", "Victor")
                .write("age", 33)
                .writeStartObject("Address")
                .write("city", "Ternopil")
                .write("Street", "Troleybusna")
                .writeEnd()
                .writeEnd()
                .writeEnd()
                .close();

        return stringWriter;
    }
}
