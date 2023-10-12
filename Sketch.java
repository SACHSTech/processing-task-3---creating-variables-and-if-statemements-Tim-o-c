import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;


public class Sketch extends PApplet {
	
  /**
   * Description: Spider Warning System
   * @author: T. Chhor
   */

  public void settings() {
    size(400, 400);
  } 

  PImage img;

  public void setup() {
    background(0, 206, 235);

    // Ed Sheeran photo
    img = loadImage("ed_sheeran_png_by_maarcopngs-da8mlh2.png");
  }
    // Defining variables
    int intTimeHours = hour();
    int intTimeMinutes = minute();
    boolean isNightTime;

    // Defining random sizes and coordinates
    Random myRandom = new Random();
    int intRandomSize = myRandom.nextInt(50, 200);
    int intRandomCoordsX = myRandom.nextInt(50, 350);
    int intRandomCoordsY = myRandom.nextInt(325, 400);

  public void draw() {

    // Grass
    fill(0, 154, 23);
    rect(0, 350, 400, 50);

    // Ed sheeran
    image(img, 50, 350, 50, (float) (50 / 1.540));
    
    // Spider
    fill(27, 24, 17);
    ellipse(intRandomCoordsX,intRandomCoordsY, intRandomSize, (float) (intRandomSize / 1.5));
    fill(255, 255, 255);
    ellipse(intRandomCoordsX - intRandomSize / 5, intRandomCoordsY - intRandomCoordsY / 30, intRandomSize / 10, intRandomSize / 10);
    ellipse(intRandomCoordsX + intRandomSize / 5, intRandomCoordsY - intRandomCoordsY / 30, intRandomSize / 10, intRandomSize / 10);
    ellipse(intRandomCoordsX - intRandomSize / 10, intRandomCoordsY - intRandomCoordsY / 30, intRandomSize / 10, intRandomSize / 10);
    ellipse(intRandomCoordsX + intRandomSize / 10, intRandomCoordsY - intRandomCoordsY / 30, intRandomSize / 10, intRandomSize / 10);

    // Spider Legs
    fill(27,24,17);
    line(intRandomCoordsX + intRandomSize / 2, intRandomCoordsY, intRandomCoordsX + intRandomSize, intRandomCoordsY + intRandomSize);
    line(intRandomCoordsX - intRandomSize / 2, intRandomCoordsY, intRandomCoordsX - intRandomSize, intRandomCoordsY + intRandomSize);
    line(intRandomCoordsX + intRandomSize / 4, intRandomCoordsY + intRandomSize / 4, intRandomCoordsX + intRandomSize / 2, intRandomCoordsY + intRandomSize);
    line(intRandomCoordsX - intRandomSize / 4, intRandomCoordsY + intRandomSize / 4, intRandomCoordsX - intRandomSize / 2, intRandomCoordsY + intRandomSize);

    // Checks the size of the spider
    if (intRandomSize > 100){
      textSize(25);
      fill(255, 0, 0);
      text("he is close", 10, 200);
    }
    else {
      textSize(50);
      fill(0, 0, 255);
      text("he is far", 10, 150);
    }
    
    // The current time
    if (intTimeMinutes > 9) {
      textSize(15);
      fill(intTimeMinutes*2, intTimeMinutes*4, intTimeMinutes*2);
      text("The current time is: " + intTimeHours + ":" + intTimeMinutes, 100, 20);
    }
    else {
      textSize(15);
      fill(0, 0, 0);
      text("The current time is: " + intTimeHours + ":0" + intTimeMinutes, 100, 20);  
    }
      
    // Day or night?
    if (intTimeHours > 6 && intTimeHours < 18){
      textSize(15);
      fill(0, 0, 0);
      text("It is day time.", 100, 35);
      isNightTime = false;
    }
    else {
      textSize(15);
      fill(0, 0, 0);
      text("It is night time", 100, 35);
      isNightTime = true;
    }

    // Is the spider a threat?
    if (isNightTime == true && intRandomSize > 100){
      textSize(15);
      fill(0, 0, 0);
      text("The spider is a threat.", 100, 50);
      text("Actions Recommended: Run.", 100, 65);
    }
    else if (isNightTime == false && intRandomSize <= 100){
      textSize(15);
      fill(0, 0, 0);
      text("The spider is not yet a threat.", 100, 50);
      text("Actions Recommended: Observe.", 100, 65);
    }
    else {
      textSize(15);
      fill(0, 0, 0);
      text("The spider is becoming a threat.", 100, 50);
      text("Actions Recommended: Hide.", 100, 65);
    }

  }
  
}