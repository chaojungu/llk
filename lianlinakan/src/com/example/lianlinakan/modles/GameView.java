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
 * ��Ϸ��ͼ ������Ϸ������ػ�
 * 
 * @author Administrator
 * 
 */
public class GameView extends View {

	/**
	 * ���ι��췽��
	 * 
	 * @param context
	 *            �����Ķ���
	 * @param attrs
	 *            ���Լ���
	 */
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// ��ʼ�����ʶ���
		paint = new Paint();
		// ���û�����ɫΪ��ɫ
		paint.setColor(Color.RED);
		// ���û��ʵĴ�ϸ
		paint.setStrokeWidth(3);

		// �������ڱ�ʶѡ��ͼƬ��ͼƬ��Դ
		selectImage = ImageUtil.getSelectImage(context);

	}

	// ���浱ǰ�Ѿ���ѡ�еķ���
	private Piece selectedPiece;
	// ���ڱ�ʶѡ��ͼƬ��ͼƬ����
	private Bitmap selectImage;
	// ��Ϸ�߼���ʵ����
	private GameService gameService;
	// ���Ӷ�����Ϣ���ڱ���������ӵĵ����Ϣ
	private LinkInfo linkPoint;
	// ���ʶ���
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
	 * view���ػ��¼� ����Ϸ�߼����л�ȡ��Ϸ���ݲ�����
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// ���ж��Ƿ���GameService����
		if (gameService == null) {
			return;
		}
		// ����GameService�����ȡ��������
		Piece[][] pieces = gameService.getPieces();
		if (pieces != null) {
			// �������飬���Ƶ�������
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
		// ��������ӵ���Ϣ���ڵ�ǰ�����ϻ�������
		if (linkPoint != null) {
			drawLine(this.linkPoint, canvas);
			// ���ƺ����ԭ�еĵ����ӵ���Ϣ
			linkPoint = null;
		}
		// �����ѡ�еĵ�ͼƬ����ѡ�е�ͼ���ϻ�ѡ�б�ʶ
		if (this.selectImage != null) {
			canvas.drawBitmap(this.selectImage, this.selectedPiece.getBeginX(),
					this.selectedPiece.getBeginY(), null);
		}

	}

	/**
	 * ���ݸ����ĵ���Ϣ���л���
	 * @param linkPoint2
	 * @param canvas
	 */
	private void drawLine(LinkInfo linkPoint2, Canvas canvas) {
		//��ȡ������Ϣ�����еľ������ӵ�
		List<Point> points = linkPoint2.getLinkPoints();
		//�������ӵ㲢��������
		int size=points.size();
		for (int i = 0; i < size-1; i++) {
			Point current=points.get(i);
			Point next=points.get(i+1);
			canvas.drawLine(current.x, current.y, next.x, next.y, this.paint);
		}
	}

	/**
	 * ��ʼ��Ϸ
	 */
	public void startGame() {
		this.gameService.start();
		this.postInvalidate();

	}
}
