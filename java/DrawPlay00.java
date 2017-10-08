import java.lang.reflect.Array;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DrawPlay00
  implements Drawable
{
  private final int DADDY_SHOW_FRAME = 16;
  private final int DAD_AROUND_DETAIL = 10;
  private final int DAD_AROUND_HEIGHT = 70;
  private final int DAD_AROUND_WIDTH = 42;
  private final int DAD_DETAIL_POSY = 10;
  private final int DEF_DROP_SPEED = 6;
  private final int DROP_AREA_PIECE = 5;
  private final int FRAME_PIXEL = 10;
  private final int INC_GAUGE = 7;
  private final int INIT_ACTIVE_FRAME = 45;
  private final int MAX_ARRAY = 11;
  private final int MAX_GAUGE = 60;
  private final int MAX_OBJECT = 10;
  private final int MAX_OBJECT_TYPE = 9;
  private final int MOM_DETAIL_POSY = 20;
  private final int OBJECT_AUTO = 1;
  private final int OBJECT_DROP = 4;
  private final int OBJECT_LEFT = 2;
  private final int OBJECT_NOTHING = 0;
  private final int OBJECT_RIGHT = 3;
  private final int OBJECT_TYPE_POISON = 8;
  private final int SALVER_SIZE = 36;
  private final int THROW_HEIGHT = 51;
  private final int THROW_PIXEL = 30;
  private final int THROW_WIDTH = 38;
  private BaseCanvas cBc;
  private DrawPlay00.Daddy cDad;
  private DrawPlay00.Object[] cObj;
  private Point cPoint;
  private boolean isGaugeEnd;
  private boolean isObjectEffect;
  private boolean isObjectKeyFlag;
  private boolean isThrow;
  private int nArrDrop;
  private int[][] nArrPos;
  private int nArrPosCount;
  private int[] nArrPosX;
  private int nArrPosXCnt;
  private int nArrPosY;
  private int nFrame;
  private int nGauge;
  private int nGaugeDelay;
  private int nGaugeTarget;
  private int nMomFrame;
  private int nObjectClearStep;
  private int nObjectEffectPosX;
  private int nObjectEffectPosY;
  private int nObjectPrevCnt;
  private int nObjectPrevWidth;
  private int nObjectState;
  private int nStackPosition;
  
  public DrawPlay00(BaseCanvas paramBaseCanvas)
  {
    cBc = paramBaseCanvas;
    cPoint = cPoint.getInstance();
    cDad = new DrawPlay00.Daddy(null);
    cObj = new DrawPlay00.Object[10];
    for (int i = 0; i < 10; i++) {
      cObj[i] = new DrawPlay00.Object(null);
    }
    nArrPos = ((int[][])Array.newInstance(Integer.TYPE, new int[] { 11, 4 }));
    nArrPosX = new int[11];
  }
  
  private void drawBoard(Graphics paramGraphics)
  {
    paramGraphics.drawImage(cBc.cRes.iBG[0], 0, 0, 20);
    paramGraphics.drawImage(cBc.cRes.iBG[1], 0, 224, 20);
  }
  
  private void drawDaddy(Graphics paramGraphics, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramGraphics.drawImage(cBc.cRes.iPlay[0], cDad.nPosX, cDad.nPosY, 20);
      paramGraphics.drawImage(cBc.cRes.iTZone, cDad.nPosX + 18, cDad.nPosY - 10 - 10, 3);
      return;
      if (paramInt2 < 4)
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[2], cDad.nPosX - 6, cDad.nPosY - 18, 20);
        if (cBc.nCurStateOff == 2) {
          paramGraphics.drawImage(cBc.cRes.iPlay[14], cDad.nPosX - 2, cDad.nPosY - 78, 20);
        } else {
          paramGraphics.drawImage(cBc.cRes.iPlay[1], cDad.nPosX - 2, cDad.nPosY - 78, 20);
        }
      }
      else if (paramInt2 < 8)
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[10], cDad.nPosX - 6, cDad.nPosY - 18, 20);
        paramGraphics.drawImage(cBc.cRes.iPlay[1], cDad.nPosX - 4, cDad.nPosY - 80, 20);
      }
      else if (paramInt2 < 12)
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[2], cDad.nPosX - 6, cDad.nPosY - 18, 20);
        paramGraphics.drawImage(cBc.cRes.iPlay[1], cDad.nPosX - 2, cDad.nPosY - 78, 20);
      }
      else
      {
        paramGraphics.drawImage(cBc.cRes.iPlay[11], cDad.nPosX - 10, cDad.nPosY - 18, 20);
        paramGraphics.drawImage(cBc.cRes.iPlay[1], cDad.nPosX - 0, cDad.nPosY - 80, 20);
        continue;
        if (paramInt2 < 4)
        {
          paramGraphics.drawImage(cBc.cRes.iPlay[6], cDad.nPosX - 6, cDad.nPosY - 12, 20);
          paramGraphics.drawImage(cBc.cRes.iPlay[4], cDad.nPosX - 14, cDad.nPosY - 72, 20);
        }
        else
        {
          paramGraphics.drawImage(cBc.cRes.iPlay[5], cDad.nPosX - 24, cDad.nPosY - 12, 20);
          paramGraphics.drawImage(cBc.cRes.iPlay[4], cDad.nPosX - 14, cDad.nPosY - 74, 20);
          continue;
          if (paramInt2 < 4)
          {
            paramGraphics.drawImage(cBc.cRes.iPlay[9], cDad.nPosX - 6, cDad.nPosY - 12, 20);
            paramGraphics.drawImage(cBc.cRes.iPlay[7], cDad.nPosX + 8, cDad.nPosY - 72, 20);
          }
          else
          {
            paramGraphics.drawImage(cBc.cRes.iPlay[8], cDad.nPosX - 6, cDad.nPosY - 12, 20);
            paramGraphics.drawImage(cBc.cRes.iPlay[7], cDad.nPosX + 8, cDad.nPosY - 74, 20);
          }
        }
      }
    }
  }
  
  private void drawGameOver(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
    drawDaddy(paramGraphics, 0, 0);
    paramGraphics.drawImage(cBc.cRes.iPlay[0], cDad.nPosX, cDad.nPosY, 20);
    drawPanel(paramGraphics);
    if (nArrDrop < nArrPosCount) {
      nArrDrop += 1;
    }
    int i = 0;
    if (i < nArrDrop)
    {
      int[] arrayOfInt;
      if (nStackPosition - nArrPos[i][2] < 308) {
        if (i % 2 == 0)
        {
          arrayOfInt = nArrPos[i];
          arrayOfInt[1] -= 6;
          label124:
          arrayOfInt = nArrPos[i];
          arrayOfInt[2] -= 10;
        }
      }
      for (int j = cBc.cUtil.getRandomInt(0, 2) * 9;; j = 0)
      {
        paramGraphics.drawImage(cBc.cRes.iObject[(j + nArrPos[i][0])], nArrPos[i][1], nStackPosition - nArrPos[i][2], 20);
        i++;
        break;
        arrayOfInt = nArrPos[i];
        arrayOfInt[1] += 6;
        break label124;
      }
    }
    if (nFrame == 0) {
      nFrame = 1;
    }
    cBc.drawGameOver(paramGraphics);
  }
  
  private void drawMark(Graphics paramGraphics)
  {
    if (cBc.getAnimationFrame(cBc.nMarkFrame, 2, 2) == 0)
    {
      if (nObjectState != 2) {
        break label62;
      }
      paramGraphics.drawImage(cBc.cRes.iPlay[20], cDad.nPosX + 18 - 54, 281, 3);
    }
    for (;;)
    {
      return;
      label62:
      if (nObjectState == 3) {
        paramGraphics.drawImage(cBc.cRes.iPlay[20], cDad.nPosX + 18 + 54, 281, 3);
      }
    }
  }
  
  private void drawMom(Graphics paramGraphics)
  {
    if (!isThrow)
    {
      nMomFrame += 1;
      if ((nMomFrame / 40 % 2 != 1) || (cBc.nCurStateOff != 1)) {
        break label142;
      }
      if (nMomFrame / 5 % 2 != 0) {
        break label114;
      }
      paramGraphics.drawImage(cBc.cRes.iPlay[17], 240, 348, 40);
      if (nMomFrame / 3 % 2 == 0) {
        paramGraphics.drawImage(cBc.cRes.iPlay[19], 250, 322, 40);
      }
    }
    for (;;)
    {
      return;
      label114:
      paramGraphics.drawImage(cBc.cRes.iPlay[18], 240, 348, 40);
      break;
      label142:
      paramGraphics.drawImage(cBc.cRes.iPlay[17], 240, 348, 40);
    }
  }
  
  private void drawObject(Graphics paramGraphics)
  {
    int j;
    Object localObject;
    if (nObjectClearStep == 1)
    {
      j = (cBc.cRes.iPlay[15].getWidth() - nFrame) / 2;
      for (i = 0; i < nArrPosCount; i++) {
        paramGraphics.drawImage(cBc.cRes.iObject[nArrPos[i][0]], nArrPos[i][1], nStackPosition - nArrPos[i][2], 20);
      }
      paramGraphics.drawImage(cBc.cRes.iPlay[15], 240 - nFrame, 244, 20);
      nFrame += j;
      if (j == 0)
      {
        nFrame = 0;
        nObjectClearStep = 2;
      }
      label262:
      for (i = 0;; i++)
      {
        if (i >= 10) {
          break label1119;
        }
        if (cObj[i].isActive)
        {
          if (!cObj[i].isStar) {
            break;
          }
          localObject = cObj[i];
          nFrame += 1;
          j = cObj[i].nFrame / 2;
          paramGraphics.drawImage(cBc.cRes.iStar[(j % 3 * 3 + cObj[i].nType)], cObj[i].nPosX, cObj[i].nPosY, 20);
        }
      }
    }
    if (nObjectClearStep == 2)
    {
      j = 240 - cBc.cRes.iPlay[15].getWidth();
      for (i = 0; i < nArrPosCount; i++)
      {
        localObject = cBc.cRes.iObject[nArrPos[i][0]];
        int[] arrayOfInt = nArrPos[i];
        int k = arrayOfInt[1] + 30;
        arrayOfInt[1] = k;
        paramGraphics.drawImage((Image)localObject, k, nStackPosition - nArrPos[i][2], 20);
      }
      if (nArrPos[0][1] >= j) {
        paramGraphics.drawImage(cBc.cRes.iPlay[16], nArrPos[0][1], 244, 20);
      }
      for (;;)
      {
        nFrame += 1;
        if (nFrame >= nArrPosCount) {
          nFrame = 0;
        }
        if ((nArrPosCount != 0) && (nArrPos[0][1] < 240)) {
          break;
        }
        nFrame = 0;
        nObjectClearStep = 3;
        break;
        paramGraphics.drawImage(cBc.cRes.iPlay[15], j, 244, 20);
      }
    }
    if (isObjectEffect)
    {
      if (nFrame == 0)
      {
        paramGraphics.drawImage(cBc.cRes.iEffect[0], nObjectEffectPosX - cBc.cRes.iEffect[0].getWidth() / 2, nObjectEffectPosY - cBc.cRes.iEffect[0].getHeight() / 2, 20);
        nFrame = 1;
      }
    }
    else
    {
      i = 0;
      label591:
      if (i >= nArrPosXCnt) {
        break label797;
      }
      if (nArrPosX[i] <= nArrPos[i][1]) {
        break label742;
      }
      localObject = nArrPosX;
      localObject[i] -= Math.abs(nArrPosX[i] - nArrPos[i][1]) / 2;
    }
    for (;;)
    {
      i++;
      break label591;
      if (nFrame != 1) {
        break;
      }
      paramGraphics.drawImage(cBc.cRes.iEffect[1], nObjectEffectPosX - cBc.cRes.iEffect[1].getWidth() / 2, nObjectEffectPosY - cBc.cRes.iEffect[1].getHeight() / 2, 20);
      setEffectPosition(false, 0, 0);
      nFrame = 0;
      break;
      label742:
      if (nArrPosX[i] < nArrPos[i][1])
      {
        localObject = nArrPosX;
        localObject[i] += Math.abs(nArrPosX[i] - nArrPos[i][1]) / 2;
      }
    }
    label797:
    nArrPosXCnt += 1;
    if (nArrPosXCnt > nArrPosCount) {
      nArrPosXCnt = 0;
    }
    int i = 0;
    if (i < nArrPosCount)
    {
      if (nArrPosX[i] > nArrPos[i][1])
      {
        localObject = nArrPosX;
        localObject[i] -= Math.abs(nArrPosX[i] - nArrPos[i][1]) / 2;
      }
      for (;;)
      {
        i++;
        break;
        if (nArrPosX[i] < nArrPos[i][1])
        {
          localObject = nArrPosX;
          localObject[i] += Math.abs(nArrPosX[i] - nArrPos[i][1]) / 2;
        }
      }
    }
    if (nObjectState == 2) {
      i = 1;
    }
    for (;;)
    {
      for (j = 0; j < nArrPosCount; j++) {
        paramGraphics.drawImage(cBc.cRes.iObject[nArrPos[j][0]], nArrPosX[j] + i * j, nStackPosition - nArrPos[j][2], 20);
      }
      break;
      if (nObjectState == 3)
      {
        i = -1;
        continue;
        localObject = cObj[i];
        nFrame += 1;
        j = cObj[i].nFrame / 3;
        paramGraphics.drawImage(cBc.cRes.iObject[(j % 2 * 9 + cObj[i].nType)], cObj[i].nPosX, cObj[i].nPosY, 20);
        break label262;
        label1119:
        return;
      }
      i = 0;
    }
  }
  
  private void drawPanel(Graphics paramGraphics)
  {
    cBc.drawScoreBar(paramGraphics);
    int i = 240 - cBc.cRes.iPlay[12].getWidth() - 2;
    int j = 224 - cBc.cRes.iPlay[12].getHeight() - 2;
    paramGraphics.drawImage(cBc.cRes.iPlay[12], i, j, 20);
    paramGraphics.setColor(247, 138, 24);
    paramGraphics.fillRect(i + 4, j + 14 + 60 - nGaugeTarget, 9, nGaugeTarget);
    paramGraphics.setColor(234, 245, 16);
    paramGraphics.fillRect(i + 4, j + 14 + 60 - nGauge, 9, nGauge);
    if ((nGauge == nGaugeTarget) && (isGaugeEnd))
    {
      nGaugeDelay += 1;
      if (nGaugeDelay <= 3) {
        break label196;
      }
      nGaugeDelay = 0;
      isGaugeEnd = false;
    }
    for (;;)
    {
      return;
      label196:
      paramGraphics.drawImage(cBc.cRes.iPlay[13], i - 2, j + 60 - nGauge + 2, 20);
    }
  }
  
  private void drawPlay(Graphics paramGraphics)
  {
    proc();
    drawBoard(paramGraphics);
    drawDaddy(paramGraphics, cDad.nDirect, cDad.nFrame);
    drawObject(paramGraphics);
    drawMom(paramGraphics);
    drawPanel(paramGraphics);
    cBc.drawHeart(paramGraphics);
    cBc.drawCombo(paramGraphics);
    cBc.drawPointAnimation(paramGraphics);
    cBc.drawMark(paramGraphics);
    drawMark(paramGraphics);
  }
  
  private void drawReady(Graphics paramGraphics)
  {
    drawBoard(paramGraphics);
    drawDaddy(paramGraphics, 0, nFrame % 16);
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
      paramGraphics.drawImage(cBc.cRes.iResult[0], 120, 213, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 153, 132, 20);
      continue;
      paramGraphics.drawImage(cBc.cRes.iResult[1], 120, 213, 33);
      paramGraphics.drawImage(cBc.cRes.iPlayResult[5], 150, 136, 20);
      continue;
      switch (i)
      {
      default: 
        break;
      case 0: 
        paramGraphics.drawImage(cBc.cRes.iResult[2], 120, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 153, 132, 20);
        break;
      case 1: 
        paramGraphics.drawImage(cBc.cRes.iResult[3], 120, 213, 33);
        paramGraphics.drawImage(cBc.cRes.iPlayResult[6], 150, 136, 20);
      }
    }
  }
  
  private void incGauge()
  {
    if (nGauge > nGaugeTarget)
    {
      nGauge -= 1;
      isGaugeEnd = false;
    }
    for (;;)
    {
      return;
      if (nGauge < nGaugeTarget) {
        nGauge += 1;
      }
    }
  }
  
  private void initArray()
  {
    for (int i = 0; i < 11; i++)
    {
      nArrPosX[i] = 0;
      nArrPos[i][0] = 0;
      nArrPos[i][1] = 0;
      nArrPos[i][2] = 0;
    }
    nArrPosXCnt = 0;
    nArrPosCount = 0;
    nArrPosY = 0;
    nArrDrop = 0;
  }
  
  private void initObject(int paramInt1, int paramInt2)
  {
    int i = 48 / 2;
    if (cPoint.isStarPoint())
    {
      cObj[paramInt1].nType = cPoint.getType();
      cObj[paramInt1].nWidth = cBc.cRes.iStar[cObj[paramInt1].nType].getWidth();
      cObj[paramInt1].nHeight = cBc.cRes.iStar[cObj[paramInt1].nType].getHeight();
    }
    for (cObj[paramInt1].isStar = true;; cObj[paramInt1].isStar = false)
    {
      cObj[paramInt1].nPosX = (48 * cBc.cUtil.getRandomInt(0, 4) + i - cObj[paramInt1].nWidth / 2);
      cObj[paramInt1].nPosY = 0;
      cObj[paramInt1].nSpeed = (cBc.nGrade + 6);
      cObj[paramInt1].isActive = false;
      cObj[paramInt1].nActiveFrame = (paramInt2 - cBc.nGrade * 10);
      return;
      cObj[paramInt1].nType = cBc.cUtil.getRandomInt(0, 9);
      cObj[paramInt1].nWidth = cBc.cRes.iObject[cObj[paramInt1].nType].getWidth();
      cObj[paramInt1].nHeight = cBc.cRes.iObject[cObj[paramInt1].nType].getHeight();
    }
  }
  
  private void moveDaddy(int paramInt1, int paramInt2)
  {
    if (cDad.nPosX < 0)
    {
      cDad.nPosX = 0;
      setPressPointer(paramInt1, paramInt2);
      if (cDad.nPosX <= cDad.nPrevPosX) {
        break label151;
      }
      cDad.nDirect = 2;
    }
    for (;;)
    {
      for (paramInt1 = 0; paramInt1 < nArrPosCount; paramInt1++)
      {
        int[] arrayOfInt = nArrPos[paramInt1];
        arrayOfInt[1] += cDad.nPosX - cDad.nPrevPosX;
      }
      if (cDad.nPosX + 36 > 240)
      {
        cDad.nPosX = 204;
        setPressPointer(paramInt1, paramInt2);
        break;
      }
      cDad.nPosX = (paramInt1 - 18 + cDad.nMovePixelX);
      break;
      label151:
      if (cDad.nPosX < cDad.nPrevPosX) {
        cDad.nDirect = 1;
      } else {
        cDad.nDirect = 0;
      }
    }
    if (nArrPosXCnt >= nArrPosCount) {
      nArrPosXCnt = 0;
    }
    cDad.nPrevPosX = cDad.nPosX;
  }
  
  private void proc()
  {
    if ((cBc.isLock()) || (nObjectClearStep == 1) || (nObjectClearStep == 2)) {}
    for (;;)
    {
      return;
      if ((nObjectState == 2) || (nObjectState == 3)) {
        cBc.isMarkEff = true;
      }
      label88:
      int i;
      label106:
      int m;
      int n;
      int k;
      int j;
      switch (nObjectState)
      {
      default: 
        cBc.setGrade(cPoint.nPoint[0]);
        i = 0;
        if (i >= 10) {
          break label1481;
        }
        if (cObj[i].isActive)
        {
          int i1 = cObj[i].nPosY + cObj[i].nSpeed;
          int i2 = nStackPosition - nArrPosY - cObj[i].nHeight;
          m = cDad.nPosX;
          n = cDad.nPosX + 18;
          k = cDad.nPosX + 36;
          j = cObj[i].nPosX + cObj[i].nWidth / 2;
          if ((i1 < i2) || (i1 >= i2 + cObj[i].nSpeed) || (cObj[i].nPosX + cObj[i].nWidth <= m) || (cObj[i].nPosX >= k)) {
            break label1397;
          }
          if (!cObj[i].isStar) {
            break;
          }
          cPoint.increaseComboCount();
          cPoint.increasePointTableStar(cBc.nCurStateSeg, cObj[i].nType);
          cPoint.setPointAnimation(cPoint.nCurPoint, cDad.nPosX + 18, cObj[i].nPosY);
          initObject(i, 450);
          label364:
          if (cObj[i].nPosY >= 378)
          {
            if (!cObj[i].isStar) {
              break label1428;
            }
            cPoint.resetComboCount();
            initObject(i, 450);
          }
        }
        label406:
        if ((!cObj[i].isActive) && (cObj[i].nActiveFrame <= 0)) {
          cObj[i].isActive = true;
        }
        break;
      }
      for (;;)
      {
        i++;
        break label106;
        if (nArrPosCount == 10) {
          isThrow = true;
        }
        if (isThrow)
        {
          if (nObjectClearStep == 0)
          {
            nObjectClearStep = 1;
            resetGauge();
            break;
          }
          if (nObjectClearStep == 3)
          {
            nArrPosY = 0;
            isThrow = false;
            nObjectClearStep = 0;
            switch (nArrPosCount)
            {
            default: 
              i = 0;
            }
          }
        }
        for (;;)
        {
          cPoint.increasePoint(cBc.nCurStateSeg, i);
          cPoint.setPointAnimation(cPoint.nCurPoint, cDad.nPosX + 18, cDad.nPosY - 40);
          localObject = cBc;
          cBc.getClass();
          ((BaseCanvas)localObject).setMark(true, 0);
          initArray();
          incGauge();
          break;
          i = 0;
          continue;
          i = 1;
          continue;
          i = 2;
          continue;
          i = 4;
          continue;
          i = 6;
          continue;
          i = 8;
          continue;
          i = 10;
          continue;
          i = 12;
          continue;
          i = 14;
          continue;
          i = 16;
          continue;
          i = 30;
        }
        cPoint.increasePointTable(cBc.nCurStateSeg, nArrPos[nObjectPrevCnt][0]);
        cPoint.setPointAnimation(cPoint.nCurPoint, cDad.nPosX + 18, nStackPosition - nArrPos[nObjectPrevCnt][2]);
        nArrPos[nObjectPrevCnt][1] = (cDad.nPosX + 18 - nObjectPrevWidth / 2);
        nObjectState = 0;
        setGauge(7);
        break label88;
        if (isObjectKeyFlag) {
          break label88;
        }
        cPoint.increasePointTable(cBc.nCurStateSeg, nArrPos[nObjectPrevCnt][0]);
        cPoint.setPointAnimation(cPoint.nCurPoint, cDad.nPosX + 18, nStackPosition - nArrPos[nObjectPrevCnt][2]);
        nArrPos[nObjectPrevCnt][1] = (cDad.nPosX + 18 - nObjectPrevWidth / 2);
        nObjectState = 0;
        setGauge(7);
        break label88;
        cBc.cSound.playSound(24, 1);
        cBc.setState(2000, 2);
        break;
        if (isObjectKeyFlag) {
          nObjectState = 4;
        }
        for (;;)
        {
          if (cObj[i].nType == 8) {
            nObjectState = 4;
          }
          nObjectPrevCnt = nArrPosCount;
          nObjectPrevWidth = cObj[i].nWidth;
          nArrPosY += cObj[i].nHeight;
          nArrPos[nArrPosCount][0] = cObj[i].nType;
          nArrPos[nArrPosCount][1] = cObj[i].nPosX;
          nArrPosX[nArrPosCount] = cObj[i].nPosX;
          nArrPos[nArrPosCount][2] = nArrPosY;
          nArrPos[nArrPosCount][3] = (cObj[i].nPosX + cObj[i].nWidth / 2);
          nArrPosCount += 1;
          setEffectPosition(true, cObj[i].nPosX + cObj[i].nWidth / 2, cObj[i].nPosY + cObj[i].nHeight);
          if ((nObjectState != 4) && ((nArrPosCount == 4) || (nArrPosCount == 6) || (nArrPosCount == 8) || (nArrPosCount == 10))) {
            cBc.setEvent(true);
          }
          initObject(i, 450);
          break;
          if (cBc.cSound.nCurIdx != 7) {
            cBc.cSound.playSound(8, 1);
          }
          if ((n - 5 <= j) && (n + 5 >= j))
          {
            nObjectState = 1;
          }
          else
          {
            if ((m < j) && (k > j))
            {
              if (n < j)
              {
                nObjectState = 2;
                localObject = cBc;
                cBc.getClass();
                ((BaseCanvas)localObject).setMark(true, 3);
              }
              for (;;)
              {
                isObjectKeyFlag = true;
                break;
                nObjectState = 3;
                localObject = cBc;
                cBc.getClass();
                ((BaseCanvas)localObject).setMark(true, 4);
              }
            }
            nObjectState = 4;
          }
        }
        label1397:
        localObject = cObj[i];
        nPosY += cObj[i].nSpeed;
        break label364;
        label1428:
        if (cObj[i].nType != 8) {
          nObjectState = 4;
        }
        initObject(i, 450);
        break label406;
        localObject = cObj[i];
        nActiveFrame -= 1;
      }
      label1481:
      if (nArrPosXCnt >= 11) {
        nArrPosXCnt = 0;
      }
      Object localObject = cDad;
      nFrame += 1;
      if (cDad.nFrame > 16) {
        cDad.nFrame = 0;
      }
    }
  }
  
  private void resetGauge()
  {
    nGaugeTarget = 0;
  }
  
  private void setEffectPosition(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    isObjectEffect = paramBoolean;
    nObjectEffectPosX = paramInt1;
    nObjectEffectPosY = paramInt2;
  }
  
  private void setGauge(int paramInt)
  {
    nGaugeTarget += paramInt;
    if (nGaugeTarget >= 60) {
      nGaugeTarget = 61;
    }
    isGaugeEnd = true;
  }
  
  private void setPressPointer(int paramInt1, int paramInt2)
  {
    cDad.nMovePixelX = (cDad.nPosX + 18 - paramInt1);
    cDad.nMovePixelY = (cDad.nPosY - paramInt2);
  }
  
  private void setPrevPosX(int paramInt)
  {
    cDad.nPrevPosX = paramInt;
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
    BaseCanvas localBaseCanvas = cBc;
    cBc.getClass();
    localBaseCanvas.setMark(false, 0);
    cPoint.initPoint();
    cPoint.resetComboCount();
    isGaugeEnd = false;
    nGauge = 0;
    nGaugeDelay = 0;
    nGaugeTarget = 0;
    nArrDrop = 0;
    cDad.isMove = false;
    cDad.nFrame = 0;
    cDad.nPosX = 102;
    cDad.nPosY = 303;
    cDad.nPrevPosX = 0;
    cDad.nDirect = 0;
    nStackPosition = cDad.nPosY;
    nObjectState = 0;
    nObjectPrevCnt = 0;
    isObjectKeyFlag = false;
    nObjectClearStep = 0;
    isThrow = false;
    nMomFrame = 0;
    initObject();
    initArray();
  }
  
  public void initObject()
  {
    for (int i = 0; i < 10; i++) {
      initObject(i, i * 45);
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
      moveDaddy(paramInt1, paramInt2);
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
      if ((!isObjectKeyFlag) && (cBc.isPointer(paramInt1, paramInt2, 202, 297, 240, 348))) {
        isThrow = true;
      }
      if (cBc.isPointer(paramInt1, paramInt2, cDad.nPosX + 18 - 42, cDad.nPosY - 70 - 10, cDad.nPosX + 18 + 42, cDad.nPosY + 70 - 10))
      {
        setPrevPosX(cDad.nPosX);
        setPressPointer(paramInt1, paramInt2);
      }
      if (cDad.nPosX > paramInt1)
      {
        if (nObjectState == 2) {
          isObjectKeyFlag = false;
        }
      }
      else if ((cDad.nPosX <= paramInt1) && (nObjectState == 3)) {
        isObjectKeyFlag = false;
      }
    }
  }
  
  public void pointerReleased(int paramInt1, int paramInt2)
  {
    switch (cBc.nCurStateOff)
    {
    }
    for (;;)
    {
      return;
      cDad.nDirect = 0;
    }
  }
  
  private class Daddy
  {
    boolean isMove;
    int nDirect;
    int nFrame;
    int nMovePixelX;
    int nMovePixelY;
    int nPosX;
    int nPosY;
    int nPrevPosX;
    
    private Daddy() {}
    
    Daddy(DrawPlay00.1 param1)
    {
      this();
    }
  }
  
  private class Object
  {
    boolean isActive;
    boolean isStar;
    int nActiveFrame;
    int nFrame;
    int nHeight;
    int nPosX;
    int nPosY;
    int nSpeed;
    int nType;
    int nWidth;
    
    private Object() {}
    
    Object(DrawPlay00.1 param1)
    {
      this();
    }
  }
}
