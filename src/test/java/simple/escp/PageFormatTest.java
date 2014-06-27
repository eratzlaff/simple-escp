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

package simple.escp;

import org.junit.Test;
import static org.junit.Assert.*;

public class PageFormatTest {

    @Test
    public void pageFormatLineSpacing() {
        PageFormat pageFormat = new PageFormat();
        pageFormat.setLineSpacing("1/8");
        String result = pageFormat.build();
        assertEquals(4, result.length());
        assertEquals((char) 27, result.charAt(0));
        assertEquals('@', result.charAt(1));
        assertEquals((char) 27, result.charAt(2));
        assertEquals((char) 48, result.charAt(3));
    }

}