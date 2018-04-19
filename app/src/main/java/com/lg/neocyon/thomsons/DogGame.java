package com.lg.neocyon.thomsons;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.media.AudioManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DogGame extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // full screan action
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN   );
        setContentView(R.layout.game_dog);
    }



        private final int MAX_BALL = 3;
        private final int MAX_STAR = 5;
        private final int DROP_AREA_PIECE = 5;
        private final int STAR_TIME = 5000;
        private final int STAR_MIN_SPEED = 6;
        private final int STAR_MAX_SPEED = 10;
        private final int BALL_WIDTH = 18;
        private final int BALL_HEIGHT = 18;
        private final int BALL_DEFAULT_SPEED = 14;
        private final int BALL_DEFAULT_SLOPE = 8;
        private final int BALL_MAX_SPEED = 20;
        private final int BOOM_TYPE_UD = 0;
        private final int BOOM_TYPE_LR = 1;
        private final int MERRY_AROUND_WIDTH = 60;
        private final int MERRY_AROUND_HEIGHT = 60;
        private final int MERRY_WIDTH = 60;
        private final int MERRY_HEIGHT = 65;
        private final int MERRY_DEFAULT_SPEED = 6;
        private final int BLOCK_KIND = 10;
        private final int BLOCK_WIDTH = 34;
        private final int BLOCK_HEIGHT = 24;
        private final long BLOCK_PUSH_TIME = 14000L;
        private int BLOCK_X;
        private int BLOCK_Y;
        private long dwStarTime;
        private int nBoomType;
        private boolean isBoom;
        private boolean isPushBlock;
        private int nPushCount;
        private DogGame cBc;
        private DogGame.Ball[] cBall;
        private DogGame.Merry cMerry;
        private DogGame.Board cBoard;
        private DogGame.Star[] cStar;
        private Point cPoint;
        private boolean isGameLockTime;
        private long dwGameLockTime;
    public DogGame(BaseCanvas paramBaseCanvas)
    {
        int i = 0;
        cBc = paramBaseCanvas;
        cPoint = cPoint.getInstance();
        BLOCK_X = 7;
        BLOCK_Y = 9;
        cBall = new DogGame.Ball[3];
        cMerry = new DogGame.Merry();
        cStar = new DogGame.Star[5];
        for (i = 0; i < 3; i++) {
            cBall[i] = new DogGame().Ball();
        }
        for (i = 0; i < 5; i++) {
            cStar[i] = new DogGame().Star();
        }
        cBoard = new DogGame.Board();
        cBoard.nBlock = new int[BLOCK_Y][BLOCK_X];
        cBoard.nBlockFrame = new int[BLOCK_Y][BLOCK_X];
        isGameLockTime = false;
        dwGameLockTime = 0L;
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

    private void initBall()
    {
        int i = 0;
        for (i = 0; i < 3; i++) {
            initBall(i);
        }
    }

    private void initBall(int paramInt)
    {
        cBall[paramInt].nType = 0;
        if (paramInt == 0) {
            cBall[paramInt].isActive = true;
        } else {
            cBall[paramInt].isActive = false;
        }
        cBall[paramInt].nPosX = 120;
        cBall[paramInt].nPosY = 261;
        cBall[paramInt].nDirect = (cBc.cUtil.getRandomInt(0, 2) == 0 ? 1 : 2);
        cBall[paramInt].nDirect2 = 3;
        cBall[paramInt].nSpeed = 14;
        cBall[paramInt].nSlope = 8;
        cBall[paramInt].nLevel = 1;
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

    private void initBoard()
    {
        int i = 0;
        int j = 0;
        isBoom = false;
        isPushBlock = false;
        nPushCount = 0;
        for (i = 0; i < BLOCK_Y; i++) {
            for (j = 0; j < BLOCK_X; j++)
            {
                if (i < 5)
                {
                    cBoard.nBlock[i][j] = cBc.cUtil.getRandomInt(0, 10);
                    setBlock(i);
                }
                else
                {
                    cBoard.nBlock[i][j] = 0;
                }
                cBoard.nBlockFrame[i][j] = 0;
            }
        }
        cBoard.isDown = false;
        cBoard.nTime = cBc.getCurTime();
    }

    private void initStar()
    {
        int i = 0;
        for (i = 0; i < 5; i++) {
            initStar(i);
        }
        dwStarTime = cBc.getCurTime();
    }

    private void initStar(int paramInt)
    {
        int i = 48;
        int j = i / 2;
        cStar[paramInt].nType = cPoint.getType();
        cStar[paramInt].nWidth = cBc.cRes.iStar[cStar[paramInt].nType].getWidth();
        cStar[paramInt].nHeight = cBc.cRes.iStar[cStar[paramInt].nType].getHeight();
        cStar[paramInt].nPosX = (cBc.cUtil.getRandomInt(0, 5) * i + j);
        cStar[paramInt].nPosY = (-cStar[paramInt].nHeight / 2);
        cStar[paramInt].nFrame = 0;
        cStar[paramInt].nSpeed = cBc.cUtil.getRandomInt(6, 10);
        cStar[paramInt].isActive = false;
        cStar[paramInt].isHit = false;
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

    private void increaseBall()
    {
        int i = 0;
        int j = 0;
        for (i = 0; i < 3; i++) {
            if (!cBall[i].isActive) {
                for (j = 0; j < 3; j++) {
                    if (cBall[j].isActive)
                    {
                        setBall(i, cMerry.nPosX, cMerry.nPosY, cBall[j].nDirect == 1 ? 2 : 1, 3, 14, cBall[j].nType, cBall[j].nLevel, true);
                        break;
                    }
                }
            }
        }
    }

    private void setBlock(int paramInt)
    {
        int i = 0;
        for (i = 0; i < BLOCK_X; i++)
        {
            cBoard.nBlock[paramInt][i] = cBc.cUtil.getRandomInt(0, 10);
            if (cBc.cUtil.getRandomInt(0, 10) == 0) {
                cBoard.nBlock[paramInt][i] = cBc.cUtil.getRandomInt(10, 14);
            }
        }
    }

    private void boomBlock(int paramInt)
    {
        isBoom = true;
        nBoomType = paramInt;
    }

    private void pushBlock()
    {
        int i = 0;
        for (i = 0; i < BLOCK_X; i++) {
            if (cBoard.nBlock[(BLOCK_Y - 1)][i] != 0)
            {
                cBc.setState(2005, 2);
                return;
            }
        }
        if (cBc.getCurTime() - cBoard.nTime > 14000L - cBc.nGrade * 1000)
        {
            isPushBlock = true;
            if (isPushBlock) {
                cBoard.nTime = cBc.getCurTime();
            }
        }
    }

    private void moveMerry(int paramInt1, int paramInt2)
    {
        if (cMerry.nPrevPosX > cMerry.nPosX) {
            cMerry.nDirect = 1;
        } else if (cMerry.nPrevPosX < cMerry.nPosX) {
            cMerry.nDirect = 2;
        }
        cMerry.nPrevPosX = cMerry.nPosX;
        if (cMerry.nPosX < 0)
        {
            cMerry.nPosX = 0;
            setPressPointer(paramInt1, paramInt2);
        }
        else if (cMerry.nPosX > 240)
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
            cMerry.nPosX = (paramInt1 + cMerry.nMovePixelX);
            cMerry.nPosY = (paramInt2 + cMerry.nMovePixelY);
        }
        cMerry.isMove = true;
        cMerry.nAniFrame += 1;
        if (cMerry.nAniFrame > 3) {
            cMerry.nAniFrame = 0;
        }
    }

    private void setPressPointer(int paramInt1, int paramInt2)
    {
        cMerry.nMovePixelX = (cMerry.nPosX - paramInt1);
        cMerry.nMovePixelY = (cMerry.nPosY - paramInt2);
    }

    private int getBlockType(int paramInt1, int paramInt2)
    {
        if ((paramInt1 > BLOCK_X - 1) || (paramInt2 > BLOCK_Y - 1) || (paramInt1 < 0) || (paramInt2 < 0)) {
            return 0;
        }
        if (cBoard.nBlockFrame[paramInt2][paramInt1] != 0) {
            return 0;
        }
        return cBoard.nBlock[paramInt2][paramInt1];
    }

    private void hitBlock(int paramInt1, int paramInt2, int paramInt3)
    {
        int i = 0;
        int j = 1;
        isBoom = false;
        int k = getBlockType(paramInt2, paramInt3);
        if (k < 10) {
            cPoint.increasePointTable(cBc.nCurStateSeg, k);
        } else {
            switch (k)
            {
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
            }
        }
        cPoint.setPointAnimation(cPoint.nCurPoint, cBall[paramInt1].nPosX, cBall[paramInt1].nPosY);
        cBc.setGrade(cPoint.nPoint[5]);
        if (cBoard.nBlock[paramInt3][paramInt2] == 10) {
            return;
        }
        if (cBall[paramInt1].isHit) {
            return;
        }
        for (i = 0; i < BLOCK_X; i++) {
            if ((cBoard.nBlock[paramInt3][i] != 10) && (cBoard.nBlock[paramInt3][i] != 0) && (i != paramInt2)) {
                j = 0;
            }
        }
        if (j != 0)
        {
            cBc.setEvent(true);
            for (i = 0; i < BLOCK_X; i++) {
                if (cBoard.nBlock[paramInt3][i] == 10) {
                    cBoard.nBlockFrame[paramInt3][i] += 1;
                }
            }
        }
        if (isBoom)
        {
            switch (nBoomType)
            {
                case 1:
                    i = 0;
                case 0:
                    while (i < BLOCK_X)
                    {
                        if (cBoard.nBlock[paramInt3][i] != 0) {
                            cBoard.nBlockFrame[paramInt3][i] += 1;
                        }
                        i++;
                        continue;
                        for (i = 0; i < BLOCK_Y; i++) {
                            if (cBoard.nBlock[i][paramInt2] != 0) {
                                cBoard.nBlockFrame[i][paramInt2] += 1;
                            }
                        }
                    }
            }
            isBoom = false;
        }
        else
        {
            cBall[paramInt1].isHit = true;
            switch (cBall[paramInt1].nDirect)
            {
                case 1:
                    cBall[paramInt1].nEffPosX = -6;
                    break;
                case 2:
                    cBall[paramInt1].nEffPosX = 6;
            }
            switch (cBall[paramInt1].nDirect2)
            {
                case 3:
                    cBall[paramInt1].nEffPosY = -6;
                    break;
                case 4:
                    cBall[paramInt1].nEffPosY = 6;
            }
            cBoard.nBlockFrame[paramInt3][paramInt2] += 1;
        }
    }

    private void proc()
    {
        int i = 0;
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
            else
            {
                for (i = 0; i < 3; i++) {
                    cBall[i].nPosY += 1;
                }
            }
        }
        if (cBc.isLock())
        {
            if (!isGameLockTime)
            {
                dwGameLockTime = cBc.getCurTime();
                isGameLockTime = true;
            }
            return;
        }
        if (isGameLockTime)
        {
            cBoard.nTime += cBc.getCurTime() - dwGameLockTime;
            isGameLockTime = false;
            dwGameLockTime = 0L;
        }
        if (cBc.getCurTime() - dwStarTime > 5000L) {
            for (i = 0; i < 5; i++) {
                if (!cStar[i].isActive)
                {
                    cStar[i].isActive = true;
                    dwStarTime = cBc.getCurTime();
                    break;
                }
            }
        }
        for (i = 0; i < 5; i++) {
            if (cStar[i].isActive) {
                if (cStar[i].nPosY > 378)
                {
                    cPoint.resetComboCount();
                    initStar(i);
                }
                else if (!cStar[i].isHit)
                {
                    cStar[i].nPosY += cStar[i].nSpeed;
                }
            }
        }
        for (i = 0; i < 3; i++) {
            if (cBall[i].isActive)
            {
                int j = 0;
                int k = 0;
                int m = 0;
                if (cBall[i].nDirect2 == 3)
                {
                    k = cBall[i].nPosX / 34;
                    m = (cBall[i].nPosY - 9) / 24;
                    if (getBlockType(k, m) != 0)
                    {
                        j = 1;
                        cBc.cSound.playSound(16, 1);
                        hitBlock(i, k, m);
                        cBall[i].nDirect2 = 4;
                    }
                    else
                    {
                        cBall[i].nPosY -= cBall[i].nSpeed + cBc.nGrade;
                    }
                    if (cBall[i].nPosY - 9 <= 0)
                    {
                        cBall[i].nPosY = 9;
                        cBall[i].nDirect2 = 4;
                    }
                }
                else if (cBall[i].nDirect2 == 4)
                {
                    k = cBall[i].nPosX / 34;
                    m = (cBall[i].nPosY + 9) / 24;
                    if (getBlockType(k, m) != 0)
                    {
                        j = 1;
                        hitBlock(i, k, m);
                        cBall[i].nDirect2 = 3;
                    }
                    else
                    {
                        cBall[i].nPosY += cBall[i].nSpeed + cBc.nGrade;
                    }
                }
                if (cBall[i].nDirect == 1)
                {
                    k = (cBall[i].nPosX - 9) / 34;
                    m = cBall[i].nPosY / 24;
                    if ((j == 0) && (getBlockType(k, m) != 0))
                    {
                        hitBlock(i, k, m);
                        cBall[i].nDirect = 2;
                    }
                    else
                    {
                        cBall[i].nPosX -= cBall[i].nSlope;
                    }
                    if (cBall[i].nPosX - 9 < 0)
                    {
                        cBall[i].nPosX = 9;
                        cBall[i].nDirect = 2;
                    }
                }
                else if (cBall[i].nDirect == 2)
                {
                    k = (cBall[i].nPosX + 9) / 34;
                    m = cBall[i].nPosY / 24;
                    if ((j == 0) && (getBlockType(k, m) != 0))
                    {
                        hitBlock(i, k, m);
                        cBall[i].nDirect = 1;
                    }
                    else
                    {
                        cBall[i].nPosX += cBall[i].nSlope;
                    }
                    if (cBall[i].nPosX + 9 > 240)
                    {
                        cBall[i].nPosX = 231;
                        cBall[i].nDirect = 1;
                    }
                }
                if ((cBall[i].nPosY + 9 >= cMerry.nPosY - 40) && (cBall[i].nPosY + 9 < cMerry.nPosY - 10) && (cBall[i].nPosX >= cMerry.nPosX - 40) && (cBall[i].nPosX <= cMerry.nPosX + 40))
                {
                    n = 0;
                    i1 = 0;
                    int i2 = 0;
                    n = cMerry.nPosX;
                    i1 = cBall[i].nPosX;
                    cBall[i].nDirect2 = 3;
                    cMerry.isJump = true;
                    cMerry.nJumpFrame = 0;
                    cBc.cSound.playSound(14, 1);
                    if (cBall[i].nDirect == 1)
                    {
                        i2 = Math.abs(n - i1) / (4 - cBall[i].nLevel);
                        cBall[i].nSlope = (n > i1 ? i2 : -i2);
                        if (cBall[i].nSlope < 0)
                        {
                            cBall[i].nDirect = 2;
                            cBall[i].nSlope *= -1;
                        }
                    }
                    else if (cBall[i].nDirect == 2)
                    {
                        i2 = Math.abs(n - i1) / (4 - cBall[i].nLevel);
                        cBall[i].nSlope = (n > i1 ? -i2 : i2);
                        if (cBall[i].nSlope < 0)
                        {
                            cBall[i].nDirect = 1;
                            cBall[i].nSlope *= -1;
                        }
                    }
                }
                int n = 0;
                n = 14;
                switch (n)
                {
                    case 12:
                        cBall[i].nLevel = 0;
                        break;
                    case 14:
                        cBall[i].nLevel = 1;
                        break;
                    case 16:
                        cBall[i].nLevel = 2;
                        break;
                    case 18:
                        cBall[i].nLevel = 3;
                        break;
                    case 20:
                        cBall[i].nLevel = 4;
                }
                if (n > 20) {
                    n = 20;
                }



    public void pointerReleased(int paramInt1, int paramInt2) {}

    class Board
    {
        int[][] nBlock;
        int[][] nBlockFrame;
        boolean isDown;
        long nTime;

        Board() {}
    }

    class Star
    {
        int nType;
        int nPosX;
        int nPosY;
        int nWidth;
        int nHeight;
        int nFrame;
        int nSpeed;
        boolean isActive;
        boolean isHit;

        Star() {}
    }

    class Merry
    {
        int nPosX;
        int nPosY;
        int nPrevPosX;
        int nType;
        int nDirect;
        int nSpeed;
        int nMovePixelX;
        int nMovePixelY;
        int nAniFrame;
        int nJumpFrame;
        boolean isMove;
        boolean isJump;

        Merry() {}
    }

    class Ball
    {
        int nPosX;
        int nPosY;
        int nType;
        int nDirect;
        int nDirect2;
        int nEffPosX;
        int nEffPosY;
        int nSlope;
        int nSpeed;
        int nLevel;
        boolean isActive;
        boolean isHit;

        Ball() {}
    }
}

}
