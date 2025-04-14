import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')
WebUI.navigateToUrl('https://vervane.tn/')

WebUI.click(findTestObject('Object Repository/Page_My account - Vervane/Page_Vervane Vervane/i_Wishlist_tb-icon tb-icon-account'))

WebUI.setText(findTestObject('Object Repository/Page_My account - Vervane/Page_My account - Vervane/input_Obligatoire_username'), "<script>alert('XSS Attack');</script>")

WebUI.setEncryptedText(findTestObject('Object Repository/Page_My account - Vervane/Page_My account - Vervane/input_Obligatoire_password'), 'AC8o8eqKi3wLGj2eB8503g==')

WebUI.click(findTestObject('Object Repository/Page_My account - Vervane/Page_My account - Vervane/button_Se connecter'))

boolean isAlertPresent = WebUI.verifyAlertNotPresent(5)

WebUI.closeBrowser()
