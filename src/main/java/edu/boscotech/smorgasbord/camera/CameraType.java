package edu.boscotech.smorgasbord.camera;

import java.util.Map;
import java.util.function.Function;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

public final class CameraType extends ComplexDataType<CameraData> {
  public static final CameraType instance = new CameraType();

  private CameraType() {
    super("Camera", CameraData.class);
  }

  @Override
  public Function<Map<String, Object>, CameraData> fromMap() {
    return CameraData::fromMap;
  }

  @Override
  public CameraData getDefaultValue() {
    return new CameraData(-1, -1, -1, -1);
  }
}