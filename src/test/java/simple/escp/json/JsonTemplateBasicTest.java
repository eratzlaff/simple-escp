/*
 * Copyright 2014 Jocki Hendry
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package simple.escp.json;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class JsonTemplateBasicTest {

    @Test
    public void parseString() {
        String jsonString = "{\"template\": [" +
            "\"This is the first line\"," +
            "\"This is the second line\"" +
            "]}";
        JsonTemplate jsonTemplate = new JsonTemplate(jsonString);
        jsonTemplate.parse();
        assertEquals(jsonString, jsonTemplate.getOriginalText());
        assertEquals("This is the first line\nThis is the second line\n", jsonTemplate.getParsedText());
    }

    @Test
    public void findPlaceholderName() {
        String jsonString =
            "{" +
                "\"placeholder\": [" +
                    "\"id\"," +
                    "\"nickname\"" +
                "]," +
                "\"template\": [" +
                    "\"Your id is ${id}, Mr. ${nickname}.\"" +
                "]" +
            "}";
        JsonTemplate jsonTemplate = new JsonTemplate(jsonString);

        List<String> results = jsonTemplate.findPlaceholderIn("Your id is ${id}");
        assertEquals(1, results.size());
        assertEquals("id", results.get(0));

        results = jsonTemplate.findPlaceholderIn("Your id is ${id} and your name is ${name}");
        assertEquals(2, results.size());
        assertTrue(results.contains("id"));
        assertTrue(results.contains("name"));
    }

}