import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DrawPlay04
  implements Drawable
{
  private final int DEF_DROP_SPEED = 6;
  private final int DROP_AREA_PIECE = 5;
  private final int INIT_ACTIVE_FRAME = 50;
  private final int MAP_SPACE = 30;
  private int[][] MAP_TABLE;
  private final int MAX_BGOBJECT = 20;
  private int MAX_MAP_POINT;
  private final int MAX_OBJECT = 10;
  private final int MAX_OBJECT_PATTERN = 2;
  private final int MAX_OBJECT_TYPE = 4;
  private final int MERRY_AROUND_HEIGHT = 60;
  private final int MERRY_AROUND_WIDTH = 60;
  private final int OBJECT_PATTERN_DN = 0;
  private final int OBJECT_PATTERN_LR = 1;
  private DrawPlay04.BGObj[] cBGObj;
  private BaseCanvas cBc;
  private DrawPlay04.Map[] cMapLeft;
  private DrawPlay04.Map[] cMapRight;
  private DrawPlay04.Merry cMerry;
  private DrawPlay04.Object[] cObj;
  private Point cPoint;
  
  public DrawPlay04(BaseCanvas paramBaseCanvas)
  {
    int[] arrayOfInt1 = { 5, 235 };
    int[] arrayOfInt2 = { 5, 235 };
    int[] arrayOfInt3 = { 5, 235 };
    int[] arrayOfInt4 = { 5, 235 };
    int[] arrayOfInt5 = { 5, 235 };
    int[] arrayOfInt6 = { 5, 235 };
    int[] arrayOfInt7 = { 5, 235 };
    int[] arrayOfInt8 = { 5, 235 };
    int[] arrayOfInt9 = { 5, 235 };
    int[] arrayOfInt10 = { 5, 235 };
    int[] arrayOfInt11 = { 5, 235 };
    int[] arrayOfInt12 = { 5, 235 };
    int[] arrayOfInt13 = { 5, 235 };
    int[] arrayOfInt14 = { 5, 235 };
    int[] arrayOfInt15 = { 5, 235 };
    int[] arrayOfInt16 = { 5, 235 };
    int[] arrayOfInt17 = { 5, 235 };
    int[] arrayOfInt18 = { 5, 235 };
    int[] arrayOfInt19 = { 5, 235 };
    int[] arrayOfInt20 = { 5, 235 };
    int[] arrayOfInt21 = { 50, 200 };
    int[] arrayOfInt22 = { 50, 200 };
    int[] arrayOfInt23 = { 50, 200 };
    int[] arrayOfInt24 = { 50, 200 };
    int[] arrayOfInt25 = { 50, 200 };
    int[] arrayOfInt26 = { 50, 200 };
    int[] arrayOfInt27 = { 50, 200 };
    int[] arrayOfInt28 = { 50, 200 };
    int[] arrayOfInt29 = { 50, 200 };
    int[] arrayOfInt30 = { 50, 200 };
    int[] arrayOfInt31 = { 50, 200 };
    int[] arrayOfInt32 = { 50, 200 };
    int[] arrayOfInt33 = { 50, 200 };
    int[] arrayOfInt34 = { 50, 200 };
    int[] arrayOfInt35 = { 50, 200 };
    int[] arrayOfInt36 = { 50, 200 };
    int[] arrayOfInt37 = { 50, 200 };
    int[] arrayOfInt38 = { 50, 200 };
    int[] arrayOfInt39 = { 50, 200 };
    int[] arrayOfInt40 = { 50, 200 };
    int[] arrayOfInt41 = { 5, 235 };
    int[] arrayOfInt42 = { 5, 235 };
    int[] arrayOfInt43 = { 5, 235 };
    int[] arrayOfInt44 = { 5, 235 };
    int[] arrayOfInt45 = { 5, 235 };
    int[] arrayOfInt46 = { 5, 235 };
    int[] arrayOfInt47 = { 5, 235 };
    int[] arrayOfInt48 = { 5, 235 };
    int[] arrayOfInt49 = { 5, 235 };
    int[] arrayOfInt50 = { 5, 235 };
    int[] arrayOfInt51 = { 50, 200 };
    int[] arrayOfInt52 = { 50, 200 };
    int[] arrayOfInt53 = { 50, 200 };
    int[] arrayOfInt54 = { 50, 200 };
    int[] arrayOfInt55 = { 50, 200 };
    int[] arrayOfInt56 = { 50, 200 };
    int[] arrayOfInt57 = { 50, 200 };
    int[] arrayOfInt58 = { 20, 200 };
    int[] arrayOfInt59 = { 50, 210 };
    int[] arrayOfInt60 = { 93, 220 };
    int[] arrayOfInt61 = { 130, 230 };
    int[] arrayOfInt62 = { 117, 214 };
    int[] arrayOfInt63 = { 103, 199 };
    int[] arrayOfInt64 = { 90, 183 };
    int[] arrayOfInt65 = { 77, 167 };
    int[] arrayOfInt66 = { 63, 150 };
    int[] arrayOfInt67 = { 50, 162 };
    int[] arrayOfInt68 = { 67, 175 };
    int[] arrayOfInt69 = { 83, 187 };
    int[] arrayOfInt70 = { 100, 200 };
    int[] arrayOfInt71 = { 87, 190 };
    int[] arrayOfInt72 = { 75, 180 };
    int[] arrayOfInt73 = { 63, 170 };
    int[] arrayOfInt74 = { 50, 161 };
    int[] arrayOfInt75 = { 67, 150 };
    int[] arrayOfInt76 = { 83, 160 };
    int[] arrayOfInt77 = { 100, 170 };
    int[] arrayOfInt78 = { 70, 180 };
    int[] arrayOfInt79 = { 40, 190 };
    int[] arrayOfInt80 = { 10, 200 };
    int[] arrayOfInt81 = { 30, 187 };
    int[] arrayOfInt82 = { 50, 175 };
    int[] arrayOfInt83 = { 40, 163 };
    int[] arrayOfInt84 = { 30, 150 };
    int[] arrayOfInt85 = { 20, 167 };
    int[] arrayOfInt86 = { 10, 186 };
    int[] arrayOfInt87 = { 30, 199 };
    int[] arrayOfInt88 = { 50, 220 };
    int[] arrayOfInt89 = { 33, 208 };
    int[] arrayOfInt90 = { 20, 200 };
    int[] arrayOfInt91 = { 20, 200 };
    int[] arrayOfInt92 = { 5, 235 };
    int[] arrayOfInt93 = { 5, 235 };
    int[] arrayOfInt94 = { 5, 235 };
    int[] arrayOfInt95 = { 5, 235 };
    int[] arrayOfInt96 = { 5, 235 };
    MAP_TABLE = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27, arrayOfInt28, arrayOfInt29, arrayOfInt30, arrayOfInt31, arrayOfInt32, arrayOfInt33, arrayOfInt34, arrayOfInt35, arrayOfInt36, arrayOfInt37, arrayOfInt38, arrayOfInt39, arrayOfInt40, arrayOfInt41, arrayOfInt42, arrayOfInt43, arrayOfInt44, arrayOfInt45, arrayOfInt46, arrayOfInt47, arrayOfInt48, arrayOfInt49, arrayOfInt50, arrayOfInt51, arrayOfInt52, arrayOfInt53, arrayOfInt54, { 50, 200 }, arrayOfInt55, { 50, 200 }, arrayOfInt56, { 50, 200 }, arrayOfInt57, arrayOfInt58, arrayOfInt59, arrayOfInt60, arrayOfInt61, arrayOfInt62, arrayOfInt63, arrayOfInt64, arrayOfInt65, arrayOfInt66, arrayOfInt67, arrayOfInt68, arrayOfInt69, arrayOfInt70, arrayOfInt71, arrayOfInt72, arrayOfInt73, arrayOfInt74, arrayOfInt75, arrayOfInt76, arrayOfInt77, arrayOfInt78, arrayOfInt79, arrayOfInt80, arrayOfInt81, arrayOfInt82, arrayOfInt83, arrayOfInt84, arrayOfInt85, arrayOfInt86, arrayOfInt87, arrayOfInt88, arrayOfInt89, arrayOfInt90, arrayOfInt91, arrayOfInt92, arrayOfInt93, arrayOfInt94, arrayOfInt95, { 5, 235 }, arrayOfInt96 };
    cBc = paramBaseCanvas;
    cPoint = cPoint.getInstance();
    MAX_MAP_POINT = MAP_TABLE.length;
    cMerry = new DrawPlay04.Merry(null);
    cObj = new DrawPlay04.Object[10];
    cBGObj = new DrawPlay04.BGObj[20];
    cMapLeft = new DrawPlay04.Map[MAX_MAP_POINT];
    cMapRight = new DrawPlay04.Map[MAX_MAP_POINT];
    for (int i = 0; i < 10; i++) {
      cObj[i] = new DrawPlay04.Object(null);
    }
    for (i = 0; i < 20; i++) {
      cBGObj[i] = new DrawPlay04.BGObj(null);
    }
    for (i = 0; i < MAX_MAP_POINT; i++) {
      cMapLeft[i] = new DrawPlay04.Map(null);
    }
    for (i = 0; i < MAX_MAP_POINT; i++) {
      cMapRight[i] = new DrawPlay04.Map(null);
    }
  }
  
  private void drawBoard(Graphics paramGraphics)
  {
    paramGraphics.setColor(53, 36, 96);
    paramGraphics.fillRect(0, 0, 480, 378);
    for (int i = 0; i < 20; i++) {
      paramGraphics.drawImage(cBc.cRes.iBG[cBGObj[i].nType], cBGObj[i].nPosX, cBGObj[i].nPosY, 3);
    }
    paramGraphics.setColor(143, 133, 166);
    for (i = 0; i < MAX_MAP_POINT - 1; i++)
    {
      if (cMapLeft[i].nPosY < cMapLeft[cMapLeft[i].nNextIdx].nPosY)
      {
        paramGraphics.drawLine(cMapLeft[i].nPosX, cMapLeft[i].nPosY, cMapLeft[cMapLeft[i].nNextIdx].nPosX, cMapLeft[cMapLeft[i].nNextIdx].nPosY);
        paramGraphics.drawLine(cMapLeft[i].nPosX - 1, cMapLeft[i].nPosY, cMapLeft[cMapLeft[i].nNextIdx].nPosX - 1, cMapLeft[cMapLeft[i].nNextIdx].nPosY);
      }
      if (cMapRight[i].nPosY < cMapRight[cMapRight[i].nNextIdx].nPosY)
      {
        paramGraphics.drawLine(cMapRight[i].nPosX, cMapRight[i].nPosY, cMapRight[cMapRight[i].nNextIdx].nPosX, cMapRight[cMapRight[i].nNextIdx].nPosY);
        paramGraphics.drawLine(cMapRight[i].nPosX - 1, cMapRight[i].nPosY, cMapRight[cMapRight[i].nNextIdx].nPosX - 1, cMapRight[cMapRight[i].nNextIdx].nPosY);
      }
    }
  }
  
  private void drawGameOver(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
    drawMerry(paramGraphics);
    drawPanel(paramGraphics);
    drawObject(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawGameOver(paramGraphics);
  }
  
  private void drawMerry(Graphics paramGraphics)
  {
    Image[] arrayOfImage = cBc.cRes.iPlay;
    DrawPlay04.Merry localMerry = cMerry;
    int i = nFrame + 1;
    nFrame = i;
    paramGraphics.drawImage(arrayOfImage[(i / 3 % 2)], cMerry.nPosX, cMerry.nPosY, 3);
    paramGraphics.drawImage(cBc.cRes.iTZone, cMerry.nPosX, cMerry.nPosY, 3);
    if (cMerry.nFrame > 3) {
      cMerry.nFrame = 0;
    }
  }
  
  private void drawObject(Graphics paramGraphics)
  {
    int i = 0;
    if (i < 10)
    {
      DrawPlay04.Object localObject;
      if (cObj[i].isActive)
      {
        if (!cObj[i].isStar) {
          break label119;
        }
        localObject = cObj[i];
        nFrame += 1;
        int j = cObj[i].nFrame / 2;
        paramGraphics.drawImage(cBc.cRes.iStar[(j % 3 * 3 + cObj[i].nType)], cObj[i].nPosX, cObj[i].nPosY, 3);
      }
      for (;;)
      {
        i++;
        break;
        label119:
        localObject = cObj[i];
        nFrame += 1;
        paramGraphics.drawImage(cBc.cRes.iObject[cObj[i].nType], cObj[i].nPosX, cObj[i].nPosY, 3);
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
    drawMerry(paramGraphics);
    drawObject(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawHeart(paramGraphics);
    cBc.drawCombo(paramGraphics);
    cBc.drawPointAnimation(paramGraphics);
    cBc.drawMark(paramGraphics);
  }
  
  private void drawReady(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
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
      if (cBc.nCurStateSeg == 2004) {
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      cBc.drawGameResultForward(paramGraphics);
      return;
      paramGraphics.drawImage(cBc.cRes.iResult[0], 22, 116, 6);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 94, 173, 6);
      continue;
      paramGraphics.drawImage(cBc.cRes.iResult[1], 22, 116, 6);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 91, 173, 6);
      continue;
      switch (i)
      {
      default: 
        break;
      case 0: 
        paramGraphics.drawImage(cBc.cRes.iResult[0], 22, 116, 6);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 132, 173, 6);
        break;
      case 1: 
        paramGraphics.drawImage(cBc.cRes.iResult[1], 22, 116, 6);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 132, 170, 6);
        continue;
        if (cBc.nCurStateSeg == 2004) {
          switch (i)
          {
          default: 
            break;
          case 0: 
            paramGraphics.drawImage(cBc.cRes.iResult[2], 22, 116, 6);
            paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 94, 173, 6);
            break;
          case 1: 
            paramGraphics.drawImage(cBc.cRes.iResult[3], 22, 116, 6);
            paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 91, 173, 6);
            break;
          }
        } else {
          switch (i)
          {
          default: 
            break;
          case 0: 
            paramGraphics.drawImage(cBc.cRes.iResult[2], 22, 116, 6);
            paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 135, 173, 6);
            break;
          case 1: 
            paramGraphics.drawImage(cBc.cRes.iResult[3], 22, 116, 6);
            paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 135, 170, 6);
          }
        }
        break;
      }
    }
  }
  
  private void initObject(int paramInt1, int paramInt2)
  {
    int j = 48 / 2;
    DrawPlay04.Object localObject;
    int i;
    if (cPoint.isStarPoint())
    {
      cObj[paramInt1].nType = cPoint.getType();
      localObject = cObj[paramInt1];
      if (cObj[paramInt1].nType != 0)
      {
        i = cBc.cUtil.getRandomInt(0, 2);
        nPattern = i;
        cObj[paramInt1].nWidth = cBc.cRes.iStar[cObj[paramInt1].nType].getWidth();
        cObj[paramInt1].nHeight = cBc.cRes.iStar[cObj[paramInt1].nType].getHeight();
        cObj[paramInt1].isStar = true;
        if (cObj[paramInt1].nPattern != 0) {
          break label437;
        }
        cObj[paramInt1].nPosX = (48 * cBc.cUtil.getRandomInt(1, 4) + j - cObj[paramInt1].nWidth / 2);
        cObj[paramInt1].nPosY = 0;
        cObj[paramInt1].nDirect = 4;
        cObj[paramInt1].nPatternCount = 0;
      }
    }
    for (;;)
    {
      cObj[paramInt1].nSpeed = (cBc.nGrade + 6);
      cObj[paramInt1].isActive = false;
      cObj[paramInt1].nActiveFrame = paramInt2;
      cObj[paramInt1].nFrame = 0;
      cObj[paramInt1].nBooster = 0;
      return;
      i = 0;
      break;
      cObj[paramInt1].nType = cBc.cUtil.getRandomInt(0, 4);
      localObject = cObj[paramInt1];
      if (cObj[paramInt1].nType != 0) {}
      for (i = cBc.cUtil.getRandomInt(1, 8) / 7;; i = 0)
      {
        nPattern = i;
        cObj[paramInt1].nWidth = cBc.cRes.iObject[cObj[paramInt1].nType].getWidth();
        cObj[paramInt1].nHeight = cBc.cRes.iObject[cObj[paramInt1].nType].getHeight();
        cObj[paramInt1].isStar = false;
        break;
      }
      label437:
      if (cObj[paramInt1].nPattern == 1)
      {
        cObj[paramInt1].nPosX = (48 * cBc.cUtil.getRandomInt(1, 4) + j - cObj[paramInt1].nWidth / 2);
        cObj[paramInt1].nPosY = 0;
        cObj[paramInt1].nDirect = 1;
        cObj[paramInt1].nPatternCount = 0;
      }
    }
  }
  
  private void moveMerry(int paramInt1, int paramInt2)
  {
    if (cMerry.nPosX < 0)
    {
      cMerry.nPosX = 0;
      setPressPointer(paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
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
    if (cBc.isLock()) {}
    for (;;)
    {
      return;
      int i = 0;
      label13:
      label273:
      label315:
      label355:
      label382:
      Object localObject;
      if (i < 10)
      {
        if (cObj[i].isActive)
        {
          if ((cMerry.nPosY - cMerry.nWidth / 2 >= cObj[i].nPosY + cObj[i].nHeight / 2) || (cMerry.nPosY + 6 <= cObj[i].nPosY - cObj[i].nHeight / 2) || (cMerry.nPosX - cMerry.nWidth / 2 + 6 >= cObj[i].nPosX + cObj[i].nWidth / 2) || (cMerry.nPosX + cMerry.nWidth / 2 <= cObj[i].nPosX - cObj[i].nWidth / 2)) {
            break label382;
          }
          if (!cObj[i].isStar) {
            break label355;
          }
          cPoint.increaseComboCount();
          cPoint.increasePointTableStar(cBc.nCurStateSeg, cObj[i].nType);
          cPoint.setPointAnimation(cPoint.nCurPoint, cObj[i].nPosX, cObj[i].nPosY);
          initObject(i, 500);
          if (cObj[i].nPosY >= 378)
          {
            if (!cObj[i].isStar) {
              break label1090;
            }
            cPoint.resetComboCount();
            initObject(i, 500);
          }
        }
        if ((!cObj[i].isActive) && (cObj[i].nActiveFrame <= 0)) {
          cObj[i].isActive = true;
        }
        for (;;)
        {
          i++;
          break label13;
          cBc.cSound.playSound(24, 1);
          cBc.setState(2004, 2);
          break;
          int m;
          int j;
          DrawPlay04.Object localObject1;
          int k;
          if (cObj[i].nPattern == 0)
          {
            if (cObj[i].isStar)
            {
              localObject = cObj[i];
              nPosY += cObj[i].nSpeed;
              break label273;
            }
            if (cObj[i].nType == 0)
            {
              if (cObj[i].nPosY < 74)
              {
                localObject = cObj[i];
                nPosY += cObj[i].nSpeed;
                break label273;
              }
              localObject = cObj[i];
              m = nPosY;
              j = cObj[i].nSpeed;
              localObject1 = cObj[i];
              k = nBooster + 1;
              nBooster = k;
              nPosY = (m + (j + cObj[i].nBooster * k));
              setBoosterSound(cObj[i].nBooster);
              break label273;
            }
            localObject = cObj[i];
            nPosY += cObj[i].nSpeed;
            break label273;
          }
          if (cObj[i].nPattern != 1) {
            break label273;
          }
          if (cObj[i].isStar)
          {
            localObject = cObj[i];
            nPosY += 1;
            if (cObj[i].nDirect == 1)
            {
              localObject = cObj[i];
              nPosX -= cObj[i].nSpeed;
              if (cObj[i].nPosX >= 40) {
                break label273;
              }
              cObj[i].nDirect = 2;
              break label273;
            }
            if (cObj[i].nDirect != 2) {
              break label273;
            }
            localObject = cObj[i];
            nPosX += cObj[i].nSpeed;
            if (cObj[i].nPosX <= 200) {
              break label273;
            }
            cObj[i].nDirect = 1;
            break label273;
          }
          if (cObj[i].nType == 0)
          {
            if (cObj[i].nPosY < 74)
            {
              localObject = cObj[i];
              nPosY += cObj[i].nSpeed;
              break label273;
            }
            localObject1 = cObj[i];
            j = nPosY;
            k = cObj[i].nSpeed;
            localObject = cObj[i];
            m = nBooster + 1;
            nBooster = m;
            nPosY = (j + (k + cObj[i].nBooster * m));
            setBoosterSound(cObj[i].nBooster);
            break label273;
          }
          localObject = cObj[i];
          nPosY += 1;
          if (cObj[i].nDirect == 1)
          {
            localObject = cObj[i];
            nPosX -= cObj[i].nSpeed;
            if (cObj[i].nPosX >= 40) {
              break label273;
            }
            cObj[i].nDirect = 2;
            break label273;
          }
          if (cObj[i].nDirect != 2) {
            break label273;
          }
          localObject = cObj[i];
          nPosX += cObj[i].nSpeed;
          if (cObj[i].nPosX <= 200) {
            break label273;
          }
          cObj[i].nDirect = 1;
          break label273;
          label1090:
          cPoint.increasePointTable(cBc.nCurStateSeg, cObj[i].nType);
          cPoint.setPointAnimation(cPoint.nCurPoint, cMerry.nPosX + 20, cMerry.nPosY - 20);
          if (cObj[i].nType == 0) {
            cBc.setEvent(true);
          }
          initObject(i, 500);
          break label315;
          localObject = cObj[i];
          nActiveFrame -= 1;
        }
      }
      i = 0;
      if (i < 20)
      {
        if (cBGObj[i].nPosY > 378) {
          initBG(i, -10);
        }
        for (;;)
        {
          i++;
          break;
          localObject = cBGObj[i];
          nPosY += 1;
        }
      }
      for (i = 0;; i++)
      {
        if (i >= MAX_MAP_POINT) {
          break label1577;
        }
        if ((cMerry.nPosY - cMerry.nWidth / 2 < cMapLeft[i].nPosY) && (cMerry.nPosY + 6 > cMapLeft[i].nPosY) && (cMerry.nPosX - cMerry.nWidth / 2 + 6 < cMapLeft[i].nPosX))
        {
          cBc.setState(2004, 2);
          break;
        }
        if ((cMerry.nPosY - cMerry.nWidth / 2 < cMapRight[i].nPosY) && (cMerry.nPosY + 6 > cMapRight[i].nPosY) && (cMerry.nPosX + cMerry.nWidth / 2 > cMapRight[i].nPosX))
        {
          cBc.setState(2004, 2);
          break;
        }
        localObject = cMapLeft[i];
        nPosY += cBc.nGrade + 1;
        localObject = cMapRight[i];
        nPosY += cBc.nGrade + 1;
        if (cMapLeft[i].nPosY > (MAX_MAP_POINT - 2) * 30) {
          initMapLeft(i, 0);
        }
        if (cMapRight[i].nPosY > (MAX_MAP_POINT - 2) * 30) {
          initMapRight(i, 0);
        }
      }
      label1577:
      cBc.setGrade(cPoint.nPoint[4]);
    }
  }
  
  private void setBoosterSound(int paramInt)
  {
    if (paramInt == 4) {
      cBc.cSound.playSound(18, 1);
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
    cMerry.isMove = false;
    cMerry.nFrame = 0;
    cMerry.nPosX = 120;
    cMerry.nPosY = 301;
    cMerry.nWidth = cBc.cRes.iPlay[0].getWidth();
    cMerry.nHeight = cBc.cRes.iPlay[0].getHeight();
    initBG();
    initObject();
    initMap();
  }
  
  public void initBG()
  {
    for (int i = 0; i < 20; i++) {
      initBG(i, cBc.cUtil.getRandomInt(0, 24) * 20);
    }
  }
  
  public void initBG(int paramInt1, int paramInt2)
  {
    cBGObj[paramInt1].nType = cBc.cUtil.getRandomInt(0, 4);
    cBGObj[paramInt1].nPosX = (cBc.cUtil.getRandomInt(2, 22) * 10);
    cBGObj[paramInt1].nPosY = paramInt2;
    cBGObj[paramInt1].nSpeed = cBc.cUtil.getRandomInt(0, 3);
  }
  
  public void initMap()
  {
    int i = 0;
    if (i < MAX_MAP_POINT)
    {
      if (i == 0)
      {
        cMapLeft[i].nPrevIdx = (MAX_MAP_POINT - 1);
        cMapLeft[i].nNextIdx = (i + 1);
        cMapRight[i].nPrevIdx = (MAX_MAP_POINT - 1);
        cMapRight[i].nNextIdx = (i + 1);
      }
      for (;;)
      {
        initMapLeft(i, i * 30);
        initMapRight(i, i * 30);
        i++;
        break;
        if (i == MAX_MAP_POINT - 1)
        {
          cMapLeft[i].nPrevIdx = (i - 1);
          cMapLeft[i].nNextIdx = 0;
          cMapRight[i].nPrevIdx = (i - 1);
          cMapRight[i].nNextIdx = 0;
        }
        else
        {
          cMapLeft[i].nPrevIdx = (i - 1);
          cMapLeft[i].nNextIdx = (i + 1);
          cMapRight[i].nPrevIdx = (i - 1);
          cMapRight[i].nNextIdx = (i + 1);
        }
      }
    }
  }
  
  public void initMapLeft(int paramInt1, int paramInt2)
  {
    cMapLeft[paramInt1].nPosX = MAP_TABLE[paramInt1][0];
    cMapLeft[paramInt1].nPosY = (paramInt2 - 30);
  }
  
  public void initMapRight(int paramInt1, int paramInt2)
  {
    cMapRight[paramInt1].nPosX = MAP_TABLE[paramInt1][1];
    cMapRight[paramInt1].nPosY = (paramInt2 - 30);
  }
  
  public void initObject()
  {
    for (int i = 0; i < 10; i++) {
      initObject(i, (50 - cBc.nGrade) * i);
    }
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
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      if (cBc.isPointer(paramInt1, paramInt2, cMerry.nPosX - 60, cMerry.nPosY - 60, cMerry.nPosX + 60, cMerry.nPosY + 60)) {
        setPressPointer(paramInt1, paramInt2);
      }
    }
  }
  
  public void pointerReleased(int paramInt1, int paramInt2)
  {
    paramInt1 = cBc.nCurStateOff;
  }
  
  private class BGObj
  {
    int nPosX;
    int nPosY;
    int nSpeed;
    int nType;
    
    private BGObj() {}
    
    BGObj(DrawPlay04.1 param1)
    {
      this();
    }
  }
  
  private class Map
  {
    int nNextIdx;
    int nPosX;
    int nPosY;
    int nPrevIdx;
    
    private Map() {}
    
    Map(DrawPlay04.1 param1)
    {
      this();
    }
  }
  
  private class Merry
  {
    boolean isMove;
    int nFrame;
    int nHeight;
    int nMovePixelX;
    int nMovePixelY;
    int nPosX;
    int nPosY;
    int nWidth;
    
    private Merry() {}
    
    Merry(DrawPlay04.1 param1)
    {
      this();
    }
  }
  
  private class Object
  {
    boolean isActive;
    boolean isStar;
    int nActiveFrame;
    int nBooster;
    int nDirect;
    int nFrame;
    int nHeight;
    int nPattern;
    int nPatternCount;
    int nPosX;
    int nPosY;
    int nSpeed;
    int nType;
    int nWidth;
    
    private Object() {}
    
    Object(DrawPlay04.1 param1)
    {
      this();
    }
  }
}
