import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DrawPlay02
  implements Drawable
{
  private final int BLOCK_BUTTON_HEIGHT = 64;
  private final int BLOCK_BUTTON_WIDTH = 67;
  private final int BLOCK_DIRECT_LEFT = 0;
  private final int BLOCK_DIRECT_RIGHT = 1;
  private final int BLOCK_EVENT_HEIGHT = 100;
  private final int BLOCK_EVENT_WIDTH = 100;
  private final int BLOCK_SIDE = 2;
  private final int BLOCK_SIDE_HEIGHT = 40;
  private final int BLOCK_SIDE_WIDTH = 40;
  private final int BLOCK_TYPE_NORMAL = 0;
  private final int BLOCK_TYPE_TARGET = 1;
  private final int[][] BUTTON_POSITION;
  private final int BUTTON_TYPE_NORMAL = 0;
  private final int BUTTON_TYPE_PRESS = 1;
  private final int CIRCLE_ACTIVE = 10;
  private final int CIRCLE_ACTIVE_POINT = 30;
  private final int CIRCLE_HEIGHT = 40;
  private final int CIRCLE_WIDTH = 40;
  private final int DEFAULT_BALL_SPEED = 2;
  private final int DEFAULT_SCROLL_SPEED = 2;
  private final int EVENT_HIGH = 30;
  private final int MAX_BLOCK = 9;
  private final int MAX_BUTTON = 5;
  private final int MAX_CIRCLE = 3;
  private final int MAX_MOVE_PIXEL = 10;
  private final int MAX_STAR = 3;
  private final int METER_PIXEL = 20;
  private final int NANA_EVENT_ENDFRAME = 12;
  private final int NANA_HEIGHT = 87;
  private final int NOTHING_PRESS_BUTTON = -1;
  private final int NOTHING_PRESS_TIME = 50000;
  private final int STAR_ACTIVE = 50;
  private final int STAR_HEIGHT = 44;
  private final int STAR_MAX_SPEED = 10;
  private final int STAR_MIN_SPEED = 6;
  private final int STAR_WIDTH = 44;
  private DrawPlay02.Ball cBall;
  private BaseCanvas cBc;
  private DrawPlay02.Block[] cBlock;
  private DrawPlay02.Button[] cButton;
  private DrawPlay02.Circle[] cCircle;
  private Point cPoint;
  private DrawPlay02.Star[] cStar;
  private long dwPressButtonTime;
  private boolean isCircleHit;
  private boolean isNanaAction;
  private boolean isNanaEvent;
  private boolean isNanaEventEnd;
  private boolean isNanaEventFrame;
  private int nMarkFrame;
  private int nMeter;
  private int nNanaEventCount;
  private int nNanaEventFrame;
  private int nNanaFrame;
  private int nNanaPosY;
  private int nPressButtonIdx;
  private int nScrollPixel;
  private int nTarget;
  
  public DrawPlay02(BaseCanvas paramBaseCanvas)
  {
    int[] arrayOfInt1 = { -70, -30 };
    int[] arrayOfInt2 = { 70, 30 };
    int[] arrayOfInt3 = { 0, 0 };
    BUTTON_POSITION = new int[][] { arrayOfInt1, { 70, -30 }, { -70, 30 }, arrayOfInt2, arrayOfInt3 };
    cBc = paramBaseCanvas;
    cPoint = cPoint.getInstance();
    cBall = new DrawPlay02.Ball();
    cBlock = new DrawPlay02.Block[2];
    cCircle = new DrawPlay02.Circle[3];
    cStar = new DrawPlay02.Star[3];
    cButton = new DrawPlay02.Button[5];
    for (int i = 0; i < 2; i++) {
      cBlock[i] = new DrawPlay02.Block();
    }
    for (i = 0; i < 3; i++) {
      cCircle[i] = new DrawPlay02.Circle();
    }
    for (i = 0; i < 3; i++) {
      cStar[i] = new DrawPlay02.Star();
    }
    for (i = 0; i < 5; i++) {
      cButton[i] = new DrawPlay02.Button();
    }
  }
  
  private void drawBall(Graphics paramGraphics)
  {
    int i;
    if (cBall.isHit)
    {
      Image localImage = cBc.cRes.iEffect[0];
      int j = cBall.nPosX;
      if (cBall.nDirect == 0)
      {
        i = 10;
        paramGraphics.drawImage(localImage, j + i, cBall.nPosY, 3);
        paramGraphics.drawImage(cBc.cRes.iObject[4], cBall.nPosX, cBall.nPosY, 3);
        cBall.isHit = false;
      }
    }
    for (;;)
    {
      return;
      i = -10;
      break;
      paramGraphics.drawImage(cBc.cRes.iObject[(cBall.nFrame % 4)], cBall.nPosX, cBall.nPosY, 3);
      paramGraphics = cBall;
      nFrame += 1;
      if (cBall.nFrame % 4 == 0) {
        cBall.nFrame = 0;
      }
    }
  }
  
  private void drawBlock(Graphics paramGraphics)
  {
    int i3 = -1;
    int n = -1;
    int k = 0;
    int j = 0;
    int i = 0;
    if (i < 9)
    {
      int m;
      label56:
      int i1;
      label92:
      int i2;
      int i4;
      switch (cBlock[0].nType[i])
      {
      default: 
        m = i3;
        switch (cBlock[1].nType[i])
        {
        default: 
          i1 = n;
          i3 = m;
          n = i1;
          i2 = k;
          i4 = j;
          if (isNanaEvent) {
            switch (cBlock[0].nType[i])
            {
            default: 
              n = i1;
              label152:
              switch (cBlock[1].nType[i])
              {
              default: 
                i4 = j;
                i2 = k;
                i3 = m;
              }
              break;
            }
          }
          break;
        }
        break;
      }
      for (;;)
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[i4], 40, cBlock[0].nPosY[i], 10);
        paramGraphics.drawImage(cBc.cRes.iPlay[i2], 200, cBlock[1].nPosY[i], 6);
        i++;
        k = i2;
        j = i4;
        break;
        j = cBlock[0].nKind[i] + 5;
        m = i3;
        break label56;
        m = i3;
        if (nPressButtonIdx == cBlock[0].nKind[i])
        {
          m = i;
          n = 0;
        }
        j = cBlock[0].nKind[i] + 0;
        break label56;
        k = cBlock[1].nKind[i] + 5;
        i1 = n;
        break label92;
        if (nPressButtonIdx == cBlock[1].nKind[i])
        {
          m = i;
          n = 1;
        }
        k = cBlock[1].nKind[i] + 0;
        i1 = n;
        break label92;
        j = 9;
        n = i1;
        break label152;
        n = 0;
        j = 4;
        m = i;
        break label152;
        i2 = 9;
        i3 = m;
        i4 = j;
        continue;
        n = 1;
        i2 = 4;
        i3 = i;
        i4 = j;
      }
    }
    if (isNanaEvent) {
      if ((n == 0) && (nPressButtonIdx != -1)) {
        paramGraphics.drawImage(cBc.cRes.iPlay[29], 0, cBlock[0].nPosY[i3], 6);
      }
    }
    for (;;)
    {
      return;
      if ((n == 1) && (nPressButtonIdx != -1))
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[29], 240, cBlock[1].nPosY[i3], 10);
        continue;
        if ((n == 0) && (cBlock[0].nType[i3] == 1) && (nPressButtonIdx == cBlock[0].nKind[i3]))
        {
          i = cBlock[0].nKind[i3];
          paramGraphics.drawImage(cBc.cRes.iPlay[(i + 25)], 0, cBlock[0].nPosY[i3], 6);
        }
        else if ((n == 1) && (cBlock[1].nType[i3] == 1) && (nPressButtonIdx == cBlock[1].nKind[i3]))
        {
          i = cBlock[1].nKind[i3];
          paramGraphics.drawImage(cBc.cRes.iPlay[(i + 25)], 240, cBlock[1].nPosY[i3], 10);
        }
      }
    }
  }
  
  private void drawBoard(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iBG[0], 0, 0, 20);
  }
  
  private void drawButton(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iBG[1], 0, 224, 20);
    int i = 0;
    int j = 0;
    if (j < 5)
    {
      int k;
      if (isNanaEvent)
      {
        k = j + 20;
        if (cButton[j].nType == 0) {
          i = k;
        }
      }
      for (;;)
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[i], cButton[j].nPosX, cButton[j].nPosY, 3);
        j++;
        break;
        i = k;
        if (cButton[j].nType == 1)
        {
          i = k;
          if (k == 24)
          {
            i = 19;
            continue;
            if (cButton[j].nType == 0) {
              i = j + 10;
            } else if (cButton[j].nType == 1) {
              i = j + 15;
            }
          }
        }
      }
    }
  }
  
  private void drawCircle(Graphics paramGraphics)
  {
    for (int i = 0; i < 3; i++) {
      paramGraphics.drawImage(cBc.cRes.iObject[5], cCircle[i].nPosX, cCircle[i].nPosY, 3);
    }
  }
  
  private void drawGameOver(Graphics paramGraphics)
  {
    drawPlay(paramGraphics);
    cBc.drawGameOver(paramGraphics);
  }
  
  private void drawMeter(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iEffect[3], 180, 42, 17);
    cBc.drawNumber(paramGraphics, cBc.cRes.iPlayResultNum, nMeter / 20, 170, 40, 0, 4, false);
    if (isNanaEvent)
    {
      int i = cBc.getAnimationFrame(nMarkFrame, 4, 2);
      nMarkFrame += 1;
      if (i == 0) {
        paramGraphics.drawImage(cBc.cRes.iMark[1], 120, 60, 17);
      }
      cBc.drawNumber(paramGraphics, cBc.cRes.iPlayResultNum, nNanaEventCount * 2 * 30 - nMeter / 20, 136, 76, 0, 2, false);
    }
  }
  
  private void drawNana(Graphics paramGraphics)
  {
    if (nNanaPosY >= 87) {}
    for (;;)
    {
      return;
      paramGraphics.drawImage(cBc.cRes.iObject[8], 0, nNanaPosY + 224, 36);
      if (!isNanaAction) {
        paramGraphics.drawImage(cBc.cRes.iObject[7], 120 - cBc.cRes.iObject[7].getWidth() / 2 + 10, nNanaPosY + 224, 33);
      }
      if (nNanaFrame < 10) {
        paramGraphics.drawImage(cBc.cRes.iObject[6], 120 - cBc.cRes.iObject[6].getWidth() / 2, nNanaPosY + 224, 33);
      } else if (nNanaFrame == 10) {
        paramGraphics.drawImage(cBc.cRes.iObject[7], 120 - cBc.cRes.iObject[7].getWidth() / 2 + 10, nNanaPosY + 224, 33);
      }
    }
  }
  
  private void drawNanaEvent(Graphics paramGraphics)
  {
    int k;
    int i;
    int m;
    int j;
    if (isNanaEventFrame)
    {
      k = 240 - cBc.cRes.iEffect[6].getWidth();
      i = 112 - cBc.cRes.iEffect[6].getHeight() + cBc.cRes.iEffect[5].getHeight();
      m = 120 - cBc.cRes.iEffect[7].getWidth() / 2;
      j = cBc.cRes.iEffect[7].getHeight() / 2 + 112 + 16;
      paramGraphics.drawImage(cBc.cRes.iEffect[5], 0, 112, 20);
      if (nNanaEventFrame == 0) {
        nNanaEventFrame = 1;
      }
    }
    for (;;)
    {
      return;
      if (nNanaEventFrame < 3)
      {
        paramGraphics.drawImage(cBc.cRes.iEffect[6], k + cBc.cRes.iEffect[6].getWidth() / nNanaEventFrame, i, 20);
        paramGraphics.drawImage(cBc.cRes.iEffect[7], m - cBc.cRes.iEffect[7].getWidth() / nNanaEventFrame, j, 3);
        nNanaEventFrame += 1;
      }
      else if (nNanaEventFrame < 12)
      {
        paramGraphics.drawImage(cBc.cRes.iEffect[6], k, i, 20);
        paramGraphics.drawImage(cBc.cRes.iEffect[7], m, j, 3);
        nNanaEventFrame += 1;
      }
      else if (nNanaEventFrame == 12)
      {
        paramGraphics.drawImage(cBc.cRes.iEffect[6], k, i, 20);
        paramGraphics.drawImage(cBc.cRes.iEffect[7], m, j, 3);
        nNanaEventFrame = 0;
        isNanaEventFrame = false;
        continue;
        if (isNanaEventEnd)
        {
          nNanaEventFrame += 1;
          if (nNanaEventFrame == 12)
          {
            for (i = 0; i < 5; i++) {
              cButton[i].nType = 0;
            }
            isNanaEventEnd = false;
            nNanaEventFrame = 0;
            cBc.setEvent(true);
          }
        }
      }
    }
  }
  
  private void drawPlay(Graphics paramGraphics)
  {
    proc();
    drawBoard(paramGraphics);
    drawNana(paramGraphics);
    drawBlock(paramGraphics);
    drawCircle(paramGraphics);
    drawStar(paramGraphics);
    drawBall(paramGraphics);
    drawMeter(paramGraphics);
    drawButton(paramGraphics);
    drawNanaEvent(paramGraphics);
    cBc.drawHeart(paramGraphics);
    cBc.drawCombo(paramGraphics);
    cBc.drawPointAnimation(paramGraphics);
    cBc.drawScoreBar(paramGraphics);
  }
  
  private void drawReady(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
    drawNana(paramGraphics);
    drawBlock(paramGraphics);
    drawBall(paramGraphics);
    drawMeter(paramGraphics);
    drawButton(paramGraphics);
    cBc.drawReadyStart(paramGraphics);
    cBc.drawScoreBar(paramGraphics);
  }
  
  private void drawResult(Graphics paramGraphics)
  {
    int i = cBc.getAnimationFrame(cBc.nResultAniFrame, 4, 2);
    BaseCanvas localBaseCanvas = cBc;
    nResultAniFrame += 1;
    cBc.drawGameResultBack(paramGraphics);
    if (cBc.isNewRecord)
    {
      switch (i)
      {
      }
      for (;;)
      {
        cBc.drawGameResultForward(paramGraphics);
        return;
        paramGraphics.drawImage(cBc.cRes.iResult[0], 120, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 153, 132, 20);
        continue;
        paramGraphics.drawImage(cBc.cRes.iResult[1], 120, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 150, 136, 20);
      }
    }
    switch (i)
    {
    }
    for (;;)
    {
      paramGraphics.drawImage(cBc.cRes.iResult[4], 81, 266, 20);
      break;
      paramGraphics.drawImage(cBc.cRes.iResult[2], 120, 213, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 153, 132, 20);
      continue;
      paramGraphics.drawImage(cBc.cRes.iResult[3], 120, 213, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 150, 136, 20);
    }
  }
  
  private void drawStar(Graphics paramGraphics)
  {
    int i = 0;
    if (i < 3)
    {
      if (cStar[i].isActive)
      {
        DrawPlay02.Star localStar = cStar[i];
        nFrame += 1;
        if (!cStar[i].isHit) {
          break label135;
        }
        if (cStar[i].nFrame / 2 % 2 == 0) {
          paramGraphics.drawImage(cBc.cRes.iStar[cStar[i].nType], cStar[i].nPosX, cStar[i].nPosY, 3);
        }
        if (cStar[i].nFrame == 10) {
          initStar(i);
        }
      }
      for (;;)
      {
        i++;
        break;
        label135:
        int j = cStar[i].nFrame / 2;
        paramGraphics.drawImage(cBc.cRes.iStar[(j % 3 * 3 + cStar[i].nType)], cStar[i].nPosX, cStar[i].nPosY, 3);
      }
    }
  }
  
  private void initBall()
  {
    cBall.nPosX = 120;
    cBall.nPosY = (224 - cBc.cRes.iObject[0].getHeight() / 2 - 2);
    cBall.nDirect = 1;
    cBall.nSpeed = 2;
    cBall.nWidth = cBc.cRes.iObject[0].getWidth();
    cBall.nHeight = cBc.cRes.iObject[0].getHeight();
    cBall.isHit = false;
  }
  
  private void initBlock()
  {
    for (int i = 0; i < 9; i++) {
      initBlock(i);
    }
    nTarget = 5;
    cBlock[1].nType[nTarget] = 1;
  }
  
  private void initBlock(int paramInt)
  {
    cBlock[0].nType[paramInt] = 0;
    cBlock[1].nType[paramInt] = 0;
    cBlock[0].nKind[paramInt] = cBc.cUtil.getRandomInt(0, 4);
    cBlock[1].nKind[paramInt] = cBc.cUtil.getRandomInt(0, 4);
    cBlock[0].nPosY[paramInt] = (paramInt * 40 - 40);
    cBlock[1].nPosY[paramInt] = (paramInt * 40 - 40);
  }
  
  private void initButton()
  {
    for (int i = 0; i < 5; i++) {
      initButton(i);
    }
  }
  
  private void initButton(int paramInt)
  {
    cButton[paramInt].nType = 0;
    cButton[paramInt].nIdx = paramInt;
    cButton[paramInt].nPosX = (BUTTON_POSITION[paramInt][0] + 120);
    cButton[paramInt].nPosY = (BUTTON_POSITION[paramInt][1] + 301 - 15);
    cButton[paramInt].nWidth = 0;
    cButton[paramInt].nHeight = 0;
    cButton[paramInt].isPress = false;
  }
  
  private void initCircle()
  {
    for (int i = 0; i < 3; i++) {
      initCircle(i);
    }
  }
  
  private void initCircle(int paramInt)
  {
    cCircle[paramInt].nPosX = (cBc.cUtil.getRandomInt(3, 5) * 40 - 20);
    cCircle[paramInt].nPosY = -40;
    cCircle[paramInt].nSpeed = (cBc.cUtil.getRandomInt(1, 3) * 4);
    cCircle[paramInt].isHit = false;
    cCircle[paramInt].isActive = false;
  }
  
  private void initStar()
  {
    for (int i = 0; i < 3; i++) {
      initStar(i);
    }
  }
  
  private void initStar(int paramInt)
  {
    cStar[paramInt].nType = cPoint.getType();
    cStar[paramInt].nWidth = cBc.cRes.iStar[cStar[paramInt].nType].getWidth();
    cStar[paramInt].nHeight = cBc.cRes.iStar[cStar[paramInt].nType].getHeight();
    cStar[paramInt].nPosX = (cBc.cUtil.getRandomInt(2, 6) * 40 - 20);
    cStar[paramInt].nPosY = -44;
    cStar[paramInt].nSpeed = (cBc.cUtil.getRandomInt(1, 3) * 4);
    cStar[paramInt].nSpeed = cBc.cUtil.getRandomInt(6, 10);
    cStar[paramInt].isActive = false;
    cStar[paramInt].isHit = false;
  }
  
  private void proc()
  {
    int j = cBall.nWidth / 2;
    if ((cBc.isLock()) || (isNanaEventFrame) || (isNanaEventEnd)) {}
    for (;;)
    {
      return;
      if (cBc.nCurStateOff == 1) {
        nNanaFrame += 1;
      }
      if (!isNanaAction) {
        nNanaPosY += nScrollPixel;
      }
      if (nNanaFrame == 10) {
        isNanaAction = false;
      }
      if (!isNanaAction)
      {
        Object localObject;
        for (int i = 0; i < 9; i++)
        {
          localObject = cBlock[0].nPosY;
          localObject[i] += nScrollPixel;
          localObject = cBlock[1].nPosY;
          localObject[i] += nScrollPixel;
        }
        nMeter += nScrollPixel;
        i = 10 - cBall.nSpeed;
        switch (cBall.nDirect)
        {
        default: 
          cBall.nMovePixelY = ((cBlock[cBall.nDirect].nPosY[nTarget] - cBall.nPosY) / 2);
          localObject = cBall;
          nPosX += cBall.nMovePixelX;
          localObject = cBall;
          nPosY += cBall.nMovePixelY;
          if (cBall.nPosX <= j + 40)
          {
            cBc.cSound.playSound(12, 1);
            cBall.isHit = true;
            cBall.nPosX = 40;
            procBall(1);
            label336:
            if (System.currentTimeMillis() - dwPressButtonTime > 50000L)
            {
              if (nPressButtonIdx != -1) {
                cButton[nPressButtonIdx].nType = 0;
              }
              nPressButtonIdx = -1;
            }
            i = 0;
            label379:
            if (i >= 3) {
              break label766;
            }
            if (!cCircle[i].isActive) {
              break label706;
            }
            localObject = cCircle[i];
            nPosY += cCircle[i].nSpeed;
            if (cCircle[i].nPosY - 20 > 224) {
              initCircle(i);
            }
            label444:
            if ((!cCircle[i].isHit) && (cBall.nPosX > cCircle[i].nPosX - 20) && (cBall.nPosX < cCircle[i].nPosX + 20) && (cBall.nPosY > cCircle[i].nPosY - 20) && (cBall.nPosY < cCircle[i].nPosY + 20))
            {
              isCircleHit = true;
              cBc.cSound.playSound(13, 1);
              cCircle[i].isHit = true;
              switch (cBall.nDirect)
              {
              }
            }
          }
          break;
        }
        for (;;)
        {
          i++;
          break label379;
          cBall.nMovePixelX = ((200 - cBall.nPosX) / i);
          break;
          cBall.nMovePixelX = (-(cBall.nPosX - 40) / i);
          break;
          if (cBall.nPosX < 200 - j) {
            break label336;
          }
          cBc.cSound.playSound(12, 1);
          cBall.isHit = true;
          cBall.nPosX = 200;
          procBall(0);
          break label336;
          label706:
          if ((cPoint.nPoint[2] <= 30) || (cBc.cUtil.getRandomInt(0, 10) != 5)) {
            break label444;
          }
          cCircle[i].isActive = true;
          break label444;
          procBall(1);
          continue;
          procBall(0);
        }
        label766:
        i = 0;
        if (i < 3)
        {
          if (cStar[i].isActive)
          {
            localObject = cStar[i];
            nPosY += cCircle[i].nSpeed;
            if (cStar[i].nPosY - 22 > 224)
            {
              cPoint.resetComboCount();
              initStar(i);
            }
          }
          for (;;)
          {
            if ((!cStar[i].isHit) && (cBall.nPosX > cStar[i].nPosX - 22) && (cBall.nPosX < cStar[i].nPosX + 22) && (cBall.nPosY > cStar[i].nPosY - 22) && (cBall.nPosY < cStar[i].nPosY + 22))
            {
              cPoint.increaseComboCount();
              cPoint.increasePointTableStar(cBc.nCurStateSeg, cStar[i].nType);
              cPoint.setPointAnimation(cPoint.nCurPoint, cStar[i].nPosX, cStar[i].nPosY);
              cStar[i].isHit = true;
              cStar[i].nFrame = 0;
            }
            i++;
            break;
            if (cBc.cUtil.getRandomInt(0, 50) == 25) {
              cStar[i].isActive = true;
            }
          }
        }
        if (cBlock[0].nPosY[8] % 40 == 0)
        {
          System.arraycopy(cBlock[0].nPosY, 0, cBlock[0].nPosY, 1, 8);
          System.arraycopy(cBlock[1].nPosY, 0, cBlock[1].nPosY, 1, 8);
          System.arraycopy(cBlock[0].nType, 0, cBlock[0].nType, 1, 8);
          System.arraycopy(cBlock[1].nType, 0, cBlock[1].nType, 1, 8);
          System.arraycopy(cBlock[0].nKind, 0, cBlock[0].nKind, 1, 8);
          System.arraycopy(cBlock[1].nKind, 0, cBlock[1].nKind, 1, 8);
          nTarget += 1;
          initBlock(0);
          setGrade(cPoint.nPoint[2]);
        }
        cBc.setGrade(cPoint.nPoint[2]);
      }
    }
  }
  
  private void procBall(int paramInt)
  {
    if (cBall.isHit) {
      if (nPressButtonIdx == -1) {
        cBc.setState(2002, 2);
      }
    }
    for (;;)
    {
      return;
      if ((cBlock[cBall.nDirect].nKind[nTarget] != nPressButtonIdx) && (!isNanaEvent))
      {
        cBc.setState(2002, 2);
      }
      else
      {
        cPoint.increasePoint(cBc.nCurStateSeg, cBc.cUtil.getRandomInt(1, 4));
        cPoint.setPointAnimation(cPoint.nCurPoint, cBall.nPosX, cBall.nPosY);
        cButton[nPressButtonIdx].nType = 0;
        nPressButtonIdx = -1;
        dwPressButtonTime = 0L;
        if (isCircleHit)
        {
          cBc.setEvent(true);
          isCircleHit = false;
        }
        for (int i = 0; i < 3; i++) {
          cCircle[i].isHit = false;
        }
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          cBall.nDirect = 0;
          cBlock[1].nType[nTarget] = 0;
          paramInt = cBc.cUtil.getRandomInt(2, 5);
          if (paramInt < nTarget) {
            nTarget = paramInt;
          }
          cBlock[0].nType[nTarget] = 1;
          break;
        case 1: 
          cBall.nDirect = 1;
          cBlock[0].nType[nTarget] = 0;
          paramInt = cBc.cUtil.getRandomInt(2, 5);
          if (paramInt < nTarget) {
            nTarget = paramInt;
          }
          cBlock[1].nType[nTarget] = 1;
        }
      }
    }
  }
  
  private void setGrade(int paramInt)
  {
    if (cBc.nGrade == 0)
    {
      cBall.nSpeed = 2;
      nScrollPixel = 2;
      if (nMeter / 20 / 30 % 2 != 1) {
        break label247;
      }
      if (!isNanaEvent)
      {
        isNanaEvent = true;
        isNanaEventFrame = true;
        nNanaEventCount += 1;
      }
    }
    for (;;)
    {
      return;
      if (cBc.nGrade == 1)
      {
        cBall.nSpeed = 2;
        nScrollPixel = 4;
        break;
      }
      if (cBc.nGrade == 2)
      {
        cBall.nSpeed = 3;
        nScrollPixel = 2;
        break;
      }
      if (cBc.nGrade == 3)
      {
        cBall.nSpeed = 3;
        nScrollPixel = 4;
        break;
      }
      if (cBc.nGrade == 4)
      {
        cBall.nSpeed = 4;
        nScrollPixel = 2;
        break;
      }
      if (cBc.nGrade == 5)
      {
        cBall.nSpeed = 4;
        nScrollPixel = 4;
        break;
      }
      if (cBc.nGrade == 6)
      {
        cBall.nSpeed = 4;
        nScrollPixel = 5;
        break;
      }
      cBall.nSpeed = 5;
      nScrollPixel = 8;
      break;
      label247:
      if ((nMeter / 20 > 30) && (isNanaEvent))
      {
        isNanaEvent = false;
        isNanaEventEnd = true;
      }
    }
  }
  
  private void setPressButton(int paramInt)
  {
    if (nPressButtonIdx != -1) {
      cButton[nPressButtonIdx].nType = 0;
    }
    nPressButtonIdx = paramInt;
    dwPressButtonTime = System.currentTimeMillis();
    if (nPressButtonIdx != -1) {
      cButton[nPressButtonIdx].nType = 1;
    }
  }
  
  public void drawManager(Graphics paramGraphics)
  {
    cBc.drawClear(paramGraphics);
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      cBc.drawBottomButton(paramGraphics);
      return;
      drawReady(paramGraphics);
      continue;
      drawPlay(paramGraphics);
      continue;
      drawGameOver(paramGraphics);
      continue;
      drawResult(paramGraphics);
    }
  }
  
  public void init()
  {
    cBc.setGrade(0);
    cPoint.initPoint();
    cPoint.resetComboCount();
    initBall();
    initBlock();
    initCircle();
    initStar();
    initButton();
    isNanaEvent = false;
    nScrollPixel = 2;
    isNanaAction = true;
    nNanaFrame = 0;
    nNanaPosY = 0;
    nNanaEventFrame = 0;
    isNanaEventFrame = false;
    isNanaEventEnd = false;
    nNanaEventCount = 0;
    isCircleHit = false;
    nMeter = 0;
    nMarkFrame = 0;
    nPressButtonIdx = -1;
    dwPressButtonTime = 0L;
  }
  
  public void pointerDragged(int paramInt1, int paramInt2)
  {
    paramInt1 = cBc.nCurStateOff;
  }
  
  public void pointerPressed(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      if (isNanaEvent)
      {
        if (cBc.isPointer(paramInt1, paramInt2, cButton[4].nPosX - 50, cButton[4].nPosY - 50, cButton[4].nPosX + 50, cButton[4].nPosY + 50)) {
          setPressButton(4);
        }
      }
      else if (cBc.isPointer(paramInt1, paramInt2, cButton[0].nPosX - 33, cButton[0].nPosY - 32, cButton[0].nPosX + 33, cButton[0].nPosY + 32)) {
        setPressButton(0);
      } else if (cBc.isPointer(paramInt1, paramInt2, cButton[1].nPosX - 33, cButton[1].nPosY - 32, cButton[1].nPosX + 33, cButton[1].nPosY + 32)) {
        setPressButton(1);
      } else if (cBc.isPointer(paramInt1, paramInt2, cButton[2].nPosX - 33, cButton[2].nPosY - 32, cButton[2].nPosX + 33, cButton[2].nPosY + 32)) {
        setPressButton(2);
      } else if (cBc.isPointer(paramInt1, paramInt2, cButton[3].nPosX - 33, cButton[3].nPosY - 32, cButton[3].nPosX + 33, cButton[3].nPosY + 32)) {
        setPressButton(3);
      }
    }
  }
  
  public void pointerReleased(int paramInt1, int paramInt2)
  {
    paramInt1 = cBc.nCurStateOff;
  }
  
  class Ball
  {
    boolean isHit;
    int nDirect;
    int nFrame;
    int nHeight;
    int nMovePixelX;
    int nMovePixelY;
    int nPosX;
    int nPosY;
    int nSpeed;
    int nWidth;
    
    Ball() {}
  }
  
  class Block
  {
    int[] nKind = new int[9];
    int[] nPosY = new int[9];
    int[] nType = new int[9];
    
    Block() {}
  }
  
  class Button
  {
    boolean isPress;
    int nHeight;
    int nIdx;
    int nPosX;
    int nPosY;
    int nType;
    int nWidth;
    
    Button() {}
  }
  
  class Circle
  {
    boolean isActive;
    boolean isHit;
    int nPosX;
    int nPosY;
    int nSpeed;
    
    Circle() {}
  }
  
  class Star
  {
    boolean isActive;
    boolean isHit;
    int nFrame;
    int nHeight;
    int nPosX;
    int nPosY;
    int nSpeed;
    int nType;
    int nWidth;
    
    Star() {}
  }
}
