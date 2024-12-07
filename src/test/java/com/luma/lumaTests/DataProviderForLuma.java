package com.luma.lumaTests;

import org.testng.annotations.DataProvider;

public class DataProviderForLuma {

    @DataProvider(name = "dataFrLuma")
    public Object[][]getData(){

       return new Object[][]{
               {"test@test.com", "dasdsafsds", "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."},
               {"2343@test.com", "#$%#$@$#%$^%", "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."},
               {"l@test.com", "32131324543", "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."},
               {"SADFD@test.com", "DSFADSFDS", "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."},
       };
    }


}
