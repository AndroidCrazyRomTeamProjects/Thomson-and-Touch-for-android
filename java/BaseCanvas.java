import com.netmite.andme.MIDletThread;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;

public class BaseCanvas
  extends Canvas
  implements Drawable, Runnable
{
  public final int BOUNUS_BOX_FRAME = 30;
  private final int BUTTON_BACK = 31;
  private final int BUTTON_END = 30;
  private final int BUTTON_LEFT = 1;
  private final int BUTTON_MENU = 32;
  private final int BUTTON_MIDDLE = 2;
  private final int BUTTON_NOTHING = 0;
  private final int BUTTON_OK = 21;
  private final int BUTTON_RESUME = 40;
  private final int BUTTON_RIGHT = 3;
  private final int BUTTON_SCORE = 10;
  private final int BUTTON_SETUP = 20;
  private final int GAMEOVER_FRAME = 30;
  private final int GRADE_UP_POINT = 30;
  public int LANG;
  private final int LOGO_FRAME_LG = 4;
  private final int LOGO_FRAME_NEOCYON = 4;
  public final int MARK_CLEAR = 0;
  public final int MARK_EVENT = 1;
  public final int MARK_LEFT = 3;
  public final int MARK_OK = 2;
  public final int MARK_RIGHT = 4;
  public final int MAX_HEART = 3;
  public final int MAX_HEART_FRAME = 3;
  private final int NOTHING = -1;
  private final int OPEN_STAGE_STAR = 300;
  public byte[] byVenusSet;
  public DrawMenu cMenu;
  public DrawPlay00 cPlay00;
  public DrawPlay02 cPlay02;
  public DrawPlay03 cPlay03;
  public DrawPlay04 cPlay04;
  public DrawPlay05 cPlay05;
  public DrawPlay06 cPlay06;
  public Point cPoint;
  public Resource cRes;
  public Rms cRms;
  public Sound cSound;
  public Util cUtil;
  public Display display;
  public boolean isAppExecute;
  public boolean isBounusBox;
  public boolean isCall;
  public boolean isDragged;
  public boolean isEvent;
  public boolean isMarkEff;
  public boolean isNewRecord;
  public boolean isOncePlay = false;
  public boolean isPressed;
  public boolean isReleased;
  public boolean isResource;
  public boolean isResumePlay = false;
  public MIDlet midlet;
  public int nBounusBox;
  public int nBounusBoxFrame;
  public int nButtonLeft;
  public int nButtonMiddle;
  public int nButtonRight;
  public int nCurStateOff;
  public int nCurStateSeg;
  public int nEventTypeCh;
  public int nEventTypeText;
  public int nFrame;
  public int nFrame2;
  public int nGameIdx;
  public int nGrade;
  public int nHeart;
  public int nHeartFrame;
  public int[] nHiddenGameActive;
  public int[] nHiddenGameIdx;
  public int nMarkFrame;
  public int nMarkIdx;
  public int nPointerFrame;
  public int nPointerX;
  public int nPointerY;
  public int nPopupState;
  public int nPressType;
  public int nPressTypeP;
  public int nPrevStateOff;
  public int nPrevStateSeg;
  public int nResultAniFrame;
  public int nScorePage;
  public int[] nSetup;
  public int nStarInc;
  public int nTargetLcd;
  public boolean outOfMem = false;
  public int outOfMemCnt = 0;
  public int outOfMemWhere = 0;
  public StringBuffer strBuf;
  public Thread thread;
  
  public BaseCanvas(MIDlet paramMIDlet)
  {
    midlet = paramMIDlet;
    setFullScreenMode(true);
    display = Display.getDisplay(paramMIDlet);
    isAppExecute = true;
    isResumePlay = false;
    nSetup = new int[5];
    nSetup[0] = 1;
    nSetup[1] = 100;
    nSetup[2] = 0;
    nSetup[3] = 100;
    nSetup[4] = 1;
    nHiddenGameIdx = new int[2];
    nHiddenGameIdx[0] = 4;
    nHiddenGameIdx[1] = 6;
    nHiddenGameActive = new int[2];
    nHiddenGameActive[0] = 0;
    nHiddenGameActive[1] = 0;
    isEvent = false;
    nHeartFrame = 0;
    nCurStateSeg = 0;
    nCurStateOff = 0;
    strBuf = new StringBuffer();
    cRes = new Resource(this);
    cUtil = new Util();
    cSound = new Sound(this);
    cPoint = new Point(this);
    cMenu = new DrawMenu(this);
    cRms = new Rms(this);
    cPlay00 = new DrawPlay00(this);
    cPlay02 = new DrawPlay02(this);
    cPlay03 = new DrawPlay03(this);
    cPlay04 = new DrawPlay04(this);
    cPlay05 = new DrawPlay05(this);
    cPlay06 = new DrawPlay06(this);
    init();
    thread = new MIDletThread(this);
    thread.start();
  }
  
  private void clickButton(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      clickButtonFunc(nButtonLeft);
      continue;
      clickButtonFunc(nButtonMiddle);
      continue;
      clickButtonFunc(nButtonRight);
    }
  }
  
  private void clickButtonFunc(int paramInt)
  {
    if ((nCurStateSeg >= 2000) && (nCurStateOff == 0)) {}
    for (;;)
    {
      return;
      switch (paramInt)
      {
      case 21: 
      default: 
        break;
      case 10: 
        nScorePage = 0;
        setPopupState(3);
        setState(nCurStateSeg, nCurStateOff);
        break;
      case 20: 
        setPopupState(4);
        setState(nCurStateSeg, nCurStateOff);
        break;
      case 30: 
        setPopupState(2);
        setState(nCurStateSeg, nCurStateOff);
        break;
      case 31: 
        if (getPopupState() != 0)
        {
          if (getPopupState() == 4) {
            cRms.saveData(1);
          }
          setPopupState(0);
          setState(nCurStateSeg, nCurStateOff);
        }
        else
        {
          switch (nCurStateSeg)
          {
          default: 
            break;
          case 1000: 
            cMenu.init();
            setState(1000, 0);
            break;
          case 2000: 
          case 2001: 
          case 2002: 
          case 2003: 
          case 2004: 
          case 2005: 
          case 2006: 
            if (nCurStateOff == 1) {
              setState(1000, 0);
            }
            break;
          }
        }
        break;
      case 32: 
        setPopupState(1);
        setState(nCurStateSeg, nCurStateOff);
        break;
      case 40: 
        setPopupState(0);
        setState(nCurStateSeg, nCurStateOff);
      }
    }
  }
  
  private void drawBottomButton(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((nCurStateSeg == 1000) || (getPopupState() != 0)) {}
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        switch (paramInt2)
        {
        default: 
          switch (paramInt3)
          {
          default: 
            return;
            paramGraphics.setColor(0);
            paramGraphics.fillRect(0, 348, 240, 40);
          }
          break;
        }
        break;
      }
    }
    if (nPressType == 1) {}
    for (paramInt1 = 14;; paramInt1 = 0)
    {
      paramGraphics.drawImage(cRes.iBottomButton[paramInt1], 0, 376, 36);
      break;
    }
    if (nPressType == 2) {}
    for (paramInt1 = 15;; paramInt1 = 1)
    {
      paramGraphics.drawImage(cRes.iBottomButton[paramInt1], 120 - cRes.iBottomButton[paramInt1].getWidth() / 2, 376, 36);
      break;
    }
    if (nPressType == 3) {}
    for (paramInt1 = 16;; paramInt1 = 2)
    {
      paramGraphics.drawImage(cRes.iBottomButton[paramInt1], 240 - cRes.iBottomButton[paramInt1].getWidth(), 376, 36);
      break;
    }
    if (nPressType == 3) {}
    for (paramInt1 = 17;; paramInt1 = 3)
    {
      paramGraphics.drawImage(cRes.iBottomButton[paramInt1], 240 - cRes.iBottomButton[paramInt1].getWidth(), 376, 36);
      break;
    }
    if (nPressType == 3) {}
    for (paramInt1 = 18;; paramInt1 = 11)
    {
      paramGraphics.drawImage(cRes.iBottomButton[paramInt1], 240 - cRes.iBottomButton[paramInt1].getWidth(), 376, 36);
      break;
    }
    if (nPressType == 3) {}
    for (paramInt1 = 17;; paramInt1 = 3)
    {
      paramGraphics.drawImage(cRes.iBottomButton[paramInt1], 240 - cRes.iBottomButton[paramInt1].getWidth(), 376, 36);
      break;
    }
  }
  
  private void drawEnd(Graphics paramGraphics)
  {
    if (nCurStateSeg != 1000) {
      paramGraphics.drawImage(cRes.iPlayText[7], 120, 112, 3);
    }
    paramGraphics.drawImage(cRes.iButtonBack[0], 60, 323, 3);
    paramGraphics.drawImage(cRes.iButtonBack[0], 180, 323, 3);
    if (nCurStateSeg == 1000)
    {
      paramGraphics.drawImage(cRes.iEnd[5], 120, 262, 3);
      paramGraphics.drawImage(cRes.iEnd[1], 60, 323, 3);
      paramGraphics.drawImage(cRes.iEnd[2], 180, 323, 3);
      if (nPressTypeP != getPopupState() + 1000) {
        break label212;
      }
      paramGraphics.drawImage(cRes.iButtonBack[1], 60, 323, 3);
      paramGraphics.drawImage(cRes.iEnd[3], 60, 323, 3);
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iEnd[0], 120, 262, 3);
      break;
      label212:
      if (nPressTypeP == getPopupState() + 2000)
      {
        paramGraphics.drawImage(cRes.iButtonBack[1], 180, 323, 3);
        paramGraphics.drawImage(cRes.iEnd[4], 180, 323, 3);
      }
    }
  }
  
  private void drawEvent(Graphics paramGraphics)
  {
    int i;
    if (nCurStateSeg == 2004)
    {
      i = cRes.iEvent[(nEventTypeText + 8)].getWidth() / 2 + 10;
      paramGraphics.drawImage(cRes.iEvent[7], 0, 0, 20);
      if (nFrame == 0) {
        nFrame = 1;
      }
    }
    for (;;)
    {
      return;
      if (nFrame < 3)
      {
        paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], 0, 0 / (4 - nFrame), 20);
        paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], i - cRes.iEvent[(nEventTypeText + 8)].getWidth() / nFrame, 132, 3);
        nFrame += 1;
      }
      else if (nFrame < 5)
      {
        paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], 0, 0, 20);
        paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], i, 132, 3);
        nFrame += 1;
      }
      else if (nFrame == 5)
      {
        paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], 0, 0, 20);
        paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], i, 132, 3);
        nFrame = 0;
        isEvent = false;
        continue;
        int j = 240 - cRes.iEvent[nEventTypeCh].getWidth();
        int k = 112 - cRes.iEvent[nEventTypeCh].getHeight() + cRes.iEvent[7].getHeight();
        i = 120 - cRes.iEvent[(nEventTypeText + 8)].getWidth() / 2;
        int m = cRes.iEvent[7].getHeight() / 2 + 112;
        paramGraphics.drawImage(cRes.iEvent[7], 0, 112, 20);
        if (nFrame == 0)
        {
          nFrame = 1;
        }
        else if (nFrame < 3)
        {
          paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], j + cRes.iEvent[nEventTypeCh].getWidth() / nFrame, k, 20);
          paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], i - cRes.iEvent[(nEventTypeText + 8)].getWidth() / nFrame, m, 3);
          nFrame += 1;
        }
        else if (nFrame < 5)
        {
          paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], j, k, 20);
          paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], i, m, 3);
          nFrame += 1;
        }
        else if (nFrame == 5)
        {
          paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], j, k, 20);
          paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], i, m, 3);
          nFrame = 0;
          isEvent = false;
        }
      }
    }
  }
  
  private void drawHelp(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cRes.iHelpContext[0], 0, 0, 20);
    drawOk(paramGraphics);
  }
  
  private void drawLogoLG(Graphics paramGraphics)
  {
    if (nFrame == 8) {
      cRes.loadCommonImage();
    }
    if (nFrame == 16)
    {
      nFrame = 0;
      setState(0, 2);
      return;
    }
    if (nFrame < 8) {}
    for (int i = nFrame / 2;; i = 8 - nFrame / 2 - 1)
    {
      paramGraphics.drawImage(cRes.iLogo_LG[i], 120, 189, 3);
      nFrame += 1;
      break;
    }
  }
  
  private void drawLogoNEO(Graphics paramGraphics)
  {
    if (nFrame < 4)
    {
      int i = nFrame;
      drawClear(paramGraphics);
      paramGraphics.drawImage(cRes.iLogo_NEOCYON[i], 120, 189, 3);
      nFrame += 1;
    }
    for (;;)
    {
      return;
      nFrame = 0;
      cRes.loadCommonImage2();
      setState(1000, 0);
    }
  }
  
  private void drawMenu(Graphics paramGraphics)
  {
    if (nCurStateSeg != 1000)
    {
      paramGraphics.setColor(0);
      paramGraphics.drawImage(cRes.iPlayText[7], 120, 112, 3);
    }
    if (nPressTypeP != getPopupState() + 1000)
    {
      paramGraphics.drawImage(cRes.iButtonBack[0], 70, 270, 3);
      paramGraphics.drawImage(cRes.iMenuButton[0], 70, 270, 3);
    }
    if (nPressTypeP != getPopupState() + 2000)
    {
      paramGraphics.drawImage(cRes.iButtonBack[0], 170, 270, 3);
      paramGraphics.drawImage(cRes.iMenuButton[2], 170, 270, 3);
    }
    if (nPressTypeP != getPopupState() + 3000)
    {
      paramGraphics.drawImage(cRes.iButtonBack[0], 70, 335, 3);
      paramGraphics.drawImage(cRes.iMenuButton[4], 70, 335, 3);
    }
    if (nPressTypeP != getPopupState() + 4000)
    {
      paramGraphics.drawImage(cRes.iButtonBack[0], 170, 335, 3);
      paramGraphics.drawImage(cRes.iMenuButton[6], 170, 335, 3);
    }
    if (nPressTypeP == getPopupState() + 1000)
    {
      paramGraphics.drawImage(cRes.iButtonBack[1], 70, 270, 3);
      paramGraphics.drawImage(cRes.iMenuButton[1], 70, 270, 3);
    }
    for (;;)
    {
      return;
      if (nPressTypeP == getPopupState() + 2000)
      {
        paramGraphics.drawImage(cRes.iButtonBack[1], 170, 270, 3);
        paramGraphics.drawImage(cRes.iMenuButton[3], 170, 270, 3);
      }
      else if (nPressTypeP == getPopupState() + 3000)
      {
        paramGraphics.drawImage(cRes.iButtonBack[1], 70, 335, 3);
        paramGraphics.drawImage(cRes.iMenuButton[5], 70, 335, 3);
      }
      else if (nPressTypeP == getPopupState() + 4000)
      {
        paramGraphics.drawImage(cRes.iButtonBack[1], 170, 335, 3);
        paramGraphics.drawImage(cRes.iMenuButton[7], 170, 335, 3);
      }
    }
  }
  
  private void drawOk(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cRes.iOk[2], 120, 301, 3);
    if (nPressTypeP == getPopupState() + 1000) {
      paramGraphics.drawImage(cRes.iOk[1], 120, 301, 3);
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iOk[0], 120, 301, 3);
    }
  }
  
  private void drawPointerEff(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cRes.iPointer[0], nPointerX, nPointerY, 3);
  }
  
  private void drawResultButton(Graphics paramGraphics)
  {
    if (nPressTypeP == getPopupState() + 1000) {
      drawResultButton(paramGraphics, 1, 0);
    }
    for (;;)
    {
      return;
      if (nPressTypeP == getPopupState() + 2000) {
        drawResultButton(paramGraphics, 0, 1);
      } else {
        drawResultButton(paramGraphics, 0, 0);
      }
    }
  }
  
  private void drawResultButton(Graphics paramGraphics, int paramInt1, int paramInt2)
  {
    if (nCurStateSeg == 2004)
    {
      paramGraphics.drawImage(cRes.iResultButtonEach[paramInt1], 86, 301, 3);
      paramGraphics.drawImage(cRes.iResultButton[paramInt2], 184, 301, 3);
      paramGraphics.drawImage(cRes.iResultButton[2], 30, 301, 3);
      paramGraphics.drawImage(cRes.iResultButton[3], 138, 301, 3);
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iResultButtonEach[paramInt1], 72, 291, 3);
      paramGraphics.drawImage(cRes.iResultButton[paramInt2], 168, 291, 3);
      paramGraphics.drawImage(cRes.iResultButton[2], 72, 345, 3);
      paramGraphics.drawImage(cRes.iResultButton[3], 168, 345, 3);
    }
  }
  
  private void drawScore(Graphics paramGraphics)
  {
    drawMenuBG(paramGraphics);
    int i;
    int j;
    if (nScorePage == 0)
    {
      paramGraphics.drawImage(cRes.iScore[14], 120, 22, 3);
      i = 0;
      j = 0;
      if (j >= 6) {
        break label376;
      }
      if (j != 1) {
        break label636;
      }
      i = 1;
    }
    label376:
    label636:
    for (;;)
    {
      int m = j * 28;
      Image localImage = cRes.iScore[(j + i)];
      if (j == 0) {}
      for (int k = 6;; k = 0)
      {
        paramGraphics.drawImage(localImage, 25, m + 69 - k, 3);
        paramGraphics.drawImage(cRes.iScore[(j + i + 7)], 50, m + 69, 6);
        drawNumber(paramGraphics, cRes.iBlueNum, cPoint.nHighPoint[(j + i)], 234, m + 64, 0, 4, true);
        j++;
        break;
      }
      if (nScorePage == 1)
      {
        i = nFrame2 / 2 % 3 * 3;
        paramGraphics.drawImage(cRes.iScore[15], 120, 22, 3);
        paramGraphics.drawImage(cRes.iScore[16], 120, 112, 3);
        paramGraphics.drawImage(cRes.iStar[(i + 0)], 60, 88, 3);
        paramGraphics.drawImage(cRes.iStar[(i + 1)], 120, 88, 3);
        paramGraphics.drawImage(cRes.iStar[(i + 2)], 180, 88, 3);
        drawNumber(paramGraphics, cRes.iScoreNum, cPoint.nStarPoint[0], 170, 132, 2, 4, true);
        nFrame2 += 1;
        if ((nHiddenGameActive[0] == 0) && (nHiddenGameActive[1] == 0)) {
          if (cPoint.nStarPoint[0] < 300) {
            paramGraphics.drawImage(cRes.iScore[17], 120, 198, 3);
          }
        }
      }
      for (;;)
      {
        drawScoreButton(paramGraphics);
        return;
        paramGraphics.drawImage(cRes.iScore[18], 120, 198, 3);
        continue;
        if ((nHiddenGameActive[0] == 0) && (nHiddenGameActive[1] == 1))
        {
          if (cPoint.nStarPoint[0] < 300) {
            paramGraphics.drawImage(cRes.iScore[17], 120, 198, 3);
          } else {
            paramGraphics.drawImage(cRes.iScore[19], 120, 198, 3);
          }
        }
        else if ((nHiddenGameActive[0] == 1) && (nHiddenGameActive[1] == 0))
        {
          if (cPoint.nStarPoint[0] < 300) {
            paramGraphics.drawImage(cRes.iScore[17], 120, 198, 3);
          } else {
            paramGraphics.drawImage(cRes.iScore[19], 120, 198, 3);
          }
        }
        else if ((nHiddenGameActive[0] == 1) && (nHiddenGameActive[1] == 1))
        {
          paramGraphics.drawImage(cRes.iScore[20], 120, 198, 3);
          continue;
          if (nScorePage == 2) {
            paramGraphics.drawImage(cRes.iHelpContext[0], 0, 0, 20);
          }
        }
      }
    }
  }
  
  private void drawScoreButton(Graphics paramGraphics)
  {
    drawTouchText(paramGraphics);
    if (nPressTypeP == getPopupState() + 1000) {
      if (isPressed) {
        drawScoreButton(paramGraphics, 1);
      }
    }
    for (;;)
    {
      return;
      drawScoreButton(paramGraphics, 0);
      continue;
      if (nPressTypeP == getPopupState() + 2000)
      {
        if (isPressed) {
          drawScoreButton(paramGraphics, 2);
        } else {
          drawScoreButton(paramGraphics, 0);
        }
      }
      else if (nPressTypeP == getPopupState() + 3000)
      {
        if (isPressed) {
          drawScoreButton(paramGraphics, 3);
        } else {
          drawScoreButton(paramGraphics, 0);
        }
      }
      else {
        drawScoreButton(paramGraphics, 0);
      }
    }
  }
  
  private void drawScoreButton(Graphics paramGraphics, int paramInt)
  {
    paramGraphics.drawImage(cRes.iButtonBack[0], 40, 301, 3);
    paramGraphics.drawImage(cRes.iButtonBack[0], 120, 301, 3);
    paramGraphics.drawImage(cRes.iButtonBack[0], 200, 301, 3);
    paramGraphics.drawImage(cRes.iScoreButton[1], 40, 301, 3);
    paramGraphics.drawImage(cRes.iScoreButton[3], 120, 301, 3);
    paramGraphics.drawImage(cRes.iMenuButton[5], 200, 301, 3);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iButtonBack[1], 40, 301, 3);
      paramGraphics.drawImage(cRes.iScoreButton[0], 40, 301, 3);
      continue;
      paramGraphics.drawImage(cRes.iButtonBack[1], 120, 301, 3);
      paramGraphics.drawImage(cRes.iScoreButton[2], 120, 301, 3);
      continue;
      paramGraphics.drawImage(cRes.iButtonBack[1], 200, 301, 3);
      paramGraphics.drawImage(cRes.iMenuButton[4], 200, 301, 3);
    }
  }
  
  private void drawSetup(Graphics paramGraphics)
  {
    if (nCurStateSeg != 1000)
    {
      paramGraphics.setColor(0);
      paramGraphics.drawImage(cRes.iPlayText[7], 120, 112, 3);
    }
    if (nSetup[0] == 0)
    {
      paramGraphics.drawImage(cRes.iOk[3], 60, 301, 3);
      paramGraphics.drawImage(cRes.iSetup[1], 60, 'ĭ' - 4, 3);
      paramGraphics.drawImage(cRes.iSetup[4], 60, 'ĭ' + 26, 3);
    }
    label333:
    for (;;)
    {
      if (nSetup[4] == 0)
      {
        paramGraphics.drawImage(cRes.iOk[3], 180, 301, 3);
        paramGraphics.drawImage(cRes.iSetup[3], 180, 'ĭ' - 6, 3);
        paramGraphics.drawImage(cRes.iSetup[5], 180, 'ĭ' + 26, 3);
      }
      for (;;)
      {
        return;
        if (nSetup[0] != 1) {
          break label333;
        }
        paramGraphics.drawImage(cRes.iOk[2], 60, 301, 3);
        paramGraphics.drawImage(cRes.iSetup[0], 60, 'ĭ' - 4, 3);
        paramGraphics.drawImage(cRes.iSetup[4], 60, 'ĭ' + 26, 3);
        break;
        if (nSetup[4] == 1)
        {
          paramGraphics.drawImage(cRes.iOk[2], 180, 301, 3);
          paramGraphics.drawImage(cRes.iSetup[2], 180, 'ĭ' - 6, 3);
          paramGraphics.drawImage(cRes.iSetup[5], 180, 'ĭ' + 26, 3);
        }
      }
    }
  }
  
  public void drawBottomButton(Graphics paramGraphics)
  {
    drawBottomButton(paramGraphics, nButtonLeft, nButtonMiddle, nButtonRight);
  }
  
  public void drawBox(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cRes.iBox[0], 0, 224, 20);
  }
  
  public void drawClear(Graphics paramGraphics)
  {
    paramGraphics.setColor(16777215);
    paramGraphics.fillRect(0, 0, 240, 378);
    paramGraphics.setColor(0);
  }
  
  public void drawClipImage(Graphics paramGraphics, Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    paramGraphics.setClip(paramInt3 + paramInt1, paramInt4 + paramInt2, paramInt5, paramInt6);
    paramGraphics.drawImage(paramImage, paramInt1, paramInt2, paramInt7);
    paramGraphics.setClip(0, 0, 240, 378);
  }
  
  public void drawCombo(Graphics paramGraphics)
  {
    int i;
    if (cPoint.isComboAni) {
      i = cPoint.getComboCount();
    }
    switch (i)
    {
    case 0: 
    default: 
      return;
    case 1: 
      if (cPoint.nComboFrame == 0)
      {
        cSound.playSound(4, 1);
        if (nCurStateSeg != 2004) {
          break label180;
        }
        drawComboText(paramGraphics, 100, 112, i);
      }
      for (;;)
      {
        paramGraphics = cPoint;
        nComboFrame += 1;
        if (cPoint.nComboFrame != 6) {
          break;
        }
        cPoint.isComboAni = false;
        cPoint.nComboFrame = 0;
        break;
        paramGraphics.drawImage(cRes.iCombo[(cPoint.nComboFrame + 7)], 120, 112, 3);
        break label84;
        drawComboText(paramGraphics, 120, 132, i);
      }
    case 2: 
    case 3: 
      label84:
      label180:
      if (cPoint.nComboFrame == 0)
      {
        cSound.playSound(5, 1);
        label213:
        if (nCurStateSeg != 2004) {
          break label309;
        }
        drawComboText(paramGraphics, 92, 112, i);
      }
      for (;;)
      {
        paramGraphics = cPoint;
        nComboFrame += 1;
        if (cPoint.nComboFrame != 6) {
          break;
        }
        cPoint.isComboAni = false;
        cPoint.nComboFrame = 0;
        break;
        paramGraphics.drawImage(cRes.iCombo[(cPoint.nComboFrame + 13)], 120, 112, 3);
        break label213;
        label309:
        drawComboText(paramGraphics, 120, 140, i);
      }
    }
    if (cPoint.nComboFrame == 0)
    {
      cSound.playSound(6, 1);
      label343:
      if (nCurStateSeg != 2004) {
        break label453;
      }
      drawComboText(paramGraphics, 122, 112, i);
    }
    for (;;)
    {
      paramGraphics = cPoint;
      nComboFrame += 1;
      if (cPoint.nComboFrame != 6) {
        break;
      }
      cPoint.isComboAni = false;
      cPoint.nComboFrame = 0;
      if (i != 7) {
        break;
      }
      cPoint.nComboCount = 1;
      break;
      paramGraphics.drawImage(cRes.iCombo[(cPoint.nComboFrame + 19)], 120, 112, 3);
      break label343;
      label453:
      drawComboText(paramGraphics, 120, 110, i);
    }
  }
  
  public void drawComboText(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3)
  {
    paramGraphics.drawImage(cRes.iCombo[25], paramInt1, paramInt2, 3);
    if (nCurStateSeg == 2004) {
      paramGraphics.drawImage(cRes.iCombo[(paramInt3 - 1)], paramInt1 + 20, paramInt2, 3);
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iCombo[(paramInt3 - 1)], paramInt1, paramInt2 - 16, 3);
    }
  }
  
  public void drawDot(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = paramGraphics.getColor();
    paramGraphics.setColor(paramInt5);
    paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
    paramGraphics.setColor(i);
  }
  
  public void drawGameOver(Graphics paramGraphics)
  {
    if (nFrame == 0)
    {
      if (nCurStateSeg == 2006) {
        nHeart = 1;
      }
      cSound.vibration();
      nFrame = 1;
    }
    if (getPopupState() == 0) {
      nFrame += 1;
    }
    if (nFrame > 5) {
      nHeartFrame = 1;
    }
    if (nFrame > 6) {
      nHeartFrame = 2;
    }
    if (nFrame > 7) {
      nHeartFrame = -1;
    }
    int i;
    if (nCurStateSeg == 2004)
    {
      if (nHeart == 1)
      {
        if (nFrame > 7)
        {
          i = nFrame / 2 % 2 + 5;
          paramGraphics.drawImage(cRes.iPlayText[i], 162, 112 - cRes.iPlayText[i].getHeight() / 2, 20);
        }
        if (nFrame > 12)
        {
          paramGraphics.drawImage(cRes.iText_[2], 108, 56, 3);
          paramGraphics.drawImage(cRes.iText_[1], 108, 126, 3);
          drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nPoint[nGameIdx], 100, 230, 0, 4, true);
        }
        if (nFrame > 13)
        {
          paramGraphics.drawImage(cRes.iOverStar[1], 76, 50, 3);
          paramGraphics.drawImage(cRes.iText_[1], 76, 126, 3);
          drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nStarPoint[0], 69, 230, 0, 4, true);
        }
      }
      drawHeart(paramGraphics);
      if (((nHiddenGameActive[0] != 0) && (nHiddenGameActive[1] != 0)) || (cPoint.nStarPoint[0] < 300) || (nHeart != 1)) {
        break label863;
      }
      nBounusBox = 30;
      label368:
      if ((nBounusBox != 0) && (nFrame > 30))
      {
        i = nFrame2 / 2 % 3 * 3;
        if (nCurStateSeg != 2004) {
          break label876;
        }
        paramGraphics.drawImage(cRes.iPlayText[12], 120, 112, 3);
        paramGraphics.drawImage(cRes.iStar[(i + 0)], 144, 52, 3);
        paramGraphics.drawImage(cRes.iStar[(i + 1)], 144, 112, 3);
        paramGraphics.drawImage(cRes.iStar[(i + 2)], 144, 172, 3);
        paramGraphics.drawImage(cRes.iPlayText[13], 96, 112, 3);
      }
    }
    for (;;)
    {
      nFrame2 += 1;
      if (nFrame > nBounusBox + 30)
      {
        nHeart -= 1;
        nHeartFrame = 0;
        if (nHeart != 0) {
          break label979;
        }
        setPopupState(7);
        setNewRecord();
        if (getPopupState() != 0) {
          cSound.playSound(2, 1);
        }
        setState(nCurStateSeg, 3);
        nFrame = 0;
        resetHeart();
      }
      return;
      if (nHeart == 1)
      {
        if (nFrame > 7) {
          paramGraphics.drawImage(cRes.iPlayText[(nFrame / 2 % 2 + 5)], 120, 54, 17);
        }
        if (nFrame > 12)
        {
          paramGraphics.drawImage(cRes.iText[2], 44, 134, 3);
          paramGraphics.drawImage(cRes.iText[1], 114, 134, 3);
          drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nPoint[nGameIdx], 228, 126, 0, 4, true);
          drawDot(paramGraphics, 149, 130, 3, 3, 0);
          drawDot(paramGraphics, 149, 136, 3, 3, 0);
        }
        if (nFrame > 13)
        {
          paramGraphics.drawImage(cRes.iOverStar[0], 44, 158, 3);
          paramGraphics.drawImage(cRes.iText[1], 114, 158, 3);
          drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nStarPoint[0], 228, 150, 0, 4, true);
          drawDot(paramGraphics, 149, 154, 3, 3, 0);
          drawDot(paramGraphics, 149, 160, 3, 3, 0);
        }
      }
      drawHeart(paramGraphics);
      break;
      label863:
      nBounusBox = 0;
      nBounusBoxFrame = 0;
      break label368;
      label876:
      paramGraphics.drawImage(cRes.iPlayText[12], 120, 112, 3);
      paramGraphics.drawImage(cRes.iStar[(i + 0)], 60, 88, 3);
      paramGraphics.drawImage(cRes.iStar[(i + 1)], 120, 88, 3);
      paramGraphics.drawImage(cRes.iStar[(i + 2)], 180, 88, 3);
      paramGraphics.drawImage(cRes.iPlayText[13], 120, 136, 3);
    }
    label979:
    switch (nCurStateSeg)
    {
    }
    for (;;)
    {
      nFrame = 0;
      setPopupState(0);
      setState(nCurStateSeg, 0);
      break;
      cPlay00.init();
      continue;
      cPlay02.init();
      continue;
      cPlay03.init();
      continue;
      cPlay04.init();
      continue;
      cPlay05.init();
      continue;
      cPlay06.init();
    }
  }
  
  public void drawGameResultBack(Graphics paramGraphics)
  {
    if (isNewRecord)
    {
      paramGraphics.drawImage(cRes.iPlayResult[0], 0, 0, 20);
      if (nCurStateSeg == 2004) {
        paramGraphics.drawImage(cRes.iPlayResult[9], 135, 112, 3);
      }
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iPlayResult[9], 120, 38, 17);
      continue;
      paramGraphics.drawImage(cRes.iPlayResult[1], 0, 0, 20);
    }
  }
  
  public void drawGameResultForward(Graphics paramGraphics)
  {
    if (isNewRecord) {
      if (nCurStateSeg == 2004)
      {
        paramGraphics.drawImage(cRes.iPlayResult[2], 212, 112, 3);
        paramGraphics.drawImage(cRes.iPlayResult[4], 176, 112, 3);
        drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 140, 143, 0, 4, true);
        if (nResultAniFrame > 6) {
          paramGraphics.drawImage(cRes.iPlayResult[7], 120, 52, 3);
        }
      }
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iPlayResult[2], 120, 30, 3);
      paramGraphics.drawImage(cRes.iPlayResult[4], 120, 72, 3);
      drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 159, 96, 0, 4, true);
      if (nResultAniFrame > 6)
      {
        paramGraphics.drawImage(cRes.iPlayResult[7], 160, 96, 20);
        continue;
        if (nCurStateSeg == 2004)
        {
          paramGraphics.drawImage(cRes.iPlayResult[3], 212, 112, 3);
          paramGraphics.drawImage(cRes.iPlayResult[4], 176, 112, 3);
          drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 140, 143, 0, 4, true);
          if (nResultAniFrame > 6) {
            paramGraphics.drawImage(cRes.iPlayResult[8], 120, 52, 3);
          }
        }
        else
        {
          paramGraphics.drawImage(cRes.iPlayResult[3], 120, 30, 3);
          paramGraphics.drawImage(cRes.iPlayResult[4], 120, 72, 3);
          drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 159, 96, 0, 4, true);
          if (nResultAniFrame > 6) {
            paramGraphics.drawImage(cRes.iPlayResult[8], 160, 96, 20);
          }
        }
      }
    }
  }
  
  public void drawHeart(Graphics paramGraphics)
  {
    drawHeart(paramGraphics, 3);
  }
  
  public void drawHeart(Graphics paramGraphics, int paramInt)
  {
    if (nCurStateSeg == 2006) {
      return;
    }
    int i = 0;
    label13:
    int j;
    if ((i < 3) && (i < paramInt) && (i < nHeart))
    {
      if (i != nHeart - 1) {
        break label95;
      }
      j = nHeartFrame;
      label47:
      if (j == -1) {
        break label99;
      }
      if (nCurStateSeg != 2004) {
        break label101;
      }
      paramGraphics.drawImage(cRes.iHeart[j], 230, 304 - i * 20, 3);
    }
    for (;;)
    {
      i++;
      break label13;
      break;
      label95:
      j = 0;
      break label47;
      label99:
      break;
      label101:
      paramGraphics.drawImage(cRes.iHeart[j], 220 - i * 20, 30, 3);
    }
  }
  
  public void drawManager(Graphics paramGraphics)
  {
    drawClear(paramGraphics);
    switch (nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      drawClear(paramGraphics);
      setState(0, 1);
      continue;
      drawLogoLG(paramGraphics);
      continue;
      drawLogoNEO(paramGraphics);
    }
  }
  
  public void drawMark(Graphics paramGraphics)
  {
    if (isMarkEff)
    {
      if (getAnimationFrame(nMarkFrame, 2, 2) == 0) {
        paramGraphics.drawImage(cRes.iMark[nMarkIdx], 120, 60, 3);
      }
      nMarkFrame += 1;
      if (nMarkFrame > 20)
      {
        nMarkFrame = 0;
        isMarkEff = false;
      }
    }
    for (;;)
    {
      return;
      nMarkFrame = 0;
    }
  }
  
  public void drawMenuBG(Graphics paramGraphics)
  {
    int j = cRes.iMenuBG.getWidth();
    int i = 0;
    while (i < 240)
    {
      paramGraphics.drawImage(cRes.iMenuBG, i, 0, 20);
      i += j;
    }
  }
  
  public void drawNumber(Graphics paramGraphics, Image[] paramArrayOfImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    strBuf.delete(0, strBuf.length());
    String str = String.valueOf(paramInt1);
    int i = str.length();
    paramInt1 = i;
    if (paramInt5 < i)
    {
      strBuf.delete(0, strBuf.length());
      for (paramInt1 = 0; paramInt1 < paramInt5; paramInt1++) {
        strBuf.append("9");
      }
      str = strBuf.toString();
      paramInt1 = str.length();
      strBuf.delete(0, strBuf.length());
    }
    if (paramBoolean)
    {
      strBuf.delete(0, strBuf.length());
      for (i = 0; i < paramInt5 - paramInt1; i++) {
        strBuf.append("0");
      }
    }
    strBuf.append(str);
    str = strBuf.toString();
    i = str.length();
    paramInt1 = 0;
    for (paramInt5 = 0; paramInt5 < i; paramInt5++)
    {
      int j = str.charAt(i - 1 - paramInt5) - '0';
      paramInt1 += paramArrayOfImage[j].getWidth() + 1 + paramInt4;
      paramGraphics.drawImage(paramArrayOfImage[j], paramInt2 - paramInt1, paramInt3, 20);
    }
  }
  
  public void drawNumber_(Graphics paramGraphics, Image[] paramArrayOfImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    strBuf.delete(0, strBuf.length());
    String str = String.valueOf(paramInt1);
    int i = str.length();
    paramInt1 = i;
    if (paramInt5 < i)
    {
      strBuf.delete(0, strBuf.length());
      for (paramInt1 = 0; paramInt1 < paramInt5; paramInt1++) {
        strBuf.append("9");
      }
      str = strBuf.toString();
      paramInt1 = str.length();
      strBuf.delete(0, strBuf.length());
    }
    if (paramBoolean)
    {
      strBuf.delete(0, strBuf.length());
      for (i = 0; i < paramInt5 - paramInt1; i++) {
        strBuf.append("0");
      }
    }
    strBuf.append(str);
    str = strBuf.toString();
    i = str.length();
    paramInt1 = 0;
    for (paramInt5 = 0; paramInt5 < i; paramInt5++)
    {
      int j = str.charAt(i - 1 - paramInt5) - '0';
      paramInt1 += paramArrayOfImage[j].getHeight() + 1 + paramInt4;
      paramGraphics.drawImage(paramArrayOfImage[j], paramInt2, paramInt3 - paramInt1, 20);
    }
  }
  
  public void drawPointAnimation(Graphics paramGraphics)
  {
    int i = 0;
    cPoint.getClass();
    if (i < 5)
    {
      if (cPoint.cAni[i].isActive)
      {
        if (nCurStateSeg != 2004) {
          break label271;
        }
        if (cPoint.cAni[i].nPoint < 10) {
          break label252;
        }
      }
      label252:
      for (int j = cPoint.cAni[i].nPosY - 32;; j = cPoint.cAni[i].nPosY - 22)
      {
        paramGraphics.drawImage(cRes.iPlayPointNum[10], cPoint.cAni[i].nPosX - 1 + cPoint.cAni[i].nFrame, j, 20);
        drawNumber_(paramGraphics, cRes.iPlayPointNum, cPoint.cAni[i].nPoint, cPoint.cAni[i].nPosX + cPoint.cAni[i].nFrame, cPoint.cAni[i].nPosY, 0, 2, false);
        Point.PointAnimation localPointAnimation = cPoint.cAni[i];
        nFrame += 1;
        if (cPoint.cAni[i].nFrame > 5)
        {
          cPoint.cAni[i].isActive = false;
          cPoint.cAni[i].nFrame = 0;
        }
        i++;
        break;
      }
      label271:
      if (cPoint.cAni[i].nPoint >= 10) {}
      for (j = cPoint.cAni[i].nPosX - 30;; j = cPoint.cAni[i].nPosX - 20)
      {
        paramGraphics.drawImage(cRes.iPlayPointNum[10], j, cPoint.cAni[i].nPosY - 1 - cPoint.cAni[i].nFrame, 20);
        drawNumber(paramGraphics, cRes.iPlayPointNum, cPoint.cAni[i].nPoint, cPoint.cAni[i].nPosX, cPoint.cAni[i].nPosY - cPoint.cAni[i].nFrame, 0, 2, false);
        break;
      }
    }
  }
  
  public void drawPopup(Graphics paramGraphics)
  {
    switch (getPopupState())
    {
    }
    for (;;)
    {
      return;
      drawBox(paramGraphics);
      drawEnd(paramGraphics);
      drawBottomButton(paramGraphics);
      continue;
      drawBox(paramGraphics);
      drawMenu(paramGraphics);
      drawBottomButton(paramGraphics);
      continue;
      drawBox(paramGraphics);
      drawScore(paramGraphics);
      drawBottomButton(paramGraphics);
      continue;
      drawBox(paramGraphics);
      drawSetup(paramGraphics);
      drawBottomButton(paramGraphics);
      continue;
      drawBox(paramGraphics);
      drawHelp(paramGraphics);
      drawBottomButton(paramGraphics);
      continue;
      drawBox(paramGraphics);
      drawOk(paramGraphics);
      drawBottomButton(paramGraphics);
      continue;
      drawBox(paramGraphics);
      drawResultButton(paramGraphics);
      drawBottomButton(paramGraphics);
    }
  }
  
  public void drawReadyStart(Graphics paramGraphics)
  {
    if (nFrame == 0)
    {
      cSound.playSound(23, 1);
      nFrame = 1;
    }
    int j;
    int i;
    if (nFrame < 4)
    {
      j = cRes.iPlayText[0].getWidth() / nFrame;
      if (nHeart == 3)
      {
        i = 0;
        paramGraphics.drawImage(cRes.iPlayText[i], 120 - j, 112, 3);
        nFrame += 1;
      }
    }
    for (;;)
    {
      return;
      drawHeart(paramGraphics, 3);
      i = 8;
      break;
      if (nFrame < 10)
      {
        if (nHeart == 3)
        {
          j = nFrame % 2 + 1;
          i = j;
          if (nFrame >= 8)
          {
            drawHeart(paramGraphics, 1);
            i = j;
          }
        }
        for (;;)
        {
          paramGraphics.drawImage(cRes.iPlayText[i], 120, 112, 3);
          nFrame += 1;
          break;
          i = nFrame % 2 + 9;
          drawHeart(paramGraphics, 3);
        }
      }
      if (nFrame < 12)
      {
        if (nHeart == 3)
        {
          drawHeart(paramGraphics, 2);
          i = 3;
        }
        for (;;)
        {
          paramGraphics.drawImage(cRes.iPlayText[i], 120, 112, 3);
          nFrame += 1;
          break;
          i = 11;
          drawHeart(paramGraphics, 3);
        }
      }
      if (nFrame < 14)
      {
        drawHeart(paramGraphics, 3);
        nFrame += 1;
      }
      else if (nFrame == 14)
      {
        drawHeart(paramGraphics, 3);
        setState(nCurStateSeg, 1);
        nFrame = 0;
      }
    }
  }
  
  public void drawScoreBar(Graphics paramGraphics)
  {
    if (nCurStateSeg == 2004)
    {
      paramGraphics.drawImage(cRes.iText_[0], 224, 2, 20);
      paramGraphics.drawImage(cRes.iText_[1], 224, 122, 20);
      drawNumber_(paramGraphics, cRes.iBlueNum_, cPoint.nHighPoint[nGameIdx], 224, 110, 0, 4, true);
      drawNumber_(paramGraphics, cRes.iRedNum_, cPoint.nPoint[nGameIdx], 224, 244, 0, 4, true);
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iText[0], 2, 2, 20);
      paramGraphics.drawImage(cRes.iText[1], 116, 2, 20);
      drawNumber(paramGraphics, cRes.iBlueNum, cPoint.nHighPoint[nGameIdx], 110, 2, 0, 4, true);
      drawNumber(paramGraphics, cRes.iRedNum, cPoint.nPoint[nGameIdx], 238, 2, 0, 4, true);
    }
  }
  
  public void drawTouchText(Graphics paramGraphics)
  {
    if ((cMenu.isActive()) && (getPopupState() == 0))
    {
      nFrame2 += 1;
      if (nFrame2 / 5 % 2 == 0) {
        paramGraphics.drawImage(cRes.iTouchText, 'ð' - 50, 18 + 'à', 3);
      }
      if (nFrame2 >= 5) {
        nFrame2 = 0;
      }
    }
    for (;;)
    {
      return;
      paramGraphics.drawImage(cRes.iTouchText, 'ð' - 50, 18 + 'à', 3);
    }
  }
  
  public int getAnimationFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt1 / paramInt2 % paramInt3;
  }
  
  public long getCurTime()
  {
    return System.currentTimeMillis();
  }
  
  public int getPopupState()
  {
    return nPopupState;
  }
  
  public int getTargetLcd()
  {
    return nTargetLcd;
  }
  
  public void init()
  {
    String str = System.getProperty("microedition.locale");
    if (str.substring(0, 2).equals("en")) {
      LANG = 0;
    }
    for (;;)
    {
      nPointerX = 0;
      nPointerY = 0;
      isPressed = false;
      isReleased = false;
      isDragged = false;
      nPointerFrame = 0;
      nResultAniFrame = 0;
      nMarkFrame = 0;
      nScorePage = 0;
      nGameIdx = 0;
      nFrame = 0;
      nFrame2 = 0;
      isBounusBox = false;
      nBounusBox = 0;
      nBounusBoxFrame = 0;
      setPopupState(0);
      isResource = true;
      isEvent = false;
      isMarkEff = false;
      if (!cRms.existRms())
      {
        cRms.saveData(1);
        cRms.saveData(2);
        cRms.saveData(3);
      }
      nSetup = cRms.loadData(1);
      cPoint.nHighPoint = cRms.loadData(2);
      nHiddenGameActive = cRms.loadData(3);
      cPoint.nStarPoint = cRms.loadData(4);
      return;
      if (str.substring(0, 2).equals("de")) {
        LANG = 3;
      } else if (str.substring(0, 2).equals("fr")) {
        LANG = 4;
      } else if (str.substring(0, 2).equals("es")) {
        LANG = 1;
      } else if (str.substring(0, 2).equals("pt")) {
        LANG = 2;
      } else if (str.substring(0, 2).equals("it")) {
        LANG = 8;
      } else if (str.substring(0, 2).equals("tr")) {
        LANG = 12;
      } else if (str.substring(0, 2).equals("ru")) {
        LANG = 5;
      } else if (str.substring(0, 2).equals("ar")) {
        LANG = 10;
      } else if (str.substring(0, 2).equals("zh"))
      {
        if (str.substring(3, 5).equals("CN")) {
          LANG = 6;
        } else if (str.substring(3, 5).equals("TW")) {
          LANG = 0;
        } else if (str.substring(3, 5).equals("HK")) {
          LANG = 9;
        } else {
          LANG = 6;
        }
      }
      else {
        LANG = 0;
      }
    }
  }
  
  public boolean isLock()
  {
    if ((isResource) || (isEvent) || (getPopupState() != 0) || (nCurStateOff == 2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isPointer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    boolean bool;
    if ((paramInt2 <= 224) || (paramInt2 > 348)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((paramInt3 < paramInt1) && (paramInt5 > paramInt1) && (paramInt4 < paramInt2) && (paramInt6 > paramInt2)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean isPointer(int paramInt1, int paramInt2, Image paramImage, int paramInt3, int paramInt4)
  {
    boolean bool;
    if ((paramInt1 <= 0) || (paramInt1 >= 240) || (paramInt2 <= 224) || (paramInt2 >= 348)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((paramInt3 < paramInt1) && (paramImage.getWidth() + paramInt3 > paramInt1) && (paramInt4 + 224 < paramInt2) && (paramInt4 + 224 + paramImage.getHeight() > paramInt2)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean isSoundLock()
  {
    if (getPopupState() != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isStarCheck()
  {
    if (cPoint.nStarPoint[0] >= 300)
    {
      int[] arrayOfInt = cPoint.nStarPoint;
      arrayOfInt[0] -= 300;
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      nScorePage = 1;
    }
  }
  
  protected void paint(Graphics paramGraphics)
  {
    if (outOfMem)
    {
      paramGraphics.setColor(0);
      paramGraphics.fillRect(0, 0, getWidth(), getHeight() + 16);
      paramGraphics.setColor(16777215);
    }
    String str;
    switch (LANG)
    {
    case 5: 
    default: 
      str = "Not enough memory";
      paramGraphics.drawString(str, getWidth() / 2, (getHeight() + 16) / 2, 0x10 | 0x1);
      serviceRepaints();
      outOfMemCnt += 1;
      if (outOfMemCnt > 50)
      {
        midlet.notifyDestroyed();
        if (!isResource) {
          break label374;
        }
        cSound.stopSound();
        if (cRes.load(paramGraphics, nCurStateSeg, nCurStateOff)) {
          switch (nCurStateSeg)
          {
          }
        }
      }
      break;
    }
    for (;;)
    {
      return;
      str = "内存不足";
      break;
      str = "記憶体不足";
      break;
      str = "Mémoire insuffisante";
      break;
      str = "Zu wenig Speicher";
      break;
      str = "Memoria insufficiente";
      break;
      str = "Não há memória suficiente";
      break;
      str = "Memoria insuficiente";
      break;
      cSound.playSound(0, 1);
      continue;
      cPlay00.init();
      continue;
      cPlay02.init();
      continue;
      cPlay03.init();
      continue;
      cPlay04.init();
      continue;
      cPlay05.init();
      continue;
      cPlay06.init();
    }
    label374:
    switch (nCurStateSeg)
    {
    }
    for (;;)
    {
      if (isEvent) {
        drawEvent(paramGraphics);
      }
      if (getPopupState() != 0) {
        drawPopup(paramGraphics);
      }
      if (((getPopupState() == 0) && (nCurStateSeg != 1000)) || (isPressed != true) || (nPointerFrame != 0)) {
        break;
      }
      drawPointerEff(paramGraphics);
      nPointerFrame = 0;
      break;
      drawManager(paramGraphics);
      continue;
      cMenu.drawManager(paramGraphics);
      continue;
      cPlay00.drawManager(paramGraphics);
      continue;
      cPlay02.drawManager(paramGraphics);
      continue;
      cPlay03.drawManager(paramGraphics);
      continue;
      cPlay04.drawManager(paramGraphics);
      continue;
      cPlay05.drawManager(paramGraphics);
      continue;
      cPlay06.drawManager(paramGraphics);
    }
  }
  
  public void pause()
  {
    cSound.soundStop();
    isCall = true;
    switch (nCurStateSeg)
    {
    }
    for (;;)
    {
      return;
      if (nCurStateOff == 1)
      {
        setPopupState(1);
        setState(nCurStateSeg, nCurStateOff);
      }
    }
  }
  
  protected void pointerDragged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 224) || (paramInt2 >= 378) || (paramInt1 <= 0) || (paramInt1 >= 240))
    {
      isDragged = false;
      setButtonType(0);
      setButtonTypeP(0);
    }
    for (;;)
    {
      return;
      if (!isLock()) {
        switch (nCurStateSeg)
        {
        default: 
          break;
        case 1000: 
          cMenu.pointerDragged(paramInt1, paramInt2);
          break;
        case 2000: 
          cPlay00.pointerDragged(paramInt1, paramInt2);
          break;
        case 2002: 
          cPlay02.pointerDragged(paramInt1, paramInt2);
          break;
        case 2003: 
          cPlay03.pointerDragged(paramInt1, paramInt2);
          break;
        case 2004: 
          cPlay04.pointerDragged(paramInt1, paramInt2);
          break;
        case 2005: 
          cPlay05.pointerDragged(paramInt1, paramInt2);
          break;
        case 2006: 
          cPlay06.pointerDragged(paramInt1, paramInt2);
        }
      }
    }
  }
  
  protected void pointerPressed(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 224)
    {
      setPressedPointer(paramInt1, paramInt2, false);
      setButtonType(0);
      setButtonTypeP(0);
    }
    for (;;)
    {
      return;
      setPressedPointer(paramInt1, paramInt2, true);
      switch (getPopupState())
      {
      }
      for (;;)
      {
        if (paramInt2 > 348)
        {
          if ((paramInt1 >= 0) && (paramInt1 < 80))
          {
            setButtonType(1);
            break;
            int m = 70 - cRes.iButtonBack[0].getWidth() / 2;
            int i = 170 - cRes.iButtonBack[0].getWidth() / 2;
            int k = 46 - cRes.iButtonBack[0].getHeight() / 2;
            int j = 111 - cRes.iButtonBack[0].getHeight() / 2;
            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], m, k))
            {
              setButtonTypeP(getPopupState() + 1000);
              continue;
            }
            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k))
            {
              setButtonTypeP(getPopupState() + 2000);
              continue;
            }
            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], m, j))
            {
              setButtonTypeP(getPopupState() + 3000);
              continue;
            }
            if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, j)) {
              continue;
            }
            setButtonTypeP(getPopupState() + 4000);
            continue;
            j = cRes.iOk[2].getWidth() / 2;
            i = cRes.iOk[2].getHeight() / 2;
            if (!isPointer(paramInt1, paramInt2, cRes.iOk[2], 120 - j, 77 - i)) {
              continue;
            }
            setButtonTypeP(getPopupState() + 1000);
            break;
            if (isPointer(paramInt1, paramInt2, cRes.iOk[2], 60 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2)) {
              setButtonTypeP(getPopupState() + 1000);
            }
            if (!isPointer(paramInt1, paramInt2, cRes.iOk[2], 180 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2)) {
              continue;
            }
            setButtonTypeP(getPopupState() + 2000);
            continue;
            if (paramInt2 <= 224) {
              continue;
            }
            i = 120 - cRes.iButtonBack[0].getWidth() / 2;
            j = 99 - cRes.iButtonBack[0].getHeight() / 2;
            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 60, j))
            {
              setButtonTypeP(getPopupState() + 1000);
              continue;
            }
            if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 60, j)) {
              continue;
            }
            setButtonTypeP(getPopupState() + 2000);
            break;
            i = 120 - cRes.iScoreButton[0].getWidth() / 2;
            j = 77 - cRes.iScoreButton[0].getHeight() / 2;
            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 80, j))
            {
              setButtonTypeP(getPopupState() + 1000);
              break;
            }
            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, j))
            {
              setButtonTypeP(getPopupState() + 2000);
              break;
            }
            if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 80, j)) {
              continue;
            }
            setButtonTypeP(getPopupState() + 3000);
            break;
            j = cRes.iOk[2].getWidth() / 2;
            i = cRes.iOk[2].getHeight() / 2;
            if (!isPointer(paramInt1, paramInt2, cRes.iOk[2], 120 - j, 77 - i)) {
              continue;
            }
            setButtonTypeP(getPopupState() + 1000);
            break;
            if (nCurStateSeg == 2004)
            {
              j = 120 - cRes.iButtonBack[0].getWidth() / 2;
              i = 77 - cRes.iButtonBack[0].getHeight() / 2;
              if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j - 34, i))
              {
                setButtonTypeP(getPopupState() + 1000);
                break;
              }
              if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j + 64, i)) {
                continue;
              }
              setButtonTypeP(getPopupState() + 2000);
              break;
            }
            j = cRes.iButtonBack[0].getWidth() / 2;
            k = cRes.iButtonBack[0].getWidth() / 2;
            i = 67 - cRes.iButtonBack[0].getHeight() / 2;
            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], 72 - j, i))
            {
              setButtonTypeP(getPopupState() + 1000);
              break;
            }
            if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], 168 - k, i)) {
              continue;
            }
            setButtonTypeP(getPopupState() + 2000);
            break;
          }
          if ((paramInt1 >= 80) && (paramInt1 < 160))
          {
            setButtonType(2);
            break;
          }
          if ((paramInt1 < 160) || (paramInt1 >= 240)) {
            break;
          }
          setButtonType(3);
          break;
        }
      }
      if (!isLock()) {
        switch (nCurStateSeg)
        {
        default: 
          break;
        case 1000: 
          cMenu.pointerPressed(paramInt1, paramInt2);
          break;
        case 2000: 
          cPlay00.pointerPressed(paramInt1, paramInt2);
          break;
        case 2002: 
          cPlay02.pointerPressed(paramInt1, paramInt2);
          break;
        case 2003: 
          cPlay03.pointerPressed(paramInt1, paramInt2);
          break;
        case 2004: 
          cPlay04.pointerPressed(paramInt1, paramInt2);
          break;
        case 2005: 
          cPlay05.pointerPressed(paramInt1, paramInt2);
          break;
        case 2006: 
          cPlay06.pointerPressed(paramInt1, paramInt2);
        }
      }
    }
  }
  
  protected void pointerReleased(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 224)
    {
      setPressedPointer(0, 0, false);
      setReleasedPointer(0, 0, false);
    }
    for (;;)
    {
      return;
      setPressedPointer(paramInt1, paramInt2, false);
      setReleasedPointer(paramInt1, paramInt2, true);
      if (nPressTypeP > 1000) {}
      switch (getPopupState())
      {
      default: 
        label92:
        setButtonTypeP(0);
        if (paramInt2 <= 348) {
          break label1422;
        }
        if ((paramInt1 >= 0) && (paramInt1 < 80)) {
          if (nPressType == 1) {
            clickButton(nPressType);
          }
        }
        break;
      }
      for (;;)
      {
        setButtonType(0);
        break;
        int m = 70 - cRes.iButtonBack[0].getWidth() / 2;
        int i = 170 - cRes.iButtonBack[0].getWidth() / 2;
        int j = 46 - cRes.iButtonBack[0].getHeight() / 2;
        int k = 111 - cRes.iButtonBack[0].getHeight() / 2;
        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], m, j))
        {
          setPopupState(3);
          setState(nCurStateSeg, nCurStateOff);
          break label92;
        }
        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, j))
        {
          setPopupState(4);
          setState(nCurStateSeg, nCurStateOff);
          break label92;
        }
        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], m, k))
        {
          setPopupState(5);
          setState(nCurStateSeg, nCurStateOff);
          break label92;
        }
        if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k)) {
          break label92;
        }
        setPopupState(2);
        setState(nCurStateSeg, nCurStateOff);
        break label92;
        j = cRes.iOk[2].getWidth() / 2;
        i = cRes.iOk[2].getHeight() / 2;
        if (!isPointer(paramInt1, paramInt2, cRes.iOk[2], 120 - j, 77 - i)) {
          break label92;
        }
        setPopupState(0);
        setState(nCurStateSeg, nCurStateOff);
        break;
        if (isPointer(paramInt1, paramInt2, cRes.iOk[2], 60 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2))
        {
          if (nSetup[0] != 0) {
            break label614;
          }
          nSetup[0] = 1;
          cSound.playSound(0, 1);
        }
        while (isPointer(paramInt1, paramInt2, cRes.iOk[2], 180 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2))
        {
          if (nSetup[4] != 0) {
            break label641;
          }
          nSetup[4] = 1;
          cSound.vibration();
          break;
          label614:
          if (nSetup[0] == 1)
          {
            nSetup[0] = 0;
            cSound.stopSound();
          }
        }
        label641:
        if (nSetup[4] != 1) {
          break label92;
        }
        nSetup[4] = 0;
        break label92;
        if (paramInt2 <= 224) {
          break label92;
        }
        i = 120 - cRes.iButtonBack[0].getWidth() / 2;
        j = 99 - cRes.iButtonBack[0].getHeight() / 2;
        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 60, j))
        {
          if (nCurStateSeg == 1000)
          {
            quit();
            break label92;
          }
          cRms.saveData(2);
          cRms.saveData(3);
          cRms.saveData(4);
          setPopupState(0);
          setState(1000, 0);
          break;
        }
        if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 60, j)) {
          break label92;
        }
        setPopupState(0);
        setState(nCurStateSeg, nCurStateOff);
        break;
        i = 120 - cRes.iScoreButton[0].getWidth() / 2;
        j = 77 - cRes.iScoreButton[0].getHeight() / 2;
        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 80, j))
        {
          nScorePage = 0;
          break label92;
        }
        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, j))
        {
          nScorePage = 1;
          break label92;
        }
        if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 80, j)) {
          break label92;
        }
        nScorePage = 2;
        break label92;
        i = cRes.iOk[2].getWidth() / 2;
        j = cRes.iOk[2].getHeight() / 2;
        if (!isPointer(paramInt1, paramInt2, cRes.iOk[2], 120 - i, 77 - j)) {
          break label92;
        }
        cMenu.init();
        setPopupState(0);
        setState(1000, 0);
        cRms.saveData(2);
        cRms.saveData(3);
        cRms.saveData(4);
        break;
        j = cRes.iButtonBack[0].getWidth() / 2;
        k = cRes.iButtonBack[0].getWidth() / 2;
        i = 67 - cRes.iButtonBack[0].getHeight() / 2;
        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], 72 - j, i))
        {
          switch (nCurStateSeg)
          {
          }
          for (;;)
          {
            setPopupState(0);
            setState(nCurStateSeg, 0);
            cRms.saveData(2);
            cRms.saveData(3);
            cRms.saveData(4);
            break;
            cPlay00.init();
            continue;
            cPlay02.init();
            continue;
            cPlay03.init();
            continue;
            cPlay04.init();
            continue;
            cPlay05.init();
            continue;
            cPlay06.init();
          }
        }
        if (!isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], 168 - k, i)) {
          break label92;
        }
        cMenu.init();
        setPopupState(0);
        setState(1000, 0);
        cRms.saveData(2);
        cRms.saveData(3);
        cRms.saveData(4);
        break;
        if ((paramInt1 >= 80) && (paramInt1 < 160))
        {
          if (nPressType == 2) {
            clickButton(nPressType);
          }
        }
        else if ((paramInt1 >= 160) && (paramInt1 < 240) && (nPressType == 3)) {
          clickButton(nPressType);
        }
      }
      label1422:
      setButtonType(0);
      if (!isLock()) {
        switch (nCurStateSeg)
        {
        default: 
          break;
        case 1000: 
          cMenu.pointerReleased(paramInt1, paramInt2);
          break;
        case 2000: 
          cPlay00.pointerReleased(paramInt1, paramInt2);
          break;
        case 2002: 
          cPlay02.pointerReleased(paramInt1, paramInt2);
          break;
        case 2003: 
          cPlay03.pointerReleased(paramInt1, paramInt2);
          break;
        case 2004: 
          cPlay04.pointerReleased(paramInt1, paramInt2);
          break;
        case 2005: 
          cPlay05.pointerReleased(paramInt1, paramInt2);
          break;
        case 2006: 
          cPlay06.pointerReleased(paramInt1, paramInt2);
        }
      }
    }
  }
  
  public void quit()
  {
    isAppExecute = false;
    cSound.stopSound();
    cRes.free();
    System.gc();
    midlet.notifyDestroyed();
  }
  
  public void resetHeart()
  {
    setHeart(3);
  }
  
  public void resume()
  {
    isCall = false;
    if (isOncePlay) {
      isResumePlay = true;
    }
    if (!isOncePlay) {
      isOncePlay = true;
    }
  }
  
  public void run()
  {
    try
    {
      while (isAppExecute)
      {
        if (isResumePlay)
        {
          if ((cSound.nCurIdx != -1) && (cSound.nCurLoop == -1)) {
            cSound.playSound(cSound.nCurIdx, cSound.nCurLoop);
          }
          isResumePlay = false;
        }
        repaint();
        serviceRepaints();
        try
        {
          Thread.sleep(50L);
        }
        catch (Exception localException) {}
      }
      return;
    }
    finally {}
  }
  
  public void setBottomButton(int paramInt1, int paramInt2)
  {
    switch (getPopupState())
    {
    default: 
      switch (paramInt1)
      {
      }
      break;
    }
    for (;;)
    {
      return;
      setButton(0, 0, 31);
      continue;
      if (!isCall) {
        cSound.playSound(0, 1);
      }
      setButton(0, 0, 40);
      continue;
      setButton(0, 0, 0);
      continue;
      setButton(0, 0, 0);
      continue;
      switch (paramInt2)
      {
      default: 
        break;
      case 0: 
        if (cMenu.isActive())
        {
          setButton(10, 20, 31);
        }
        else
        {
          setButton(10, 20, 30);
          continue;
          switch (paramInt2)
          {
          default: 
            break;
          case 0: 
            setButton(0, 0, 32);
            break;
          case 1: 
            setButton(0, 0, 32);
            break;
          case 2: 
            setButton(0, 0, 0);
            break;
          case 3: 
            setButton(0, 0, 0);
          }
        }
        break;
      }
    }
  }
  
  public void setButton(int paramInt1, int paramInt2, int paramInt3)
  {
    nButtonLeft = paramInt1;
    nButtonMiddle = paramInt2;
    nButtonRight = paramInt3;
  }
  
  public void setButtonType(int paramInt)
  {
    nPressType = paramInt;
  }
  
  public void setButtonTypeP(int paramInt)
  {
    nPressTypeP = paramInt;
  }
  
  public void setEvent(boolean paramBoolean)
  {
    cSound.playSound(7, 1);
    isEvent = paramBoolean;
    nEventTypeCh = cUtil.getRandomInt(0, 7);
    nEventTypeText = cUtil.getRandomInt(0, 2);
  }
  
  public void setGameIdx(int paramInt)
  {
    nGameIdx = paramInt;
  }
  
  public void setGrade(int paramInt)
  {
    nGrade = (paramInt / 30);
    if (nGrade > 7) {
      nGrade = 7;
    }
  }
  
  public void setHeart(int paramInt)
  {
    nHeart = paramInt;
  }
  
  public void setMark(boolean paramBoolean, int paramInt)
  {
    nMarkIdx = paramInt;
    nMarkFrame = 0;
    isMarkEff = paramBoolean;
  }
  
  public void setNewRecord()
  {
    isNewRecord = cPoint.isNewRecord();
    if (isNewRecord) {
      cPoint.nHighPoint[nGameIdx] = cPoint.nPoint[nGameIdx];
    }
  }
  
  public void setPopupState(int paramInt)
  {
    nPopupState = paramInt;
    if ((nCurStateOff == 1) && (paramInt == 0)) {
      cSound.stopSound();
    }
  }
  
  public void setPressedPointer(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    nPointerX = paramInt1;
    nPointerY = paramInt2;
    isPressed = paramBoolean;
    nPointerFrame = 0;
  }
  
  public void setReleasedPointer(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    nPointerX = paramInt1;
    nPointerY = paramInt2;
    isReleased = paramBoolean;
    nPointerFrame = 0;
  }
  
  public void setState(int paramInt1, int paramInt2)
  {
    nPrevStateSeg = nCurStateSeg;
    nPrevStateOff = nCurStateOff;
    nCurStateSeg = paramInt1;
    nCurStateOff = paramInt2;
    setPressedPointer(0, 0, false);
    setReleasedPointer(0, 0, false);
    if (nPrevStateSeg != nCurStateSeg) {
      isResource = true;
    }
    setBottomButton(paramInt1, paramInt2);
  }
  
  public void setTargetLcd(int paramInt)
  {
    nTargetLcd = paramInt;
  }
}
