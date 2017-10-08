import java.lang.reflect.Array;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DrawPlay05
  implements Drawable
{
  private final int BALL_DEFAULT_SLOPE = 8;
  private final int BALL_DEFAULT_SPEED = 14;
  private final int BALL_HEIGHT = 18;
  private final int BALL_MAX_SPEED = 20;
  private final int BALL_WIDTH = 18;
  private final int BLOCK_HEIGHT = 24;
  private final int BLOCK_KIND = 10;
  private final long BLOCK_PUSH_TIME = 14000L;
  private final int BLOCK_WIDTH = 34;
  private int BLOCK_X;
  private int BLOCK_Y;
  private final int BOOM_TYPE_LR = 1;
  private final int BOOM_TYPE_UD = 0;
  private final int DROP_AREA_PIECE = 5;
  private final int MAX_BALL = 3;
  private final int MAX_STAR = 5;
  private final int MERRY_AROUND_HEIGHT = 60;
  private final int MERRY_AROUND_WIDTH = 60;
  private final int MERRY_DEFAULT_SPEED = 6;
  private final int MERRY_HEIGHT = 65;
  private final int MERRY_WIDTH = 60;
  private final int STAR_MAX_SPEED = 10;
  private final int STAR_MIN_SPEED = 6;
  private final int STAR_TIME = 5000;
  private DrawPlay05.Ball[] cBall;
  private BaseCanvas cBc;
  private DrawPlay05.Board cBoard;
  private DrawPlay05.Merry cMerry;
  private Point cPoint;
  private DrawPlay05.Star[] cStar;
  private long dwGameLockTime;
  private long dwStarTime;
  private boolean isBoom;
  private boolean isGameLockTime;
  private boolean isPushBlock;
  private int nBoomType;
  private int nPushCount;
  
  public DrawPlay05(BaseCanvas paramBaseCanvas)
  {
    cBc = paramBaseCanvas;
    cPoint = cPoint.getInstance();
    BLOCK_X = 7;
    BLOCK_Y = 9;
    cBall = new DrawPlay05.Ball[3];
    cMerry = new DrawPlay05.Merry();
    cStar = new DrawPlay05.Star[5];
    for (int i = 0; i < 3; i++) {
      cBall[i] = new DrawPlay05.Ball();
    }
    for (i = 0; i < 5; i++) {
      cStar[i] = new DrawPlay05.Star();
    }
    cBoard = new DrawPlay05.Board();
    paramBaseCanvas = cBoard;
    i = BLOCK_Y;
    int j = BLOCK_X;
    nBlock = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i, j }));
    paramBaseCanvas = cBoard;
    j = BLOCK_Y;
    i = BLOCK_X;
    nBlockFrame = ((int[][])Array.newInstance(Integer.TYPE, new int[] { j, i }));
    isGameLockTime = false;
    dwGameLockTime = 0L;
  }
  
  private void boomBlock(int paramInt)
  {
    isBoom = true;
    nBoomType = paramInt;
  }
  
  private void drawBall(Graphics paramGraphics)
  {
    paramGraphics.setColor(0);
    for (int i = 0; i < 3; i++) {
      if (cBall[i].isActive)
      {
        if (cBall[i].isHit)
        {
          paramGraphics.drawImage(cBc.cRes.iEffect[0], cBall[i].nPosX + cBall[i].nEffPosX, cBall[i].nPosY + cBall[i].nEffPosY, 3);
          cBall[i].isHit = false;
        }
        paramGraphics.drawImage(cBc.cRes.iPlay[0], cBall[i].nPosX, cBall[i].nPosY, 3);
      }
    }
  }
  
  private void drawBlock(Graphics paramGraphics)
  {
    for (int i = 0; i < BLOCK_Y; i++) {
      for (int j = 0; j < BLOCK_X; j++) {
        drawBlock(paramGraphics, i, j);
      }
    }
  }
  
  private void drawBlock(Graphics paramGraphics, int paramInt1, int paramInt2)
  {
    if (cBoard.nBlock[paramInt1][paramInt2] == 0) {}
    for (;;)
    {
      return;
      if (cBoard.nBlockFrame[paramInt1][paramInt2] == 0)
      {
        paramGraphics.drawImage(cBc.cRes.iObject[((cBoard.nBlock[paramInt1][paramInt2] - 1) * 2)], paramInt2 * 34 + 1, paramInt1 * 24 + nPushCount, 20);
      }
      else if (cBoard.nBlockFrame[paramInt1][paramInt2] < 3)
      {
        paramGraphics.drawImage(cBc.cRes.iObject[((cBoard.nBlock[paramInt1][paramInt2] - 1) * 2 + 1)], paramInt2 * 34 + 1, paramInt1 * 24 + nPushCount, 20);
        paramGraphics = cBoard.nBlockFrame[paramInt1];
        paramGraphics[paramInt2] += 1;
      }
      else if (cBoard.nBlockFrame[paramInt1][paramInt2] < 5)
      {
        paramGraphics.drawImage(cBc.cRes.iEffect[1], paramInt2 * 34 + 3, paramInt1 * 24 + nPushCount, 20);
        paramGraphics = cBoard.nBlockFrame[paramInt1];
        paramGraphics[paramInt2] += 1;
      }
      else if (cBoard.nBlockFrame[paramInt1][paramInt2] == 5)
      {
        cBoard.nBlock[paramInt1][paramInt2] = 0;
        cBoard.nBlockFrame[paramInt1][paramInt2] = 0;
      }
    }
  }
  
  private void drawBoard(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iBG[0], 0, 224, 36);
    paramGraphics.drawImage(cBc.cRes.iBG[1], 0, 224, 20);
  }
  
  private void drawGameOver(Graphics paramGraphics)
  {
    drawPlay(paramGraphics);
    cBc.drawGameOver(paramGraphics);
  }
  
  private void drawMerry(Graphics paramGraphics)
  {
    if (cMerry.isJump) {
      if (cMerry.nDirect == 1) {
        paramGraphics.drawImage(cBc.cRes.iPlay[12], cMerry.nPosX, cMerry.nPosY, 3);
      }
    }
    for (;;)
    {
      paramGraphics.drawImage(cBc.cRes.iTZone, cMerry.nPosX, cMerry.nPosY, 3);
      return;
      if (cMerry.nDirect == 2)
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[6], cMerry.nPosX, cMerry.nPosY, 3);
        continue;
        if (cMerry.nDirect == 1) {
          paramGraphics.drawImage(cBc.cRes.iPlay[(cMerry.nAniFrame + 7)], cMerry.nPosX, cMerry.nPosY, 3);
        } else if (cMerry.nDirect == 2) {
          paramGraphics.drawImage(cBc.cRes.iPlay[(cMerry.nAniFrame + 1)], cMerry.nPosX, cMerry.nPosY, 3);
        }
      }
    }
  }
  
  private void drawPanel(Graphics paramGraphics)
  {
    cBc.drawScoreBar(paramGraphics);
  }
  
  private void drawPlay(Graphics paramGraphics)
  {
    proc();
    drawBoard(paramGraphics);
    drawBlock(paramGraphics);
    drawStar(paramGraphics);
    drawBall(paramGraphics);
    drawMerry(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawHeart(paramGraphics);
    cBc.drawCombo(paramGraphics);
    cBc.drawPointAnimation(paramGraphics);
    cBc.drawMark(paramGraphics);
  }
  
  private void drawReady(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
    drawBlock(paramGraphics);
    drawMerry(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawReadyStart(paramGraphics);
  }
  
  private void drawResult(Graphics paramGraphics)
  {
    int i = cBc.getAnimationFrame(cBc.nResultAniFrame, 4, 2);
    BaseCanvas localBaseCanvas = cBc;
    nResultAniFrame += 1;
    cBc.drawGameResultBack(paramGraphics);
    if (cBc.isNewRecord) {
      switch (i)
      {
      }
    }
    for (;;)
    {
      cBc.drawGameResultForward(paramGraphics);
      return;
      paramGraphics.drawImage(cBc.cRes.iResult[0], 116, 215, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 142, 130, 20);
      continue;
      paramGraphics.drawImage(cBc.cRes.iResult[1], 116, 215, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 142, 134, 20);
      continue;
      switch (i)
      {
      default: 
        break;
      case 0: 
        paramGraphics.drawImage(cBc.cRes.iResult[2], 122, 215, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 138, 130, 20);
        break;
      case 1: 
        paramGraphics.drawImage(cBc.cRes.iResult[3], 122, 215, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 140, 134, 20);
      }
    }
  }
  
  private void drawStar(Graphics paramGraphics)
  {
    int i = 0;
    if (i < 5)
    {
      if (cStar[i].isActive)
      {
        DrawPlay05.Star localStar = cStar[i];
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
  
  private int getBlockType(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > BLOCK_X - 1) || (paramInt2 > BLOCK_Y - 1) || (paramInt1 < 0) || (paramInt2 < 0)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      return paramInt1;
      if (cBoard.nBlockFrame[paramInt2][paramInt1] != 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = cBoard.nBlock[paramInt2][paramInt1];
      }
    }
  }
  
  private void hitBlock(int paramInt1, int paramInt2, int paramInt3)
  {
    isBoom = false;
    int i = getBlockType(paramInt2, paramInt3);
    if (i < 10)
    {
      cPoint.increasePointTable(cBc.nCurStateSeg, i);
      cPoint.setPointAnimation(cPoint.nCurPoint, cBall[paramInt1].nPosX, cBall[paramInt1].nPosY);
      cBc.setGrade(cPoint.nPoint[5]);
      if (cBoard.nBlock[paramInt3][paramInt2] != 10) {
        break label224;
      }
    }
    label224:
    while (cBall[paramInt1].isHit)
    {
      return;
      switch (i)
      {
      default: 
        break;
      case 10: 
        cPoint.increasePoint(cBc.nCurStateSeg, 0);
        break;
      case 11: 
        increaseBall();
        cPoint.increasePoint(cBc.nCurStateSeg, 10);
        break;
      case 12: 
        boomBlock(1);
        cPoint.increasePoint(cBc.nCurStateSeg, 10);
        break;
      case 13: 
        boomBlock(0);
        cPoint.increasePoint(cBc.nCurStateSeg, 10);
        break;
      }
    }
    int j = 1;
    i = 0;
    while (i < BLOCK_X)
    {
      int k = j;
      if (cBoard.nBlock[paramInt3][i] != 10)
      {
        k = j;
        if (cBoard.nBlock[paramInt3][i] != 0)
        {
          k = j;
          if (i != paramInt2) {
            k = 0;
          }
        }
      }
      i++;
      j = k;
    }
    int[] arrayOfInt;
    if (j != 0)
    {
      cBc.setEvent(true);
      for (i = 0; i < BLOCK_X; i++) {
        if (cBoard.nBlock[paramInt3][i] == 10)
        {
          arrayOfInt = cBoard.nBlockFrame[paramInt3];
          arrayOfInt[i] += 1;
        }
      }
    }
    if (isBoom)
    {
      switch (nBoomType)
      {
      }
      for (;;)
      {
        isBoom = false;
        break;
        for (paramInt1 = 0; paramInt1 < BLOCK_X; paramInt1++) {
          if (cBoard.nBlock[paramInt3][paramInt1] != 0)
          {
            arrayOfInt = cBoard.nBlockFrame[paramInt3];
            arrayOfInt[paramInt1] += 1;
          }
        }
        for (paramInt1 = 0; paramInt1 < BLOCK_Y; paramInt1++) {
          if (cBoard.nBlock[paramInt1][paramInt2] != 0)
          {
            arrayOfInt = cBoard.nBlockFrame[paramInt1];
            arrayOfInt[paramInt2] += 1;
          }
        }
      }
    }
    cBall[paramInt1].isHit = true;
    switch (cBall[paramInt1].nDirect)
    {
    default: 
      label572:
      switch (cBall[paramInt1].nDirect2)
      {
      }
      break;
    }
    for (;;)
    {
      arrayOfInt = cBoard.nBlockFrame[paramInt3];
      arrayOfInt[paramInt2] += 1;
      break;
      cBall[paramInt1].nEffPosX = -6;
      break label572;
      cBall[paramInt1].nEffPosX = 6;
      break label572;
      cBall[paramInt1].nEffPosY = -6;
      continue;
      cBall[paramInt1].nEffPosY = 6;
    }
  }
  
  private void increaseBall()
  {
    for (int i = 0;; i++) {
      if (i < 3)
      {
        if (cBall[i].isActive) {}
      }
      else {
        for (int j = 0;; j++)
        {
          int n;
          int m;
          if (j < 3)
          {
            if (!cBall[j].isActive) {
              continue;
            }
            n = cMerry.nPosX;
            m = cMerry.nPosY;
            if (cBall[j].nDirect != 1) {
              break label104;
            }
          }
          label104:
          for (int k = 2;; k = 1)
          {
            setBall(i, n, m, k, 3, 14, cBall[j].nType, cBall[j].nLevel, true);
            return;
          }
        }
      }
    }
  }
  
  private void initBall()
  {
    for (int i = 0; i < 3; i++) {
      initBall(i);
    }
  }
  
  private void initBall(int paramInt)
  {
    cBall[paramInt].nType = 0;
    DrawPlay05.Ball localBall;
    if (paramInt == 0)
    {
      cBall[paramInt].isActive = true;
      cBall[paramInt].nPosX = 120;
      cBall[paramInt].nPosY = 261;
      localBall = cBall[paramInt];
      if (cBc.cUtil.getRandomInt(0, 2) != 0) {
        break label132;
      }
    }
    label132:
    for (int i = 1;; i = 2)
    {
      nDirect = i;
      cBall[paramInt].nDirect2 = 3;
      cBall[paramInt].nSpeed = 14;
      cBall[paramInt].nSlope = 8;
      cBall[paramInt].nLevel = 1;
      return;
      cBall[paramInt].isActive = false;
      break;
    }
  }
  
  private void initBoard()
  {
    isBoom = false;
    isPushBlock = false;
    nPushCount = 0;
    for (int i = 0; i < BLOCK_Y; i++)
    {
      int j = 0;
      if (j < BLOCK_X)
      {
        if (i < 5)
        {
          cBoard.nBlock[i][j] = cBc.cUtil.getRandomInt(0, 10);
          setBlock(i);
        }
        for (;;)
        {
          cBoard.nBlockFrame[i][j] = 0;
          j++;
          break;
          cBoard.nBlock[i][j] = 0;
        }
      }
    }
    cBoard.isDown = false;
    cBoard.nTime = cBc.getCurTime();
  }
  
  private void initMerry()
  {
    cMerry.nPosX = 120;
    cMerry.nPosY = 301;
    cMerry.nType = 0;
    cMerry.nDirect = 2;
    cMerry.nSpeed = 6;
    cMerry.nAniFrame = 0;
    cMerry.isMove = false;
    cMerry.isJump = false;
  }
  
  private void initStar()
  {
    for (int i = 0; i < 5; i++) {
      initStar(i);
    }
    dwStarTime = cBc.getCurTime();
  }
  
  private void initStar(int paramInt)
  {
    int i = 48 / 2;
    cStar[paramInt].nType = cPoint.getType();
    cStar[paramInt].nWidth = cBc.cRes.iStar[cStar[paramInt].nType].getWidth();
    cStar[paramInt].nHeight = cBc.cRes.iStar[cStar[paramInt].nType].getHeight();
    cStar[paramInt].nPosX = (48 * cBc.cUtil.getRandomInt(0, 5) + i);
    cStar[paramInt].nPosY = (-cStar[paramInt].nHeight / 2);
    cStar[paramInt].nFrame = 0;
    cStar[paramInt].nSpeed = cBc.cUtil.getRandomInt(6, 10);
    cStar[paramInt].isActive = false;
    cStar[paramInt].isHit = false;
  }
  
  private void moveMerry(int paramInt1, int paramInt2)
  {
    if (cMerry.nPrevPosX > cMerry.nPosX)
    {
      cMerry.nDirect = 1;
      cMerry.nPrevPosX = cMerry.nPosX;
      if (cMerry.nPosX >= 0) {
        break label134;
      }
      cMerry.nPosX = 0;
      setPressPointer(paramInt1, paramInt2);
    }
    for (;;)
    {
      cMerry.isMove = true;
      DrawPlay05.Merry localMerry = cMerry;
      nAniFrame += 1;
      if (cMerry.nAniFrame > 3) {
        cMerry.nAniFrame = 0;
      }
      return;
      if (cMerry.nPrevPosX >= cMerry.nPosX) {
        break;
      }
      cMerry.nDirect = 2;
      break;
      label134:
      if (cMerry.nPosX > 240)
      {
        cMerry.nPosX = 240;
        setPressPointer(paramInt1, paramInt2);
      }
      else if (cMerry.nPosY < 224)
      {
        cMerry.nPosY = 224;
        setPressPointer(paramInt1, paramInt2);
      }
      else if (cMerry.nPosY > 348)
      {
        cMerry.nPosY = 348;
        setPressPointer(paramInt1, paramInt2);
      }
      else
      {
        cMerry.nPosX = (cMerry.nMovePixelX + paramInt1);
        cMerry.nPosY = (cMerry.nMovePixelY + paramInt2);
      }
    }
  }
  
  private void proc()
  {
    int i;
    if (isPushBlock)
    {
      nPushCount = 24;
      if (nPushCount >= 24)
      {
        isPushBlock = false;
        nPushCount = 0;
        for (i = BLOCK_Y - 1; i > 0; i--) {
          System.arraycopy(cBoard.nBlock[(i - 1)], 0, cBoard.nBlock[i], 0, BLOCK_X);
        }
        setBlock(0);
      }
    }
    else
    {
      if (!cBc.isLock()) {
        break label150;
      }
      if (!isGameLockTime)
      {
        dwGameLockTime = cBc.getCurTime();
        isGameLockTime = true;
      }
    }
    label150:
    label257:
    label307:
    label313:
    label498:
    label573:
    label609:
    label808:
    label856:
    label912:
    label1465:
    label1496:
    label1645:
    label1651:
    label1962:
    label1981:
    for (;;)
    {
      return;
      Object localObject;
      for (i = 0; i < 3; i++)
      {
        localObject = cBall[i];
        nPosY += 1;
      }
      break;
      if (isGameLockTime)
      {
        localObject = cBoard;
        nTime += cBc.getCurTime() - dwGameLockTime;
        isGameLockTime = false;
        dwGameLockTime = 0L;
      }
      if (cBc.getCurTime() - dwStarTime > 5000L)
      {
        i = 0;
        if (i < 5)
        {
          if (cStar[i].isActive) {
            break label307;
          }
          cStar[i].isActive = true;
          dwStarTime = cBc.getCurTime();
        }
      }
      i = 0;
      if (i < 5)
      {
        if (cStar[i].isActive)
        {
          if (cStar[i].nPosY <= 378) {
            break label313;
          }
          cPoint.resetComboCount();
          initStar(i);
        }
        for (;;)
        {
          i++;
          break label257;
          i++;
          break;
          if (!cStar[i].isHit)
          {
            localObject = cStar[i];
            nPosY += cStar[i].nSpeed;
          }
        }
      }
      for (int k = 0; k < 3; k++) {
        if (cBall[k].isActive)
        {
          int j;
          int m;
          if (cBall[k].nDirect2 == 3)
          {
            i = cBall[k].nPosX / 34;
            j = (cBall[k].nPosY - 9) / 24;
            if (getBlockType(i, j) != 0)
            {
              cBc.cSound.playSound(16, 1);
              hitBlock(k, i, j);
              cBall[k].nDirect2 = 4;
              j = 1;
              i = j;
              if (cBall[k].nPosY - 9 <= 0)
              {
                cBall[k].nPosY = 9;
                cBall[k].nDirect2 = 4;
                i = j;
              }
              if (cBall[k].nDirect != 1) {
                break label1496;
              }
              m = (cBall[k].nPosX - 9) / 34;
              j = cBall[k].nPosY / 24;
              if ((i != 0) || (getBlockType(m, j) == 0)) {
                break label1465;
              }
              hitBlock(k, m, j);
              cBall[k].nDirect = 2;
              if (cBall[k].nPosX - 9 < 0)
              {
                cBall[k].nPosX = 9;
                cBall[k].nDirect = 2;
              }
              if ((cBall[k].nPosY + 9 >= cMerry.nPosY - 40) && (cBall[k].nPosY + 9 < cMerry.nPosY - 10) && (cBall[k].nPosX >= cMerry.nPosX - 40) && (cBall[k].nPosX <= cMerry.nPosX + 40))
              {
                m = cMerry.nPosX;
                j = cBall[k].nPosX;
                cBall[k].nDirect2 = 3;
                cMerry.isJump = true;
                cMerry.nJumpFrame = 0;
                cBc.cSound.playSound(14, 1);
                if (cBall[k].nDirect != 1) {
                  break label1651;
                }
                i = Math.abs(m - j) / (4 - cBall[k].nLevel);
                localObject = cBall[k];
                if (m <= j) {
                  break label1645;
                }
                nSlope = i;
                if (cBall[k].nSlope < 0)
                {
                  cBall[k].nDirect = 2;
                  localObject = cBall[k];
                  nSlope *= -1;
                }
              }
              i = 14;
              switch (14)
              {
              case 13: 
              case 15: 
              case 17: 
              case 19: 
              default: 
                if (14 > 20) {
                  i = 20;
                }
                if (cBall[k].nSlope == 0) {
                  cBall[k].nSlope = cBc.cUtil.getRandomInt(1, 5);
                }
                if (cBall[k].nSlope > i - 1) {
                  cBall[k].nSlope = (i - 1);
                }
                break;
              }
            }
          }
          for (;;)
          {
            cBall[k].nSpeed = (i - Math.abs(cBall[k].nSlope));
            if (cBall[k].nSpeed > 20) {
              cBall[k].nSpeed = 20;
            }
            if (cBall[k].nPosY > 378) {
              cBall[k].isActive = false;
            }
            for (i = 0; i < 5; i++) {
              if ((!cStar[i].isHit) && (cStar[i].isActive) && (cMerry.nPosY - 32 < cStar[i].nPosY + cStar[i].nHeight / 2) && (cMerry.nPosY + 65 > cStar[i].nPosY - cStar[i].nHeight / 2) && (cMerry.nPosX - 30 < cStar[i].nPosX + cStar[i].nWidth / 2) && (cMerry.nPosX + 30 > cStar[i].nPosX - cStar[i].nWidth / 2))
              {
                cPoint.increaseComboCount();
                cPoint.increasePointTableStar(cBc.nCurStateSeg, cStar[i].nType);
                cPoint.setPointAnimation(cPoint.nCurPoint, cStar[i].nPosX, cStar[i].nPosY);
                cStar[i].isHit = true;
                cStar[i].nFrame = 0;
              }
            }
            localObject = cBall[k];
            nPosY -= cBall[k].nSpeed + cBc.nGrade;
            j = 0;
            break;
            if (cBall[k].nDirect2 == 4)
            {
              i = cBall[k].nPosX / 34;
              j = (cBall[k].nPosY + 9) / 24;
              if (getBlockType(i, j) != 0)
              {
                hitBlock(k, i, j);
                cBall[k].nDirect2 = 3;
                i = 1;
                break label498;
              }
              localObject = cBall[k];
              nPosY += cBall[k].nSpeed + cBc.nGrade;
            }
            i = 0;
            break label498;
            localObject = cBall[k];
            nPosX -= cBall[k].nSlope;
            break label573;
            if (cBall[k].nDirect != 2) {
              break label609;
            }
            m = (cBall[k].nPosX + 9) / 34;
            j = cBall[k].nPosY / 24;
            if ((i == 0) && (getBlockType(m, j) != 0))
            {
              hitBlock(k, m, j);
              cBall[k].nDirect = 1;
            }
            while (cBall[k].nPosX + 9 > 240)
            {
              cBall[k].nPosX = 231;
              cBall[k].nDirect = 1;
              break;
              localObject = cBall[k];
              nPosX += cBall[k].nSlope;
            }
            i = -i;
            break label808;
            if (cBall[k].nDirect != 2) {
              break label856;
            }
            i = Math.abs(m - j) / (4 - cBall[k].nLevel);
            localObject = cBall[k];
            if (m > j) {
              i = -i;
            }
            for (;;)
            {
              nSlope = i;
              if (cBall[k].nSlope >= 0) {
                break;
              }
              cBall[k].nDirect = 1;
              localObject = cBall[k];
              nSlope *= -1;
              break;
            }
            cBall[k].nLevel = 0;
            break label912;
            cBall[k].nLevel = 1;
            break label912;
            cBall[k].nLevel = 2;
            break label912;
            cBall[k].nLevel = 3;
            break label912;
            cBall[k].nLevel = 4;
            break label912;
            if (cBall[k].nSlope < -i - 1) {
              cBall[k].nSlope = (-i - 1);
            }
          }
        }
      }
      pushBlock();
      if (cMerry.isJump)
      {
        if (cMerry.nJumpFrame != 3) {
          break label1962;
        }
        cMerry.isJump = false;
      }
      for (cMerry.nJumpFrame = 0;; nJumpFrame += 1)
      {
        if ((cBall[0].isActive) || (cBall[1].isActive) || (cBall[2].isActive)) {
          break label1981;
        }
        cBc.cSound.playSound(24, 1);
        cBc.setState(2005, 2);
        break;
        localObject = cMerry;
      }
    }
  }
  
  private void pushBlock()
  {
    int i = 0;
    if (i < BLOCK_X) {
      if (cBoard.nBlock[(BLOCK_Y - 1)][i] != 0) {
        cBc.setState(2005, 2);
      }
    }
    for (;;)
    {
      return;
      i++;
      break;
      if (cBc.getCurTime() - cBoard.nTime > 14000L - cBc.nGrade * 1000)
      {
        isPushBlock = true;
        if (isPushBlock) {
          cBoard.nTime = cBc.getCurTime();
        }
      }
    }
  }
  
  private void setBall(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    cBall[paramInt1].nPosX = paramInt2;
    cBall[paramInt1].nPosY = paramInt3;
    cBall[paramInt1].nDirect = paramInt4;
    cBall[paramInt1].nDirect2 = paramInt5;
    cBall[paramInt1].nSpeed = paramInt6;
    cBall[paramInt1].nType = paramInt7;
    cBall[paramInt1].nLevel = paramInt8;
    cBall[paramInt1].isActive = paramBoolean;
  }
  
  private void setBlock(int paramInt)
  {
    for (int i = 0; i < BLOCK_X; i++)
    {
      cBoard.nBlock[paramInt][i] = cBc.cUtil.getRandomInt(0, 10);
      if (cBc.cUtil.getRandomInt(0, 10) == 0) {
        cBoard.nBlock[paramInt][i] = cBc.cUtil.getRandomInt(10, 14);
      }
    }
  }
  
  private void setPressPointer(int paramInt1, int paramInt2)
  {
    cMerry.nMovePixelX = (cMerry.nPosX - paramInt1);
    cMerry.nMovePixelY = (cMerry.nPosY - paramInt2);
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
    initMerry();
    initBoard();
    initStar();
  }
  
  public void pointerDragged(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      moveMerry(paramInt1, paramInt2);
    }
  }
  
  public void pointerPressed(int paramInt1, int paramInt2)
  {
    if (cBc.isPointer(paramInt1, paramInt2, cMerry.nPosX - 60, cMerry.nPosY - 60, cMerry.nPosX + 60, cMerry.nPosY + 60)) {
      setPressPointer(paramInt1, paramInt2);
    }
  }
  
  public void pointerReleased(int paramInt1, int paramInt2) {}
  
  class Ball
  {
    boolean isActive;
    boolean isHit;
    int nDirect;
    int nDirect2;
    int nEffPosX;
    int nEffPosY;
    int nLevel;
    int nPosX;
    int nPosY;
    int nSlope;
    int nSpeed;
    int nType;
    
    Ball() {}
  }
  
  class Board
  {
    boolean isDown;
    int[][] nBlock;
    int[][] nBlockFrame;
    long nTime;
    
    Board() {}
  }
  
  class Merry
  {
    boolean isJump;
    boolean isMove;
    int nAniFrame;
    int nDirect;
    int nJumpFrame;
    int nMovePixelX;
    int nMovePixelY;
    int nPosX;
    int nPosY;
    int nPrevPosX;
    int nSpeed;
    int nType;
    
    Merry() {}
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
