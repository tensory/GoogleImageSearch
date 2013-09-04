package net.tensory.googleimagesearch;

public class DataSource {
	public Integer[] imageSizes = {
			R.string.txtImageSize_Icon,
			R.string.txtImageSize_Small,
			R.string.txtImageSize_Medium,
			R.string.txtImageSize_Large,
			// TODO: 
			// add anticipatory handling to make "xxlarge" 
			// easier to understand
			R.string.txtImageSize_Xlarge,
			R.string.txtImageSize_Xxlarge,
			R.string.txtImageSize_Huge
	};
	
	public Integer[] colors = {
			R.string.txtColorName_Red,
			R.string.txtColorName_Orange,
			R.string.txtColorName_Yellow,
			R.string.txtColorName_Green,
			R.string.txtColorName_Blue,
			R.string.txtColorName_Purple,
			R.string.txtColorName_Pink,
			R.string.txtColorName_Black,
			R.string.txtColorName_White,
			R.string.txtColorName_Gray,
			R.string.txtColorName_Brown
	};
	public Integer[] imageTypes = {
			R.string.txtImageType_Face,
			R.string.txtImageType_Photo,
			R.string.txtImageType_ClipArt,
			R.string.txtImageType_LineArt
	};
}
