package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletion extends TestBase{
    @BeforeMethod
    public void preConditions() {
        if (!app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))) {
            app.getUserHelper().login();
        }
    }
    @Test(enabled = false)
    public void deletionBoardTest(){
        while (app.getBoardHelper().boardCounter() > 1) {
            app.getBoardHelper().selectFirstBoard();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().openMenu1();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().openMenuMore();
            app.getBoardHelper().pause(3000);
            app.getBoardHelper().closeBoard();
            app.getBoardHelper().pause(2000);

        }
    }
    @Test
    public void boardDeletionTest() {
        if (app.getBoardHelper().NumberBoards() >= 2) {
            while (app.getBoardHelper().NumberBoards() > 2) {
                int before = app.getBoardHelper().NumberBoards();
                app.getBoardHelper().pressFirstBoardSpot();
                app.getBoardHelper().pause(2000);
                app.getBoardHelper().boardDeletionPath();
                app.getBoardHelper().pause(2000);
                int after = app.getBoardHelper().NumberBoards();
                app.getBoardHelper().pause(5000);
                Assert.assertEquals(before, after + 1);
            }
            System.out.println("there are not already any boards for deletion");
        }
    }
//package tests;
//
//import models.User;
//import org.openqa.selenium.By;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class BoardDeletion extends TestBase{
//    @BeforeMethod
//    public void preConditions(){
//        if(!app.getUserHelper().isElementPresent(By.xpath("//span[@class='DweEFaF5owOe02 V_PnoJ2AynVwLp G6CmOLx93OUZez']"))){
//            app.getUserHelper().openLoginForm();
//            app.getUserHelper().fillLoginForm(new User().withEmail("maxmayzel@gmail.com").withPassword("Rfrnec7_*"));
//            app.getUserHelper().submitLogIn();
//            app.getUserHelper().pause(3000);
//        }
//    }


//    @Test
//    public void boardDeletionTest(){
//        app.getBoardHelper().openMenu();
//        app.getUserHelper().pause(2000);
//        app.getBoardHelper().pressMore();
//        app.getUserHelper().pause(2000);
//        app.getBoardHelper().pressCloseBoard();
//        app.getUserHelper().pause(2000);
//        app.getBoardHelper().submitCloseButton();
//        app.getUserHelper().pause(2000);
//        app.getBoardHelper().pressPermanentlyDelete();
//        app.getUserHelper().pause(2000);
//        app.getBoardHelper().pressDeleteButton();
//
//    }
}
