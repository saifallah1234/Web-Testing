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

WebUI.click(findTestObject('Object Repository/Page_Vervane Vervane/i_Appelez-nous_tb-icon tb-icon-account'))

WebUI.setText(findTestObject('Object Repository/Page_Vervane Vervane/input_Sign in_username'), 'saifallahbellhaj2017@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Vervane Vervane/input_Sign in_password'), 'AC8o8eqKi3wLGj2eB8503g==')

WebUI.click(findTestObject('Object Repository/Page_Vervane Vervane/button_Log in'))

WebUI.click(findTestObject('logout/Page_My account - Vervane/i_Appelez-nous_tb-icon tb-icon-account'))

WebUI.click(findTestObject('logout/Page_My account - Vervane/a_Log out'))

// Wait in case manual CAPTCHA solving is needed
WebUI.delay(1)

WebUI.navigateToUrl('https://hara.thembaydev.com/wp-login.php?loggedout=true&wp_lang=en_US')


// Get the current URL after login/logout
String currentUrl = WebUI.getUrl()

// Check if redirected to an external site
if (currentUrl.contains("hara.thembaydev.com")) {
    WebUI.takeScreenshot()
    WebUI.comment("Redirected to unauthorized site: " + currentUrl)
    WebUI.closeBrowser()
    KeywordUtil.markFailed("Test failed due to unexpected redirection to: " + currentUrl)
}

// End the browser session normally if everything is fine
WebUI.closeBrowser()

