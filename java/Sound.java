import java.io.IOException;
import javax.microedition.lcdui.Display;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

public class Sound
{
  public static final int MIDI = 0;
  static final String[] MIME_TYPE = { "audio/midi", "audio/x-wav" };
  public static final int TYPE_KIND = 2;
  public static final int TYPE_NOTHING = -1;
  public static final int VIBRATION = 300;
  public static final int WAVE = 1;
  public static int mediaNum;
  public BaseCanvas cBc;
  public int nCurIdx;
  public int nCurLoop;
  public Player player;
  public boolean volumemuted;
  public int volumesetting;
  
  public Sound(BaseCanvas paramBaseCanvas)
  {
    cBc = paramBaseCanvas;
    mediaNum = 0;
    volumesetting = 0;
    volumemuted = false;
  }
  
  public int getVolume()
  {
    return volumesetting;
  }
  
  public void playSound(int paramInt1, int paramInt2)
  {
    int j = 1;
    if (cBc.nSetup[0] != 1) {}
    for (;;)
    {
      return;
      Object localObject = cBc.cRes.sndRes[paramInt1];
      int i;
      if (((String)localObject).endsWith(".mid"))
      {
        nCurIdx = paramInt1;
        nCurLoop = paramInt2;
        i = cBc.nSetup[1];
        j = 0;
        label64:
        if (paramInt2 == -1) {
          break label248;
        }
        switch (j)
        {
        }
      }
      try
      {
        getClass();
        player = Manager.createPlayer(Display.getResourceAsStream((String)localObject), MIME_TYPE[j]);
        player.setLoopCount(paramInt2);
        player.start();
        localObject = (VolumeControl)player.getControl("VolumeControl");
        volumesetting = i;
        volumesetting = ((VolumeControl)localObject).setLevel(volumesetting);
        mediaNum = paramInt1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          break;
          nCurIdx = -1;
          nCurLoop = -1;
          i = cBc.nSetup[1];
          break label64;
          if (player != null)
          {
            stopSound();
            continue;
            if ((player != null) && (player.getState() == 400)) {
              break;
            }
            stopSound();
            continue;
            label248:
            stopSound();
          }
        }
      }
      catch (Exception localException) {}catch (MediaException localMediaException) {}
    }
  }
  
  public void setVolume(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    VolumeControl localVolumeControl;
    if (player != null)
    {
      localVolumeControl = (VolumeControl)player.getControl("VolumeControl");
      if (localVolumeControl != null)
      {
        volumesetting = paramInt2;
        volumesetting = localVolumeControl.setLevel(volumesetting);
        if (paramBoolean) {
          if (localVolumeControl.isMuted()) {
            break label84;
          }
        }
      }
    }
    label84:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localVolumeControl.setMute(paramBoolean);
      volumemuted = localVolumeControl.isMuted();
      return;
    }
  }
  
  public void setVolume(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] == 0)
    {
      cBc.nSetup[1] = 0;
      setVolume(1, cBc.nSetup[1], false);
      if (paramArrayOfInt[2] != 0) {
        break label84;
      }
      cBc.nSetup[3] = 0;
    }
    for (;;)
    {
      setVolume(0, cBc.nSetup[3], false);
      return;
      if (paramArrayOfInt[0] != 1) {
        break;
      }
      cBc.nSetup[1] = 100;
      break;
      label84:
      if (paramArrayOfInt[2] == 1) {
        cBc.nSetup[3] = 100;
      }
    }
  }
  
  public void soundStop()
  {
    if (nCurIdx != -1) {
      stopSound();
    }
  }
  
  public void stopSound()
  {
    if (player == null) {}
    for (;;)
    {
      return;
      if (mediaNum == -1) {
        continue;
      }
      if (player.getState() == 400) {}
      try
      {
        player.stop();
        if (player.getState() == 0) {
          continue;
        }
        try
        {
          player.close();
          player = null;
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public void vibration()
  {
    if (cBc.nSetup[4] == 1) {
      cBc.display.vibrate(300);
    }
  }
}
