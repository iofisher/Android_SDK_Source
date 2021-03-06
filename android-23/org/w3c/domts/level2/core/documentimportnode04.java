
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001-2004 World Wide Web Consortium, 
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All 
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the 
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
PURPOSE.  

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;

import org.w3c.dom.*;


import org.w3c.domts.DOMTestCase;
import org.w3c.domts.DOMTestDocumentBuilderFactory;



/**
 *  The importNode method imports a node from another document to this document. 
 *  The returned node has no parent; (parentNode is null). The source node is not 
 *  altered or removed from the original document but a new copy of the source node
 *  is created.
 *  
 *  Using the method importNode with deep=true, import the default Attribute attribute, 
 *  "defaultAttr" of the second element node whose namespaceURI="http://www.nist.gov" and 
 *  localName="defaultAttr", into a new document.
 *  Check the parentNode, nodeName, nodeType and nodeValue of the imported node to 
 *  verify if it has been imported correctly.  
* @author IBM
* @author Neil Delima
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core">http://www.w3.org/TR/DOM-Level-2-Core/core</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
*/
public final class documentimportnode04 extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public documentimportnode04(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {

      org.w3c.domts.DocumentBuilderSetting[] settings = 
          new org.w3c.domts.DocumentBuilderSetting[] {
org.w3c.domts.DocumentBuilderSetting.namespaceAware,
org.w3c.domts.DocumentBuilderSetting.validating
        };
        DOMTestDocumentBuilderFactory testFactory = factory.newInstance(settings);
        setFactory(testFactory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "staffNS", true);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      Document doc;
      Document newDoc;
      DocumentType docType = null;

      DOMImplementation domImpl;
      Element element;
      Attr attr;
      NodeList childList;
      Node importedAttr;
      String nodeName;
      int nodeType;
      String nodeValue;
      doc = (Document) load("staffNS", true);
      domImpl = doc.getImplementation();
      newDoc = domImpl.createDocument("http://www.w3.org/DOM/Test", "l2:root", docType);
      childList = doc.getElementsByTagNameNS("http://www.nist.gov", "employee");
      element = (Element) childList.item(1);
      attr = element.getAttributeNode("defaultAttr");
      importedAttr = newDoc.importNode(attr, true);
      nodeName = importedAttr.getNodeName();
      nodeValue = importedAttr.getNodeValue();
      nodeType = (int) importedAttr.getNodeType();
      assertEquals("documentimportnode04_nodeName", "defaultAttr", nodeName);
      assertEquals("documentimportnode04_nodeType", 2, nodeType);
      assertEquals("documentimportnode04_nodeValue", "defaultVal", nodeValue);
      }
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/documentimportnode04";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(documentimportnode04.class, args);
   }
}

