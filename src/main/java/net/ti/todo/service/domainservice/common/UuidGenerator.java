package net.ti.todo.service.domainservice.common;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class UuidGenerator {
  static final int UUID_LENGTH = 32;

  /**
   * ハイフンなしの32桁のUUIDを生成する
   *
   * @return 32桁のUUID
   */
  public static String generate() {
    String uuid = UUID.randomUUID().toString().replace("-", "");

    StringBuilder builder = new StringBuilder();
    Random random = new Random();

    for (int i = uuid.length(); i < 32; i++) {
      char randomChar = (char) (random.nextInt(26));
      builder.append(randomChar);
    }

    return uuid + builder;
  }
}
