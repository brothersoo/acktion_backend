package io.brothersoo.acktion.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUserInfo {

  private Long id;
  private String username;
  private String nickname;
}
