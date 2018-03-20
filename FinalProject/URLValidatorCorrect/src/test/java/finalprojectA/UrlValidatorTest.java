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
   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

   @Test
   public void testManualTest() throws Throwable
   {
//You can use this function to implement your manual testing
      assertNotNull(urlVal);
      assertTrue(urlVal.isValid("http://www.google.com/")); //Valid URL
      assertTrue(urlVal.isValid("http://www.github.com"));
      //assertTrue(urlVal.isValidAuthority("www.google.com")); //Potential bug

      assertFalse(urlVal.isValid("234piojad;")); //Invalid URL
      //assertFalse(urlVal.isValid("htt://www.github.com"));


   }

   @Test
   public void testYourFirstPartition() throws Throwable
   {
      //You can use this function to implement your First Partition testing

      assertTrue(urlVal.isValidScheme("h3p"));
      assertTrue(urlVal.isValidScheme("htp"));
      assertTrue(urlVal.isValidScheme("https"));
      assertTrue(urlVal.isValidScheme("http"));

      assertFalse(urlVal.isValidScheme("://"));
      assertFalse(urlVal.isValidScheme(":/"));

   }

   @Test
   public void testYourSecondPartition() throws Throwable
   {
      //You can use this function to implement your Second Partition testing

      assertFalse(urlVal.isValidAuthority(null));

      //There seems to be a bug with testing the authority
      //Says regualr expression expected but I'm giving it a valid authority
      //assertTrue(urlVal.isValidAuthority("https://www.google.com"));
      //assertFalse(urlVal.isValidAuthority("1.3.4.5"));
      // assertFalse(urlVal.isValidAuthority(""));

      //Path Testing
      assertTrue(urlVal.isValidPath(""));
      assertTrue(urlVal.isValidPath("/file"));
      assertFalse(urlVal.isValidPath(null));
      assertFalse(urlVal.isValidPath("/.."));

      //Query Testing
      assertTrue(urlVal.isValidQuery(""));
      assertTrue(urlVal.isValidQuery("a;lksdfj"));
      assertFalse(urlVal.isValidQuery("a b"));

   }
   //You need to create more test cases for your Partitions if you need to


   //didn't know how much he wanted us to do. Objective vague, specifications unclear. Confused about what we are supposed to accomplish.
   @Test
   public void testBasicProgramming1()  throws Throwable  {
      String[] schemesCheck = {"http", "hhtp", "file"};
      boolean[] validity = {true, false, false};
      String[] schemes = {"Mkat", "http"};
      UrlValidator myURL = new UrlValidator(schemes, 0);
      for (int i = 0; i < 3; i++) {
         assertEquals(schemesCheck[i], validity[i], myURL.isValidScheme((schemesCheck[i])));
      }
   }
   @Test
   public void testBasicProgramming2()  throws Throwable {
      String[] URLs = {"http://www.google.com:80/test1?action=view",
              "http/www.google.com:80/test1?action=view",
              "ftp://255.255.255.255:65535/t123",
              "ftp://255.255.255.25565535/t123?aktion=view",
              "file://255.255.255.255:65535/t123?aktion=view",
      };
      boolean[] validity = {true, false, true, false, false};
      for (int i = 0; i < 5; i++) {
         assertEquals(URLs[i], validity[i], urlVal.isValid(URLs[i]));
      }
   }
}
