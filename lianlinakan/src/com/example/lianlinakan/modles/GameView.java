package com.example.lianlinakan.modles;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.example.lianlinakan.service.GameService;
import com.example.lianlinakan.util.ImageUtil;

/**
 * 游戏视图 负责游戏界面的重绘
 * 
 * @author Administrator
 * 
 */
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
	
	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
	/**
	 * view的重绘事件 从游戏逻辑类中获取游戏数据并绘制
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
		// 如果有连接点信息，在当前画布上画连接线
		if (linkPoint != null) {
			drawLine(this.linkPoint, canvas);
			// 绘制后清空原有的的连接点信息
			linkPoint = null;
		}
		// 如果有选中的的图片，在选中的图像上画选中标识
		if (this.selectImage != null) {
			canvas.drawBitmap(this.selectImage, this.selectedPiece.getBeginX(),
					this.selectedPiece.getBeginY(), null);
		}

	}

	/**
	 * 根据给定的点信息进行画线
	 * @param linkPoint2
	 * @param canvas
	 */
	private void drawLine(LinkInfo linkPoint2, Canvas canvas) {
		//获取连接信息对象中的具体连接点
		List<Point> points = linkPoint2.getLinkPoints();
		//遍历连接点并绘制线条
		int size=points.size();
		for (int i = 0; i < size-1; i++) {
			Point current=points.get(i);
			Point next=points.get(i+1);
			canvas.drawLine(current.x, current.y, next.x, next.y, this.paint);
		}
	}

	/**
	 * 开始游戏
	 */
	public void startGame() {
		this.gameService.start();
		this.postInvalidate();

	}
}
