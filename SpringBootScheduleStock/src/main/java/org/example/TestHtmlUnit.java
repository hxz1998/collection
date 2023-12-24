/**
 * SpringBootScheduleStock
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/12/24
 **/
package org.example;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.List;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class TestHtmlUnit {

    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(600 * 1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage("");
        List<HtmlDivision> divs = (List) page.getByXPath("//div[@id='plist']//ul//li[@class='gl-item']//div[@class='gl-i-wrap j-sku-item']");
        page.getTabbableElements();
        for (HtmlDivision div : divs) {
            DomNodeList<DomNode> childs = div.getChildNodes();
            String name = "";
            String price = "";
            String comments = "";
            for (DomNode dn : childs) {
                NamedNodeMap map = dn.getAttributes();
                Node node = map.getNamedItem("class");
                if (node != null) {
                    String value = node.getNodeValue();
                    if (value.contains("p-name")) {
                        name = dn.getLocalName();
                    } else if (value.contains("p-price")) {
                        price = dn.getTextContent();
                    } else if (value.contains("p-commit")) {
                        comments = dn.getTextContent();
                    }
                }
            }
            System.out.println(name + "//" + price + "//" + comments);
        }

    }
}
