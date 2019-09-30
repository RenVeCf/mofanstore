package com.mofanstore.util;

/**
 * Created by Administrator on 2017/6/23.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 实现圆角image
 *
 * @author Administrator
 *
 */
public class RoundAngleImageView extends ImageView {
//
//    /**
//     * 实现圆形、圆角，椭圆等自定义图片View。
//     * @author zq
//     *
//     */
//        private Paint mPaint;
//
//        private int mWidth;
//
//        private int mHeight;
//
//        private int mRadius;//圆半径
//
//        private RectF mRect;//矩形凹行大小
//
//        private int mRoundRadius;//圆角大小
//
//        private BitmapShader mBitmapShader;//图形渲染
//
//        private Matrix mMatrix;
//
//        private int mType;//记录是圆形还是圆角矩形
//
//        public static final int TYPE_CIRCLE = 0;//圆形
//        public static final int TYPE_ROUND = 1;//圆角矩形
//        public static final int TYPE_OVAL = 2;//椭圆形
//        public static final int DEFAUT_ROUND_RADIUS = 30;//默认圆角大小
//
//        public RoundAngleImageView(Context context) {
//            this(context, null);
//            // TODOAuto-generated constructor stub
//        }
//
//        public RoundAngleImageView(Context context, AttributeSet attrs) {
//            this(context,attrs, 0);
//            // TODOAuto-generated constructor stub
//        }
//
//        public RoundAngleImageView(Context context, AttributeSet attrs, int defStyle){
//            super(context,attrs, defStyle);
//            initView();
//        }
//
//        private void initView() {
//            mPaint = new Paint();
//            mPaint.setAntiAlias(true);
//            mMatrix = new Matrix();
//            mRoundRadius = DEFAUT_ROUND_RADIUS;
//            setType(TYPE_CIRCLE);
//            setRoundRadius(15);
//        }
//
//        @Override
//        protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec) {
//            // TODOAuto-generated method stub
//            super.onMeasure(widthMeasureSpec,heightMeasureSpec);
//            // 如果是绘制圆形，则强制宽高大小一致
//            if (mType ==TYPE_CIRCLE) {
//                mWidth = Math.min(getMeasuredWidth(),getMeasuredHeight());
//                mRadius = mWidth / 2;
//                setMeasuredDimension(mWidth, mWidth);
//            }
//
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//
//            if (null ==getDrawable()) {
//                return;
//            }
//            setBitmapShader();
//            if (mType ==TYPE_CIRCLE) {
//                canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
//            } else if (mType == TYPE_ROUND) {
//                mPaint.setColor(Color.RED);
//                canvas.drawRoundRect(mRect, mRoundRadius, mRoundRadius, mPaint);
//            }else if(mType == TYPE_OVAL){
//                canvas.drawOval(mRect, mPaint);
//            }
//        }
//
//        @Override
//        protected void onSizeChanged(int w,int h, int oldw,int oldh) {
//            // TODOAuto-generated method stub
//            super.onSizeChanged(w,h, oldw, oldh);
//            mRect = new RectF(0,0, getWidth(), getHeight());
//        }
//
//        /**
//         * 设置BitmapShader
//         */
//        private void setBitmapShader() {
//            Drawable drawable = getDrawable();
//            if (null ==drawable) {
//                return;
//            }
//            Bitmap bitmap = drawableToBitmap(drawable);
//            // 将bitmap作为着色器来创建一个BitmapShader
//            mBitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//            float scale =1.0f;
//            if (mType ==TYPE_CIRCLE) {
//                // 拿到bitmap宽或高的小值
//                int bSize =Math.min(bitmap.getWidth(), bitmap.getHeight());
//                scale = mWidth * 1.0f /bSize;
//
//            } else if (mType == TYPE_ROUND ||mType == TYPE_OVAL) {
//                // 如果图片的宽或者高与view的宽高不匹配，计算出需要缩放的比例；缩放后的图片的宽高，一定要大于我们view的宽高；所以我们这里取大值；
//                scale = Math.max(getWidth() * 1.0f/ bitmap.getWidth(), getHeight() * 1.0f / bitmap.getHeight());
//            }
//            // shader的变换矩阵，我们这里主要用于放大或者缩小
//            mMatrix.setScale(scale,scale);
//            // 设置变换矩阵
//            mBitmapShader.setLocalMatrix(mMatrix);
//            mPaint.setShader(mBitmapShader);
//
//        }
//
//        /**
//         * drawable转bitmap
//         *
//         * @paramdrawable
//         * @return
//         */
//        private Bitmap drawableToBitmap(Drawable drawable) {
//            if (drawable instanceof BitmapDrawable) {
//                BitmapDrawable bitmapDrawable =(BitmapDrawable) drawable;
//                return bitmapDrawable.getBitmap();
//            }
//            int w =drawable.getIntrinsicWidth();
//            int h =drawable.getIntrinsicHeight();
//            Bitmap bitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
//            Canvas canvas = new Canvas(bitmap);
//            drawable.setBounds(0, 0, w, h);
//            drawable.draw(canvas);
//            return bitmap;
//        }
//        /**
//         * 单位dp转单位px
//         */
//        public int dpTodx(int dp){
//
//            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                    dp,getResources().getDisplayMetrics());
//        }
//
//        public int getType(){
//            return mType;
//        }
//        /**
//         * 设置图片类型：圆形、圆角矩形、椭圆形
//         * @param mType
//         */
//        public void setType(int mType) {
//            if(this.mType !=mType){
//                this.mType = mType;
//                invalidate();
//            }
//
//        }
//        public int getRoundRadius() {
//            return mRoundRadius;
//        }
//        /**
//         * 设置圆角大小
//         * @parammRoundRadius
//         */
//        public void setRoundRadius(int mRoundRadius) {
//            if(this.mRoundRadius !=mRoundRadius){
//                this.mRoundRadius =mRoundRadius;
//                invalidate();
//            }
//
//        }
private static final ScaleType SCALE_TYPE = ScaleType.CENTER_CROP;

    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 2;

    // 圆形边框的厚度默认值。
    // 如果是0，则没有天蓝色渐变的边框。
    private static final int DEFAULT_BORDER_WIDTH = 0;

    private static final int DEFAULT_BORDER_COLOR = 0xffFCD44B;

    private final RectF mDrawableRect = new RectF();
    private final RectF mBorderRect = new RectF();

    private final Matrix mShaderMatrix = new Matrix();
    private final Paint mBitmapPaint = new Paint();
    private final Paint mBorderPaint = new Paint();

    private int mBorderColor = DEFAULT_BORDER_COLOR;
    private int mBorderWidth = DEFAULT_BORDER_WIDTH;

    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBitmapHeight;

    private float mDrawableRadius;
    private float mBorderRadius;

    private boolean mReady;
    private boolean mSetupPending;
    private final Paint mFlagBackgroundPaint = new Paint();
    private final TextPaint mFlagTextPaint = new TextPaint();
    private String mFlagText;
    private boolean mShowFlag = false;
    private Rect mFlagTextBounds = new Rect();

    Shader mSweepGradient = null;

    public RoundAngleImageView(Context context) {
        super(context);

        init();
    }

    public RoundAngleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        mReady = true;

        if (mSetupPending) {
            setup();
            mSetupPending = false;
        }
    }

    @Override
    public ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    @Override
    public void setScaleType(ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format(
                    "ScaleType %s not supported.", scaleType));
        }
    }

    @Override
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        if (adjustViewBounds) {
            throw new IllegalArgumentException(
                    "adjustViewBounds not supported.");
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mDrawableRadius,
                mBitmapPaint);
        if (mBorderWidth != 0) {
            canvas.save();
            canvas.rotate(20, getWidth() / 2, getHeight() / 2);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, mBorderRadius,
                    mBorderPaint);
            canvas.restore();
        }

        if (mShowFlag && mFlagText != null) {
            canvas.drawArc(mBorderRect, 40, 100, false, mFlagBackgroundPaint);
            mFlagTextPaint.getTextBounds(mFlagText, 0, mFlagText.length(),
                    mFlagTextBounds);
            canvas.drawText(mFlagText, getWidth() / 2,
                    (float) ((3 + Math.cos((float) (Math.PI * 5 / 18)))
                            * getHeight() / 4 + mFlagTextBounds.height() / 3),
                    mFlagTextPaint);

        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        setup();
    }

    public int getBorderColor() {
        return mBorderColor;
    }

    public void setBorderColor(int borderColor) {
//        if (borderColor == mBorderColor) {
//            return;
//        }

        mBorderColor = borderColor;
        mBorderPaint.setColor(mBorderColor);
        invalidate();
    }

    public int getBorderWidth() {
        return mBorderWidth;
    }

    /**
     * @param borderWidth
     *   圆形的边框厚度。
     */
    public void setBorderWidth(int borderWidth) {
        if (borderWidth == mBorderWidth) {
            return;
        }

        mBorderWidth = borderWidth;
        setup();
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        super.setImageBitmap(bm);
        mBitmap = bm;
        setup();
    }

    @Override
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        try {
            Bitmap bitmap;

            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(COLORDRAWABLE_DIMENSION,
                        COLORDRAWABLE_DIMENSION, BITMAP_CONFIG);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }

            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void setup() {
        if (!mReady) {
            mSetupPending = true;
            return;
        }

        if (mBitmap == null) {
            return;
        }

        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);

        mBitmapPaint.setAntiAlias(true);
        mBitmapPaint.setShader(mBitmapShader);

        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setAntiAlias(true);
        mBorderPaint.setColor(mBorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);

        mBitmapHeight = mBitmap.getHeight();
        mBitmapWidth = mBitmap.getWidth();

        mBorderRect.set(0, 0, getWidth(), getHeight());
        mBorderRadius = Math.min((mBorderRect.height() - mBorderWidth) / 2,
                (mBorderRect.width() - mBorderWidth) / 2);

        mDrawableRect.set(mBorderWidth, mBorderWidth, mBorderRect.width()
                - mBorderWidth, mBorderRect.height() - mBorderWidth);
        mDrawableRadius = Math.min(mDrawableRect.height() / 2,
                mDrawableRect.width() / 2);

        mFlagBackgroundPaint.setColor(mBorderColor);
        mFlagBackgroundPaint.setFlags(TextPaint.ANTI_ALIAS_FLAG);

        mFlagTextPaint.setFlags(TextPaint.ANTI_ALIAS_FLAG);
        mFlagTextPaint.setTextAlign(Paint.Align.CENTER);
        mFlagTextPaint.setColor(Color.WHITE);
        mFlagTextPaint
                .setTextSize(getResources().getDisplayMetrics().density * 18);

        mSweepGradient = new SweepGradient(getWidth() / 2, getHeight() / 2,
                new int[] { Color.rgb(252,212,75), Color.rgb(252,212,75) },
                null);

        mBorderPaint.setShader(mSweepGradient);

        updateShaderMatrix();
        invalidate();
    }

    private void updateShaderMatrix() {
        float scale;
        float dx = 0;
        float dy = 0;

        mShaderMatrix.set(null);

        if (mBitmapWidth * mDrawableRect.height() > mDrawableRect.width()
                * mBitmapHeight) {
            scale = mDrawableRect.height() / (float) mBitmapHeight;
            dx = (mDrawableRect.width() - mBitmapWidth * scale) * 0.5f;
        } else {
            scale = mDrawableRect.width() / (float) mBitmapWidth;
            dy = (mDrawableRect.height() - mBitmapHeight * scale) * 0.5f;
        }

        mShaderMatrix.setScale(scale, scale);
        mShaderMatrix.postTranslate((int) (dx + 0.5f) + mBorderWidth,
                (int) (dy + 0.5f) + mBorderWidth);

        mBitmapShader.setLocalMatrix(mShaderMatrix);
    }

    public void setShowFlag(boolean show) {
        mShowFlag = show;
        invalidate();
    }

    public void setFlagText(String text) {
        mFlagText = text;
        invalidate();
    }
}