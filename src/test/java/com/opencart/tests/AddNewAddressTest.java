package com.opencart.tests;

import com.opencart.pages.MyAccountPage;
import com.opencart.pojo.Address;
import com.opencart.utility.FakerUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewAddressTest extends TestBase {

    private MyAccountPage myAccountPage;
    private Address address;

    @BeforeMethod
    public void setup() {
        myAccountPage = homePage.navigateToLoginPage().loginToApplication(
                "daref44118@erapk.com", "TestPassword123@");
        address = FakerUtil.getFakeAddress();
    }

    @Test
    public void verifyAddNewAddress() {
        String addressSuccessToast = myAccountPage.navigateToAddressPage()
                .clickOnNewAddressButton()
                .saveAddress(address);
        Assert.assertEquals(addressSuccessToast.trim(), "Your address has been successfully added");
    }
}
