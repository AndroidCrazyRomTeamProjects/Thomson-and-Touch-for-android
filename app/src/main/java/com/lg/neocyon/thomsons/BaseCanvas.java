package com.lg.neocyon.thomsons;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;


public class BaseCanvas{

    public boolean isOncePlay = false;
    public boolean isResumePlay = false;
    private final int NOTHING = -1;
    private final int OPEN_STAGE_STAR = 300;
    private final int GRADE_UP_POINT = 30;
    private final int LOGO_FRAME_LG = 4;
    private final int LOGO_FRAME_NEOCYON = 4;
    private final int BUTTON_LEFT = 1;
    private final int BUTTON_MIDDLE = 2;
    private final int BUTTON_RIGHT = 3;
    private final int BUTTON_NOTHING = 0;
    private final int BUTTON_SETUP = 20;
    private final int BUTTON_SCORE = 10;
    private final int BUTTON_OK = 21;
    private final int BUTTON_END = 30;
    private final int BUTTON_BACK = 31;
    private final int BUTTON_MENU = 32;
    private final int BUTTON_RESUME = 40;
    private final int GAMEOVER_FRAME = 30;
    public final int MAX_HEART = 3;
    public final int MAX_HEART_FRAME = 3;
    public final int MARK_CLEAR = 0;
    public final int MARK_EVENT = 1;
    public final int MARK_OK = 2;
    public final int MARK_LEFT = 3;
    public final int MARK_RIGHT = 4;
    public final int BOUNUS_BOX_FRAME = 30;
    public int LANG;
    public int nStarInc;
    public byte[] byVenusSet;
    public MIDlet midlet;
    public Display display;
    public boolean isCall;
    public int nGameIdx;
    public int nFrame;
    public int nFrame2;
    public Thread thread;
    public boolean isAppExecute;
    public Sound cSound;
    public Resource cRes;
    public Util cUtil;
    public Point cPoint;
    public Rms cRms;
    public MainActivity cMenu;
    public ChefGame cPlay00;
    //public DrawPlay02 cPlay02;
    //public DrawPlay03 cPlay03;
    //public DrawPlay04 cPlay04;
    public DogGame cPlay05;
    // public DrawPlay06 cPlay06;
    public StringBuffer strBuf;
    public int nPointerX;
    public int nPointerY;
    public int nPrevStateSeg;
    public int nPrevStateOff;
    public int nCurStateSeg;
    public int nCurStateOff;
    public boolean isResource;
    public int nTargetLcd;
    public int nPopupState;
    public int nButtonLeft;
    public int nButtonMiddle;
    public int nButtonRight;
    public int[] nHiddenGameIdx;
    public int[] nHiddenGameActive;
    public int[] nSetup;
    public boolean isPressed;
    public boolean isReleased;
    public boolean isDragged;
    public int nPointerFrame;
    public int nMarkIdx;
    public int nMarkFrame;
    public boolean isMarkEff;
    public boolean isEvent;
    public int nEventTypeCh;
    public int nEventTypeText;
    public boolean isNewRecord;
    public int nPressType;
    public int nPressTypeP;
    public int nScorePage;
    public int nResultAniFrame;
    public int nGrade;
    public int nHeart;
    public int nHeartFrame;
    public boolean isBounusBox;
    public int nBounusBox;
    public int nBounusBoxFrame;
    public boolean outOfMem = false;
    public int outOfMemCnt = 0;
    public int outOfMemWhere = 0;

    public BaseCanvas(Drawable) {
        midlet = Drawable;
        display = Display.getDisplay(Drawable);
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
        cPoint = new Point(this);
        cMenu = new MainActivity(this);
        cPlay00 = new ChefGame(this);
        //cPlay02 = new DrawPlay02(this);
        //cPlay03 = new DrawPlay03(this);
        //cPlay04 = new DrawPlay04(this);
        cPlay05 = new DogGame(this);
        //cPlay06 = new DrawPlay06(this);
        init();
        thread = new Thread(this);
        thread.start();
    }

    public int init() {
        String str = System.getProperty("microedition.locale");
        if (str.substring(0, 2).equals("en")) {
            LANG = 0;
        } else if (str.substring(0, 2).equals("de")) {
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
        } else if (str.substring(0, 2).equals("zh")) {
            if (str.substring(3, 5).equals("CN")) {
                LANG = 6;
            } else if (str.substring(3, 5).equals("TW")) {
                LANG = 0;
            } else if (str.substring(3, 5).equals("HK")) {
                LANG = 9;
            } else {
                LANG = 6;
            }
        } else {
            LANG = 0;
        }
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

        public void pause ()
        {
            cSound.soundStop();
            isCall = true;
            switch (nCurStateSeg) {
                case 1000:
                    break;
                case 2000:
                case 2001:
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                case 2006:
                    if (nCurStateOff == 1) {
                        setPopupState(1);
                        setState(nCurStateSeg, nCurStateOff);
                    }
                    break;
            }
        }

        public void resume ()
        {
            isCall = false;
            if (isOncePlay) {
                isResumePlay = true;
            }
            if (!isOncePlay) {
                isOncePlay = true;
            }
        }

        public void quit ()
        {
            isAppExecute = false;
            cSound.stopSound();
            cRes.free();
            System.gc();
            midlet.notifyDestroyed();
        }

        public long getCurTime ()
        {
            return System.currentTimeMillis();
        }

        public void setButtonType ( int paramInt)
        {
            nPressType = paramInt;
        }

        public void setButtonTypeP ( int paramInt)
        {
            nPressTypeP = paramInt;
        }

        public void setGameIdx ( int paramInt)
        {
            nGameIdx = paramInt;
        }

        public int getAnimationFrame ( int paramInt1, int paramInt2, int paramInt3)
        {
            return paramInt1 / paramInt2 % paramInt3;
        }

        public void setPressedPointer ( int paramInt1, int paramInt2, boolean paramBoolean)
        {
            nPointerX = paramInt1;
            nPointerY = paramInt2;
            isPressed = paramBoolean;
            nPointerFrame = 0;
        }

        public void setReleasedPointer ( int paramInt1, int paramInt2, boolean paramBoolean)
        {
            nPointerX = paramInt1;
            nPointerY = paramInt2;
            isReleased = paramBoolean;
            nPointerFrame = 0;
        }

        public void setButton ( int paramInt1, int paramInt2, int paramInt3)
        {
            nButtonLeft = paramInt1;
            nButtonMiddle = paramInt2;
            nButtonRight = paramInt3;
        }

        public void setBottomButton ( int paramInt1, int paramInt2)
        {
            switch (getPopupState()) {
                case 2:
                case 3:
                case 4:
                case 5:
                    setButton(0, 0, 31);
                    return;
                case 1:
                    if (!isCall) {
                        cSound.playSound(0, 1);
                    }
                    setButton(0, 0, 40);
                    return;
                case 6:
                case 7:
                    setButton(0, 0, 0);
                    return;
            }
            switch (paramInt1) {
                case 0:
                    setButton(0, 0, 0);
                    break;
                case 1000:
                    switch (paramInt2) {
                        case 0:
                            if (cMenu.isActive()) {
                                setButton(10, 20, 31);
                            } else {
                                setButton(10, 20, 30);
                            }
                            break;
                    }
                    break;
                case 2000:
                case 2001:
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                case 2006:
                    switch (paramInt2) {
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
                    break;
            }
        }

        public void setPopupState ( int paramInt)
        {
            nPopupState = paramInt;
            if ((nCurStateOff == 1) && (paramInt == 0)) {
                cSound.stopSound();
            }
        }

        public int getPopupState ()
        {
            return nPopupState;
        }

        public void setGrade ( int paramInt)
        {
            nGrade = (paramInt / 30);
            if (nGrade > 7) {
                nGrade = 7;
            }
        }

        public void setEvent ( boolean paramBoolean)
        {
            cSound.playSound(7, 1);
            isEvent = paramBoolean;
            nEventTypeCh = cUtil.getRandomInt(0, 7);
            nEventTypeText = cUtil.getRandomInt(0, 2);
        }

        public void setMark ( boolean paramBoolean, int paramInt)
        {
            nMarkIdx = paramInt;
            nMarkFrame = 0;
            isMarkEff = paramBoolean;
        }

        public void setState ( int paramInt1, int paramInt2)
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

        public void setTargetLcd ( int paramInt)
        {
            nTargetLcd = paramInt;
        }

        public int getTargetLcd ()
        {
            return nTargetLcd;
        }

        public void setNewRecord ()
        {
            isNewRecord = cPoint.isNewRecord();
            if (isNewRecord) {
                cPoint.nHighPoint[nGameIdx] = cPoint.nPoint[nGameIdx];
            }
        }

        public void setHeart ( int paramInt)
        {
            nHeart = paramInt;
        }

        public void resetHeart ()
        {
            setHeart(3);
        }

        public boolean isStarCheck ()
        {
            if (cPoint.nStarPoint[0] >= 300) {
                cPoint.nStarPoint[0] -= 300;
                return true;
            }
            nScorePage = 1;
            return false;
        }

        public boolean isLock ()
        {
            return (isResource) || (isEvent) || (getPopupState() != 0) || (nCurStateOff == 2);
        }

        public boolean isSoundLock ()
        {
            return getPopupState() != 0;
        }

        public void drawClear (Graphics paramGraphics)
        {
            paramGraphics.setColor(16777215);
            paramGraphics.fillRect(0, 0, 240, 378);
            paramGraphics.setColor(0);
        }

        public void drawMark (Graphics paramGraphics)
        {
            if (isMarkEff) {
                int i = 0;
                i = getAnimationFrame(nMarkFrame, 2, 2);
                if (i == 0) {
                    paramGraphics.drawImage(cRes.iMark[nMarkIdx], 120, 60, 3);
                }
                nMarkFrame += 1;
                if (nMarkFrame > 20) {
                    nMarkFrame = 0;
                    isMarkEff = false;
                }
            } else {
                nMarkFrame = 0;
            }
        }

        public void drawClipImage (Graphics paramGraphics, Image paramImage,int paramInt1,
        int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
        {
            paramGraphics.setClip(paramInt3 + paramInt1, paramInt4 + paramInt2, paramInt5, paramInt6);
            paramGraphics.drawImage(paramImage, paramInt1, paramInt2, paramInt7);
            paramGraphics.setClip(0, 0, 240, 378);
        }

        public void drawDot (Graphics paramGraphics,int paramInt1, int paramInt2, int paramInt3,
        int paramInt4, int paramInt5)
        {
            int i = paramGraphics.getColor();
            paramGraphics.setColor(paramInt5);
            paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
            paramGraphics.setColor(i);
        }

        public void drawNumber (Graphics paramGraphics, Image[]paramArrayOfImage,int paramInt1,
        int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
        {
            strBuf.delete(0, strBuf.length());
            String str = String.valueOf(paramInt1);
            int i = str.length();
            if (paramInt5 < i) {
                strBuf.delete(0, strBuf.length());
                for (j = 0; j < paramInt5; j++) {
                    strBuf.append("9");
                }
                str = strBuf.toString();
                i = str.length();
                strBuf.delete(0, strBuf.length());
            }
            if (paramBoolean) {
                strBuf.delete(0, strBuf.length());
                for (j = 0; j < paramInt5 - i; j++) {
                    strBuf.append("0");
                }
            }
            strBuf.append(str);
            str = strBuf.toString();
            i = str.length();
            int j = 0;
            int k = 0;
            int m = 0;
            int n = 0;
            int i1 = 0;
            for (int i2 = 0; i2 < i; i2++) {
                k = str.charAt(i - 1 - i2) - '0';
                j = paramArrayOfImage[k].getWidth();
                m += j + 1 + paramInt4;
                n = paramInt2 - m;
                i1 = paramInt3;
                paramGraphics.drawImage(paramArrayOfImage[k], n, i1, 20);
            }
        }

        public void drawNumber_ (Graphics paramGraphics, Image[]paramArrayOfImage,int paramInt1,
        int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
        {
            strBuf.delete(0, strBuf.length());
            String str = String.valueOf(paramInt1);
            int i = str.length();
            if (paramInt5 < i) {
                strBuf.delete(0, strBuf.length());
                for (j = 0; j < paramInt5; j++) {
                    strBuf.append("9");
                }
                str = strBuf.toString();
                i = str.length();
                strBuf.delete(0, strBuf.length());
            }
            if (paramBoolean) {
                strBuf.delete(0, strBuf.length());
                for (j = 0; j < paramInt5 - i; j++) {
                    strBuf.append("0");
                }
            }
            strBuf.append(str);
            str = strBuf.toString();
            i = str.length();
            int j = 0;
            int k = 0;
            int m = 0;
            int n = 0;
            int i1 = 0;
            for (int i2 = 0; i2 < i; i2++) {
                k = str.charAt(i - 1 - i2) - '0';
                j = paramArrayOfImage[k].getHeight();
                m += j + 1 + paramInt4;
                n = paramInt2;
                i1 = paramInt3 - m;
                paramGraphics.drawImage(paramArrayOfImage[k], n, i1, 20);
            }
        }

        public void drawPointAnimation (Graphics paramGraphics)
        {
            int i = 0;
            for (i = 0; ; i++) {
                cPoint.getClass();
                if (i >= 5) {
                    break;
                }
                if (cPoint.cAni[i].isActive) {
                    int j = 0;
                    if (nCurStateSeg == 2004) {
                        if (cPoint.cAni[i].nPoint >= 10) {
                            j = cPoint.cAni[i].nPosY - 32;
                        } else {
                            j = cPoint.cAni[i].nPosY - 22;
                        }
                        paramGraphics.drawImage(cRes.iPlayPointNum[10], cPoint.cAni[i].nPosX - 1 + cPoint.cAni[i].nFrame, j, 20);
                        drawNumber_(paramGraphics, cRes.iPlayPointNum, cPoint.cAni[i].nPoint, cPoint.cAni[i].nPosX + cPoint.cAni[i].nFrame, cPoint.cAni[i].nPosY, 0, 2, false);
                    } else {
                        if (cPoint.cAni[i].nPoint >= 10) {
                            j = cPoint.cAni[i].nPosX - 30;
                        } else {
                            j = cPoint.cAni[i].nPosX - 20;
                        }
                        paramGraphics.drawImage(cRes.iPlayPointNum[10], j, cPoint.cAni[i].nPosY - 1 - cPoint.cAni[i].nFrame, 20);
                        drawNumber(paramGraphics, cRes.iPlayPointNum, cPoint.cAni[i].nPoint, cPoint.cAni[i].nPosX, cPoint.cAni[i].nPosY - cPoint.cAni[i].nFrame, 0, 2, false);
                    }
                    cPoint.cAni[i].nFrame += 1;
                    if (cPoint.cAni[i].nFrame > 5) {
                        cPoint.cAni[i].isActive = false;
                        cPoint.cAni[i].nFrame = 0;
                    }
                }
            }
        }

        public void drawComboText (Graphics paramGraphics,int paramInt1, int paramInt2,
        int paramInt3)
        {
            paramGraphics.drawImage(cRes.iCombo[25], paramInt1, paramInt2, 3);
            if (nCurStateSeg == 2004) {
                paramGraphics.drawImage(cRes.iCombo[(paramInt3 - 1)], paramInt1 + 20, paramInt2, 3);
            } else {
                paramGraphics.drawImage(cRes.iCombo[(paramInt3 - 1)], paramInt1, paramInt2 - 16, 3);
            }
        }

        public void drawCombo (Graphics paramGraphics)
        {
            if (cPoint.isComboAni) {
                int i = cPoint.getComboCount();
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        if (cPoint.nComboFrame == 0) {
                            cSound.playSound(4, 1);
                        } else {
                            paramGraphics.drawImage(cRes.iCombo[(7 + cPoint.nComboFrame)], 120, 112, 3);
                        }
                        if (nCurStateSeg == 2004) {
                            drawComboText(paramGraphics, 100, 112, i);
                        } else {
                            drawComboText(paramGraphics, 120, 132, i);
                        }
                        cPoint.nComboFrame += 1;
                        if (cPoint.nComboFrame == 6) {
                            cPoint.isComboAni = false;
                            cPoint.nComboFrame = 0;
                        }
                        break;
                    case 2:
                    case 3:
                        if (cPoint.nComboFrame == 0) {
                            cSound.playSound(5, 1);
                        } else {
                            paramGraphics.drawImage(cRes.iCombo[(13 + cPoint.nComboFrame)], 120, 112, 3);
                        }
                        if (nCurStateSeg == 2004) {
                            drawComboText(paramGraphics, 92, 112, i);
                        } else {
                            drawComboText(paramGraphics, 120, 140, i);
                        }
                        cPoint.nComboFrame += 1;
                        if (cPoint.nComboFrame == 6) {
                            cPoint.isComboAni = false;
                            cPoint.nComboFrame = 0;
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        if (cPoint.nComboFrame == 0) {
                            cSound.playSound(6, 1);
                        } else {
                            paramGraphics.drawImage(cRes.iCombo[(19 + cPoint.nComboFrame)], 120, 112, 3);
                        }
                        if (nCurStateSeg == 2004) {
                            drawComboText(paramGraphics, 122, 112, i);
                        } else {
                            drawComboText(paramGraphics, 120, 110, i);
                        }
                        cPoint.nComboFrame += 1;
                        if (cPoint.nComboFrame == 6) {
                            cPoint.isComboAni = false;
                            cPoint.nComboFrame = 0;
                            if (i == 7) {
                                cPoint.nComboCount = 1;
                            }
                        }
                        break;
                }
            }
        }

        public void drawScoreBar (Graphics paramGraphics)
        {
            if (nCurStateSeg == 2004) {
                paramGraphics.drawImage(cRes.iText_[0], 224, 2, 20);
                paramGraphics.drawImage(cRes.iText_[1], 224, 122, 20);
                drawNumber_(paramGraphics, cRes.iBlueNum_, cPoint.nHighPoint[nGameIdx], 224, 110, 0, 4, true);
                drawNumber_(paramGraphics, cRes.iRedNum_, cPoint.nPoint[nGameIdx], 224, 244, 0, 4, true);
            } else {
                paramGraphics.drawImage(cRes.iText[0], 2, 2, 20);
                paramGraphics.drawImage(cRes.iText[1], 116, 2, 20);
                drawNumber(paramGraphics, cRes.iBlueNum, cPoint.nHighPoint[nGameIdx], 110, 2, 0, 4, true);
                drawNumber(paramGraphics, cRes.iRedNum, cPoint.nPoint[nGameIdx], 238, 2, 0, 4, true);
            }
        }

        public void drawHeart (Graphics paramGraphics)
        {
            drawHeart(paramGraphics, 3);
        }

        public void drawHeart (Graphics paramGraphics,int paramInt)
        {
            if (nCurStateSeg == 2006) {
                return;
            }
            int i = 0;
            int j = 0;
            for (i = 0; (i < 3) && (i < paramInt) && (i < nHeart); i++) {
                if (i == nHeart - 1) {
                    j = nHeartFrame;
                } else {
                    j = 0;
                }
                if (j == -1) {
                    return;
                }
                if (nCurStateSeg == 2004) {
                    paramGraphics.drawImage(cRes.iHeart[j], 230, 304 - i * 20, 3);
                } else {
                    paramGraphics.drawImage(cRes.iHeart[j], 220 - i * 20, 30, 3);
                }
            }
        }

        public void drawReadyStart (Graphics paramGraphics)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            int m = 0;
            i = 120;
            j = 112;
            if (nFrame == 0) {
                cSound.playSound(23, 1);
                nFrame = 1;
            }
            if (nFrame < 4) {
                k = cRes.iPlayText[0].getWidth() / nFrame;
                if (nHeart == 3) {
                    m = 0;
                } else {
                    m = 8;
                    drawHeart(paramGraphics, 3);
                }
                paramGraphics.drawImage(cRes.iPlayText[m], i - k, j, 3);
                nFrame += 1;
            } else if (nFrame < 10) {
                if (nHeart == 3) {
                    m = 1 + nFrame % 2;
                    if (nFrame >= 8) {
                        drawHeart(paramGraphics, 1);
                    }
                } else {
                    m = 9 + nFrame % 2;
                    drawHeart(paramGraphics, 3);
                }
                paramGraphics.drawImage(cRes.iPlayText[m], i, j, 3);
                nFrame += 1;
            } else if (nFrame < 12) {
                if (nHeart == 3) {
                    m = 3;
                    drawHeart(paramGraphics, 2);
                } else {
                    m = 11;
                    drawHeart(paramGraphics, 3);
                }
                paramGraphics.drawImage(cRes.iPlayText[m], i, j, 3);
                nFrame += 1;
            } else if (nFrame < 14) {
                drawHeart(paramGraphics, 3);
                nFrame += 1;
            } else if (nFrame == 14) {
                drawHeart(paramGraphics, 3);
                setState(nCurStateSeg, 1);
                nFrame = 0;
            }
        }

        public void drawGameOver (Graphics paramGraphics)
        {
            if (nFrame == 0) {
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
            if (nCurStateSeg == 2004) {
                if (nHeart == 1) {
                    if (nFrame > 7) {
                        i = 5 + nFrame / 2 % 2;
                        paramGraphics.drawImage(cRes.iPlayText[i], 162, 112 - cRes.iPlayText[i].getHeight() / 2, 20);
                    }
                    if (nFrame > 12) {
                        paramGraphics.drawImage(cRes.iText_[2], 108, 56, 3);
                        paramGraphics.drawImage(cRes.iText_[1], 108, 126, 3);
                        drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nPoint[nGameIdx], 100, 230, 0, 4, true);
                    }
                    if (nFrame > 13) {
                        paramGraphics.drawImage(cRes.iOverStar[1], 76, 50, 3);
                        paramGraphics.drawImage(cRes.iText_[1], 76, 126, 3);
                        drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nStarPoint[0], 69, 230, 0, 4, true);
                    }
                }
                drawHeart(paramGraphics);
            } else {
                if (nHeart == 1) {
                    if (nFrame > 7) {
                        paramGraphics.drawImage(cRes.iPlayText[(5 + nFrame / 2 % 2)], 120, 54, 17);
                    }
                    if (nFrame > 12) {
                        paramGraphics.drawImage(cRes.iText[2], 44, 134, 3);
                        paramGraphics.drawImage(cRes.iText[1], 114, 134, 3);
                        drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nPoint[nGameIdx], 228, 126, 0, 4, true);
                        drawDot(paramGraphics, 149, 130, 3, 3, 0);
                        drawDot(paramGraphics, 149, 136, 3, 3, 0);
                    }
                    if (nFrame > 13) {
                        paramGraphics.drawImage(cRes.iOverStar[0], 44, 158, 3);
                        paramGraphics.drawImage(cRes.iText[1], 114, 158, 3);
                        drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nStarPoint[0], 228, 150, 0, 4, true);
                        drawDot(paramGraphics, 149, 154, 3, 3, 0);
                        drawDot(paramGraphics, 149, 160, 3, 3, 0);
                    }
                }
                drawHeart(paramGraphics);
            }
            if (((nHiddenGameActive[0] == 0) || (nHiddenGameActive[1] == 0)) && (cPoint.nStarPoint[0] >= 300) && (nHeart == 1)) {
                nBounusBox = 30;
            } else {
                nBounusBox = 0;
                nBounusBoxFrame = 0;
            }
            if (nBounusBox != 0) {
                i = 0;
                if (nFrame > 30) {
                    i = nFrame2 / 2 % 3 * 3;
                    if (nCurStateSeg == 2004) {
                        paramGraphics.drawImage(cRes.iPlayText[12], 120, 112, 3);
                        paramGraphics.drawImage(cRes.iStar[(0 + i)], 144, 52, 3);
                        paramGraphics.drawImage(cRes.iStar[(1 + i)], 144, 112, 3);
                        paramGraphics.drawImage(cRes.iStar[(2 + i)], 144, 172, 3);
                        paramGraphics.drawImage(cRes.iPlayText[13], 96, 112, 3);
                    } else {
                        paramGraphics.drawImage(cRes.iPlayText[12], 120, 112, 3);
                        paramGraphics.drawImage(cRes.iStar[(0 + i)], 60, 88, 3);
                        paramGraphics.drawImage(cRes.iStar[(1 + i)], 120, 88, 3);
                        paramGraphics.drawImage(cRes.iStar[(2 + i)], 180, 88, 3);
                        paramGraphics.drawImage(cRes.iPlayText[13], 120, 136, 3);
                    }
                    nFrame2 += 1;
                }
            }
            if (nFrame > 30 + nBounusBox) {
                nHeart -= 1;
                nHeartFrame = 0;
                if (nHeart == 0) {
                    setPopupState(7);
                    setNewRecord();
                    if (getPopupState() != 0) {
                        cSound.playSound(2, 1);
                    }
                    setState(nCurStateSeg, 3);
                    nFrame = 0;
                    resetHeart();
                } else {
                    switch (nCurStateSeg) {
                        case 2000:
                            cPlay00.init();
                            break;
                        /*case 2002:
                            cPlay02.init();
                            break
                        case 2003:
                            cPlay03.init();
                            break;
                        case 2004:
                            cPlay04.init();
                            break;*/
                        case 2005:
                            cPlay05.init();
                            break;
                        /*case 2006:
                            cPlay06.init();*/
                    }
                    nFrame = 0;
                    setPopupState(0);
                    setState(nCurStateSeg, 0);
                }
            }
        }

        public void drawGameResultBack (Graphics paramGraphics)
        {
            if (isNewRecord) {
                paramGraphics.drawImage(cRes.iPlayResult[0], 0, 0, 20);
                if (nCurStateSeg == 2004) {
                    paramGraphics.drawImage(cRes.iPlayResult[9], 135, 112, 3);
                } else {
                    paramGraphics.drawImage(cRes.iPlayResult[9], 120, 38, 17);
                }
            } else {
                paramGraphics.drawImage(cRes.iPlayResult[1], 0, 0, 20);
            }
        }

        public void drawGameResultForward (Graphics paramGraphics)
        {
            int i = 6;
            if (isNewRecord) {
                if (nCurStateSeg == 2004) {
                    paramGraphics.drawImage(cRes.iPlayResult[2], 212, 112, 3);
                    paramGraphics.drawImage(cRes.iPlayResult[4], 176, 112, 3);
                    drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 140, 143, 0, 4, true);
                    if (nResultAniFrame > i) {
                        paramGraphics.drawImage(cRes.iPlayResult[7], 120, 52, 3);
                    }
                } else {
                    paramGraphics.drawImage(cRes.iPlayResult[2], 120, 30, 3);
                    paramGraphics.drawImage(cRes.iPlayResult[4], 120, 72, 3);
                    drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 159, 96, 0, 4, true);
                    if (nResultAniFrame > i) {
                        paramGraphics.drawImage(cRes.iPlayResult[7], 160, 96, 20);
                    }
                }
            } else if (nCurStateSeg == 2004) {
                paramGraphics.drawImage(cRes.iPlayResult[3], 212, 112, 3);
                paramGraphics.drawImage(cRes.iPlayResult[4], 176, 112, 3);
                drawNumber_(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 140, 143, 0, 4, true);
                if (nResultAniFrame > i) {
                    paramGraphics.drawImage(cRes.iPlayResult[8], 120, 52, 3);
                }
            } else {
                paramGraphics.drawImage(cRes.iPlayResult[3], 120, 30, 3);
                paramGraphics.drawImage(cRes.iPlayResult[4], 120, 72, 3);
                drawNumber(paramGraphics, cRes.iPlayResultNum, cPoint.nHighPoint[nGameIdx], 159, 96, 0, 4, true);
                if (nResultAniFrame > i) {
                    paramGraphics.drawImage(cRes.iPlayResult[8], 160, 96, 20);
                }
            }
        }

        public void drawMenuBG (Graphics paramGraphics)
        {
            int i = 0;
            int j = 0;
            j = cRes.iMenuBG.getWidth();
            i = 0;
            while (i < 240) {
                paramGraphics.drawImage(cRes.iMenuBG, i, 0, 20);
                i += j;
            }
        }

        private void drawLogoLG (Graphics paramGraphics)
        {
            if (nFrame == 8) {
                cRes.loadCommonImage();
            }
            int i = 0;
            if (nFrame == 16) {
                nFrame = 0;
                setState(0, 2);
                return;
            }
            if (nFrame < 8) {
                i = nFrame / 2;
            } else {
                i = 8 - nFrame / 2 - 1;
            }
            paramGraphics.drawImage(cRes.iLogo_LG[i], 120, 189, 3);
            nFrame += 1;
        }

        private void drawLogoNEO (Graphics paramGraphics)
        {
            int i = 0;
            if (nFrame < 4) {
                i = nFrame;
            } else {
                nFrame = 0;
                cRes.loadCommonImage2();
                setState(1000, 0);
                return;
            }
            drawClear(paramGraphics);
            paramGraphics.drawImage(cRes.iLogo_NEOCYON[i], 120, 189, 3);
            nFrame += 1;
        }

        public void drawBottomButton (Graphics paramGraphics)
        {
            drawBottomButton(paramGraphics, nButtonLeft, nButtonMiddle, nButtonRight);
        }

        private void drawBottomButton (Graphics paramGraphics,int paramInt1, int paramInt2,
        int paramInt3)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            if ((nCurStateSeg != 1000) && (getPopupState() == 0)) {
                paramGraphics.setColor(0);
                paramGraphics.fillRect(0, 348, 240, 40);
            }
            switch (paramInt1) {
                case 10:
                    if (nPressType == 1) {
                        i = 14;
                    } else {
                        i = 0;
                    }
                    paramGraphics.drawImage(cRes.iBottomButton[i], 0, 376, 36);
            }
            switch (paramInt2) {
                case 20:
                    if (nPressType == 2) {
                        j = 15;
                    } else {
                        j = 1;
                    }
                    paramGraphics.drawImage(cRes.iBottomButton[j], 120 - cRes.iBottomButton[j].getWidth() / 2, 376, 36);
            }
            switch (paramInt3) {
                case 30:
                    if (nPressType == 3) {
                        k = 16;
                    } else {
                        k = 2;
                    }
                    paramGraphics.drawImage(cRes.iBottomButton[k], 240 - cRes.iBottomButton[k].getWidth(), 376, 36);
                    break;
                case 31:
                    if (nPressType == 3) {
                        k = 17;
                    } else {
                        k = 3;
                    }
                    paramGraphics.drawImage(cRes.iBottomButton[k], 240 - cRes.iBottomButton[k].getWidth(), 376, 36);
                    break;
                case 32:
                    if (nPressType == 3) {
                        k = 18;
                    } else {
                        k = 11;
                    }
                    paramGraphics.drawImage(cRes.iBottomButton[k], 240 - cRes.iBottomButton[k].getWidth(), 376, 36);
                    break;
                case 40:
                    if (nPressType == 3) {
                        k = 17;
                    } else {
                        k = 3;
                    }
                    paramGraphics.drawImage(cRes.iBottomButton[k], 240 - cRes.iBottomButton[k].getWidth(), 376, 36);
            }
        }

        public void drawBox (Graphics paramGraphics)
        {
            paramGraphics.drawImage(cRes.iBox[0], 0, 224, 20);
        }

        public void drawTouchText (Graphics paramGraphics)
        {
            int i = 50;
            int j = 18;
            if ((cMenu.isActive()) && (getPopupState() == 0)) {
                nFrame2 += 1;
                if (nFrame2 / 5 % 2 == 0) {
                    paramGraphics.drawImage(cRes.iTouchText, 240 - i, 224 + j, 3);
                }
                if (nFrame2 >= 5) {
                    nFrame2 = 0;
                }
            } else {
                paramGraphics.drawImage(cRes.iTouchText, 240 - i, 224 + j, 3);
            }
        }

        public void drawPopup (Graphics paramGraphics)
        {
            switch (getPopupState()) {
                case 2:
                    drawBox(paramGraphics);
                    drawEnd(paramGraphics);
                    drawBottomButton(paramGraphics);
                    break;
                case 1:
                    drawBox(paramGraphics);
                    drawMenu(paramGraphics);
                    drawBottomButton(paramGraphics);
                    break;
                case 3:
                    drawBox(paramGraphics);
                    drawScore(paramGraphics);
                    drawBottomButton(paramGraphics);
                    break;
                case 4:
                    drawBox(paramGraphics);
                    drawSetup(paramGraphics);
                    drawBottomButton(paramGraphics);
                    break;
                case 5:
                    drawBox(paramGraphics);
                    drawHelp(paramGraphics);
                    drawBottomButton(paramGraphics);
                    break;
                case 6:
                    drawBox(paramGraphics);
                    drawOk(paramGraphics);
                    drawBottomButton(paramGraphics);
                    break;
                case 7:
                    drawBox(paramGraphics);
                    drawResultButton(paramGraphics);
                    drawBottomButton(paramGraphics);
            }
        }

        private void drawPointerEff (Graphics paramGraphics)
        {
            paramGraphics.drawImage(cRes.iPointer[0], nPointerX, nPointerY, 3);
        }

        private void drawEvent (Graphics paramGraphics)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            int m = 0;
            int n = 5;
            if (nCurStateSeg == 2004) {
                i = 0;
                j = 0;
                k = cRes.iEvent[(8 + nEventTypeText)].getWidth() / 2 + 10;
                m = 132;
                paramGraphics.drawImage(cRes.iEvent[7], 0, 0, 20);
                if (nFrame == 0) {
                    nFrame = 1;
                } else if (nFrame < 3) {
                    paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], i, j / (4 - nFrame), 20);
                    paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], k - cRes.iEvent[(8 + nEventTypeText)].getWidth() / nFrame, m, 3);
                    nFrame += 1;
                } else if (nFrame < n) {
                    paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], i, j, 20);
                    paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], k, m, 3);
                    nFrame += 1;
                } else if (nFrame == n) {
                    paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], i, j, 20);
                    paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], k, m, 3);
                    nFrame = 0;
                    isEvent = false;
                }
            } else {
                i = 240 - cRes.iEvent[nEventTypeCh].getWidth();
                j = 112 - cRes.iEvent[nEventTypeCh].getHeight() + cRes.iEvent[7].getHeight();
                k = 120 - cRes.iEvent[(8 + nEventTypeText)].getWidth() / 2;
                m = 112 + cRes.iEvent[7].getHeight() / 2;
                paramGraphics.drawImage(cRes.iEvent[7], 0, 112, 20);
                if (nFrame == 0) {
                    nFrame = 1;
                } else if (nFrame < 3) {
                    paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], i + cRes.iEvent[nEventTypeCh].getWidth() / nFrame, j, 20);
                    paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], k - cRes.iEvent[(8 + nEventTypeText)].getWidth() / nFrame, m, 3);
                    nFrame += 1;
                } else if (nFrame < n) {
                    paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], i, j, 20);
                    paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], k, m, 3);
                    nFrame += 1;
                } else if (nFrame == n) {
                    paramGraphics.drawImage(cRes.iEvent[nEventTypeCh], i, j, 20);
                    paramGraphics.drawImage(cRes.iEvent[(nEventTypeText + 8)], k, m, 3);
                    nFrame = 0;
                    isEvent = false;
                }
            }
        }

        private void drawMenu (Graphics paramGraphics)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            int m = 0;
            i = 70;
            k = 170;
            j = 270;
            m = 335;
            if (nCurStateSeg != 1000) {
                paramGraphics.setColor(0);
                paramGraphics.drawImage(cRes.iPlayText[7], 120, 112, 3);
            }
            if (nPressTypeP != getPopupState() + 1000) {
                paramGraphics.drawImage(cRes.iButtonBack[0], i, j, 3);
                paramGraphics.drawImage(cRes.iMenuButton[0], i, j, 3);
            }
            if (nPressTypeP != getPopupState() + 2000) {
                paramGraphics.drawImage(cRes.iButtonBack[0], k, j, 3);
                paramGraphics.drawImage(cRes.iMenuButton[2], k, j, 3);
            }
            if (nPressTypeP != getPopupState() + 3000) {
                paramGraphics.drawImage(cRes.iButtonBack[0], i, m, 3);
                paramGraphics.drawImage(cRes.iMenuButton[4], i, m, 3);
            }
            if (nPressTypeP != getPopupState() + 4000) {
                paramGraphics.drawImage(cRes.iButtonBack[0], k, m, 3);
                paramGraphics.drawImage(cRes.iMenuButton[6], k, m, 3);
            }
            if (nPressTypeP == getPopupState() + 1000) {
                paramGraphics.drawImage(cRes.iButtonBack[1], i, j, 3);
                paramGraphics.drawImage(cRes.iMenuButton[1], i, j, 3);
            } else if (nPressTypeP == getPopupState() + 2000) {
                paramGraphics.drawImage(cRes.iButtonBack[1], k, j, 3);
                paramGraphics.drawImage(cRes.iMenuButton[3], k, j, 3);
            } else if (nPressTypeP == getPopupState() + 3000) {
                paramGraphics.drawImage(cRes.iButtonBack[1], i, m, 3);
                paramGraphics.drawImage(cRes.iMenuButton[5], i, m, 3);
            } else if (nPressTypeP == getPopupState() + 4000) {
                paramGraphics.drawImage(cRes.iButtonBack[1], k, m, 3);
                paramGraphics.drawImage(cRes.iMenuButton[7], k, m, 3);
            }
        }

        private void drawEnd (Graphics paramGraphics)
        {
            if (nCurStateSeg != 1000) {
                paramGraphics.drawImage(cRes.iPlayText[7], 120, 112, 3);
            }
            paramGraphics.drawImage(cRes.iButtonBack[0], 60, 323, 3);
            paramGraphics.drawImage(cRes.iButtonBack[0], 180, 323, 3);
            if (nCurStateSeg == 1000) {
                paramGraphics.drawImage(cRes.iEnd[5], 120, 262, 3);
            } else {
                paramGraphics.drawImage(cRes.iEnd[0], 120, 262, 3);
            }
            paramGraphics.drawImage(cRes.iEnd[1], 60, 323, 3);
            paramGraphics.drawImage(cRes.iEnd[2], 180, 323, 3);
            if (nPressTypeP == getPopupState() + 1000) {
                paramGraphics.drawImage(cRes.iButtonBack[1], 60, 323, 3);
                paramGraphics.drawImage(cRes.iEnd[3], 60, 323, 3);
            } else if (nPressTypeP == getPopupState() + 2000) {
                paramGraphics.drawImage(cRes.iButtonBack[1], 180, 323, 3);
                paramGraphics.drawImage(cRes.iEnd[4], 180, 323, 3);
            }
        }

        private void drawScore (Graphics paramGraphics)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            drawMenuBG(paramGraphics);
            if (nScorePage == 0) {
                paramGraphics.drawImage(cRes.iScore[14], 120, 22, 3);
                k = 0;
                for (i = 0; i < 6; i++) {
                    if (i == 1) {
                        k = 1;
                    }
                    j = i * 28;
                    paramGraphics.drawImage(cRes.iScore[(i + k)], 25, 69 + j - (i == 0 ? 6 : 0), 3);
                    paramGraphics.drawImage(cRes.iScore[(i + k + 7)], 50, 69 + j, 6);
                    drawNumber(paramGraphics, cRes.iBlueNum, cPoint.nHighPoint[(i + k)], 234, 64 + j, 0, 4, true);
                }
            }
            if (nScorePage == 1) {
                j = nFrame2 / 2 % 3 * 3;
                paramGraphics.drawImage(cRes.iScore[15], 120, 22, 3);
                paramGraphics.drawImage(cRes.iScore[16], 120, 112, 3);
                paramGraphics.drawImage(cRes.iStar[(0 + j)], 60, 88, 3);
                paramGraphics.drawImage(cRes.iStar[(1 + j)], 120, 88, 3);
                paramGraphics.drawImage(cRes.iStar[(2 + j)], 180, 88, 3);
                drawNumber(paramGraphics, cRes.iScoreNum, cPoint.nStarPoint[0], 170, 132, 2, 4, true);
                nFrame2 += 1;
                if ((nHiddenGameActive[0] == 0) && (nHiddenGameActive[1] == 0)) {
                    if (cPoint.nStarPoint[0] < 300) {
                        paramGraphics.drawImage(cRes.iScore[17], 120, 198, 3);
                    } else {
                        paramGraphics.drawImage(cRes.iScore[18], 120, 198, 3);
                    }
                } else if ((nHiddenGameActive[0] == 0) && (nHiddenGameActive[1] == 1)) {
                    if (cPoint.nStarPoint[0] < 300) {
                        paramGraphics.drawImage(cRes.iScore[17], 120, 198, 3);
                    } else {
                        paramGraphics.drawImage(cRes.iScore[19], 120, 198, 3);
                    }
                } else if ((nHiddenGameActive[0] == 1) && (nHiddenGameActive[1] == 0)) {
                    if (cPoint.nStarPoint[0] < 300) {
                        paramGraphics.drawImage(cRes.iScore[17], 120, 198, 3);
                    } else {
                        paramGraphics.drawImage(cRes.iScore[19], 120, 198, 3);
                    }
                } else if ((nHiddenGameActive[0] == 1) && (nHiddenGameActive[1] == 1)) {
                    paramGraphics.drawImage(cRes.iScore[20], 120, 198, 3);
                }
            } else if (nScorePage == 2) {
                paramGraphics.drawImage(cRes.iHelpContext[0], 0, 0, 20);
            }
            drawScoreButton(paramGraphics);
        }

        private void drawScoreButton (Graphics paramGraphics)
        {
            drawTouchText(paramGraphics);
            if (nPressTypeP == getPopupState() + 1000) {
                if (isPressed) {
                    drawScoreButton(paramGraphics, 1);
                } else {
                    drawScoreButton(paramGraphics, 0);
                }
            } else if (nPressTypeP == getPopupState() + 2000) {
                if (isPressed) {
                    drawScoreButton(paramGraphics, 2);
                } else {
                    drawScoreButton(paramGraphics, 0);
                }
            } else if (nPressTypeP == getPopupState() + 3000) {
                if (isPressed) {
                    drawScoreButton(paramGraphics, 3);
                } else {
                    drawScoreButton(paramGraphics, 0);
                }
            } else {
                drawScoreButton(paramGraphics, 0);
            }
        }

        private void drawScoreButton (Graphics paramGraphics,int paramInt)
        {
            paramGraphics.drawImage(cRes.iButtonBack[0], 40, 301, 3);
            paramGraphics.drawImage(cRes.iButtonBack[0], 120, 301, 3);
            paramGraphics.drawImage(cRes.iButtonBack[0], 200, 301, 3);
            paramGraphics.drawImage(cRes.iScoreButton[1], 40, 301, 3);
            paramGraphics.drawImage(cRes.iScoreButton[3], 120, 301, 3);
            paramGraphics.drawImage(cRes.iMenuButton[5], 200, 301, 3);
            switch (paramInt) {
                case 1:
                    paramGraphics.drawImage(cRes.iButtonBack[1], 40, 301, 3);
                    paramGraphics.drawImage(cRes.iScoreButton[0], 40, 301, 3);
                    break;
                case 2:
                    paramGraphics.drawImage(cRes.iButtonBack[1], 120, 301, 3);
                    paramGraphics.drawImage(cRes.iScoreButton[2], 120, 301, 3);
                    break;
                case 3:
                    paramGraphics.drawImage(cRes.iButtonBack[1], 200, 301, 3);
                    paramGraphics.drawImage(cRes.iMenuButton[4], 200, 301, 3);
            }
        }

        private void drawSetup (Graphics paramGraphics)
        {
            int i = 0;
            int j = 0;
            if (nCurStateSeg != 1000) {
                paramGraphics.setColor(0);
                paramGraphics.drawImage(cRes.iPlayText[7], 120, 112, 3);
            }
            i = 60;
            j = 301;
            if (nSetup[0] == 0) {
                paramGraphics.drawImage(cRes.iOk[3], i, j, 3);
                paramGraphics.drawImage(cRes.iSetup[1], i, j - 4, 3);
                paramGraphics.drawImage(cRes.iSetup[4], i, j + 26, 3);
            } else if (nSetup[0] == 1) {
                paramGraphics.drawImage(cRes.iOk[2], i, j, 3);
                paramGraphics.drawImage(cRes.iSetup[0], i, j - 4, 3);
                paramGraphics.drawImage(cRes.iSetup[4], i, j + 26, 3);
            }
            i = 180;
            j = 301;
            if (nSetup[4] == 0) {
                paramGraphics.drawImage(cRes.iOk[3], i, j, 3);
                paramGraphics.drawImage(cRes.iSetup[3], i, j - 6, 3);
                paramGraphics.drawImage(cRes.iSetup[5], i, j + 26, 3);
            } else if (nSetup[4] == 1) {
                paramGraphics.drawImage(cRes.iOk[2], i, j, 3);
                paramGraphics.drawImage(cRes.iSetup[2], i, j - 6, 3);
                paramGraphics.drawImage(cRes.iSetup[5], i, j + 26, 3);
            }
        }

        private void drawHelp (Graphics paramGraphics)
        {
            paramGraphics.drawImage(cRes.iHelpContext[0], 0, 0, 20);
            drawOk(paramGraphics);
        }

        private void drawOk (Graphics paramGraphics)
        {
            paramGraphics.drawImage(cRes.iOk[2], 120, 301, 3);
            if (nPressTypeP == getPopupState() + 1000) {
                paramGraphics.drawImage(cRes.iOk[1], 120, 301, 3);
            } else {
                paramGraphics.drawImage(cRes.iOk[0], 120, 301, 3);
            }
        }

        private void drawResultButton (Graphics paramGraphics)
        {
            if (nPressTypeP == getPopupState() + 1000) {
                drawResultButton(paramGraphics, 1, 0);
            } else if (nPressTypeP == getPopupState() + 2000) {
                drawResultButton(paramGraphics, 0, 1);
            } else {
                drawResultButton(paramGraphics, 0, 0);
            }
        }

        private void drawResultButton (Graphics paramGraphics,int paramInt1, int paramInt2)
        {
            if (nCurStateSeg == 2004) {
                paramGraphics.drawImage(cRes.iResultButtonEach[paramInt1], 86, 301, 3);
                paramGraphics.drawImage(cRes.iResultButton[paramInt2], 184, 301, 3);
                paramGraphics.drawImage(cRes.iResultButton[2], 30, 301, 3);
                paramGraphics.drawImage(cRes.iResultButton[3], 138, 301, 3);
            } else {
                paramGraphics.drawImage(cRes.iResultButtonEach[paramInt1], 72, 291, 3);
                paramGraphics.drawImage(cRes.iResultButton[paramInt2], 168, 291, 3);
                paramGraphics.drawImage(cRes.iResultButton[2], 72, 345, 3);
                paramGraphics.drawImage(cRes.iResultButton[3], 168, 345, 3);
            }
        }

        public void drawManager (Graphics paramGraphics)
        {
            drawClear(paramGraphics);
            switch (nCurStateOff) {
                case 0:
                    drawClear(paramGraphics);
                    setState(0, 1);
                    break;
                case 1:
                    drawLogoLG(paramGraphics);
                    break;
                case 2:
                    drawLogoNEO(paramGraphics);
            }
        }

        protected void paint (Graphics paramGraphics)
        {
            if (outOfMem) {
                String str = "";
                paramGraphics.setColor(0);
                paramGraphics.fillRect(0, 0, getWidth(), getHeight() + 16);
                paramGraphics.setColor(16777215);
                switch (LANG) {
                    case 0:
                    case 5:
                    case 10:
                    case 11:
                    case 12:
                    default:
                        str = "Not enough memory";
                        break;
                    case 6:
                        str = "内存不足";
                        break;
                    case 7:
                    case 9:
                        str = "記憶体不足";
                        break;
                    case 4:
                        str = "Mémoire insuffisante";
                        break;
                    case 3:
                        str = "Zu wenig Speicher";
                        break;
                    case 8:
                        str = "Memoria insufficiente";
                        break;
                    case 2:
                        str = "Não há memória suficiente";
                        break;
                    case 1:
                        str = "Memoria insuficiente";
                }
                paramGraphics.drawString(str, getWidth() / 2, (getHeight() + 16) / 2, 0x10 | 0x1);
                serviceRepaints();
                outOfMemCnt += 1;
                if (outOfMemCnt > 50) {
                    midlet.notifyDestroyed();
                } else {
                    return;
                }
            }
            if (isResource) {
                cSound.stopSound();
                if (cRes.load(paramGraphics, nCurStateSeg, nCurStateOff)) {
                    switch (nCurStateSeg) {
                        case 1000:
                            cSound.playSound(0, 1);
                            break;
                        case 2000:
                            cPlay00.init();
                            break;
                        case 2002:
                            cPlay02.init();
                            break;
                        case 2003:
                            cPlay03.init();
                            break;
                        case 2004:
                            cPlay04.init();
                            break;
                        case 2005:
                            cPlay05.init();
                            break;
                        case 2006:
                            cPlay06.init();
                    }
                }
                return;
            }
            switch (nCurStateSeg) {
                case 0:
                    drawManager(paramGraphics);
                    break;
                case 1000:
                    cMenu.drawManager(paramGraphics);
                    break;
                case 2000:
                    cPlay00.drawManager(paramGraphics);
                    break;
                case 2002:
                    cPlay02.drawManager(paramGraphics);
                    break;
                case 2003:
                    cPlay03.drawManager(paramGraphics);
                    break;
                case 2004:
                    cPlay04.drawManager(paramGraphics);
                    break;
                case 2005:
                    cPlay05.drawManager(paramGraphics);
                    break;
                case 2006:
                    cPlay06.drawManager(paramGraphics);
            }
            if (isEvent) {
                drawEvent(paramGraphics);
            }
            if (getPopupState() != 0) {
                drawPopup(paramGraphics);
            }
            if (((getPopupState() != 0) || (nCurStateSeg == 1000)) && (isPressed == true) && (nPointerFrame == 0)) {
                drawPointerEff(paramGraphics);
                nPointerFrame = 0;
            }
        }

        protected void pointerPressed ( int paramInt1, int paramInt2)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            int m = 0;
            if (paramInt2 < 224) {
                setPressedPointer(paramInt1, paramInt2, false);
                setButtonType(0);
                setButtonTypeP(0);
                return;
            }
            setPressedPointer(paramInt1, paramInt2, true);
            switch (getPopupState()) {
                case 1:
                    i = 70 - cRes.iButtonBack[0].getWidth() / 2;
                    j = 170 - cRes.iButtonBack[0].getWidth() / 2;
                    k = 46 - cRes.iButtonBack[0].getHeight() / 2;
                    m = 111 - cRes.iButtonBack[0].getHeight() / 2;
                    if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k)) {
                        setButtonTypeP(getPopupState() + 1000);
                    } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j, k)) {
                        setButtonTypeP(getPopupState() + 2000);
                    } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, m)) {
                        setButtonTypeP(getPopupState() + 3000);
                    } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j, m)) {
                        setButtonTypeP(getPopupState() + 4000);
                    }
                    break;
                case 5:
                    i = 120 - cRes.iOk[2].getWidth() / 2;
                    k = 77 - cRes.iOk[2].getHeight() / 2;
                    if (isPointer(paramInt1, paramInt2, cRes.iOk[2], i, k)) {
                        setButtonTypeP(getPopupState() + 1000);
                        return;
                    }
                    break;
                case 4:
                    if (isPointer(paramInt1, paramInt2, cRes.iOk[2], 60 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2)) {
                        setButtonTypeP(getPopupState() + 1000);
                    }
                    if (isPointer(paramInt1, paramInt2, cRes.iOk[2], 180 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2)) {
                        setButtonTypeP(getPopupState() + 2000);
                    }
                    break;
                case 2:
                    if (paramInt2 > 224) {
                        i = 120 - cRes.iButtonBack[0].getWidth() / 2;
                        k = 99 - cRes.iButtonBack[0].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 60, k)) {
                            setButtonTypeP(getPopupState() + 1000);
                        } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 60, k)) {
                            setButtonTypeP(getPopupState() + 2000);
                            return;
                        }
                    }
                    break;
                case 3:
                    i = 120 - cRes.iScoreButton[0].getWidth() / 2;
                    k = 77 - cRes.iScoreButton[0].getHeight() / 2;
                    if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 80, k)) {
                        setButtonTypeP(getPopupState() + 1000);
                        return;
                    }
                    if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k)) {
                        setButtonTypeP(getPopupState() + 2000);
                        return;
                    }
                    if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 80, k)) {
                        setButtonTypeP(getPopupState() + 3000);
                        return;
                    }
                    break;
                case 6:
                    i = 120 - cRes.iOk[2].getWidth() / 2;
                    k = 77 - cRes.iOk[2].getHeight() / 2;
                    if (isPointer(paramInt1, paramInt2, cRes.iOk[2], i, k)) {
                        setButtonTypeP(getPopupState() + 1000);
                        return;
                    }
                    break;
                case 7:
                    if (nCurStateSeg == 2004) {
                        i = 120 - cRes.iButtonBack[0].getWidth() / 2;
                        k = 77 - cRes.iButtonBack[0].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 34, k)) {
                            setButtonTypeP(getPopupState() + 1000);
                            return;
                        }
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 64, k)) {
                            setButtonTypeP(getPopupState() + 2000);
                        }
                    } else {
                        i = 72 - cRes.iButtonBack[0].getWidth() / 2;
                        j = 168 - cRes.iButtonBack[0].getWidth() / 2;
                        k = 67 - cRes.iButtonBack[0].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k)) {
                            setButtonTypeP(getPopupState() + 1000);
                            return;
                        }
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j, k)) {
                            setButtonTypeP(getPopupState() + 2000);
                            return;
                        }
                    }
                    break;
            }
            if (paramInt2 > 348) {
                if ((paramInt1 >= 0) && (paramInt1 < 80)) {
                    setButtonType(1);
                } else if ((paramInt1 >= 80) && (paramInt1 < 160)) {
                    setButtonType(2);
                } else if ((paramInt1 >= 160) && (paramInt1 < 240)) {
                    setButtonType(3);
                }
                return;
            }
            if (isLock()) {
                return;
            }
            switch (nCurStateSeg) {
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

        protected void pointerReleased ( int paramInt1, int paramInt2)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            int m = 0;
            if (paramInt2 < 224) {
                setPressedPointer(0, 0, false);
                setReleasedPointer(0, 0, false);
                return;
            }
            setPressedPointer(paramInt1, paramInt2, false);
            setReleasedPointer(paramInt1, paramInt2, true);
            if (nPressTypeP > 1000) {
                switch (getPopupState()) {
                    case 1:
                        i = 70 - cRes.iButtonBack[0].getWidth() / 2;
                        j = 170 - cRes.iButtonBack[0].getWidth() / 2;
                        k = 46 - cRes.iButtonBack[0].getHeight() / 2;
                        m = 111 - cRes.iButtonBack[0].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k)) {
                            setPopupState(3);
                            setState(nCurStateSeg, nCurStateOff);
                        } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j, k)) {
                            setPopupState(4);
                            setState(nCurStateSeg, nCurStateOff);
                        } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, m)) {
                            setPopupState(5);
                            setState(nCurStateSeg, nCurStateOff);
                        } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j, m)) {
                            setPopupState(2);
                            setState(nCurStateSeg, nCurStateOff);
                        }
                        break;
                    case 5:
                        i = 120 - cRes.iOk[2].getWidth() / 2;
                        k = 77 - cRes.iOk[2].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iOk[2], i, k)) {
                            setPopupState(0);
                            setState(nCurStateSeg, nCurStateOff);
                            return;
                        }
                        break;
                    case 4:
                        if (isPointer(paramInt1, paramInt2, cRes.iOk[2], 60 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2)) {
                            if (nSetup[0] == 0) {
                                nSetup[0] = 1;
                                cSound.playSound(0, 1);
                            } else if (nSetup[0] == 1) {
                                nSetup[0] = 0;
                                cSound.stopSound();
                            }
                        }
                        if (isPointer(paramInt1, paramInt2, cRes.iOk[2], 180 - cRes.iOk[2].getWidth() / 2, 77 - cRes.iOk[2].getHeight() / 2)) {
                            if (nSetup[4] == 0) {
                                nSetup[4] = 1;
                                cSound.vibration();
                            } else if (nSetup[4] == 1) {
                                nSetup[4] = 0;
                            }
                        }
                        break;
                    case 2:
                        if (paramInt2 > 224) {
                            i = 120 - cRes.iButtonBack[0].getWidth() / 2;
                            k = 99 - cRes.iButtonBack[0].getHeight() / 2;
                            if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 60, k)) {
                                if (nCurStateSeg == 1000) {
                                    quit();
                                } else {
                                    cRms.saveData(2);
                                    cRms.saveData(3);
                                    cRms.saveData(4);
                                    setPopupState(0);
                                    setState(1000, 0);
                                }
                            } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 60, k)) {
                                setPopupState(0);
                                setState(nCurStateSeg, nCurStateOff);
                                return;
                            }
                        }
                        break;
                    case 3:
                        i = 120 - cRes.iScoreButton[0].getWidth() / 2;
                        k = 77 - cRes.iScoreButton[0].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i - 80, k)) {
                            nScorePage = 0;
                        } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k)) {
                            nScorePage = 1;
                        } else if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i + 80, k)) {
                            nScorePage = 2;
                        }
                        break;
                    case 6:
                        i = 120 - cRes.iOk[2].getWidth() / 2;
                        k = 77 - cRes.iOk[2].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iOk[2], i, k)) {
                            cMenu.init();
                            setPopupState(0);
                            setState(1000, 0);
                            cRms.saveData(2);
                            cRms.saveData(3);
                            cRms.saveData(4);
                            return;
                        }
                        break;
                    case 7:
                        i = 72 - cRes.iButtonBack[0].getWidth() / 2;
                        j = 168 - cRes.iButtonBack[0].getWidth() / 2;
                        k = 67 - cRes.iButtonBack[0].getHeight() / 2;
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], i, k)) {
                            switch (nCurStateSeg) {
                                case 2000:
                                    cPlay00.init();
                                    break;
                                case 2002:
                                    cPlay02.init();
                                    break;
                                case 2003:
                                    cPlay03.init();
                                    break;
                                case 2004:
                                    cPlay04.init();
                                    break;
                                case 2005:
                                    cPlay05.init();
                                    break;
                                case 2006:
                                    cPlay06.init();
                            }
                            setPopupState(0);
                            setState(nCurStateSeg, 0);
                            cRms.saveData(2);
                            cRms.saveData(3);
                            cRms.saveData(4);
                            return;
                        }
                        if (isPointer(paramInt1, paramInt2, cRes.iButtonBack[0], j, k)) {
                            cMenu.init();
                            setPopupState(0);
                            setState(1000, 0);
                            cRms.saveData(2);
                            cRms.saveData(3);
                            cRms.saveData(4);
                            return;
                        }
                        break;
                }
            }
            setButtonTypeP(0);
            if (paramInt2 > 348) {
                if ((paramInt1 >= 0) && (paramInt1 < 80)) {
                    if (nPressType == 1) {
                        clickButton(nPressType);
                    }
                } else if ((paramInt1 >= 80) && (paramInt1 < 160)) {
                    if (nPressType == 2) {
                        clickButton(nPressType);
                    }
                } else if ((paramInt1 >= 160) && (paramInt1 < 240) && (nPressType == 3)) {
                    clickButton(nPressType);
                }
                setButtonType(0);
                return;
            }
            setButtonType(0);
            if (isLock()) {
                return;
            }
            switch (nCurStateSeg) {
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

        protected void pointerDragged ( int paramInt1, int paramInt2)
        {
            if ((paramInt2 < 224) || (paramInt2 >= 378) || (paramInt1 <= 0) || (paramInt1 >= 240)) {
                isDragged = false;
                setButtonType(0);
                setButtonTypeP(0);
                return;
            }
            if (isLock()) {
                return;
            }
            switch (nCurStateSeg) {
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

        public boolean isPointer ( int paramInt1, int paramInt2, int paramInt3, int paramInt4,
        int paramInt5, int paramInt6)
        {
            if ((paramInt2 <= 224) || (paramInt2 > 348)) {
                return false;
            }
            return (paramInt3 < paramInt1) && (paramInt5 > paramInt1) && (paramInt4 < paramInt2) && (paramInt6 > paramInt2);
        }

        public boolean isPointer ( int paramInt1, int paramInt2, Image paramImage,int paramInt3,
        int paramInt4)
        {
            if ((paramInt1 <= 0) || (paramInt1 >= 240) || (paramInt2 <= 224) || (paramInt2 >= 348)) {
                return false;
            }
            return (paramInt3 < paramInt1) && (paramInt3 + paramImage.getWidth() > paramInt1) && (224 + paramInt4 < paramInt2) && (224 + paramInt4 + paramImage.getHeight() > paramInt2);
        }

        private void clickButtonFunc ( int paramInt)
        {
            if ((nCurStateSeg >= 2000) && (nCurStateOff == 0)) {
                return;
            }
            switch (paramInt) {
                case 10:
                    nScorePage = 0;
                    setPopupState(3);
                    setState(nCurStateSeg, nCurStateOff);
                    break;
                case 20:
                    setPopupState(4);
                    setState(nCurStateSeg, nCurStateOff);
                    break;
                case 21:
                    break;
                case 30:
                    setPopupState(2);
                    setState(nCurStateSeg, nCurStateOff);
                    break;
                case 31:
                    if (getPopupState() != 0) {
                        if (getPopupState() == 4) {
                            cRms.saveData(1);
                        }
                        setPopupState(0);
                        setState(nCurStateSeg, nCurStateOff);
                    } else {
                        switch (nCurStateSeg) {
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
    }
}
