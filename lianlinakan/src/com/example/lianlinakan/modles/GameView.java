package com.example.lianlinakan.modles;

import com.example.lianlinakan.service.GameService;
import com.example.lianlinakan.util.ImageUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {

	/**
	 * 带参构造方法
	 * 
	 * @param context
	 *            上下文对象
	 * @param attrs
	 *            属性集合
	 */
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// 初始化画笔对象
		paint = new Paint();
		// 设置画笔颜色为红色
		paint.setColor(Color.RED);
		// 设置画笔的粗细
		paint.setStrokeWidth(3);

		// 加载用于标识选中图片的图片资源
		selectImage = ImageUtil.getSelectImage(context);

	}

	// 保存当前已经被选中的方块
	private Piece selectedPiece;
	// 用于标识选中图片的图片对象
	private Bitmap selectImage;
	// 游戏逻辑的实现类
	private GameService gameService;
	// 连接对象信息用于保存可以连接的点的信息
	private LinkInfo linkPoint;
	// 画笔对象
	private Paint paint;

	public void setLinkPoint(LinkInfo linkPoint) {
		this.linkPoint = linkPoint;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	/**
	 * 在view的重绘事件中
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 先判断是否有GameService对象
		if (gameService == null) {
			return;
		}
		// 调用GameService对象获取方块数组
		Piece[][] pieces = gameService.getPieces();
		if (pieces != null) {
			// 遍历数组，绘制到界面上
			for (int i = 0; i < pieces.length; i++) {
				for (int j = 0; j < pieces[i].length; j++) {
					Piece piece = pieces[i][j];
					if (piece != null) {
						canvas.drawBitmap(piece.getImage().getImage(),
								piece.getBeginX(), piece.getBeginY(), null);
					}
				}
			}
		}
		//如果有连接点信息，在当前画布上画连接线
		if (linkPoint!= null) {
			drawLine(this.linkPoint,canvas);
		}
	}

	private void drawLine(LinkInfo linkPoint2, Canvas canvas) {
		// TODO Auto-generated method stub
		
	}

}
