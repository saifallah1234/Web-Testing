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

WebUI.openBrowser('')
WebUI.navigateToUrl('https://vervane.tn/')
WebUI.maximizeWindow()

List<TestObject> linksToClick = [
    findTestObject('Object Repository/Page_Vervane Vervane/a_FAQs'),
    findTestObject('Object Repository/Page_FAQ - Vervane/a_Home'),
    findTestObject('Object Repository/Page_Soin Visage - Vervane/a_Cheveux'),
    findTestObject('Object Repository/Page_Soin Corps - Vervane/a_Maison'),
]

for (TestObject link : linksToClick) {
    String oldUrl = WebUI.getUrl()
    
    WebUI.click(link)
    WebUI.delay(3) // Wait for navigation to complete
    
    String newUrl = WebUI.getUrl()
    
    if (oldUrl == newUrl) {
        WebUI.comment("❌ URL did not change after clicking ${link.getObjectId()} — Test Failed!")
        WebUI.verifyMatch("Different URL expected", "Same URL detected", false) // force fail
    } else {
        WebUI.comment("✅ URL changed from ${oldUrl} to ${newUrl}")
    }
}

WebUI.closeBrowser()


