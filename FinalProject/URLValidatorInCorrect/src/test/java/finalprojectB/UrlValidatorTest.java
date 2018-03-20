/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;
import junit.framework.TestCase;
import org.junit.Test;

public class UrlValidatorTest extends TestCase {

   @Test
   public void test01()  throws Throwable  {
      String[] schemesCheck = {"http", "hhtp", "file"};
      boolean[] validity = {true, false, false};
      String[] schemes = {"Mkat", "http"};
      UrlValidator urlVal = new UrlValidator(schemes, 0);
      for (int i = 0; i < 3; i++) {
         assertEquals(validity[i], urlVal.isValidScheme((schemesCheck[i])));
      }
   }
   @Test
   public void test02()  throws Throwable {
      String[] URLs = {"http://www.google.com:80/test1?action=view",
              "http/www.google.com:80/test1?action=view",
              "ftp://255.255.255.255:65535/t123",
              "ftp://255.255.255.25565535/t123?aktion=view",
              "file://255.255.255.255:65535/t123?aktion=view",
      };
      boolean[] validity = {true, false, true, false, false};
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      for (int i = 0; i < 5; i++) {
         assertEquals(URLs[i], validity[i], urlVal.isValid(URLs[i]));
      }
   }
}
