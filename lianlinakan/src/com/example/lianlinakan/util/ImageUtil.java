package com.example.lianlinakan.util;

import java.lang.reflect.Field;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.lianlinakan.R;
import com.example.lianlinakan.modles.PieceImage;

public class ImageUtil {
	// 保存所有连连看图片资源值（int类型）
	private static List<Integer> imageIds = getImageIds();

	public static Bitmap getSelectImage(Context context) {
		
		return BitmapFactory.decodeResource(context.getResources(),
				R.drawable.selected);
	}

	/**
	 * 通过反射获取所有以p开头的图片资源
	 * 
	 * @return
	 */
	private static List<Integer> getImageIds() {
		try {
			// 利用反射获取资源文件R中的图像id
			Field[] fields = R.drawable.class.getFields();
			// 判断字段名称是否以p开头，如果是，获取值并添加到id集合中(预先约定图片以p开头)
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
