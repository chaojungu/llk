package com.example.lianlinakan.util;

import java.lang.reflect.Field;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.lianlinakan.R;
import com.example.lianlinakan.modles.PieceImage;

public class ImageUtil {
	// ��������������ͼƬ��Դֵ��int���ͣ�
	private static List<Integer> imageIds = getImageIds();

	public static Bitmap getSelectImage(Context context) {
		
		return BitmapFactory.decodeResource(context.getResources(),
				R.drawable.selected);
	}

	/**
	 * ͨ�������ȡ������p��ͷ��ͼƬ��Դ
	 * 
	 * @return
	 */
	private static List<Integer> getImageIds() {
		try {
			// ���÷����ȡ��Դ�ļ�R�е�ͼ��id
			Field[] fields = R.drawable.class.getFields();
			// �ж��ֶ������Ƿ���p��ͷ������ǣ���ȡֵ����ӵ�id������(Ԥ��Լ��ͼƬ��p��ͷ)
			for (Field field : fields) {
				if (field.getName().startsWith("p_")) {
					imageIds.add(field.getInt(R.drawable.class));
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<PieceImage> getPalyImages(
			Context context, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
