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

// Open browser and navigate to site
WebUI.openBrowser('')
WebUI.navigateToUrl('https://vervane.tn/')
WebUI.maximizeWindow()

// Define the list of links to be tested
List<TestObject> linksToClick = [
    findTestObject('Object Repository/Page_Vervane Vervane/a_FAQs'),
    findTestObject('Object Repository/Page_FAQ - Vervane/a_Home'),
    findTestObject('Object Repository/Page_Soin Visage - Vervane/a_Cheveux'),
    findTestObject('Object Repository/Page_Soin Corps - Vervane/a_Maison')
]

// Iterate through the links
for (TestObject link : linksToClick) {
    // Click the link
    WebUI.click(link)
    WebUI.delay(2) // Optional delay for the page to load

    // Get the body text excluding header and footer
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

// Close browser after test
WebUI.closeBrowser()
