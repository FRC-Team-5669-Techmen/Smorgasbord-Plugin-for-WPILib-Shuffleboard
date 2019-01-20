package edu.boscotech.smorgasbord.camera;

import java.util.Map;

import edu.wpi.first.shuffleboard.api.data.ComplexData;
import edu.wpi.first.shuffleboard.api.util.Maps;

public final class CameraData extends ComplexData<CameraData> {
  private final int width, height, fps, quality;

  public CameraData(int width, int height, int fps, int quality) {
    this.width = width;
    this.height = height;
    this.fps = fps;
    this.quality = quality;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getFps() {
    return fps;
  }

  public int getCompression() {
    return quality;
  }

  @Override
  public Map<String, Object> asMap() {
    return Maps.<String, Object>builder()
      .put("width", width)
      .put("height", height)
      .put("fps", fps)
      .put("quality", quality)
      .build();
  }

  public static CameraData fromMap(Map<String, Object> map) {
    return new CameraData(
      (int) map.getOrDefault("width", -1),
      (int) map.getOrDefault("height", -1),
      (int) map.getOrDefault("fps", -1),
      (int) map.getOrDefault("quality", -1)
    );
  }
}