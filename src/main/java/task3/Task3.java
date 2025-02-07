package task3;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Task3 {
    public static void main(String[] args) {

        try {
            File testFile = new File("src/main/java/task3/test.json");
            File valueFile = new File("src/main/java/task3/values.json");
            File resultFile = new File("src/main/java/task3/result.json");

            ObjectMapper mapper = new ObjectMapper();

            TestsContainer testsContainer = mapper.readValue(testFile, TestsContainer.class);
            List<Test> tests = testsContainer.getTests();

            ValuesContainer valuesContainer = mapper.readValue(valueFile, ValuesContainer.class);
            List<Value> values = valuesContainer.getValues();

            Map<Integer, String> valueMap = values.stream()
                    .collect(Collectors.toMap(Value::getId, Value::getValue));

            for (Test test : tests) {
                test.updateValues(test, valueMap);
            }

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("tests", tests);

            mapper.enable(com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            mapper.writeValue(resultFile, resultMap);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
