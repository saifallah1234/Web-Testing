import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import org.openqa.selenium.WebElement
import java.util.Arrays
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://vervane.tn/')
WebUI.maximizeWindow()

List<TestObject> footerObjects = [
	findTestObject('Object Repository/Page_Contact Us - Vervane/a_Term Of Use'),
	findTestObject('Object Repository/Page_Term Of Use - Vervane/a_Privacy Policy'),
]

String currentUrl = WebUI.getUrl()

for (TestObject obj : footerObjects) {
    try {
        WebUI.scrollToElement(obj, 10)
        WebUI.waitForElementVisible(obj, 10)
        WebUI.waitForElementClickable(obj, 10)

        // Click the element
        WebUI.click(obj)
        WebUI.delay(2)  // Optional delay for smoother navigation

        // Get the new URL after the click
        String newUrl = WebUI.getUrl()

        // Check if the URL has changed and isn't just a fragment (#) change
        if (newUrl.equals(currentUrl) || newUrl.contains('#')) {
            WebUI.comment("❌ URL didn't change significantly after clicking: " + obj.getObjectId())
            WebUI.fail("URL did not change significantly after clicking: " + obj.getObjectId())
        } else {
            currentUrl = newUrl  // Update the current URL for the next iteration
            WebUI.comment("✅ URL changed to: " + newUrl)
        }
    } catch (Exception e) {
        // Try JS click if standard click fails
        WebElement el = WebUI.findWebElement(obj, 10)
        WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(el))
        WebUI.delay(1)
        WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
        WebUI.comment("⚠️ JavaScript click used for: " + obj.getObjectId())
        WebUI.delay(2)

        // Get the new URL after the JS click
        String newUrl = WebUI.getUrl()

        // Check if the URL has changed and isn't just a fragment (#) change
        if (newUrl.equals(currentUrl) || newUrl.contains('#')) {
            WebUI.comment("❌ URL didn't change significantly after JS click: " + obj.getObjectId())
            WebUI.fail("URL did not change significantly after JS click: " + obj.getObjectId())
        } else {
            currentUrl = newUrl  // Update the current URL for the next iteration
            WebUI.comment("✅ URL changed to (JS click): " + newUrl)
        }
    }
}
