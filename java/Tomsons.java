import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Tomsons
  extends MIDlet
{
  BaseCanvas bc = new BaseCanvas(this);
  Display display;
  
  public Tomsons() {}
  
  protected void destroyApp(boolean paramBoolean)
  {
    bc.quit();
  }
  
  public void pauseApp()
  {
    bc.pause();
  }
  
  public void startApp()
  {
    display = Display.getDisplay(this);
    display.setCurrent(bc);
    bc.resume();
  }
}
