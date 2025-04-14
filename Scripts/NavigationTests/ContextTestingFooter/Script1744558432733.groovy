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

import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import java.util.Arrays

WebUI.openBrowser('')
WebUI.navigateToUrl('https://vervane.tn/')
WebUI.maximizeWindow()

List<TestObject> footerObjects = [
	findTestObject('Object Repository/Page_Contact Us - Vervane/a_Term Of Use'),
	findTestObject('Object Repository/Page_Term Of Use - Vervane/a_Privacy Policy'),
]

for (TestObject obj : footerObjects) {
	try {
		WebUI.scrollToElement(obj, 10)
		WebUI.waitForElementVisible(obj, 10)
		WebUI.waitForElementClickable(obj, 10)
		WebUI.click(obj)
		WebUI.delay(2)
		WebUI.comment("✅ Clicked on: " + obj.getObjectId())
	} catch (Exception e) {
		WebElement el = WebUI.findWebElement(obj, 10)
		WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(el))
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(el))
		WebUI.comment("⚠️ JavaScript click used for: " + obj.getObjectId())
		WebUI.delay(2)
	}

	// Context check for forbidden word in page body
	String bodyText = WebUI.executeJavaScript("""
	    var bodyClone = document.body.cloneNode(true);
	    var header = bodyClone.querySelector('header');
	    var footer = bodyClone.querySelector('footer');
	    if (header) header.remove();
	    if (footer) footer.remove();
	    return bodyClone.innerText;
	""", null)

	String lowerBody = bodyText.toLowerCase()
	if (lowerBody.contains('hara')) {
	    WebUI.comment("❌ The word 'hara' was found in the body! Failing the test.")
	    WebUI.verifyMatch("hara not found", "hara found", false)
	} else {
	    WebUI.comment("✅ The word 'hara' was NOT found in the body. Proceeding.")
	}
}

WebUI.closeBrowser()
