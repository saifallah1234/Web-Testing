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

WebUI.click(findTestObject('Object Repository/Commande/Page_Vervane Vervane/span_Shop'))

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Commande/Page_Shop - Vervane/img_Le prix actuel est .38,000_image-no-effect'))

WebUI.click(findTestObject('Object Repository/Commande/Page_Crme carottes - Vervane/button_Ajouter au panier'))

WebUI.click(findTestObject('Object Repository/Commande/Page_Crme carottes - Vervane/a_Voir le panier'))

WebUI.verifyElementText(findTestObject('Object Repository/Commande/Page_Cart - Vervane/span_44,000'), 'د.ت 44,000')

WebUI.verifyElementText(findTestObject('Object Repository/Commande/Page_Cart - Vervane/input_38,000_wc-block-components-quantity-s_45c506'), 
    '')

WebUI.click(findTestObject('Object Repository/Commande/Page_Cart - Vervane/button_'))

WebUI.verifyElementText(findTestObject('Object Repository/Commande/Page_Cart - Vervane/input_38,000_wc-block-components-quantity-s_45c506_1'), 
    '')

WebUI.waitForElementPresent(findTestObject('Object Repository/Commande/Page_Cart - Vervane/span_76,000'), 0)

WebUI.click(findTestObject('Object Repository/Commande/Page_Cart - Vervane/span_Valider la commande'))

WebUI.setText(findTestObject('Object Repository/Commande/Page_Checkout - Vervane/input_Nom et Prnom_billing_first_name'), 
    'ss')

WebUI.setText(findTestObject('Object Repository/Commande/Page_Checkout - Vervane/input_Numro et nom de rue_billing_address_1'), 
    '55')

WebUI.click(findTestObject('Object Repository/Commande/Page_Checkout - Vervane/label_Tlphone'))

WebUI.setText(findTestObject('Object Repository/Commande/Page_Checkout - Vervane/input_Tlphone_billing_phone'), '55')

WebUI.click(findTestObject('Commande/Page_Checkout - Vervane/button_Commander'))

WebUI.closeBrowser()

