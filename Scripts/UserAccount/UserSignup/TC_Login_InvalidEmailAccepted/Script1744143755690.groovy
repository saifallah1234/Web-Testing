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

WebUI.click(findTestObject('Object Repository/SignUp/Page_Vervane Vervane/i_Appelez-nous_tb-icon tb-icon-account'))

WebUI.click(findTestObject('Object Repository/SignUp/Page_Vervane Vervane/a_Create an account'))

WebUI.setText(findTestObject('Object Repository/SignUp/Page_My account - Vervane/input_Obligatoire_email'), 'webtestinggvervanebysaifallah@gmail.com')

WebUI.click(findTestObject('Object Repository/SignUp/Page_My account - Vervane/button_Sinscrire'))

WebUI.verifyElementText(findTestObject('Object Repository/SignUp/Page_My account - Vervane/div_Votre compte pour Vervane utilise un mo_bf8abf'), 
    'Votre compte pour Vervane utilise un mot de passe temporaire. Nous vous avons envoyé un lien par e-mail pour modifier votre mot de passe.')

