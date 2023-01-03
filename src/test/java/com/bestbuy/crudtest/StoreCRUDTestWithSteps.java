package com.bestbuy.crudtest;

import com.bestbuy.storeinfo.StoreSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static java.lang.Math.log;
import static org.hamcrest.Matchers.hasValue;


@RunWith(SerenityRunner.class)
public class StoreCRUDTestWithSteps extends TestBase {

    static String name = "Cambridge" + TestUtils.getRandomValue();
    static String type = "BigBox" + TestUtils.getRandomValue();
    static String address = "Hilton Rd.";
    static String address2 = "Cambridge";
    static String city = "Cambridge";
    static String state = "Cambridgeshire";
    static String zip = "CB4 3NB";
    static Double lat = 44.969658;
    static Double lng = -93.449539;
    static String hours = "Mon: 10-9; Tue: 10-9, Wed: 10-9, Thurs: 10-9, Fri: 10-9, Sat: 10-9, Sun: 10-8";

    static int storeId;

    @Steps
    StoreSteps storeSteps;

    @Title("This will create new store")
    @Test
    public void test1(Object storeID) {
        ValidatableResponse response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours);
        response.log().all().statusCode(201);
    }

    @Title("Verify if the store was created in system")
    @Test
    public void test2() {
        HashMap<String, Object> storeMap = storeSteps.getStoreInfoByname(Integer.parseInt(name));
        Assert.assertThat(storeMap, hasValue(name));
        storeId = (int) storeMap.get("id");
    }

    @Title("Update the store information and verify the updated information")
    @Test
    public void test3() {
        name = name + "(Updated)";
        storeSteps.updateStore( storeId, name, type, address, address2, city, state, zip, lat, lng, hours)
                .log().all().statusCode(200);

        HashMap<String, Object> value = storeSteps.getStoreInfoByname(Integer.parseInt(name));
        Assert.assertThat(value, hasValue(name));
    }

    @Title("Delete the store and verify if the store is deleted!")
    @Test
    public void test4(){
        storeSteps.deleteStore(storeId).statusCode(204);
      //  storeSteps.getStoreById(storeId).statusCode(404);
    }

}


