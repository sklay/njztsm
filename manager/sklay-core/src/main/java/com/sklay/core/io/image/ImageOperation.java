package com.sklay.core.io.image;

import java.awt.image.BufferedImage;

/**
 * @author StormNing
 * 
 */
public interface ImageOperation {
	BufferedImage resize(BufferedImage src, double ratio);

	BufferedImage resizeWithMaxWidth(BufferedImage src, int maxWidth);

	BufferedImage resizeWithMaxHeight(BufferedImage src, int maxHeight);

	BufferedImage resizeWithContainer(BufferedImage src, int containerWidth,
			int containerHeight);

	BufferedImage crop(BufferedImage src, int left, int top, int width,
			int height);

	// TODO marking

	BufferedImage cropWithContainer(BufferedImage src, int containerWidth,
			int containerHeight);
}
