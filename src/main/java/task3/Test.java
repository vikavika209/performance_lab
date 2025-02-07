package task3;

import java.util.List;
import java.util.Map;

public class Test {
    private int id;
    private String title;
    private String value;
    private List<Test> values;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void updateValues(Test test, Map<Integer, String> valueMap) {
        test.setValue(valueMap.getOrDefault(test.getId(), null));

        if (test.getValues() != null) {
            for (Test subTest : test.getValues()) {
                updateValues(subTest, valueMap);
            }
        }
    }
}
