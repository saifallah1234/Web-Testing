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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://vervane.tn/')
WebUI.maximizeWindow()
def bullets = [
	findTestObject('Object Repository/Page_Vervane Vervane/sr7-bullet_Acheter_sr7-bullet sr7-touchhover_1'),
	findTestObject('Object Repository/Page_Vervane Vervane/sr7-bullet_Acheter_sr7-bullet sr7-touchhover_1_2'),
	findTestObject('Object Repository/Page_Vervane Vervane/sr7-bullet_Acheter_sr7-bullet sr7-touchhover')
]

for (def bullet : bullets) {
	String urlBeforeClick = WebUI.getUrl()
	WebUI.waitForElementVisible(bullet, 10)
	WebUI.waitForElementClickable(bullet, 10)
	WebUI.click(bullet)
	WebUI.delay(2) 
	String urlAfterClick = WebUI.getUrl()
	
	if (urlBeforeClick == urlAfterClick) {
	} else {
		WebUI.verifyMatch(urlBeforeClick, urlAfterClick, true)  
	}
}

WebUI.closeBrowser()


