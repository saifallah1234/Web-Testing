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

WebUI.click(findTestObject('Object Repository/Cart/Delete_Product/Page_Vervane Vervane/span_Shop'))

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Cart/Delete_Product/Page_Shop - Vervane/img_View_image-no-effect'))

WebUI.click(findTestObject('Object Repository/Cart/Delete_Product/Page_2 crans Solaires Achets  1 Gel Nettoya_8e0a36/button_Ajouter au panier'))

WebUI.click(findTestObject('Object Repository/Cart/Delete_Product/Page_2 crans Solaires Achets  1 Gel Nettoya_8e0a36/a_Voir le panier'))

WebUI.click(findTestObject('Object Repository/Cart/Delete_Product/Page_Cart - Vervane/button_Supprimer llment'))

String itemCount = WebUI.getText(findTestObject('Object Repository/Cart/Delete_Product/Page_Cart - Vervane/span_1'))

if (itemCount == '1') {
    WebUI.comment('❌ Bug Detected: Cart still shows 1 item after deletion.')
    assert false : 'Bug - Cart still shows 1 item after deletion.'
} else {
    WebUI.comment('✅ Product successfully removed from the cart.')
}

WebUI.closeBrowser()

